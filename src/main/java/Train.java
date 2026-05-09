import java.time.LocalTime;
import java.util.List;

public class Train {

private int trainID;
private String trainName;
private List<TrainSchedule> trainSchedule;
private int totalSeats;
private int bookedSeats;
private int delayMinutes = 0;

public Train(int trainID, String trainName, List<TrainSchedule> trainSchedule, int totalSeats) {
    this.trainID = trainID;
    this.trainName = trainName;
    this.trainSchedule = trainSchedule;
    this.totalSeats = totalSeats;
    this.bookedSeats = 0;
}

public int getTrainID() {
    return trainID;
}

public String getTrainName() {
    return trainName;
}
public List<TrainSchedule> getTrainSchedule() {
    return trainSchedule;
}

public int getAvailableSeats() {
    return totalSeats - bookedSeats;
}

public int getDelayMinutes() {
    return delayMinutes;
}

public void setDelayMinutes(int delayMinutes) {
    this.delayMinutes = delayMinutes;
}

public boolean bookedSeatsAvailable(int numberTickets) {
    if (numberTickets <= getAvailableSeats()) {
        bookedSeats += numberTickets;
        return true;
    }
    return false;
}

    public int getStationIndex(String stationName) {
        for (int i = 0; i < trainSchedule.size(); i++) {
            if (trainSchedule.get(i).getTrainStation().getName().equals(stationName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean directConnection(String departureStation, String arrivalStation) {
        int departureIndex = getStationIndex(departureStation);
        int arrivalIndex = getStationIndex(arrivalStation);

        return departureIndex != -1 && arrivalIndex != -1 && departureIndex < arrivalIndex;
    }

    public LocalTime getDepartureTime(String stationName) {
        int index = getStationIndex(stationName);
        if (index == -1) {
            return null;
        }
        return trainSchedule.get(index).getDepartureTime();
    }

    public LocalTime getArrivalTime(String stationName) {
        int index = getStationIndex(stationName);
        if (index == -1) {
            return null;
        }
        return trainSchedule.get(index).getArrivalTime();
    }

}
