package org.ztest.test5;

/**
 * Created by Lichaojie on 2017/4/19.
 */
public class DistanceTest {
    public static double getDistance(BDLocation p1,BDLocation p2)
    {
        double distance = 0.0;

        double lat1 = (Math.PI/180)*(p1.getLatitude());
        double lon1 = (Math.PI/180)*(p1.getLongitude());
        double lat2 = (Math.PI/180)*(p2.getLatitude());
        double lon2 = (Math.PI/180)*(p2.getLongitude());
        double R = 6371.004;//地球半径，单位KM
        distance += Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon2-lon1))*R*1000;

        return distance;            //单位：m
    }

    public static void main(String[] args) {
        BDLocation bd1=new BDLocation(179.0,0.0);//38.891819,115.521052
        BDLocation bd2=new BDLocation(-179.0,0.0);//38.891901,115.521109
        BDLocation bd3=new BDLocation(38.891994,115.521194);

        System.out.print(getDistance(bd1,bd2));
    }
}
