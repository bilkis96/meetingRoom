package meetingRoom.example.meetingRoom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
public class Booking {
    private String userId;
    private String bookingId;
    private Room room;
    private Integer startTime;
    private Integer endTime;
}
