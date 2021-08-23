package com.microsoft.azure.functions.worker.broker;

import com.microsoft.azure.functions.rpc.messages.BindingInfo;
import com.microsoft.azure.functions.worker.WorkerLogManager;
import com.microsoft.azure.functions.worker.description.FunctionMethodDescriptor;
import com.microsoft.azure.functions.worker.reflect.ClassLoaderProvider;
import org.apache.commons.lang3.SystemUtils;

import java.net.MalformedURLException;
import java.util.Map;

public class FactoryJavaMethodExecutor {
    public JavaMethodExecutor getJavaMethodExecutor(FunctionMethodDescriptor descriptor, Map<String, BindingInfo> bindings, ClassLoaderProvider classLoaderProvider)
            throws MalformedURLException, ClassNotFoundException, NoSuchMethodException {

        WorkerLogManager.getSystemLogger().info("Loading EnhancedJavaMethodExecutorImpl");
        return new EnhancedJavaMethodExecutorImpl(descriptor, bindings, classLoaderProvider);
    }
}
