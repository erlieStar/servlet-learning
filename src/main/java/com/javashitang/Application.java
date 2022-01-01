package com.javashitang;

import lombok.SneakyThrows;
import org.apache.catalina.startup.Tomcat;

/**
 * @author lilimin
 * @since 2022-01-01
 */
public class Application {

    private static int port = 8080;
    private static String contextPath = "/";

    @SneakyThrows
    public static void run() {
        final Tomcat tomcat = new Tomcat();
        String baseDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        tomcat.setBaseDir(baseDir);
        tomcat.setPort(port);
        tomcat.addWebapp(contextPath, baseDir);
        tomcat.enableNaming();
        tomcat.start();
        Thread awaitThread = new Thread(() -> { tomcat.getServer().await(); });
        awaitThread.setDaemon(false);
        awaitThread.start();
    }
}
