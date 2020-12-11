package Views;

import Commons.EnumClass;
import Commons.FuncFileCSV;
import Commons.ManageHotel;
import Models.Customer;
import Models.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Customer> listCustomer = new ArrayList<>();
    private static ArrayList<Room> listRoom = new ArrayList<>();


    public static void displayMainMenu() {
        System.out.println("1. Đăng kí nhận phòng.\n" +
                "2. Kiểm tra phòng.\n" +
                "3. Hiển thị thông tin khách hàng.\n" +
                "4. Sửa thông tin khách hàng.\n" +
                "5. Khách trả phòng.\n" +
                "6. Xóa thông tin khách hàng.\n" +
                "7. Exit.");
        Scanner sc = new Scanner(System.in);
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                addCustomer();
                break;
            case "2":
                checkRoom();
                break;
            case "3":
                showInfoCustomer();
                break;
            case "4":
                correctCustomInfo();
            case "5":
                checkOut();
                break;
            case "6":
                deteleCustomer();
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("Lỗi ! Xin hãy nhập lại ...");
                sc.nextLine();
                displayMainMenu();
        }
    }

    private static void correctCustomInfo() {listRoom = ManageHotel.getFileCSVToListRoom();
        listCustomer = FuncFileCSV.getFileCSVToListCustomer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phòng: ");
        int searchIDRoom = checkInputInt(sc," Value in number");
        System.out.println("1. Sửa tên khách hàng.\n" +
                "2. Sửa tuổi khách hàng.\n" +
                "3. Sửa chứng minh thư khách hàng.\n" +
                "4. Đổi phòng cho khách hàng.\n" +
                "5. Đổi kiểu phòng cho khách hàng.\n" +
                "6. Đổi thời gian thuê phòng cho khách hàng.\n" +
                "7. Thay đổi giá phòng cho khách hàng.\n");
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getIdRoom().equals(searchIDRoom+"")) {
                String choose = sc.nextLine();
                switch (choose){
                    case "1":
                        System.out.println("Sửa tên khách hàng");
                        listCustomer.get(i).setName(sc.nextLine());
                        break;
                    case "2":
                        System.out.println("Sửa tuổi khách hàng");
                        listCustomer.get(i).setAge(sc.nextLine());
                        break;
                    case "3":
                        System.out.println("Sửa chứng minh thư khách hàng");
                        listCustomer.get(i).setCmt(sc.nextLine());
                        break;
                    case "4":
                        System.out.println("Đổi phòng cho khách hàng");
                        listRoom.get(i).setIdRoom(sc.nextLine());
                        break;
                    case "5":
                        System.out.println("Đổi kiểu phòng cho khách hàng(VIP/ECONOMY");
                        listRoom.get(i).setTypeRoom(sc.nextLine());
                        break;
                    case "6":
                        System.out.println("Đổi thời gian thuê phòng cho khách hàng");
                        listRoom.get(i).setTypeRoom(sc.nextLine());
                        break;
                    case "7":
                        System.out.println("Đổi giá phòng cho khách hàng(VIP/ECONOMY)");
                        listRoom.get(i).setPrice(sc.nextLong());
                    default:
                        System.out.println("Lỗi...Hãy nhập lại");
                        sc.nextLine();
                }
            }
        }
        FuncFileCSV.writeCustomerToFileCSV(listCustomer);
        ManageHotel.writeManageHotelToFileCSV(listRoom);
        System.out.println("Thay đổi thành công");
        displayMainMenu();

    }

    private static void deteleCustomer() {
        listRoom = ManageHotel.getFileCSVToListRoom();
        listCustomer = FuncFileCSV.getFileCSVToListCustomer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phòng: ");
        int searchIDRoom = checkInputInt(sc," Value in number");
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getIdRoom().equals(searchIDRoom+"")) {
                listRoom.remove(i);
                listCustomer.remove(i);
            }
        }
        FuncFileCSV.writeCustomerToFileCSV(listCustomer);
        ManageHotel.writeManageHotelToFileCSV(listRoom);
        displayMainMenu();
    }

    private static void addCustomer() {
        listCustomer = FuncFileCSV.getFileCSVToListCustomer();
        listRoom = ManageHotel.getFileCSVToListRoom();
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        Room room = new Room();

        System.out.println(" Nhập tên khách hàng ");
        customer.setName(sc.nextLine());
        System.out.println(" Nhập tuổi khách hàng ");
        customer.setAge(sc.nextLine());
        System.out.println(" Nhập chứng minh thư ");
        customer.setCmt(sc.nextLine());
        System.out.println("Chọn kiểu phòng\n" + "1.VIP\n" + "2.ECONOMY");
        String choose1 = sc.nextLine();
        switch (choose1) {
            case "1":
                room.setTypeRoom("VIP");
                break;
            case "2":
                room.setTypeRoom("ECONOMY");
                break;
            default:
                System.out.println("Lỗi ! Xin hãy nhập lại ...");
                sc.nextLine();
                displayMainMenu();
        }

        System.out.println("Nhập số ngày thuê trọ ");
        room.setDateOfRent(sc.nextLine());
        System.out.println("Giá phòng($):\n" + "1. VIP\n" + "2. ECONOMY");
        String choose2 = sc.nextLine();
        switch (choose2) {
            case "1":
                room.setPrice(EnumClass.VIP);
                System.out.println(EnumClass.VIP);
                break;
            case "2":
                room.setPrice(EnumClass.ECONOMY);
                System.out.println(EnumClass.ECONOMY);
                break;
            default:
                System.out.println("Lỗi ! Xin hãy nhập lại ...");
                sc.nextLine();
                displayMainMenu();
        }

        boolean checkRoomUse;
        int idRoom;
        do {
            checkRoomUse = false;
            System.out.println("Phòng số: ");
            idRoom = checkInputInt(sc, "Giá trị của biến phải là chữ số");
            for (Room value : listRoom) {
                int idRoomUse = Integer.parseInt(value.getIdRoom());
                if (idRoomUse == idRoom) {
                    System.out.println("Phòng đang được sử dụng...");
                    checkRoomUse = true;
                    break;
                }
            }
        } while (checkRoomUse);
        room.setIdRoom(idRoom + "");

        listCustomer.add(customer);
        listRoom.add(room);
        FuncFileCSV.writeCustomerToFileCSV(listCustomer);
        ManageHotel.writeManageHotelToFileCSV(listRoom);
        System.out.println("Hoàn thành thông tin khách hàng! Nhấn Enter để tiếp tục...");
        sc.nextLine();
        displayMainMenu();
    }

    private static int checkInputInt(Scanner input, String mess) {
        boolean check = true;
        int number = -1;
        while (check) {
            try {
                number = Integer.parseInt(input.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(" Hãy nhập lại " + mess);
            }
        }
        return number;
    }

    private static void checkRoom() {
        listRoom = ManageHotel.getFileCSVToListRoom();
        ArrayList<Integer> listIdRomUse = new ArrayList<>();

        System.out.println(listRoom.size());
        System.out.println("Phòng đang sử dụng: ");
        for (Room room : listRoom) {
            String idRoom = room.getIdRoom();
            System.out.print("Phòng số: " + idRoom + ", ");
            listIdRomUse.add(Integer.parseInt(idRoom));
        }

        System.out.println();
        System.out.println("Phòng còn trống là: ");
        for (int i = 1; i < 21; i++) {
            if (!listIdRomUse.contains(i)) {
                System.out.print("Phòng số: " + i + ", ");
            }
        }
        System.out.println();
        displayMainMenu();
    }

    private static void showInfoCustomer() {
        listCustomer = FuncFileCSV.getFileCSVToListCustomer();
        listRoom = ManageHotel.getFileCSVToListRoom();

        for (int i = 0; i < listRoom.size(); i++) {
            System.out.println("*********************************************");
            System.out.println(" Tên khách hàng: " + listCustomer.get(i).getName());
            System.out.println(" Tuổi khách hàng: " + listCustomer.get(i).getAge());
            System.out.println(" Số chứng minh thư khách hàng: " + listCustomer.get(i).getCmt());
            System.out.println(" Loại phòng sử dụng: " + listRoom.get(i).getTypeRoom());
            System.out.println(" Số ngày sử dụng: " + listRoom.get(i).getDateOfRent());
            System.out.println(" Giá phòng($/day): " + listRoom.get(i).getPrice());
            System.out.println(" Phòng số: " + listRoom.get(i).getIdRoom());
            System.out.println("*********************************************");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhấn Enter để tiếp tục...");
        sc.nextLine();
        displayMainMenu();
    }

    private static void checkOut() {
        listRoom = ManageHotel.getFileCSVToListRoom();
        listCustomer = FuncFileCSV.getFileCSVToListCustomer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phòng: ");
        int searchIDRoom = checkInputInt(sc, " Value in number");
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getIdRoom().equals(searchIDRoom + "")) {
                long bill;
                bill = Long.parseLong(listRoom.get(i).getDateOfRent()) * listRoom.get(i).getPrice();
                System.out.println("Số tiền cần thanh toán là: " + bill + "$");
            }
        }
        displayMainMenu();
    }
    public static void main(String[] args) {
        displayMainMenu();
    }
}
