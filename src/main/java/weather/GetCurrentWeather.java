package weather;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;


public class GetCurrentWeather {

    private final OpenWeatherMapService service;

    public GetCurrentWeather() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(OpenWeatherMapService.class);
    }


    public Observable<CurrentWeather> getCurrentWeather(String zipcode){

        return service.getCurrentWeather(zipcode);

    }

}
