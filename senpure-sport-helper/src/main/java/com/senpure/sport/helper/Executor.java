package com.senpure.sport.helper;

import com.senpure.base.AppEvn;
import com.senpure.base.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Executor
 *
 * @author senpure
 * @time 2019-08-19 16:07:39
 */
@Component
public class Executor implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HelperProperties properties;
    private boolean database = false;
    private File root;


    private void checkDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + properties.getDatabaseUrl() + "?serverTimezone=GMT",
                    properties.getDatabaseUsername(), properties.getDatabasePassword());
            String sql = "SET GLOBAL time_zone='+8:00'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            boolean result = preparedStatement.execute();
            logger.debug("SET GLOBAL  result {}", result);
            database = true;
        } catch (Exception e) {
            database = false;
            try {
                logger.error("数据库配置不正确,不会替换数据库配置");
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            logger.error("", e);
            return;
        } finally {
            if (connection
                    != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkProperties() {


        List<File> files = new ArrayList<>();

        findProperties(files, root);

        StringBuilder sb = new StringBuilder();
        String[] temp = properties.getEurekaServiceUrl().split(",");
        for (int i = 0; i < temp.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("http://").append(temp[i]).append("/eureka/");

        }
        String eurekaUrl = sb.toString();
        for (File file : files) {
            AtomicBoolean update = new AtomicBoolean(false);

            ReplaceProperties replaceProperties = new ReplaceProperties();
            try {
                FileInputStream in = new FileInputStream(file);
                replaceProperties.load(in);
                in.close();
                boolean result = replaceProperties.computeIfPresent("eureka.client.serviceUrl.defaultZone", (key, value) -> {
                    update.set(true);
                    logger.info("{}\n{}\n{} -> {}", file.getAbsolutePath(), key, value, eurekaUrl);
                    return eurekaUrl;
                });
                if (result) {
                    if (temp.length == 1) {
                        String appName = replaceProperties.getProperty("spring.application.name");
                        if (appName != null) {
                            if (appName.startsWith("eureka-")) {
                                replaceProperties.computeIfPresent("server.port", (key, value) -> {
                                    String s[] = temp[0].split(":");
                                    logger.info("{}\n{}\n{} -> {}", file.getAbsolutePath(), key, value, s[1]);
                                    return s[1];
                                });
                            }
                        }

                    }

                }
                if (database) {
                    replaceProperties.computeIfPresent("spring.datasource.druid.url", (key, value) -> {
                        String fullurl = value;
                        int index = StringUtil.indexOf(fullurl, "/", 1, true);

                        String data = fullurl.substring(index + 1);
                        data = "jdbc:mysql://" + properties.getDatabaseUrl() + "/" + data;
                        update.set(true);
                        logger.info("{}\n{}\n{} -> {}", file.getAbsolutePath(), key, value, data);
                        return data;
                    });
                    replaceProperties.computeIfPresent("spring.datasource.druid.username", (key, value) -> {
                        update.set(true);
                        logger.info("{}\n{}\n{} -> {}", file.getAbsolutePath(), key, value, properties.getDatabaseUsername());
                        return properties.getDatabaseUsername();
                    });
                    replaceProperties.computeIfPresent("spring.datasource.druid.password", (key, value) -> {
                        update.set(true);
                        logger.info("{}\n{}\n{} -> {}", file.getAbsolutePath(), key, value, properties.getDatabasePassword());
                        return properties.getDatabasePassword();
                    });
                }

                if (update.get()) {
                    OutputStream out = null;
                    try {
                        out = new FileOutputStream(file);
                        replaceProperties.store(out);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (out != null) {
                            try {
                                out.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkBat() {
        if (AppEvn.classInJar(AppEvn.getStartClass())) {
            if (properties.isGenearteBatLink()) {
                try {
                    for (int i = 3; i > 0; i--) {
                        logger.warn("{}准备生成快捷启动方式,安全卫士可能会进行拦截,请注意授权同意", i);
                        logger.debug("");
                        Thread.sleep(1200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<File> files = new ArrayList<>();
                findBat(files, root);
                for (File file : files) {
                    String name = file.getParentFile().getName() + "-" + file.getName();
                    name = file.getParentFile().getParentFile().getAbsolutePath() + File.separator + name;
                    logger.info("{} - > {}", file.getAbsolutePath(), name);
                    Link.createLink(file.getAbsolutePath(), name, file.getParent());
                }
                logger.info("生成bat快捷方式完成");
            }
        }
    }

    public void executor() {
        String path = AppEvn.getClassRootPath();
        Class clazz = AppEvn.getStartClass();
        logger.debug("clazz {}", clazz);
        logger.debug("clazzRoot {}", path);
        if (AppEvn.classInJar(clazz)) {
            root = new File(path).getParentFile();
        } else {
            root = new File(path).getParentFile().getParentFile().getParentFile();
        }
        logger.debug("file root {}", root.getAbsolutePath());
        checkDatabase();
        checkProperties();
        checkBat();

    }

    private void findProperties(List<File> files, File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File listFile : children) {
                    findProperties(files, listFile);
                }
            }
        } else {
            if (file.getName().endsWith(".properties")) {
                files.add(file);
            }
        }
    }

    private void findBat(List<File> files, File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File listFile : children) {
                    findBat(files, listFile);
                }
            }

        } else {
            if (file.getName().endsWith(".bat")) {
                files.add(file);
            }
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        executor();
    }
}
