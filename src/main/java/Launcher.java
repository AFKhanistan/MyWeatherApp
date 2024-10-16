import appconfig.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher {

    private static final Logger logger = LogManager.getLogger(Launcher.class);

    public static void main(String[] args) {

        logger.trace("starting application");

        Context.init();

        logger.info("API_KEY = {}", Context.API_KEY);

        logger.trace("stopping application");
    }
}
