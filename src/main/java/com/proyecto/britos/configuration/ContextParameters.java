package com.proyecto.britos.configuration;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextParameters implements ServletContextListener {

    static Logger log = Logger.getLogger(ContextParameters.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
