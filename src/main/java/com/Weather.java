package com;

public class Weather {
    private Integer weatherID;
    private String weather;
    private double  temperature;
    private double wind;
    private Integer clouds;
    private String icon;

    public Weather(Integer weatherID, String weather, double temperature, double wind, Integer clouds, String icon) {
        this.weatherID = weatherID;
        this.weather = weather;
        this.temperature = temperature;
        this.wind = wind;
        this.clouds = clouds;
        this.icon = icon;
    }

    public Integer getWeatherID() {
        return weatherID;
    }

    public void setWeatherID(Integer weatherID) {
        this.weatherID = weatherID;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weatherID=" + weatherID +
                ", weather='" + weather + '\'' +
                ", temperature=" + temperature +
                ", wind='" + wind + '\'' +
                ", clouds=" + clouds +
                ", icon='" + icon + '\'' +
                '}';
    }
}
