package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class CityIDFinder {

    private static final Logger logger = LogManager.getLogger(CityIDFinder.class);

    private JsonArray jsonArray;

    public CityIDFinder() {
        super();
        init();
    }

    private void init() {

        logger.debug("starting method init()");

        File json_data_file = new File(System.getProperty("user.home") + File.separator + ".data" + File.separator + "city.list.json");

        try (BufferedReader br = new BufferedReader(new FileReader(json_data_file))) {

            jsonArray = new Gson().fromJson(br, JsonArray.class);

            if (!jsonArray.isJsonArray()) {
                logger.warn("JSON data is expected to be a JSON Array");
                jsonArray = null;
            }

        } catch (FileNotFoundException e) {
            logger.error("file not found: {}", json_data_file.getAbsolutePath());
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("IOException when accessing file: {}", json_data_file.getAbsolutePath());
            throw new RuntimeException(e);
        }

        logger.debug("finished method init()");
    }

    public JsonArray findByCityName(String city_name) {

        logger.debug("starting method findByCityName({})", city_name);

        JsonArray result = new JsonArray();

        if (jsonArray != null && !jsonArray.isEmpty()) {

            for (int i = 0; i < jsonArray.size(); i++) {

                JsonObject city_json_object = jsonArray.get(i).getAsJsonObject();

                if (city_json_object.get("name").getAsString().equals(city_name)) {
                    result.add(city_json_object);
                }
            }

        } else {
            logger.warn("JSON data is empty");
        }

        logger.debug("finished method findByCityName({})", city_name);

        return result;
    }
}
