package meetingRoom.example.meetingRoom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Room {
    private String roomId;
    private String buildingId;
    private String floorId;
}
