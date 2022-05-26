package weather;

import weather.dagger.DaggerCurrentWeatherComponent;
import weather.json.TemperatureSign;


import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


@Singleton
public class CurrentWeatherFrame extends JFrame {

    private final JTextField zipField;
    private final JButton submitButton;
    private final JLabel tempLabel;
    private final TemperatureSign temperatureSign;

    private final CurrentWeatherPresenter presenter;


    @Inject
    public CurrentWeatherFrame(CurrentWeatherPresenter presenter){

        this.presenter = presenter;


        setTitle("Current Weather");
        setSize(300, 200);
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

        temperatureSign = new TemperatureSign();
        add(temperatureSign);

    }

    public void onSubmitClick(ActionEvent e) {
        presenter.loadWeatherFromZipcode(zipField.getText());
    }

    public void setTemp(double fahrenheit) {
        tempLabel.setText(String.valueOf(fahrenheit));
        temperatureSign.setTemperature(fahrenheit);
    }

    public void showError() {

    }

    public static void main(String[] args) {
        CurrentWeatherFrame frame = DaggerCurrentWeatherComponent.create()
                .getCurrentWeatherFrame();

        frame.setVisible(true);
    }

}
