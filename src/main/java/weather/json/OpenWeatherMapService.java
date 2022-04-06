package weather.json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapService {

    //http get call from file part of url
    @GET("data/2.5/weather?appid=b6907d289e10d714a6e88b30761fae22")

    //call represents that something will be returned here because getting the data takes some time
    Call<CurrentWeather> getCurrentWeather(@Query("zip") String zipcode);
}
