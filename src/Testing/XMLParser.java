package Testing;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser {

    public static void main(String[] args) {

        try {
            File inputFile = new File("C:\\Users\\jacob\\Desktop\\Fresh\\Freshservice-Gamification\\TicketDump\\Tickets_129.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class UserHandler extends DefaultHandler {

    private enum States {INIT, FINAL, HELPDESKTICKETS, HELPDESKTICKET, NOTES, NOTE}
    private enum TicketStates {INIT, DISPLAYID, RESPONDERID, REQUESTERID, GROUPID, TICKETTYPE, SUBJECT, DESCRIPTION, STATUS, PRIORITY, SOURCE, ISESCALATED, DUEBY, CREATEDAT}
    private enum NoteStates {INIT, USERID, PRIVATE}
    private NoteStates noteStates = NoteStates.INIT;
    private TicketStates ticketStates = TicketStates.INIT;
    private States states = States.INIT;

    Ticket ticket = new Ticket();
    Note note = new Note();

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if(qName.equalsIgnoreCase("HELPDESK-TICKETS")){
            states = States.HELPDESKTICKETS;
        }
        if(qName.equalsIgnoreCase("HELPDESK-TICKET")){
            System.out.println("test");
            ticket = new Ticket();
            states = States.HELPDESKTICKET;
        }
        if(qName.equalsIgnoreCase("HELPDESK-NOTES")){
            states = States.NOTES;
        }
        if(qName.equalsIgnoreCase("HELPDESK-NOTE")){
            states = States.NOTE;
        }
        if(qName.equalsIgnoreCase("DISPLAY-ID")){
            ticketStates = TicketStates.DISPLAYID;
        }
        if(qName.equalsIgnoreCase("RESPONDER-ID")){
            ticketStates = TicketStates.RESPONDERID;
        }
        if(qName.equalsIgnoreCase("REQUESTER-ID")){
            ticketStates = TicketStates.REQUESTERID;
        }
        if(qName.equalsIgnoreCase("GROUP-ID")){
            ticketStates = TicketStates.GROUPID;
        }
        if(qName.equalsIgnoreCase("TICKET-TYPE")){
            ticketStates = TicketStates.TICKETTYPE;
        }
        if(qName.equalsIgnoreCase("SUBJECT")){
            ticketStates = TicketStates.SUBJECT;
        }
        if(qName.equalsIgnoreCase("STATUS-NAME")){
            ticketStates = TicketStates.STATUS;
        }
        if(qName.equalsIgnoreCase("PRIORITY-NAME")){
            ticketStates = TicketStates.PRIORITY;
        }
        if(qName.equalsIgnoreCase("SOURCE-NAME")){
            ticketStates = TicketStates.SOURCE;
        }
        if(qName.equalsIgnoreCase("ISESCALATED")){
            ticketStates = TicketStates.ISESCALATED;
        }

        //Note start tags
        if(qName.equalsIgnoreCase("USER-ID")){
            noteStates = NoteStates.USERID;
        }
        if(qName.equalsIgnoreCase("PRIVATE")){
            noteStates = NoteStates.PRIVATE;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if(qName.equalsIgnoreCase("HELPDESK-TICKETS")){
            states = States.FINAL;
        }
        if(qName.equalsIgnoreCase("HELPDESK-TICKET")){
            System.out.println(ticket.toString());
            states = States.HELPDESKTICKETS;
        }
        if(qName.equalsIgnoreCase("CC-EMAIL")){
            states = States.HELPDESKTICKET;
        }
        if(qName.equalsIgnoreCase("HELPDESK-NOTES")){
            states = States.HELPDESKTICKET;
        }
        if(qName.equalsIgnoreCase("HELPDESK-NOTE")){
            ticket.addNote(note);
            note = new Note();
            states = States.NOTES;
        }
        if(qName.equalsIgnoreCase("DISPLAY-ID")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("RESPONDER-ID")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("REQUESTER-ID")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("GROUP-ID")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("TICKET-TYPE")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("SUBJECT")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("STATUS-NAME")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("PRIORITY-NAME")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("SOURCE-NAME")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("ISESCALATED")){
            ticketStates = TicketStates.INIT;
        }
        if(qName.equalsIgnoreCase("USER-ID")){
            noteStates = NoteStates.INIT;
        }
        if(qName.equalsIgnoreCase("PRIVATE")){
            noteStates = NoteStates.INIT;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String word = new String(ch, start, length);
        if(ticketStates == TicketStates.DISPLAYID){
            ticket.setDisplayid("DISPLAY ID: " + word);
        }
        if(ticketStates == TicketStates.RESPONDERID){
            ticket.setResponderid("RESPONDER ID: " + word);
        }
        if(ticketStates == TicketStates.REQUESTERID){
            ticket.setRequesterid("REQUESTER ID: " + word);
        }
        if(ticketStates == TicketStates.GROUPID){
            ticket.setGroupid("GROUP ID: " + word);
        }
        if(ticketStates == TicketStates.TICKETTYPE){
            ticket.setTickettype("TICKET TYPE: " + word);
        }
        if(ticketStates == TicketStates.SUBJECT){
            ticket.setSubject("SUBJECT: " + word);
        }
        if(ticketStates == TicketStates.STATUS){
            ticket.setStatus("STATUS: " + word);
        }
        if(ticketStates == TicketStates.PRIORITY){
            ticket.setPriority("PRIORITY: " + word);
        }
        if(ticketStates == TicketStates.SOURCE){
            ticket.setSource("SOURCE: " + word);
        }
        if(ticketStates == TicketStates.ISESCALATED){
            ticket.setIsescalated("IS ESCALATED: " + word);
        }
        if(noteStates == NoteStates.USERID){
            note.setUserid("USER ID: " + word);
        }
        if(noteStates == NoteStates.PRIVATE){
            note.setPrivateBool("PRIVATE: " + word);
        }
    }
}