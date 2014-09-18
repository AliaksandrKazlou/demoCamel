package com.epam.democamel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroppedHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(DroppedHandler.class);

    public void justPrint(Object o) {
        LOGGER.info("Dropped object: " + o.getClass().getName() + "=" + o.toString());
    }
}