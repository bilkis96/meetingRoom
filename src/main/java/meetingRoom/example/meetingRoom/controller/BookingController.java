package meetingRoom.example.meetingRoom.controller;

import lombok.AllArgsConstructor;
import meetingRoom.example.meetingRoom.model.Booking;
import meetingRoom.example.meetingRoom.model.Room;
import meetingRoom.example.meetingRoom.service.BookingService;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    public String createBooking(String userId, Room room, Integer startTime, Integer endTime)
    {
        return bookingService.createBooking(userId, room, startTime, endTime);
    }

    public void cancelBooking(String userId, String bookingId)
    {
        bookingService.cancelBooking(userId,bookingId);
    }
    public List<Booking> getAllBookedRoom()
    {
        return bookingService.allBookedRoom();
    }
}
