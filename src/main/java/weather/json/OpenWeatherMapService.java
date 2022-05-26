package weather.json;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapService {

    String APPID = "49b26c074824301fb2177c4217b322d7";

    //http get call from file part of url
    @GET("data/2.5/weather?appid=" + APPID + "&units=imperial")
    Single<CurrentWeather> getCurrentWeather(@Query("q") String zipcode);
}
