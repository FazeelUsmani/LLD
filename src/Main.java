import dto.Ticket;
import dto.User;
import services.TicketService;

public class Main {
    public static void main(String[] args) {

        User u1 = new User("Fazeel");
        Ticket ticket = new Ticket("First Ticket", u1);

        TicketService ticketService = new TicketService();
        ticketService.startProgress(ticket, u1);
        ticketService.startReview(ticket, u1);
    }
}