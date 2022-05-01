package weather;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;
import static org.junit.jupiter.api.Assertions.*;

class GetCurrentWeatherTest {

    GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

    @Test
    void getCurrentWeather(){
        //given

        //when
        Observable<CurrentWeather> weatherObservable = getCurrentWeather.getCurrentWeather("01106");
        CurrentWeather currentWeather = weatherObservable.blockingFirst();

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