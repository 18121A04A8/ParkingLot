package ParkingLot;

import ParkingLot.Repositories.GateRepository;
import ParkingLot.Repositories.ParkingLotRepository;
import ParkingLot.Repositories.TicketRepository;
import ParkingLot.Repositories.VehicleRepository;
import ParkingLot.controllers.TicketController;
import ParkingLot.dtos.IssueTicketRequestDto;
import ParkingLot.dtos.IssueTokenResponseDto;
import ParkingLot.dtos.ResponseStatus;
import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.exceptions.InvalidTicketException;
import ParkingLot.models.Ticket;
import ParkingLot.services.TicketService;

public class Client {
    public static void main(String[] args) throws InvalidTicketException, GateNotFoundException {
        TicketRepository ticketRepository = new TicketRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                ticketRepository,
                parkingLotRepository);
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        IssueTokenResponseDto issueTokenResponseDto = ticketController.issueTicket(issueTicketRequestDto);

        if(issueTokenResponseDto.getResponseStatus().equals(ResponseStatus.VALID)){
            Ticket ticket = issueTokenResponseDto.getTicket();
        }
        else{
            throw new InvalidTicketException();
        }

    }
}
