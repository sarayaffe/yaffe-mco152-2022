package weather.dagger;

import dagger.Component;
import weather.CurrentWeatherFrame;

import javax.inject.Singleton;

@Singleton
@Component(modules = {CurrentWeatherModule.class})
public interface CurrentWeatherComponent {

    CurrentWeatherFrame getCurrentWeatherFrame();

}
