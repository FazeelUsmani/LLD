package services;

import dto.Ticket;
import dto.User;
import state.Done;
import state.InProgress;
import state.Review;
import java.util.concurrent.locks.ReentrantLock;

public class TicketService {

    public Ticket createTicket(String description, User createdBy) {
        return new Ticket(description, createdBy);
    }

    private final ReentrantLock lock = new ReentrantLock();

    public void startProgress(Ticket ticket, User user) {
        boolean isFeasible = ticket.getTicketState().startProgress(ticket, user);
        if (isFeasible) {
            // Critical Section
            lock.lock();
            if (ticket.getTicketState().startProgress(ticket, user)) {
                ticket.setTicketState(InProgress.getInstance());
            }
            lock.unlock();
        }
    }

    public void startReview(Ticket ticket, User user) {
        boolean isFeasible = ticket.getTicketState().startReview(ticket, user);
        if (isFeasible) {
            lock.lock();
            if (ticket.getTicketState().startReview(ticket, user)) {
                ticket.setTicketState(Review.getInstance());
            }
            lock.unlock();
        }
    }

    public void markDone(Ticket ticket, User user) {
        boolean isFeasible = ticket.getTicketState().markDone(ticket, user);
        if (isFeasible) {
            lock.lock();
            if (ticket.getTicketState().markDone(ticket, user)) {
                ticket.setTicketState(Done.getInstance());
                System.out.println(">>> You can try to delete the ticket here");
            }
            lock.unlock();
        }
    }

//    public void changeTicketState(Ticket ticket, TicketState newState) {
//        TicketState oldState = ticket.getTicketState();
//        if (oldState.equals(TicketState.InProgress)) {
//            if (newState.equals(TicketState.Review)) {
//                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
//            }
//            else if (newState.equals(TicketState.Done)) {
//                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
//            }
//            else if (newState.equals(TicketState.InProgress)) {
//                System.out.println("ERROR: Incorrect state transition");
//            }
//        }
//        else if (oldState.equals(TicketState.Review)) {
//            if (newState.equals(TicketState.InProgress)) {
//                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
//            }
//            else if (newState.equals(TicketState.Done)) {
//                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
//            }
//            else if (newState.equals(TicketState.Review)) {
//                System.out.println("ERROR: Incorrect state transition");
//            }
//        }
//        else if (oldState.equals(TicketState.Done)) {
//            if (newState.equals(TicketState.InProgress)) {
//                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
//            }
//            else if (newState.equals(TicketState.Done)) {
//                System.out.println(ticket.getDescription() + " is already in Done state.");
//            }
//            else if (newState.equals(TicketState.Review)) {
//                System.out.println(ticket.getDescription() + " moved from " + oldState + " to " + newState);
//            }
//        }
//    }
}
