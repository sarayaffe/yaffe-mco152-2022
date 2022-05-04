package weather;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

import javax.swing.*;

public class CurrentWeatherPresenter {

    private final CurrentWeatherFrame view;
    private final GetCurrentWeather model;
    private Disposable disposable;

    public CurrentWeatherPresenter(CurrentWeatherFrame view, GetCurrentWeather model){
        this.view = view;
        this.model = model;
    }

    public void loadWeatherFromZipcode(String zipcode){

        //observable - observe result of
        // disposable - cancel call if not needed

        disposable = model.getCurrentWeather(zipcode)
                .subscribeOn(Schedulers.io())         //do this request in background
                .observeOn(Schedulers.newThread())    //run onNext in new thread
                .subscribe(this::onNext, this::onError);
    }
    public void cancel(){
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private void onNext(CurrentWeather currentWeather){
        double fahrenheit = currentWeather.getTemperature();
        view.setTemp(fahrenheit);
    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
        view.showError();
    }

}
