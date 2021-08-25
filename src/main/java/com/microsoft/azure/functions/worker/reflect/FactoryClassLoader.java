package com.microsoft.azure.functions.worker.reflect;

import com.microsoft.azure.functions.worker.Helper;
import org.apache.commons.lang3.SystemUtils;

public class FactoryClassLoader {
    public ClassLoaderProvider createClassLoaderProvider(){
        if(Helper.isCustomURLClassLoader()) {
            return new CustomClassLoaderProvider();
        }else {
            if (SystemUtils.IS_JAVA_1_8) {
                return new DefaultClassLoaderProvider();
            } else {
                return new EnhancedClassLoaderProvider();
            }
        }
    }
}
