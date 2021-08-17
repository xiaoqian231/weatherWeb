package com;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class WeatherAPI {

    private String jsonText;

    private final String apiKey = "77f78082f798fd25c52ceeb43db100dd";

    public WeatherAPI(int cityID){
        try {
           getJson(cityID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**get weather by cityID
     *
     */

public void getJson(int cityID)throws IOException{
    String apiRequest ="http://api.openweathermap.org/data/2.5/forecast?id="+cityID+"&appid=" + apiKey + "&units=metric";
InputStream is=new URL(apiRequest).openStream();
BufferedReader rd=new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
    jsonText = readAll(rd);

}
/**
 * readALL JESON FILE AND COVER TO STRING
* */

public static String readAll(Reader rd) throws IOException{
    StringBuilder sb=new StringBuilder();
    int cp;
    while((cp = rd.read()) != -1){
        sb.append((char) cp);
    }
    return sb.toString();
}
public Weather getWeatherDataByIndex (int index){
Integer weatherID=null;
String weather=null;
double temperature=0;
double wind=0;
Integer clouds=null;
String icon="";
    try {
        weatherID = JsonPath.read(jsonText, "$.list[" + index + "].weather[0].id");
    } catch (PathNotFoundException e) {}

    try {
        weather = JsonPath.read(jsonText, "$.list[" + index + "].weather[0].main");
    } catch (PathNotFoundException e) {
    } catch (ClassCastException e) {
    }

    try {
        temperature = JsonPath.read(jsonText, "$.list[" + index + "].main.temp");
    } catch (PathNotFoundException e) {
    } catch (ClassCastException e) {
        temperature = castToDouble(JsonPath.read(jsonText, "$.list[" + index + "].main.temp"));
    }

    try {
        wind = JsonPath.read(jsonText, "$.list[" + index + "].wind.speed");
    } catch (PathNotFoundException e) {
    } catch (ClassCastException e) {
        wind = castToDouble(JsonPath.read(jsonText, "$.list[" + index + "].wind.speed"));
    }

    try {
        clouds = JsonPath.read(jsonText, "$.list[" + index + "].clouds.all");
    } catch (PathNotFoundException e) {
    } catch (ClassCastException e) {
    }

    try {
        icon = JsonPath.read(jsonText, "$.list[" + index + "].weather[0].icon");
    } catch (PathNotFoundException e) {
    }

    return new Weather(weatherID, weather, temperature, wind, clouds, icon);

}
    /**
     * if JsonPath returns int value somewhere where usually returns double, it converts int to Double
     * @param a Integer or int to convert
     * @return Double value of passed argument
     */
    private Double castToDouble(Object a) {
        String b = String.valueOf(a);
        Double c = Double.valueOf(b);
        return c;
    }

    /**
     * Method returns city name from received data
     * @return city name
     */
    public String getCityFromJson(){
        String cityName = JsonPath.read(jsonText, "$.city.name");
        return cityName;
    }
    /**
     * Method next 3 days data
     * @return list
     */
    public ArrayList<Weather> getWeatherList() throws IOException {
        ArrayList<Weather> list = new ArrayList<>();

        list.add(getWeatherDataByIndex(0));
        list.add(getWeatherDataByIndex(8));
        list.add(getWeatherDataByIndex(16));
        list.add(getWeatherDataByIndex(24));

        return list;
    }


}