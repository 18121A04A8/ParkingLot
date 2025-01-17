package ParkingLot.Repositories;

import ParkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    Map<Long, Gate> gates = new HashMap();
    public Optional<Gate> getGateById(Long gateId){
        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }

        return Optional.empty();
    }
}
