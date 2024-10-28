package meetingRoom.example.meetingRoom.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetingRoom.example.meetingRoom.model.Room;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor

public class RoomService {
    public final Map<String, Room> roomMap = new HashMap<>();
    public final BookingService bookingService;

    public Room createRoom(String buildingId, String floorId)
    {
        String roomId = UUID.randomUUID().toString();
        Room room = new Room(roomId,buildingId,floorId);
        roomMap.putIfAbsent(roomId, room);
        return room;
    }

    public Room getRoom(String roomId)
    {
        return roomMap.get(roomId);
    }

    public List<Room> getAllRooms()
    {
        return roomMap.values().stream().toList();
    }
    public List<Room> isRoomAvailableInParticularSlot(String buildingId, Integer startTime, Integer endTime)
    {
        return getAllRooms().stream().filter(room -> bookingService.isRoomAvailable(room,startTime,endTime)).toList();
    }





}
