import java.time.LocalTime;

public class TrainSchedule {

        private TrainStations trainStation;
        private LocalTime arrivalTime;
        private LocalTime departureTime;

        public TrainSchedule(TrainStations trainStation, LocalTime arrivalTime, LocalTime departureTime) {
            this.trainStation = trainStation;
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }

        public TrainStations getTrainStation() {
            return trainStation;
        }

        public LocalTime getArrivalTime() {
            return arrivalTime;
        }

        public LocalTime getDepartureTime() {
            return departureTime;
        }
    }
