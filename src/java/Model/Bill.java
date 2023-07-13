package Model;

import java.util.Date;

public class Bill {

    private String orderID, departure, startTime, destination, endTime;
    private Date startDate, endDate;
    private String totalAmount;
    private String userID, promotionID, isConfirmed;
    private Date date;
    private float Tax;

    public Bill() {
    }

    public Bill(String orderID, String userID, Date date, String promotionID, float Tax, String totalAmount, String isConfirmed) {
        this.orderID = orderID;
        this.totalAmount = totalAmount;
        this.userID = userID;
        this.promotionID = promotionID;
        this.isConfirmed = isConfirmed;
        this.date = date;
        this.Tax = Tax;
    }

    public Bill(String orderID, String totalAmount, String departure, Date startDate, String startTime, String destination, Date endDate, String endTime) {
        this.orderID = orderID;
        this.departure = departure;
        this.startTime = startTime;
        this.destination = destination;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = totalAmount;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getDeparture() {
        return departure;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getEndTime() {
        return endTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setOrderID(String billID) {
        this.orderID = billID;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUserID() {
        return userID;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public String getIsConfirmed() {
        return isConfirmed;
    }

    public Date getDate() {
        return date;
    }

    public float getTax() {
        return Tax;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public void setIsConfirmed(String isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTax(float Tax) {
        this.Tax = Tax;
    }

}
