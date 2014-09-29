package name.marmar.javatwo.service;

import name.marmar.javatwo.model.Room;

import javax.inject.Singleton;
import java.util.*;

/** Catalogue of the rooms for JavaTwo conference.
 */
@Singleton
public class RoomCatalogueService {

    static final List<Room> rooms = new ArrayList<>();
    static final Map<Integer, Room> roomsMap = new HashMap<>();
    static {
        rooms.add(new Room(101, "West", "Super Hotel", 40));
        rooms.add(new Room(102, "East", "Super Hotel", 50));
        rooms.add(new Room(206, "North", "Super Hotel", 40));
        rooms.add(new Room(222, "South", "Super Hotel", 55));
        rooms.add(new Room(1024, "Ball hall", "City center", 128));
        for (Room room : rooms) {
            roomsMap.put(room.getNumber(), room);
        }
    }


    public RoomCatalogueService() {
    }

    public List<Room> listRooms() {
        return Collections.unmodifiableList(rooms);
    }

    public Room getRoomByNumber(int number) {
        for (Room room : rooms) {
            if (number == room.getNumber()) {
                return room;
            }
        }
        return null;
    }
}
