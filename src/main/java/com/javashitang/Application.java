package com.javashitang;

import lombok.SneakyThrows;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author lilimin
 * @since 2022-01-01
 */
public class Application {

    private static int port = 8080;
    private static String contextPath = "/";
    private Class<?> primarySource;

    public Application(Class<?> primarySource) {
        this.primarySource = primarySource;
    }

    public static ConfigurableApplicationContext run(Class<?> primarySource) {
        return new Application(primarySource).run();
    }

    @SneakyThrows
    private ConfigurableApplicationContext run() {

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
        return null;
    }


}
