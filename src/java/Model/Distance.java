/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class Distance extends Flight{
    private String distanceID;
    private String distance;
    private float distancePrice;

    public Distance() {
        super(null, null, null, null, null, null);
    }

    public Distance(String distanceID, String distance, float distancePrice, String flightId, String startDate, String startTime, String endTime, String departure, String destination) {
        super(flightId, startDate, startTime, endTime, departure, destination);
        this.distanceID = distanceID;
        this.distance = distance;
        this.distancePrice = distancePrice;
    }

    public Distance(String distanceID, String distance, float distancePrice, String flightId, String startDate, String endDate, String startTime, String endTime, String departure, String destination) {
        super(flightId, startDate, endDate, startTime, endTime, departure, destination);
        this.distanceID = distanceID;
        this.distance = distance;
        this.distancePrice = distancePrice;
    }
    
    public String getDistanceID() {
        return distanceID;
    }

    public void setDistanceID(String distanceID) {
        this.distanceID = distanceID;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public float getDistancePrice() {
        return distancePrice;
    }

    public void setDistancePrice(float distancePrice) {
        this.distancePrice = distancePrice;
    }

    @Override
    public String toString() {
        return "Distance{" + "distanceID=" + distanceID + ", distance=" + distance + ", distancePrice=" + distancePrice + '}';
    }
}