package weather;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class GetCurrentWeatherTest {

    GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
    Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather("01106");
    CurrentWeather currentWeather = observable.blockingFirst();

    @Test
    void getCurrentWeather(){
        //given

        //when

        //then
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > 0);
        assertNotNull(currentWeather.getDescription());
        assertNotNull(currentWeather.getIcon());

    }

    @Test
    void onNext(){
        //given
        CurrentWeatherFrame currentWeatherFrame = new CurrentWeatherFrame();

        //when
        currentWeatherFrame.onNext(currentWeather);

        //then
        assertEquals(String.valueOf(currentWeather.getTemperature()), currentWeatherFrame.tempLabel.getText());

    }


}