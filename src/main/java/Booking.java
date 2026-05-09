public class Booking {

    private static int nextBookingID = 0;
    private int bookingID;
    private String customerName;
    private String customerEmail;
    private Train train;
    private int numberTickets;

    public Booking(String customerName, String customerEmail, Train train, int numberTickets) {
        this.bookingID = nextBookingID++;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.train = train;
        this.numberTickets = numberTickets;
    }

   public int  getBookingID() {
        return bookingID;
    }
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Train getTrain() {
        return train;
    }

    public int getNumberTickets() {
        return numberTickets;
    }

}
