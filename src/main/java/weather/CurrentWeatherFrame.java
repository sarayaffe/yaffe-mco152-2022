package weather;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class CurrentWeatherFrame extends JFrame {

    private JTextField zipField;
    private JButton submitButton;
    private JLabel tempLabel;

    private GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

    public CurrentWeatherFrame(){
        setTitle("Current Weather");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        zipField = new JTextField();
        zipField.setPreferredSize(new Dimension(50, 20));
        add(zipField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this::onSubmitClick);
        add(submitButton);

        tempLabel = new JLabel();
        add(tempLabel);
    }

    public void onSubmitClick(ActionEvent e) {
        Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather(zipField.getText());

        Disposable disposable = observable
                .subscribeOn(Schedulers.io())         //do this request in background
                .observeOn(Schedulers.newThread())    //run onNext in new thread
                .subscribe(this::onNext, this::onError);
    }

    public void onNext(CurrentWeather currentWeather){
        double fahrenheit = currentWeather.getTemperature();
        tempLabel.setText(String.valueOf(fahrenheit));
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public static void main(String[] args) {
        JFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }

}
