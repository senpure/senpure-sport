package com.senpure.sport.helper;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.function.BiFunction;

/**
 * ReplaceProperties
 *
 * @author senpure
 * @time 2019-08-20 10:50:58
 */
public class ReplaceProperties {

    private Logger logger = LoggerFactory.getLogger(ReplaceProperties.class);

    private List<LineStr> lineStrs = new ArrayList<>();
    private Map<String, LineStr> lineStrMap = new HashMap<>();

    public String getProperty(String key) {
        LineStr lineStr = lineStrMap.get(key);
        if (lineStr != null) {
            return lineStr.value;
        }
        return null;
    }

    private void log() {
        for (LineStr lineStr : lineStrs) {
            if (lineStr.update) {
                if (lineStr.master) {
                    logger.debug("{}{}{}", lineStr.key, lineStr.separator, lineStr.value);
                }

            } else {
                logger.debug("{}", lineStr.line);
            }

        }
    }

    public void store(OutputStream outputStream) {
        List<String> writes = new ArrayList<>();
        for (LineStr lineStr : lineStrs) {
            if (lineStr.update) {
                if (lineStr.master) {
                    writes.add(lineStr.key + lineStr.separator + saveConvert(lineStr.value, false, true));
                } else {
                    writes.add("");
                }

            } else {
                writes.add(lineStr.line);
            }

        }
        try {
            IOUtils.writeLines(writes, "\n", outputStream, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void load(InputStream inputStream) {

        try {
            List<String> lines = IOUtils.readLines(inputStream, "utf-8");
            String key = "";
            String value = "";
            boolean last = false;
            LineStr master = null;
            for (int i = 0; i < lines.size(); i++) {
                String str = lines.get(i);
                //logger.debug(str);

                LineStr lineStr = new LineStr();
                if (!last) {
                    lineStr.master = true;
                    master = lineStr;
                }
                lineStr.line = str;
                lineStrs.add(lineStr);
                if (str.length() == 0) {
                    continue;
                }
                int c = str.charAt(0);
                if (c == '#' | c == '!') {
                    last = false;
                    lineStr.comment = true;
                } else {
                    if (last) {
                        if (master.slaves == null) {
                            master.slaves = new ArrayList<>();
                        }
                        master.slaves.add(lineStr);
                        value = value.substring(0, value.length() - 1) + str.trim();
                    } else {
                        int index = str.indexOf("=");
                        if (index < 0) {
                            index = str.indexOf(":");
                            master.separator = ":";
                        } else {
                            master.separator = "=";
                        }
                        key = str.substring(0, index);
                        value = str.substring(index + 1);

                    }
                    if (str.endsWith("\\")) {
                        last = true;
                    } else {
                        last = false;
                        char[] in = key.toCharArray();
                        master.key = loadConvert(in, 0, in.length, new char[in.length]);
                        in = value.toCharArray();
                        master.value = loadConvert(in, 0, in.length, new char[in.length]);
                        lineStrMap.put(key, master);
                        key = "";
                        value = "";
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean computeIfPresent(String key, BiFunction<String, String, String> remappingFunction) {

        LineStr lineStr = lineStrMap.get(key);
        if (lineStr != null) {
            String v = remappingFunction.apply(key, lineStr.value);
            lineStr.value = v;
            lineStr.update = true;
            if (lineStr.slaves != null) {
                for (LineStr slave : lineStr.slaves) {
                    slave.update = true;
                }
            }
            return true;
        }
        return false;
    }

    private String loadConvert(char[] in, int off, int len, char[] convtBuf) {
        if (convtBuf.length < len) {
            int newLen = len * 2;
            if (newLen < 0) {
                newLen = Integer.MAX_VALUE;
            }
            convtBuf = new char[newLen];
        }
        char aChar;
        char[] out = convtBuf;
        int outLen = 0;
        int end = off + len;

        while (off < end) {
            aChar = in[off++];
            if (aChar == '\\') {
                aChar = in[off++];
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = in[off++];
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed \\uxxxx encoding.");
                        }
                    }
                    out[outLen++] = (char) value;
                } else {
                    if (aChar == 't') aChar = '\t';
                    else if (aChar == 'r') aChar = '\r';
                    else if (aChar == 'n') aChar = '\n';
                    else if (aChar == 'f') aChar = '\f';
                    out[outLen++] = aChar;
                }
            } else {
                out[outLen++] = aChar;
            }
        }
        return new String(out, 0, outLen);
    }

    private String saveConvert(String theString,
                               boolean escapeSpace,
                               boolean escapeUnicode) {
        int len = theString.length();
        int bufLen = len * 2;
        if (bufLen < 0) {
            bufLen = Integer.MAX_VALUE;
        }
        StringBuffer outBuffer = new StringBuffer(bufLen);

        for (int x = 0; x < len; x++) {
            char aChar = theString.charAt(x);
            // Handle common case first, selecting largest block that
            // avoids the specials below
            if ((aChar > 61) && (aChar < 127)) {
                if (aChar == '\\') {
                    outBuffer.append('\\');
                    outBuffer.append('\\');
                    continue;
                }
                outBuffer.append(aChar);
                continue;
            }
            switch (aChar) {
                case ' ':
                    if (x == 0 || escapeSpace)
                        outBuffer.append('\\');
                    outBuffer.append(' ');
                    break;
                case '\t':
                    outBuffer.append('\\');
                    outBuffer.append('t');
                    break;
                case '\n':
                    outBuffer.append('\\');
                    outBuffer.append('n');
                    break;
                case '\r':
                    outBuffer.append('\\');
                    outBuffer.append('r');
                    break;
                case '\f':
                    outBuffer.append('\\');
                    outBuffer.append('f');
                    break;
                case '=': // Fall through
                case ':': // Fall through
                case '#': // Fall through
                case '!':
                    // outBuffer.append('\\');
                    outBuffer.append(aChar);
                    break;
                default:
                    if (((aChar < 0x0020) || (aChar > 0x007e)) & escapeUnicode) {
                        outBuffer.append('\\');
                        outBuffer.append('u');
                        outBuffer.append(toHex((aChar >> 12) & 0xF));
                        outBuffer.append(toHex((aChar >> 8) & 0xF));
                        outBuffer.append(toHex((aChar >> 4) & 0xF));
                        outBuffer.append(toHex(aChar & 0xF));
                    } else {
                        outBuffer.append(aChar);
                    }
            }
        }
        return outBuffer.toString();
    }

    private static char toHex(int nibble) {
        return hexDigit[(nibble & 0xF)];
    }

    private static final char[] hexDigit = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    private static class LineStr {
        boolean comment;
        boolean update;
        boolean master;
        String line;
        String key;
        String separator;
        String value;
        List<LineStr> slaves;
    }


    public static void main(String[] args) {

        File file
                = new File("E:\\IdeaProjects\\senpure-sport\\senpure-sport-helper\\src\\main\\resources\\application.properties");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ReplaceProperties strongProperties = new ReplaceProperties();
            strongProperties.load(inputStream);


            strongProperties.computeIfPresent("hepler.databaseUsername", (key, value) -> {
                System.out.println("s:" + value);
                return "da 大家";
            });
            System.out.println("------------");
            strongProperties.log();
            strongProperties.store(new FileOutputStream(file));

            Properties properties = new Properties();
            inputStream = new FileInputStream(file);
            properties.load(inputStream);

            String key = "hepler.databaseUsername";
            System.out.println(properties.getProperty(key));
            System.out.println(properties.getProperty("hepler.eurekaServiceUrl"));
            properties.setProperty(key, "没有oooo");
            // properties.store(new FileOutputStream(file), "");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
