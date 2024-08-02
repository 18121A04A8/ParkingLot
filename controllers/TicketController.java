package ParkingLot.controllers;

import ParkingLot.dtos.IssueTicketRequestDto;
import ParkingLot.dtos.IssueTokenResponseDto;
import ParkingLot.dtos.ResponseStatus;
import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.models.Ticket;
import ParkingLot.services.TicketService;

public class TicketController {

    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }


    public IssueTokenResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) throws GateNotFoundException {
        IssueTokenResponseDto resDto = new IssueTokenResponseDto();
        Ticket ticket = ticketService.issueToken(issueTicketRequestDto.getGateId(),
                issueTicketRequestDto.getVehicleNo(),
                issueTicketRequestDto.getOwnerName(),
                issueTicketRequestDto.getVehicleType());
        resDto.setTicket(ticket);
        resDto.setResponseStatus(ResponseStatus.VALID);
        return resDto;

    }
}
