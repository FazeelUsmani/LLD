package services;

import dto.Ticket;
import dto.User;
import enums.TicketState;

public class TicketService {

    public Ticket createTicket(String description, User createdBy) {
        return new Ticket(description, createdBy);
    }

    public void changeTicketState(Ticket ticket, TicketState newState) {
        TicketState oldState = ticket.getTicketState();
        if (oldState.equals(TicketState.InProgress)) {
            if (newState.equals(TicketState.Review)) {
                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
            }
            else if (newState.equals(TicketState.Done)) {
                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
            }
            else if (newState.equals(TicketState.InProgress)) {
                System.out.println("ERROR: Incorrect state transition");
            }
        }
        else if (oldState.equals(TicketState.Review)) {
            if (newState.equals(TicketState.InProgress)) {
                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
            }
            else if (newState.equals(TicketState.Done)) {
                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
            }
            else if (newState.equals(TicketState.Review)) {
                System.out.println("ERROR: Incorrect state transition");
            }
        }
        else if (oldState.equals(TicketState.Done)) {
            if (newState.equals(TicketState.InProgress)) {
                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
            }
            else if (newState.equals(TicketState.Done)) {
                System.out.println(ticket.getDescription() + " is already in Done state.");
            }
            else if (newState.equals(TicketState.Review)) {
                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
            }
        }
    }
}
