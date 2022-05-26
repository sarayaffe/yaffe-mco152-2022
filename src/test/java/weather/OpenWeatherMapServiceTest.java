package weather;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;
import weather.json.OpenWeatherMapServiceFactory;

import static org.junit.jupiter.api.Assertions.*;

class OpenWeatherMapServiceTest {


    @Test
    void getCurrentWeather(){
        //given
        OpenWeatherMapServiceFactory factory = new OpenWeatherMapServiceFactory();
        OpenWeatherMapService service = factory.getInstance();

        //when
        CurrentWeather currentWeather = service.getCurrentWeather("01106")
                    .blockingGet();

        //then
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > 0);
        assertNotNull(currentWeather.getDescription());
        assertNotNull(currentWeather.getIcon());

    }

}