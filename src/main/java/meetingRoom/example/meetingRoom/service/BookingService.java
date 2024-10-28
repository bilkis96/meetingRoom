package meetingRoom.example.meetingRoom.service;

import lombok.extern.slf4j.Slf4j;
import meetingRoom.example.meetingRoom.model.Booking;
import meetingRoom.example.meetingRoom.model.Room;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class BookingService {

    public final Map<String , Booking> bookingMap = new HashMap<>();
    public String createBooking(String userId, Room room, Integer startTime, Integer endTime)
    {
        if(!isRoomAvailable(room,startTime,endTime))
        {
            return "Room is not available";
        }
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, userId, room,startTime, endTime);
        bookingMap.putIfAbsent(bookingId,booking);
        return booking.getBookingId();
    }

    public Booking getBookingById(String bookingId)
    {
        return bookingMap.get(bookingId);
    }
    public Boolean isRoomAvailable(Room room, Integer startTime, Integer endTime)
    {
        String roomId = room.getRoomId();
        if(!bookingMap.containsKey(roomId))
        {
            return Boolean.TRUE;
        }
        Booking booking = bookingMap.get(roomId);
        return endTime<booking.getStartTime() || startTime>booking.getEndTime();
    }

    public void cancelBooking(String userId, String bookingId)
    {
        bookingMap.remove(bookingId);
    }
    public List<Booking> allBookedRoom()
    {
        return bookingMap.values().stream().toList();
    }

}
