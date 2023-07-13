package Model;


public class Ticket {
    private String ticketID;
    private String orderID;
    private String flightID;
    private String ticketTypeID;
    private String luggageID;

    public Ticket() {
    }

    public Ticket(String ticketID, String orderID, String flightID, String ticketTypeID, String luggageID) {
        this.ticketID = ticketID;
        this.orderID = orderID;
        this.flightID = flightID;
        this.ticketTypeID = ticketTypeID;
        this.luggageID = luggageID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getTicketTypeID() {
        return ticketTypeID;
    }

    public void setTicketTypeID(String ticketTypeID) {
        this.ticketTypeID = ticketTypeID;
    }

    public String getLuggageID() {
        return luggageID;
    }

    public void setLuggageID(String luggageID) {
        this.luggageID = luggageID;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketID=" + ticketID + ", orderID=" + orderID + ", flightID=" + flightID + ", ticketTypeID=" + ticketTypeID + ", luggageID=" + luggageID + '}';
    }

}
