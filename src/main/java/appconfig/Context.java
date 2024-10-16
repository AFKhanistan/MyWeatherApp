package appconfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class Context {

    private static final Logger logger = LogManager.getLogger(Context.class);

    public static String API_KEY;

    public static void init() {

        logger.debug("starting method init()");

        API_KEY = "";

        File api_keys_file = new File(System.getProperty("user.home") + File.separator + ".config" + File.separator + "api.keys");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(api_keys_file))) {

            Properties props = new Properties();
            props.load(bis);

            API_KEY = props.getProperty("WeatherMap1", "");

        } catch (FileNotFoundException e) {
            logger.error("file not found: {}", api_keys_file.getAbsolutePath());
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("IOException when accessing file: {}", api_keys_file.getAbsolutePath());
            throw new RuntimeException(e);
        }

        logger.debug("finished method init()");
    }
}
