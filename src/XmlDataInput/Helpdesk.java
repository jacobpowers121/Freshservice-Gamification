package XmlDataInput;

import java.util.LinkedList;
import java.util.List;

public class Helpdesk {

    List<Ticket> ticketList = new LinkedList<Ticket>();
    int ticketIndex = 0;

    public Helpdesk(){

    }

    public void addTicket(Ticket ticket){
        ticketList.add(ticket);
        System.out.println();
        System.out.println(ticketList.get(0).toString());
    }

    public int getIndex(){
        return ticketIndex;
    }

    public void addNote(Note note){

    }

    public void advanceIndex(){
        ticketIndex++;
    }
}
