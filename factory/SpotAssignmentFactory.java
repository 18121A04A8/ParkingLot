package ParkingLot.factory;

import ParkingLot.models.ParkingSpotAssignmentStrategyType;
import ParkingLot.strategies.CheapestSpotAssignmentStrategy;
import ParkingLot.strategies.NearestSpotAssignmentStrategy;
import ParkingLot.strategies.SpotAssignmentStrategy;

public class SpotAssignmentFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType){
        if(parkingSpotAssignmentStrategyType.equals(ParkingSpotAssignmentStrategyType.NEAREST)){
            return new NearestSpotAssignmentStrategy();
        }
        else if(parkingSpotAssignmentStrategyType.equals(ParkingSpotAssignmentStrategyType.CHEAPEST)){
            return new CheapestSpotAssignmentStrategy();
        }
        else{
            return null;
        }
    }
}
