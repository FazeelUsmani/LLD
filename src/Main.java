import dto.Ticket;
import dto.User;
import enums.TicketState;
import services.TicketService;

public class Main {
    public static void main(String[] args) {

        User u1 = new User("Fazeel");
        Ticket ticket = new Ticket("First Ticket", u1);

        TicketService ticketService = new TicketService();
        ticketService.changeTicketState(ticket, TicketState.Review);
        ticketService.changeTicketState(ticket, TicketState.InProgress);
    }
}