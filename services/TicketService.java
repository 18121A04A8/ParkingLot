package ParkingLot.services;

import ParkingLot.Repositories.GateRepository;
import ParkingLot.Repositories.ParkingLotRepository;
import ParkingLot.Repositories.TicketRepository;
import ParkingLot.Repositories.VehicleRepository;
import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.factory.SpotAssignmentFactory;
import ParkingLot.models.*;
import ParkingLot.strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }


    public Ticket issueToken(Long gateId, String vehicleNo, String ownerName, VehicleType vehicleType) throws GateNotFoundException {


        Ticket ticket = new Ticket();
        ticket.setCreatedOn(new Date());
        Optional<Gate> optionalGate =gateRepository.getGateById(gateId);
        if(optionalGate.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByVehicleNo(vehicleNo);
        Vehicle savedVehicle;
        if(optionalVehicle.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo(vehicleNo);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save();
            savedVehicle = vehicle;
        }
        else{
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        ParkingLot parkingLot = parkingLotRepository.getParkingLot();
        ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType = parkingLot.getParkingSpotAssignmentStrategyType();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentFactory.getSpotAssignmentStrategy(parkingSpotAssignmentStrategyType);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot();
        ticket.setParkingSpot(parkingSpot);
        ticket.setTicketNo("Ticket_No"+gateId+"_"+ticket.getGeneratedAt());
        ticketRepository.save(ticket);
        return ticket;


    }
}
