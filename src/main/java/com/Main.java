package com;

public class Main {

    public static void main(String[] args) {

        CheckCity checkCity=new CheckCity();
        WeatherAPI weatherAPI = new WeatherAPI(checkCity.CheckCityID("Kraków","PL"));
//
//        weatherAPI.getCityFromJson();
        System.out.println(weatherAPI.getWeatherDataByIndex(0).getTemperature());
//UserDAO userDAO=new UserDAO();
//User user = new User("name", "pass");
//register(){
//if(user.userDAO.add() ==0){
//    diaplayPage()
//}}
//        login(user.userDAO.login()){
//    diapleyPage()
//        }
//    }

}}
