package com.example;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

public class App {
    private static final XLogger logger = XLoggerFactory.getXLogger(App.class);

    public static void main(String[] args) {
        logger.entry();
        logger.info("Hello with SLF4J Extension!");
        logger.exit();
    }

}