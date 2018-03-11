package Utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Properties;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by dgollapudi on 07/03/2018.
 */
public class PropertyReader {
    private static final Properties SYSTEM_PROPS = new Properties();
    public static List<String> userNames = null;
    private static Logger logger = Logger.getLogger(PropertyReader.class.getName());

    public static void loadPropertyFile() {
        //create new session
        if (Session.sessionVars == null) {
            Session.createSession();
        }
        //reading the valus from property file
        String propFilePath = "src/test/resources/environment.properties";
        System.out.println("loadPropertyFile.propFilePath: " + propFilePath);
        try {
            FileReader reader = new FileReader(propFilePath);
            Throwable exception = null;
            try {
                SYSTEM_PROPS.load(reader);
            } catch (Throwable ex) {
                exception = ex;
                throw ex;
            } finally {
                if (reader != null) {
                    if (exception != null) {
                        try {
                            reader.close();
                        } catch (Throwable ex2) {
                            exception.addSuppressed(ex2);
                        }
                    } else {
                        reader.close();
                    }
                }
            }
        } catch (FileNotFoundException fnfe) {
            logger.info("******** Unable to find property file " + fnfe + propFilePath);
        } catch (IOException ioex) {
            logger.info("******** Unable to read property file " + ioex + propFilePath);
        }
    }

    public static Properties getSystemProps() {

        if (SYSTEM_PROPS == null || SYSTEM_PROPS.isEmpty()) {
            loadPropertyFile();
        }

        return SYSTEM_PROPS;
    }


}
