package Utils;

/**
 * Created by dgollapudi on 07/03/2018.
 */
public class Logging {
    private static org.apache.log4j.Logger logger;

    public static void info(Class<?> prodClass, String message)
    {
        logger = org.apache.log4j.Logger.getLogger(prodClass);
        logger.info(message);
    }
    public static void error(Class<?> prodClass, String message, Exception ex)
    {
        logger = org.apache.log4j.Logger.getLogger(prodClass);
        logger.error(message, ex);
    }
    public static void error(Class<?> prodClass, String message)
    {
        logger = org.apache.log4j.Logger.getLogger(prodClass);
        logger.error(message);
    }

}
