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
            System.out.println(customerName + " requested " + numberOfTickets + " tickets.");
            System.out.println("Not enough available seats.");
            System.out.println("Available seats: " + train.getAvailableSeats());
        }
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void showBookingsForTrain(Train train) {
        boolean found = false;

        System.out.println("Bookings for train: " + train.getTrainName());

        for (Booking booking : bookings) {
            if (booking.getTrain() == train) {
                found = true;
                System.out.println("Booking ID: " + booking.getBookingID());
                System.out.println("Customer: " + booking.getCustomerName());
                System.out.println("Email: " + booking.getCustomerEmail());
                System.out.println("Tickets: " + booking.getNumberTickets());
            }
        }

        if (!found) {
            System.out.println("No bookings found for this train.");
        }
    }

}

