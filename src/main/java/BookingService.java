import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private List<Booking> bookings = new ArrayList<>();
    private Email email = new Email();

    public void bookTickets(String customerName, String customerEmail, Train train, int numberOfTickets) {
        if (numberOfTickets <= 0) {
            System.out.println("Invalid number of tickets.");
            return;
        }

        if (train.bookedSeatsAvailable(numberOfTickets)) {
            Booking booking = new Booking(customerName, customerEmail, train, numberOfTickets);
            bookings.add(booking);

            System.out.println("Booking successful!");
            System.out.println("Booking ID: " + booking.getBookingID());

            email.confirmationEmail(booking);
        } else {
            System.out.println("Booking failed!");
            System.out.println("Not enough available seats.");
            System.out.println("Available seats: " + train.getAvailableSeats());
        }
    }
}

