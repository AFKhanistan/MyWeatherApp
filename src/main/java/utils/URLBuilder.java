package utils;

import appconfig.Context;

public class URLBuilder {

    private String url;

    public URLBuilder(String cityId) {
        setUrl(cityId);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String cityId) {
        this.url = String.format("https://api.openweathermap.org/data/2.5/weather?id=%s&appid=%s", cityId, Context.API_KEY);
    }
}
