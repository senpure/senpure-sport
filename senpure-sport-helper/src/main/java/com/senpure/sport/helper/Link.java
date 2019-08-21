package com.senpure.sport.helper;

import com.senpure.base.AppEvn;

import java.io.*;

/**
 * Link
 *
 * @author senpure
 * @time 2019-08-21 15:47:33
 */
public class Link {

//    @echo off
//    set SCRIPT="%TEMP%\%RANDOM%-%RANDOM%-%RANDOM%-%RANDOM%.vbs"
//    echo Set oWS = WScript.CreateObject("WScript.Shell") >> %SCRIPT%
//    echo sLinkFile = "%USERPROFILE%\Desktop\myshortcut.lnk" >> %SCRIPT%
//    echo Set oLink = oWS.CreateShortcut(sLinkFile) >> %SCRIPT%
//    echo oLink.TargetPath = "C:\Users\Administrator\Desktop\sport\gateway\start-console.bat" >> %SCRIPT%
//    echo oLink.Save >> %SCRIPT%
//
//    cscript /nologo %SCRIPT%
//    del %SCRIPT%

    private static String cmd = "@echo off\n" +
            "set source=%1%\n" +
            "set name=%2%\n" +
            "set workspace=%3%\n" +
            "set SCRIPT=\"%TEMP%\\%RANDOM%-%RANDOM%-%RANDOM%-%RANDOM%.vbs\"\n" +
            "echo Set oWS = WScript.CreateObject(\"WScript.Shell\") >> %SCRIPT%\n" +
            "echo sLinkFile = \"%name%\">> %SCRIPT%\n" +
            "echo Set oLink = oWS.CreateShortcut(sLinkFile) >> %SCRIPT%\n" +
            "echo oLink.TargetPath = \"%source%\" >> %SCRIPT%\n" +
            "echo oLink.WorkingDirectory = \"%workspace%\" >> %SCRIPT%\n"+
            "echo oLink.Save >> %SCRIPT%\n" +
            "\n" +
            "cscript /nologo %SCRIPT%\n" +
            "del %SCRIPT%";
    private static File bat;

    /**
     * @param source 原文件地址
     * @param name   快捷地址
     */
    public static void createLink(String source, String name,String workspace) {

        if (bat == null) {
           // File file = new File(AppEvn.getClassRootPath());
           // System.out.println(file.getAbsoluteFile());
            try {
                bat = File.createTempFile("temp", ".bat");
                FileOutputStream   out = new FileOutputStream(bat);
                out.write(cmd.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String cmd = "cmd.exe /c " + bat.getAbsolutePath() + " " + source + " " + (name + ".lnk")+" "+workspace;
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //   executeBatFile("C:\\Users\\Administrator\\Desktop\\999.bat", true);
    }


    public static  void close(){
        if (bat != null) {
            bat.deleteOnExit();
        }
    }
    public static void main(String[] args) {
        AppEvn.markClassRootPath();
        String source = "C:\\Users\\Administrator\\Desktop\\sport\\gateway\\start-console.bat";
        String name = "C:\\Users\\Administrator\\Desktop\\sport\\gateway\\start-console2";
        String workspace="C:\\Users\\Administrator\\Desktop\\sport\\gateway";
        createLink(source, name,workspace);

        //close();
    }
}
