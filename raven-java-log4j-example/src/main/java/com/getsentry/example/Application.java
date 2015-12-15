package com.getsentry.example;

import org.apache.log4j.Logger;

public class Application
{
    private static final Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args)
    {
        try {
            int example = 1 / 0;
        } catch (Exception e) {
            logger.error("Caught exception!", e);
        }
    }
}
