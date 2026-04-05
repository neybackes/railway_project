package com.solvd.railway.generics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Printer<T> {

    private static final Logger logger = LogManager.getLogger(Printer.class);

    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String RESET = "\u001B[0m";

    public void info(T item) {
        logger.info(GREEN + "Info: {}" + RESET, item);
    }

    public void info(String message, T item) {
        logger.info(GREEN + message + RESET, item);
    }

    public void warn(T item) {
        logger.warn(YELLOW + "Warning: {}" + RESET, item);
    }

    public void error(T item) {
        logger.error(RED + "Error: {}" + RESET, item);
    }

    public void title(String message) {
        logger.info(BLUE + "\n" + message + RESET);
    }
}
