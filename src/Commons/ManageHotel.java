package Commons;

import Models.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ManageHotel {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String fileManageHotel = "src/Data/Hotel.csv";
    private static final String FILE_HEADER = "typeRoom,dateOfRent,price,idRoom";

    public static void writeManageHotelToFileCSV(ArrayList<Room> listRoom) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileManageHotel);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Room room : listRoom) {
                fileWriter.append(room.getTypeRoom()+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getDateOfRent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append((room.getPrice())+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getIdRoom());
                fileWriter.append(NEW_LINE_SEPARATOR);

            }

        } catch (Exception e) {
            System.out.println("Lỗi trong Csv FileWriter !!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e){
                System.out.println(" Lỗi khi đóng luồng và đóng bộ nhớ đệm !");
            }
        }
    }

    public static ArrayList<Room> getFileCSVToListRoom(){
        BufferedReader br = null;
        ArrayList<Room> listRoom = new ArrayList<>();
        Path path = Paths.get(fileManageHotel);
        if (!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileManageHotel);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try{
            String line;
            br = new BufferedReader(new FileReader(fileManageHotel));

            while ((line = br.readLine())!= null){
                String[] splitData = line.split(",");
                if(splitData[0].equals("typeRoom")){
                    continue;
                }
                Room room = new Room();
                room.setTypeRoom(splitData[0]);
                room.setDateOfRent(splitData[1]);
                room.setPrice(Long.parseLong(splitData[2]));
                room.setIdRoom(splitData[3]);
                listRoom.add(room);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return listRoom;
    }
}
