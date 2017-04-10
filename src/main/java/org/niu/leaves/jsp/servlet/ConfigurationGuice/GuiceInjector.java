package org.niu.leaves.jsp.servlet.ConfigurationGuice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GuiceInjector {
    static Injector injector;

    public static void initializeInjector(Module module) {
        injector = Guice.createInjector(module);
    }

    public static <T> T getInstance(Class<T> type) {
        if (injector == null)
            injector = Guice.createInjector(new ConfigureModule());
        return injector.getInstance(type);
    }
}