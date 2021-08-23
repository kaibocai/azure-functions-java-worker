package com.microsoft.azure.functions.worker.reflect;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class CustomURLClassLoader extends URLClassLoader {
    public CustomURLClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public CustomURLClassLoader(URL[] urls) {
        super(urls);
    }

    public CustomURLClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    public void addURL(URL url) {
        super.addURL(url);
    }
}
