import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TrainStations brasov = new TrainStations("Brasov");
        TrainStations sinaia = new TrainStations("Sinaia");
        TrainStations ploiesti = new TrainStations("Ploiesti");
        TrainStations bucuresti = new TrainStations("Bucuresti");
        TrainStations constanta = new TrainStations("Constanta");
        TrainStations cluj = new TrainStations("Cluj");

        TrainRoute route1 = new TrainRoute(
                "Brasov - Bucuresti",
                Arrays.asList(brasov, sinaia, ploiesti, bucuresti)
        );

        TrainRoute route2 = new TrainRoute(
                "Bucuresti - Constanta",
                Arrays.asList(bucuresti, constanta)
        );

        TrainRoute route3 = new TrainRoute(
                "Cluj - Brasov",
                Arrays.asList(cluj, brasov)
        );

        Train train1 = new Train(
                1,
                "IR 6700",
                Arrays.asList(
                        new TrainSchedule(brasov, null, LocalTime.of(8, 0)),
                        new TrainSchedule(sinaia, LocalTime.of(9, 0), LocalTime.of(9, 5)),
                        new TrainSchedule(ploiesti, LocalTime.of(10, 0), LocalTime.of(10, 10)),
                        new TrainSchedule(bucuresti, LocalTime.of(11, 0), null)
                ),
                100
        );

        Train train2 = new Train(
                2,
                "IR 1999",
                Arrays.asList(
                        new TrainSchedule(bucuresti, null, LocalTime.of(12, 0)),
                        new TrainSchedule(constanta, LocalTime.of(14, 30), null)
                ),
                80
        );

        Train train3 = new Train(
                3,
                "IR 2005",
                Arrays.asList(
                        new TrainSchedule(cluj, null, LocalTime.of(6, 0)),
                        new TrainSchedule(brasov, LocalTime.of(10, 30), null)
                ),
                50
        );

        List<TrainRoute> routes = new ArrayList<>();
        routes.add(route1);
        routes.add(route2);
        routes.add(route3);

        List<Train> trains = new ArrayList<>();
        trains.add(train1);
        trains.add(train2);
        trains.add(train3);

        BookingService bookingService = new BookingService();
        RouteService routeService = new RouteService(trains);
        Administrator administrator = new Administrator(trains, routes, bookingService);

        System.out.println("BOOKINGS");

        bookingService.bookTickets("Marian Cosmin", "marianCosmin1999@gmail.com", train1, 2);
        bookingService.bookTickets("George Paladi", "paladigeorge87@gmail.com", train1, 3);
        bookingService.bookTickets("Marius Moga", "mariusmmga94@gmail.com", train1, 200);

        System.out.println();

        System.out.println("ROUTE SEARCH");

        routeService.findConnections("Brasov", "Bucuresti");

        routeService.findConnections("Brasov", "Constanta");

        routeService.findConnections("Cluj", "Constanta");

        routeService.findConnections("Constanta", "Cluj");

        System.out.println();

        System.out.println("ADMIN");

        administrator.showBookingsForTrain(train1);

        administrator.markTrainDelayed(train1, 30);

        TrainStations timisoara = new TrainStations("Timisoara");
        TrainRoute newRoute = new TrainRoute(
                "Timisoara - Cluj",
                Arrays.asList(timisoara, cluj)
        );

        administrator.addRoute(newRoute);

        Train newTrain = new Train(
                4,
                "IR 2000",
                Arrays.asList(
                        new TrainSchedule(timisoara, null, LocalTime.of(7, 0)),
                        new TrainSchedule(cluj, LocalTime.of(12, 0), null)
                ),
                120
        );

        administrator.addTrain(newTrain);

        administrator.removeTrain(4);
        administrator.removeRoute("Timisoara - Cluj");
    }
}