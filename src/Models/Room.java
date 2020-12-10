package Models;

public class Room {
    private String idRoom;
    private String typeRoom;
    private long price;
    private String dateOfRent;
    private boolean isRent;
    private Customer customer;

    public Room() {
    }

    public Room(String isCustom, String typeRoom, long price, String dateOfRent, boolean isRent, Customer customer) {
        this.idRoom = isCustom;
        this.typeRoom = typeRoom;
        this.price = price;
        this.dateOfRent = dateOfRent;
        this.isRent = isRent;
        this.customer = customer;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isRent() {
        return isRent;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }

    public String getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(String dateOfRent) {
        this.dateOfRent = dateOfRent;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom='" + idRoom + '\'' +
                ", typeRoom=" + typeRoom +
                ", price=" + price +
                ", isRent=" + isRent +
                '}';
    }
}
