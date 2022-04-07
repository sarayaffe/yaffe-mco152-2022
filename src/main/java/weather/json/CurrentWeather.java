package weather.json;

public class CurrentWeather {

    Main main;
    Weather weather[];

    public double getTemperature() {
        return main.temp;
    }

    public double getMaxTemperature() {
        return main.tempMax;
    }

    public double getMinTemperature() {
        return main.tempMin;
    }

    public String getDescription() {
        return weather[0].description;
    }

    public String getIcon() {
        return weather[0].icon;
    }



}
