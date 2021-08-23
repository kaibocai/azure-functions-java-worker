package com.microsoft.azure.functions.worker.reflect;

import org.apache.commons.lang3.SystemUtils;

public class FactoryClassLoader {
    public ClassLoaderProvider createClassLoaderProvider(){
            return new EnhancedClassLoaderProvider();
    }
}
