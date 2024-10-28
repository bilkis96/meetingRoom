package meetingRoom.example.meetingRoom.controller;

import lombok.AllArgsConstructor;
import meetingRoom.example.meetingRoom.model.Room;
import meetingRoom.example.meetingRoom.service.BookingService;
import meetingRoom.example.meetingRoom.service.RoomService;

import java.util.List;

@AllArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final BookingService bookingService;

    public String createRoom(String buildingId, String floorId)
    {
        return roomService.createRoom(buildingId,floorId).getRoomId();
    }
    public List<Room> getAvailableRoomInGivenSlots(String buildingId, Integer startTime, Integer endTime)
    {
        return roomService.isRoomAvailableInParticularSlot(buildingId,startTime,endTime);
    }
}
