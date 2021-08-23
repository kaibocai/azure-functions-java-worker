package com.microsoft.azure.functions.worker.reflect;

import java.io.*;
import java.net.*;
import java.sql.Driver;
import java.util.*;
import java.util.concurrent.*;


import com.microsoft.azure.functions.worker.*;

public class EnhancedClassLoaderProvider implements ClassLoaderProvider {
    public EnhancedClassLoaderProvider() {
        this.classLoader = new CustomURLClassLoader(new URL[0], this.getClass().getClassLoader());
    }

    @Override
    public ClassLoader getClassLoader() {
        Thread.currentThread().setContextClassLoader(classLoader);
        return classLoader;
    }

    @Override
    public void addDirectory(File directory) throws MalformedURLException, IOException {
        if (!directory.exists()) {
            return;
        }

        File[] jarFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".jar");
            }
        });

        for (File file : jarFiles) {
            addUrl(file.toURI().toURL());
        }
    }

    @Override
    public void addUrl(URL url) throws IOException {
        WorkerLogManager.getSystemLogger().info("Loading file URL: " + url);
        classLoader.addURL(url);
    }

    private final CustomURLClassLoader classLoader;
}
