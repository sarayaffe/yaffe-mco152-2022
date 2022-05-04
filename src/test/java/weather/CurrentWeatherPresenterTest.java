package weather;

import io.reactivex.Observable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CurrentWeatherPresenterTest {

    public CurrentWeatherPresenterTest(){
    }

    @BeforeAll
    static void beforeAllTests(){
        //runs before all tests in this class
        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setNewThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @BeforeEach
    public void beforeEachTest(){
        //runs before each test
    }

    @Test
    void loadWeatherFromZipcode(){
        //given
        CurrentWeatherFrame view = mock(CurrentWeatherFrame.class);
        GetCurrentWeather model = mock(GetCurrentWeather.class);
        CurrentWeatherPresenter presenter = new CurrentWeatherPresenter(view, model);

        CurrentWeather currentWeather = mock(CurrentWeather.class);
        doReturn(100.0).when(currentWeather).getTemperature();
        doReturn(Observable.just(currentWeather))
                .when(model).getCurrentWeather("00000");

        //when
        presenter.loadWeatherFromZipcode("00000");

        //then
        verify(view).setTemp(100.0);

    }

}