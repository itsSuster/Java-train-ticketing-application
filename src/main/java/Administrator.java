import java.util.List;

public class Administrator {

    private List<Train> trains;
    private List<TrainRoute> routes;
    private BookingService bookingService;
    private Email email;

    public Administrator(List<Train> trains, List<TrainRoute> routes, BookingService bookingService) {
        this.trains = trains;
        this.routes = routes;
        this.bookingService = bookingService;
        this.email = new Email();
    }

    public void addRoute(TrainRoute route) {
        routes.add(route);
        System.out.println("Route added successfully.");
    }

    public void removeRoute(String routeName) {
        routes.removeIf(route -> route.getRouteName().equalsIgnoreCase(routeName));
        System.out.println("Route removed successfully.");
    }

    public void modifyRoute(String oldRouteName, TrainRoute newRoute) {
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getRouteName().equalsIgnoreCase(oldRouteName)) {
                routes.set(i, newRoute);
                System.out.println("Route modified successfully.");
                return;
            }
        }

        System.out.println("Route not found.");
    }

    public void addTrain(Train train) {
        trains.add(train);
        System.out.println("Train added successfully.");
    }

    public void removeTrain(int trainId) {
        trains.removeIf(train -> train.getTrainID() == trainId);
        System.out.println("Train removed successfully.");
    }

    public void modifyTrain(int trainId, Train newTrain) {
        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getTrainID() == trainId) {
                trains.set(i, newTrain);
                System.out.println("Train modified successfully.");
                return;
            }
        }

        System.out.println("Train not found.");
    }

    public void showBookingsForTrain(Train train) {
        bookingService.showBookingsForTrain(train);
    }

    public void markTrainDelayed(Train train, int delayMinutes) {
        train.setDelayMinutes(delayMinutes);

        System.out.println("Train " + train.getTrainName()
                + " marked as delayed by " + delayMinutes + " minutes.");

        for (Booking booking : bookingService.getBookings()) {
            if (booking.getTrain() == train) {
                email.sendDelayEmail(booking, delayMinutes);
            }
        }
    }
}

