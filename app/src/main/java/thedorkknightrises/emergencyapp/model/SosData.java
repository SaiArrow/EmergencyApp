package thedorkknightrises.emergencyapp.model;

import java.util.HashMap;

import thedorkknightrises.emergencyapp.Constants;

/**
 * Created by DELL on 29/01/2017.
 */

public class SosData {

    private String user_name,user_long,user_lat,user_type;

    public SosData(String user_name, String user_long, String user_lat,String user_type) {
        this.user_lat = user_lat;
        this.user_long = user_long;
        this.user_name = user_name;
        this.user_type = user_type;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_lat() {
        return user_lat;
    }

    public void setUser_lat(String user_lat) {
        this.user_lat = user_lat;
    }

    public String getUser_long() {
        return user_long;
    }

    public void setUser_long(String user_long) {
        this.user_long = user_long;
    }

    public HashMap<String,Object> getHashMap(){
        HashMap<String,Object> hashmap = new HashMap<>();

        hashmap.put(Constants.USER_NAME,user_name);
        hashmap.put(Constants.USER_LONG,user_long);
        hashmap.put(Constants.USER_LAT,user_lat);
        hashmap.put(Constants.USER_TYPE,user_type);
        return hashmap;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
