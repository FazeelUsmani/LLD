package state;

import dto.Ticket;
import dto.User;

public class Review implements State {

    private static Review instance;

    public static Review getInstance() {
        if (instance == null) {
            instance = new Review();
        }
        return  instance;
    }

    @Override
    public boolean startProgress(Ticket ticket, User user) {
        System.out.println(ticket.getDescription() + " moved from Review to In Progress");
        return true;
    }

    @Override
    public boolean startReview(Ticket ticket, User user) {
        System.out.println("Already in Review!");
        return false;
    }

    @Override
    public boolean markDone(Ticket ticket, User user) {
        System.out.println(ticket.getDescription() + " Congrats!!! marked done!");
        return true;
    }
}
