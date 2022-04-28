package weather;

import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class GetCurrentWeatherTest {

    @Test
    void getCurrentWeather() throws IOException{
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        //when
        CurrentWeather currentWeather = getCurrentWeather.getCurrentWeather("11213");

        //then
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > 0);
        assertNotNull(currentWeather.getDescription());
        assertNotNull(currentWeather.getIcon());

    }


}