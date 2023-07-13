package Model;

public class TicketType {

    private String ticketTypeId;
    private String ticketType;
    private String ticketPrice;
    private String ticketSumAdult;
    private String ticketSumKid;

    public TicketType() {
    }

    public TicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public TicketType(String ticketId, String ticketType, String ticketPrice) {
        this.ticketTypeId = ticketId;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }

    public TicketType(String ticketType, String ticketPrice) {
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(String ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketSumAdult() {
        return ticketSumAdult;
    }

    public void setTicketSumAdult(String ticketSumAdult) {
        this.ticketSumAdult = ticketSumAdult;
    }

    public String getTicketSumKid() {
        return ticketSumKid;
    }

    public void setTicketSumKid(String ticketSumKid) {
        this.ticketSumKid = ticketSumKid;
    }

    @Override
    public String toString() {
        return "TicketType{"
                + "ticketTypeId='" + ticketTypeId + '\''
                + ", ticketType='" + ticketType + '\''
                + ", ticketPrice='" + ticketPrice + '\''
                + '}';
    }
}
