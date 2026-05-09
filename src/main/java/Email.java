public class Email {

    public void confirmationEmail(Booking booking) {
        System.out.println();
        System.out.println("Sending confirmation email...");
        System.out.println("To: " + booking.getCustomerEmail());
        System.out.println("Subject: Train ticket booking confirmation");
        System.out.println("Hello " + booking.getCustomerName() + ",");
        System.out.println("Your booking was successful.");
        System.out.println("Booking ID: " + booking.getBookingID());
        System.out.println("Train: " + booking.getTrain().getTrainName());
        System.out.println("Tickets booked: " + booking.getNumberTickets());
        System.out.println("Thank you!");
        System.out.println();
    }
}
