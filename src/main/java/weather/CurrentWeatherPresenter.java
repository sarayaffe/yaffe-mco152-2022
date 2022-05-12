package weather;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import javax.swing.*;

public class CurrentWeatherPresenter {

    private final CurrentWeatherFrame view;
    private final OpenWeatherMapService model;
    private Disposable disposable;

    public CurrentWeatherPresenter(CurrentWeatherFrame view, OpenWeatherMapService model){
        this.view = view;
        this.model = model;
    }

    public void loadWeatherFromZipcode(String zipcode){

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
