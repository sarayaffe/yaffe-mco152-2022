package weather;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;
import static org.junit.jupiter.api.Assertions.*;

class GetCurrentWeatherTest {


    @Test
    void getCurrentWeather(){
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        //when
        CurrentWeather currentWeather = getCurrentWeather.getCurrentWeather("01106")
                .blockingFirst();

        //then
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > 0);
        assertNotNull(currentWeather.getDescription());
        assertNotNull(currentWeather.getIcon());

    }

//    @Test
//    void onNext(){
//        //given
//        CurrentWeatherFrame currentWeatherFrame = new CurrentWeatherFrame();
//
//        //when
//        currentWeatherFrame.onNext(currentWeather);
//
//        //then
//        assertEquals(String.valueOf(currentWeather.getTemperature()), currentWeatherFrame.tempLabel.getText());
//
//    }


}