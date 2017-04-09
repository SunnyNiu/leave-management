package org.niu.leaves.jsp.servlet.ConfigurationGuice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GuiceInjector {

    public static void initialize(Module module){
        injector = Guice.createInjector(module);
    }

    private static Injector injector;
    public static <T> T getInstance(Class<T> type) {
        if (injector == null) {
             injector = Guice.createInjector(new ConfigureModule());
        }
        return injector.getInstance(type);
    }
}