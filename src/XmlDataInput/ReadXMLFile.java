package XmlDataInput;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Date;

public class ReadXMLFile {

    private enum States {HELPDESKTICKETS, HELPDESKTICKET, CCEMAIL, CUSTOMFIELD, HELPDESKNOTES, HELPDESKNOTE, FINAL}
    private enum NoteStates {HELPDESKNOTES, USERIDNOTES, SOURCENOTES, INCOMINGNOTES, PRIVATENOTES, CREATEDATNOTES, UPDATEDATNOTES, DELETEDNOTES, SUPPORTEMAILNOTES, BODYNOTES, BODYHTMLNOTES, ATTACHMENTSNOTES }
    private enum TicketStates {ID, REQUESTERID, RESPONDERID, STATUSTYPE, SOURCETYPE, SPAMTYPE, DELETEDTYPE, CREATEDAT, UPDATEDAT, SUBJECT, DISPLAYID, OWNERID, GROUPID, DUEBY, FRDUEBY, ISESCALATED, PRIORITY, FRESCALATED, TOEMAIL, EMAILCONFIGID, CCEMAILS, FWDEMAILS, REPLYCC, TKTCC, TICKETTYPE, URGENCY, IMPACT, DEPARTMENTIDVALUE, CATEGORY, SUBCATEGORY, ITEMCATEGORY}
    private static NoteStates noteStates;
    private static TicketStates ticketStates;
    private static States state;
    public static Helpdesk helpdesk;
    private static Note note;
    private static Ticket ticket;

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    System.out.println("Start Element: " + qName);

                    if(qName.equalsIgnoreCase("HELPDESK-NOTES")){
                        state = States.CUSTOMFIELD;
                    }
                    if (qName.equalsIgnoreCase("HELPDESK-TICKETS")) {
                        ticket = new Ticket();
                        state = States.HELPDESKTICKETS;
                    }

                    if (qName.equalsIgnoreCase("HELPDESK-TICKET")) {
                        ticket = new Ticket();
                        state = States.HELPDESKTICKET;
                    }

