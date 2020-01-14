package zadok.jct.SecApp.Utils;

import android.location.Location;

public class MyLocation extends Location
{
    public MyLocation(){super("");}

    public MyLocation(double _lat, double _lng)
    {
        super("");
        this.setLatitude(_lat);
        this.setLongitude(_lng);
    }

   // *****GETTERS/SETTERS********************************
    public double getLat() {
        return this.getLatitude();
    }

    public void setLat(double lat) {
        this.setLatitude(lat);
    }

    public double getLng() {
        return this.getLongitude();
    }

    public void setLng(double lng) {
        this.setLongitude(lng);
    }
}
/*
public class MyLocation{

    double lat;
    double lng;

    public MyLocation(){}

    public MyLocation(MyLocation location)
    {
        lat=location.getLat();
        lng=location.getLng();
    }
    public MyLocation(Location location)
    {
        lat=location.getLatitude();
        lng=location.getLongitude();
    }


    public MyLocation(double _lat,double _lng)
    {
        lat=_lat;
        lng=_lng;
    }

    //*****GETTER/ SETTERS*****************8


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}

 */
