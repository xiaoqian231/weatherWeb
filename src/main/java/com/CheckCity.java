package com;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import com.jayway.jsonpath.JsonPath;

public class CheckCity {
    File json;

    public CheckCity() {
        this.json=new File("city.list.json");
    }
    /**
     *find city ID
     *@param name name of city
     * @param country country
     * @return ID OF country
     */
public Integer CheckCityID(String name ,String country ){
    List<Map<String,Object>> findCity=null;
    name=name.substring(0,1).toUpperCase()+name.substring(1);
    country=country.toUpperCase();
    try {
        findCity = JsonPath.read(json, "$.[?(@.name == '" + name + "' && @.country == '" + country + "')]");
    } catch (Exception e) {
        e.printStackTrace();
    }
if(findCity.size()==0){
    return null;
}
    return (Integer) findCity.get(0).get("id");
}
}
