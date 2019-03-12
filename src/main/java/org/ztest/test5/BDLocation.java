package org.ztest.test5;

/**
 * Created by Lichaojie on 2017/4/19.
 */
public class BDLocation {

    private double latitude;//Î³¶È

    private double longitude;//¾­¶È

    public BDLocation(double longitude,double latitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public BDLocation setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public BDLocation setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
}
