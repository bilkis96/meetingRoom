package meetingRoom.example.meetingRoom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
public class Building {
    private String buildingId;
    Map<String, Floor> floors = new HashMap<>();

    public void addFloor(Floor floor)
    {
        floors.putIfAbsent(floor.getFloorId(), floor);
    }
}
