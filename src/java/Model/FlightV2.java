/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Pham Thinh
 */
public class FlightV2 {
    String flightId;
    String startDate;
    String endDate;
    String startTime;
    String endTime;
    String departure;
    String destination;
    int gate;
    int seatsB;
    int seatsC;
    float price;

    public FlightV2() {
    }

    public FlightV2(String flightId, String startDate, String endDate, String startTime, String endTime, String departure, String destination, int gate, int seatsB, int seatsC, float price) {
        this.flightId = flightId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.departure = departure;
        this.destination = destination;
        this.gate = gate;
        this.seatsB = seatsB;
        this.seatsC = seatsC;
        this.price = price;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public int getSeatsB() {
        return seatsB;
    }

    public void setSeatsB(int seatsB) {
        this.seatsB = seatsB;
    }

    public int getSeatsC() {
        return seatsC;
    }

    public void setSeatsC(int seatsC) {
        this.seatsC = seatsC;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FlightV2{" + "flightId=" + flightId + ", startDate=" + startDate + ", endDate=" + endDate + ", startTime=" + startTime + ", endTime=" + endTime + ", departure=" + departure + ", destination=" + destination + ", gate=" + gate + ", seatsB=" + seatsB + ", seatsC=" + seatsC + ", price=" + price + '}';
    }

    
    
    
    
}
