/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Pham Thinh
 */
public class DistanceV2 {
    String distanceID;
    float distance;
    float price;

    public DistanceV2() {
    }

    public DistanceV2(String distanceID, float distance, float price) {
        this.distanceID = distanceID;
        this.distance = distance;
        this.price = price;
    }

    public String getDistanceID() {
        return distanceID;
    }

    public void setDistanceID(String distanceID) {
        this.distanceID = distanceID;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DistanceV2{" + "distanceID=" + distanceID + ", distance=" + distance + ", price=" + price + '}';
    }
    
    
}
