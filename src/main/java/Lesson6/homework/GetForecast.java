package Lesson6.homework;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class GetForecast {
//    Ссылка на api яндекс погоды https://yandex.ru/dev/weather/doc/dg/concepts/about.html (можно в дз делать его вместо accuweather)
//    Accuweaher https://developer.accuweather.com/apis
//    Паттерны проектирования https://refactoring.guru/ru/design-patterns
//    Ссылка на okhttp3 https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp/4.9.1

    public static void main(String[] args) throws IOException {

        String apiKey = "d31a2bef-97ee-49c4-b4a0-9c8041bd4359";

        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl httpUrlYandexWeather = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("forecast")
                .addQueryParameter("lat", "60.022306")
                .addQueryParameter("lon", "30.351064")
                .addQueryParameter("limit", "5")
                .build();

        System.out.println(httpUrlYandexWeather);

        Request requestForecast = new Request.Builder()
                .url(httpUrlYandexWeather)
                .addHeader("X-Yandex-API-Key", apiKey)
                .get()
                .build();

        Response responseForecast = okHttpClient.newCall(requestForecast).execute();
        System.out.println(responseForecast);
        System.out.println(responseForecast);

        String responseForecastBody = responseForecast.body().string();
        System.out.println(responseForecastBody);

    }

}
