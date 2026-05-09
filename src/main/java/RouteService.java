import java.time.LocalTime;
import java.util.List;

public class RouteService {
    private List<Train> trains;

    public RouteService(List<Train> trains) {
        this.trains = trains;
    }

    public void findConnections(String departureStation, String arrivalStation) {
        boolean found = false;

        System.out.println();
        System.out.println("Searching connections from " + departureStation + " to " + arrivalStation + " ");

        for (Train train : trains) {
            if (train.directConnection(departureStation, arrivalStation)) {
                found = true;

                System.out.println("Direct connection found:");
                System.out.println("Train: " + train.getTrainName());
                System.out.println("Departure: " + departureStation + " at " + train.getDepartureTime(departureStation));
                System.out.println("Arrival: " + arrivalStation + " at " + train.getArrivalTime(arrivalStation));
                System.out.println();
            }
        }

        for (Train firstTrain : trains) {
            if (firstTrain.getStationIndex(departureStation) == -1) {
                continue;
            }

            for (TrainSchedule changeStationSchedule : firstTrain.getTrainSchedule()) {
                String changeStation = changeStationSchedule.getTrainStation().getName();

                if (!firstTrain.directConnection(departureStation, changeStation)) {
                    continue;
                }

                LocalTime firstArrivalTime = firstTrain.getArrivalTime(changeStation);

                for (Train secondTrain : trains) {
                    if (secondTrain == firstTrain) {
                        continue;
                    }

                    if (secondTrain.directConnection(changeStation, arrivalStation)) {
                        LocalTime secondDepartureTime = secondTrain.getDepartureTime(changeStation);

                        if (secondDepartureTime.isAfter(firstArrivalTime)) {
                            found = true;

                            System.out.println("Connection with changeover found:");
                            System.out.println("First train: " + firstTrain.getTrainName());
                            System.out.println("Departure: " + departureStation + " at " + firstTrain.getDepartureTime(departureStation));
                            System.out.println("Arrive at change station: " + changeStation + " at " + firstArrivalTime);

                            System.out.println("Changeover station: " + changeStation);

                            System.out.println("Second train: " + secondTrain.getTrainName());
                            System.out.println("Departure: " + changeStation + " at " + secondDepartureTime);
                            System.out.println("Arrival: " + arrivalStation + " at " + secondTrain.getArrivalTime(arrivalStation));
                            System.out.println();
                        }
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No connection coudl be found in between those stations.");
        }
    }
}