                    if (qName.equalsIgnoreCase("CC-EMAIL")) {
                        state = States.CCEMAIL;
                    }
                    if (qName.equalsIgnoreCase("HELPDESK-NOTE")) {
                        note = new Note();
                        state = States.HELPDESKNOTE;
                    }
                }



                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                    if(qName.equalsIgnoreCase("CUSTOMFIELD")){
                        state = States.HELPDESKTICKET;
                    }
                    if(qName.equalsIgnoreCase("CC-EMAIL")){
                        state = States.HELPDESKTICKET;
                    }
                    if(qName.equalsIgnoreCase("HELPDESK-NOTE")){
                        helpdesk.addNote(note);
                        state = States.HELPDESKNOTES;
                    }
                    if(qName.equalsIgnoreCase("HELPDESK-NOTES")){
                        state = States.HELPDESKTICKET;
                    }
                    if(qName.equalsIgnoreCase("HELPDESK-TICKET")){
                        helpdesk.addTicket(ticket);
                        helpdesk.advanceIndex();
                        state = States.HELPDESKTICKETS;
                    }
                    if(qName.equalsIgnoreCase("HELPDESK-TICKETS")){
                        state = States.FINAL;
                    }

                    System.out.println("End Element: " + qName);

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    try {
                        System.out.println(new String(ch, start, length));
                    }catch (Exception e){
                        System.out.println("FAIL");
                    }
                }
            };

            String filename = "C:\\Users\\powersjd\\Desktop\\TicketAnalyzer\\TicketDump\\TicketTest.xml";
            saxParser.parse(filename, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ticketParser(String contents){
        if(ticketStates == TicketStates.CATEGORY){
            ticket.setCategory(contents);
        }
        if(ticketStates == TicketStates.SUBCATEGORY){
            ticket.setSubCategory(contents);
        }
        if(ticketStates == TicketStates.ITEMCATEGORY){
            ticket.setItemCategory(contents);
        }
        if(ticketStates == TicketStates.SUBJECT){
            ticket.setSubject(contents);
        }
        if(ticketStates == TicketStates.TICKETTYPE){
            ticket.setTicketType(contents);
        }
    }
    public void ticketParser(String[] contents){
        if(ticketStates == TicketStates.CCEMAILS){
            ticket.setCcEmails(contents);
        }
        if(ticketStates == TicketStates.FWDEMAILS){
            ticket.setFwdEmails(contents);
        }
        if(ticketStates == TicketStates.REPLYCC){
            ticket.setReplyCc(contents);
        }
        if(ticketStates == TicketStates.TKTCC){
            ticket.setTktCc(contents);
        }
        if(ticketStates == TicketStates.TOEMAIL){
            ticket.setToEmail(contents);
        }
    }
    public void ticketParser(Date contents){
        if(ticketStates == TicketStates.DUEBY){
            ticket.setDueBy(contents);
        }
        if(ticketStates == TicketStates.FRDUEBY){
            ticket.setFrDueBy(contents);
        }
        if(ticketStates == TicketStates.CREATEDAT){
            ticket.setCreatedAt(contents);
        }
        if(ticketStates == TicketStates.UPDATEDAT){
            ticket.setUpdatedAt(contents);
        }
    }
    public void ticketParser(boolean contents){
        if(ticketStates == TicketStates.SPAMTYPE){
            ticket.setSpamType(contents);
        }
        if(ticketStates == TicketStates.DELETEDTYPE){
            ticket.setDeletedType(contents);
        }
        if(ticketStates == TicketStates.ISESCALATED){
            ticket.setEscalated(contents);
        }
        if(ticketStates == TicketStates.FRESCALATED){
            ticket.setFrEscalated(contents);
        }
    }
    public void ticketParser(int contents){
        if(ticketStates == TicketStates.ID){
            ticket.setId(contents);
        }
        if(ticketStates == TicketStates.REQUESTERID){
            ticket.setRequesterId(contents);
        }
        if(ticketStates == TicketStates.RESPONDERID){
            ticket.setResponderId(contents);
        }
        if(ticketStates == TicketStates.STATUSTYPE){
            ticket.setStatusType(contents);
        }
        if(ticketStates == TicketStates.SOURCETYPE){
            ticket.setSourceType(contents);
        }
        if(ticketStates == TicketStates.DISPLAYID){
            ticket.setDisplayId(contents);
        }
        if(ticketStates == TicketStates.OWNERID){
            ticket.setOwnerId(contents);
        }
        if(ticketStates == TicketStates.GROUPID){
            ticket.setGroupId(contents);
        }
        if(ticketStates == TicketStates.PRIORITY){
            ticket.setPriority(contents);
        }
        if(ticketStates == TicketStates.EMAILCONFIGID){
            ticket.setEmailConfigId(contents);
        }
        if(ticketStates == TicketStates.URGENCY){
            ticket.setUrgency(contents);
        }
        if(ticketStates == TicketStates.IMPACT){
            ticket.setImpact(contents);
        }
        if(ticketStates == TicketStates.DEPARTMENTIDVALUE){
            ticket.setDepartmentIdValue(contents);
        }
    }

    public void noteParser(String[] contents){
        if(noteStates == NoteStates.HELPDESKNOTES){
            note.setHelpdeskNotes(contents);
        }
        if(noteStates == NoteStates.ATTACHMENTSNOTES){
            note.setAttachmentsNotes(contents);
        }
    }
    public void noteParser(String contents){
        if(noteStates == NoteStates.SUPPORTEMAILNOTES){
            note.setSupportEmailNotes(contents);
        }
        if(noteStates == NoteStates.BODYNOTES){
            note.setBodyNotes(contents);
        }
        if(noteStates == NoteStates.BODYHTMLNOTES){
            note.setBodyHtmlNotes(contents);
        }
    }
    public void noteParser(int contents){
        if(noteStates == NoteStates.USERIDNOTES){
            note.setUserIdNotes(contents);
        }
        if(noteStates == NoteStates.SOURCENOTES){
            note.setSourceNotes(contents);
        }
    }
    public void noteParser(boolean contents){
        if(noteStates == NoteStates.INCOMINGNOTES){
            note.setIncomingNotes(contents);
        }
        if(noteStates == NoteStates.PRIVATENOTES){
            note.setPrivateNotes(contents);
        }
        if(noteStates == NoteStates.DELETEDNOTES){
            note.setDeletedNotes(contents);
        }
    }
    public void noteParser(Date contents){
        if(noteStates == NoteStates.CREATEDATNOTES){
            note.setCreatedAtNotes(contents);
        }
        if(noteStates == NoteStates.UPDATEDATNOTES){
            note.setUpdatedAtNotes(contents);
        }
    }

}