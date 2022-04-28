package weather;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import java.io.IOException;


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

        /*
        * @return current temp in Kelvin
        * */
    public Observable<CurrentWeather> getCurrentWeather(String zipcode){
        Observable<CurrentWeather> observable = service.getCurrentWeather(zipcode);

        return observable;

    }

}
