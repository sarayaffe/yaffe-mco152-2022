package weather;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class CurrentWeatherPresenter {

    private final Provider<CurrentWeatherFrame> viewProvider;
    private final OpenWeatherMapService model;
    private Disposable disposable;

    @Inject
    public CurrentWeatherPresenter(Provider<CurrentWeatherFrame> viewProvider, OpenWeatherMapService model) {
        this.viewProvider = viewProvider; //view not created yet - doesnt interfere with dependency cycle wouldve had
        this.model = model;
    }

    public void loadWeatherFromZipcode(String zipcode) {

        disposable = model.getCurrentWeather(zipcode)
                .subscribeOn(Schedulers.io())         //do this request in background
                .observeOn(Schedulers.newThread())    //run onNext in new thread
                .subscribe(this::onNext, this::onError);
    }

    public void cancel() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private void onNext(CurrentWeather currentWeather) {
        double fahrenheit = currentWeather.getTemperature();
        viewProvider.get().setTemp(fahrenheit);
    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
        viewProvider.get().showError();
    }

}
