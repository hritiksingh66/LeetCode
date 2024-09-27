import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> events; // List to store booked events
    private List<int[]> doubleBookings; // List to store overlapping intervals for double bookings

    public MyCalendarTwo() {
        events = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check if the new booking would cause a triple booking
        for (int[] doubleBooking : doubleBookings) {
            if (Math.max(doubleBooking[0], start) < Math.min(doubleBooking[1], end)) {
                return false; // This would cause a triple booking
            }
        }

        // If booking is allowed, first check if it creates double bookings
        for (int[] event : events) {
            if (Math.max(event[0], start) < Math.min(event[1], end)) {
                // Found a double booking
                doubleBookings.add(new int[]{
                    Math.max(event[0], start),
                    Math.min(event[1], end)
                });
            }
        }
        events.add(new int[]{start, end});
        return true; // Booking is successful
    }
}
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */