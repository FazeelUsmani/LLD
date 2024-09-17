package state;

import dto.Ticket;
import dto.User;

public class Done implements State {

    @Override
    public boolean startProgress(Ticket ticket, User user) {
        System.out.println(ticket.getDescription() + " moved from Done to InProgress");
        return true;
    }

    @Override
    public boolean startReview(Ticket ticket, User user) {
        System.out.println(ticket.getDescription() + " moved from Done to Review");
        return true;
    }

    @Override
    public boolean markDone(Ticket ticket, User user) {
        System.out.println("Already in Done!!!");
        return false;
    }
}
