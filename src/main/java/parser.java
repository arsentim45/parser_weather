import org.json.JSONObject;

import java.util.concurrent.atomic.AtomicReference;

public class parser {
    public static void main(String[] args) throws Exception {


        String url = "http://api.openweathermap.org/data/2.5/weather";


        String city = "Lviv";
        String newurl = url + "?q=" + city;

        AtomicReference<JSONObject> json = new AtomicReference<JSONObject>(reader.readJsonFromUrl(newurl));

        System.out.println("description:");
        System.out.println(json.get().getJSONArray("weather").getJSONObject(0).get("description"));
        System.out.println("temperature in Kelvin:");
        System.out.println(json.get().getJSONObject("main").getInt("temp"));
        System.out.println("temperature in Celsius:");
        System.out.println(json.get().getJSONObject("main").getInt("temp") - 273.15);
    }
}