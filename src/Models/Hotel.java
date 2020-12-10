package Models;

public class Hotel {
    private Customer customer;
    private Room room;

    public Hotel(){
    }

    public Hotel(Customer customer, Room room){
        this.customer = customer;
        this.room = room;

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "rooms=" +
                '}';
    }
}
