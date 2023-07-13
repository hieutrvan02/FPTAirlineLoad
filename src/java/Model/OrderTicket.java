package Model;

import java.util.Date;

public class OrderTicket {

    private String orderID;

    private String totalAmount;
    private String userID, promotionID, isConfirmed;
    private Date date;
    private float Tax;

    public OrderTicket() {
    }

    public OrderTicket(String orderID, String userID, Date date, String promotionID, float Tax, String totalAmount, String isConfirmed) {
        this.orderID = orderID;
        this.totalAmount = totalAmount;
        this.userID = userID;
        this.promotionID = promotionID;
        this.isConfirmed = isConfirmed;
        this.date = date;
        this.Tax = Tax;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setOrderID(String billID) {
        this.orderID = billID;
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
