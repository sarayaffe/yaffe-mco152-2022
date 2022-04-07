package weather;

import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCurrentWeather {

    CurrentWeather getCurrentWeather() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);

        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();

        return currentWeather;
    }

}
