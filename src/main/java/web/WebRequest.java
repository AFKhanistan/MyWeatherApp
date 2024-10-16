package web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.URLBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebRequest {

    private static final Logger logger = LogManager.getLogger(WebRequest.class);

    public static void getWeatherToday(String cityId) {

        logger.debug("starting method getWeatherToday({})", cityId);

        URLBuilder urlBuilder = new URLBuilder(cityId);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlBuilder.getUrl())).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println).join();

        logger.debug("finished method getWeatherToday({})", cityId);

    }

}
