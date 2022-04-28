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
    private JLabel weatherLabel;

    private GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

    public CurrentWeatherFrame(){
        setTitle("Current Weather");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        zipField = new JTextField("00000");
        add(zipField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this::onSubmitClick);
        add(submitButton);

        weatherLabel = new JLabel();
        add(weatherLabel);
    }

    public void onSubmitClick(ActionEvent e) {
        Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather(zipField.getText());

        Disposable disposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(this::onNext, this::onError);
    }

    public void onNext(CurrentWeather currentWeather){
        double fahrenheit = currentWeather.getTemperature();
        weatherLabel.setText(String.valueOf(fahrenheit));
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
/*        String zipcode = zipInput.getText();
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        try {
            CurrentWeather currWeather = getCurrentWeather.getCurrentWeather(zipcode);
            double temp = currWeather.getTemperature();
            double fahrenheit = (temp - 273.15) * 9/5 + 32;

            tempF.setText(fahrenheit + "");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }*/

    public static void main(String[] args) {
        JFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }

}
