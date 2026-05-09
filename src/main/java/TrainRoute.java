import java.util.List;

public class TrainRoute {

    private String routeName;
    private List<TrainStations>  trainStations;
    public TrainRoute(String routeName, List<TrainStations> trainStations) {
        this.routeName = routeName;
        this.trainStations = trainStations;
    }

    public String getRouteName() {
        return routeName;
    }

    public List<TrainStations> getTrainStations() {
        return trainStations;
    }

    public void routeDisplay() {
        System.out.println("Route Name: " + routeName);
        for (int i = 0; i < trainStations.size();i++) {
            System.out.println("Train Station: " + trainStations.get(i).getName());
            if (i < trainStations.size() - 1) {
                System.out.println("Train Station: " + trainStations.get(i + 1).getName());
            }
        }
        System.out.println();
    }
}
