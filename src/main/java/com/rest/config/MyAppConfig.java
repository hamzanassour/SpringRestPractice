package com.rest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public  class MyAppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        Class[] configFiles = {MyConfig.class};
        return configFiles;
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}