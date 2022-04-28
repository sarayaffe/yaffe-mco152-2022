package weather.json;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapService {

    String APPID = "b6907d289e10d714a6e88b30761fae22";

    //http get call from file part of url
    @GET("data/2.5/weather?appid" + APPID + "&units=imperial")
    Observable<CurrentWeather> getCurrentWeather(@Query("q") String zipcode);
}
