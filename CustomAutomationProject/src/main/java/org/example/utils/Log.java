package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    static {
        String log4jpath = System.getProperty("user.dir") + "/src/main/resources/log4j.xml";
        System.setProperty("logoutputpath", System.getProperty("user.dir"));
        System.setProperty("log4j.configuration", log4jpath);
    }

    public static Logger Log = LogManager.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName) {
        Log.info("***** START" + sTestCaseName + "*****");
    }

    public static void endTestCase(String sTestCaseName) {
        Log.info("***** END" + sTestCaseName + "*****");
    }

    public static void info(String message)
    {
        Log.info(message);
    }

    public static void warn(String message)
    {
        Log.warn(message);
    }

    public static void error(String message, Exception e)
    {
        Log.error(message, e);
    }

    public static void fatal(String message)
    {
        Log.fatal(message);
    }
}
