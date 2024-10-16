import appconfig.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher {

    private static final Logger logger = LogManager.getLogger(Launcher.class);

    public static void main(String[] args) {

        logger.debug("starting application");

        Context.init();

        logger.debug("stopping application");
    }
}
