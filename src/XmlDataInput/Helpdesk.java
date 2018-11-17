package XmlDataInput;

import java.util.LinkedList;
import java.util.List;

public class Helpdesk {

    List<Ticket> ticketList = new LinkedList<>();
    int ticketIndex = 0;

    public Helpdesk(){

    }

    public void addTicket(Ticket ticket){
        ticketList.add(ticket);
    }

    public void addNote(Note note){

    }

    public void advanceIndex(){
        ticketIndex++;
    }
}
