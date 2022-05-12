package weather;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;
import weather.json.OpenWeatherMapServiceFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class CurrentWeatherFrame extends JFrame {

    private final JTextField zipField;
    private final JButton submitButton;
    private final JLabel tempLabel;

    private final CurrentWeatherPresenter presenter;

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

        OpenWeatherMapServiceFactory factory = new OpenWeatherMapServiceFactory();
        presenter = new CurrentWeatherPresenter(this, factory.getInstance());
    }

    public void onSubmitClick(ActionEvent e) {
        presenter.loadWeatherFromZipcode(zipField.getText());
    }

    public void setTemp(double fahrenheit) {
        tempLabel.setText(String.valueOf(fahrenheit));
    }

    public void showError(){

    }

    public static void main(String[] args) {
        JFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }

}
