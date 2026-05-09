public class Train {

private int trainID;
private String trainName;
private TrainRoute trainRoute;
private int totalSeats;
private int bookedSeats;

public Train(int trainID, String trainName, TrainRoute trainRoute, int totalSeats, int bookedSeats) {
    this.trainID = trainID;
    this.trainName = trainName;
    this.trainRoute = trainRoute;
    this.totalSeats = totalSeats;
    this.bookedSeats = 0;
}

public int getTrainID() {
    return trainID;
}

public String getTrainName() {
    return trainName;
}
public TrainRoute getTrainRoute() {
    return trainRoute;
}

public int getAvailableSeats() {
    return totalSeats - bookedSeats;
}

public boolean bookedSeatsAvailable(int numberTickets) {
    if ( numberTickets <= bookedSeats) {
        bookedSeats += bookedSeats;
        return true;
    }
    return false;
}

public void trainDisplay() {
    System.out.println("Train ID: " + trainID);
    System.out.println("Train Name: " + trainName);
    trainRoute.routeDisplay();
    System.out.println("Available Seats: " + getAvailableSeats());
}

}
