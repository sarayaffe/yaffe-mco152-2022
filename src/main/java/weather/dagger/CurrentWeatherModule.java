package weather.dagger;

import dagger.Module;
import dagger.Provides;
import weather.json.OpenWeatherMapService;
import weather.json.OpenWeatherMapServiceFactory;

import javax.inject.Singleton;

@Module  //tells dagger to create openweathermapservice
public class CurrentWeatherModule {

    @Singleton
    @Provides
    public OpenWeatherMapService providesOpenWeatherMapService(
            OpenWeatherMapServiceFactory factory
    ) {
        return factory.getInstance();
    }

}
