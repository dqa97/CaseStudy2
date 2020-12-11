package Models;

public class Room {
    private String idRoom;
    private String typeRoom;
    private long price;
    private String dateOfRent;

    public Room() {
    }

    public Room(String isCustom, String typeRoom, long price, String dateOfRent) {
        this.idRoom = isCustom;
        this.typeRoom = typeRoom;
        this.price = price;
        this.dateOfRent = dateOfRent;
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

    public String getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(String dateOfRent) {
        this.dateOfRent = dateOfRent;
    }


    @Override
    public String toString() {
        return "Room{" +
                "idRoom='" + idRoom + '\'' +
                ", typeRoom=" + typeRoom +
                ", price=" + price +
                ", isRent=" +
                '}';
    }
}
