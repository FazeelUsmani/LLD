package state;

import dto.Ticket;
import dto.User;

public interface State {

    boolean startProgress(Ticket ticket, User user);

    boolean startReview(Ticket ticket, User user);

    boolean markDone(Ticket ticket, User user);

}
