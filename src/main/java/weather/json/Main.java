package weather.json;

import com.google.gson.annotations.SerializedName;

public class Main {

    double temp;
    double pressure;
    double humidity;
    @SerializedName("temp_min")
    double tempMin;
    @SerializedName("temp_max")
    double tempMax;

}
