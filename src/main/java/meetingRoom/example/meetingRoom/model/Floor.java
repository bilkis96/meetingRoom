package meetingRoom.example.meetingRoom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Floor {
    private String floorId;
    private Map<String, Room> rooms = new HashMap<>();

    public void addRoom(Room room)
    {
        rooms.putIfAbsent(room.getRoomId(), room);
    }
}
