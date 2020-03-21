package com.javashitang.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtil {

    // 获取指定包下的Class对象数组
    public static List<Class<?>> getAllClassByPackageName(String packageName) {
        List<Class<?>> clazzList = new ArrayList<>();
        try {
            Enumeration<URL> iterator = Thread.currentThread().getContextClassLoader()
                    .getResources(packageName.replace(".", "/"));
            while (iterator.hasMoreElements()) {
                URL url = iterator.nextElement();
                if ("file".equals(url.getProtocol())) {
                    File rootFile = new File(url.getPath());
                    if (rootFile.isDirectory()) {
                        File[] files = rootFile.listFiles();
                        for(File file : files) {
                            String className = file.getName();
                            className = className.substring(0, className.lastIndexOf("."));
                            Class<?> clazz = Thread.currentThread().getContextClassLoader()
                                    .loadClass(packageName + "." + className);
                            clazzList.add(clazz);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazzList;
    }
}
