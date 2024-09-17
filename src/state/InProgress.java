package state;

import dto.Ticket;
import dto.User;

public class InProgress implements State {
    @Override
    public boolean startProgress(Ticket ticket, User user) {
        System.out.println("Ticket already in progress state");
        return false;
    }

    @Override
    public boolean startReview(Ticket ticket, User user) {
        System.out.println(ticket.getDescription() + " moved from InProgress to Review ");
        return true;
    }

    @Override
    public boolean markDone(Ticket ticket, User user) {
        System.out.println(ticket.getDescription() + " Congratulations!!! marked done");
        return true;
    }
}
