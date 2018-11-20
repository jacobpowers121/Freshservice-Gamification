package XmlDataInput;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadXMLFile {

    private enum States {HELPDESKTICKETS, HELPDESKTICKET, CCEMAIL, TOEMAILS, CUSTOMFIELD, HELPDESKNOTES, HELPDESKNOTE, FINAL}
    private enum NoteStates {HELPDESKNOTES, USERIDNOTES, SOURCENOTES, INCOMINGNOTES, PRIVATENOTES, CREATEDATNOTES, UPDATEDATNOTES, DELETEDNOTES, SUPPORTEMAILNOTES, BODYNOTES, BODYHTMLNOTES, ATTACHMENTSNOTES }
    private enum TicketStates {CCEMAIL, PHONENUMBER14966, WHATDIDYOUDO, DEPENDANTFIELDCHOOSE14966, TROUBLESHOOTING, STUDENTID14966, ASSETTAG14966, LOCATION14966, INCIDENTTYPE14966, SOURCENAME, PRIORITYNAME, REQUESTERSTATUSNAME, REQUESTERNAME, RESPONDERNAME, ASSOCPROBLEM, ASSOCCHANGE, ASSOCCHANGECAUSE, DESCRIPTION, DESCRIPTIONHTML, ATTACHMENTS, TAGS, STATUSNAME, ID, REQUESTERID, RESPONDERID, STATUSTYPE, SOURCETYPE, SPAMTYPE, DELETEDTYPE, CREATEDAT, UPDATEDAT, SUBJECT, DISPLAYID, OWNERID, GROUPID, DUEBY, FRDUEBY, ISESCALATED, PRIORITY, FRESCALATED, TOEMAIL, EMAILCONFIGID, CCEMAILS, FWDEMAILS, REPLYCC, TKTCC, TICKETTYPE, URGENCY, IMPACT, DEPARTMENTIDVALUE, CATEGORY, SUBCATEGORY, ITEMCATEGORY}
    private static NoteStates noteStates;
    private static TicketStates ticketStates;
    private static States state;
    public static Helpdesk helpdesk = new Helpdesk();
    private static Note note = new Note();
    private static Ticket ticket = new Ticket();
    private static SimpleDateFormat dateFormatting = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
    private static String ccEmailString = "";
    private static String replyCcString = "";
    private static String fwdEmailString = "";

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
                    if(qName.equalsIgnoreCase("to_emails")){
                        state = States.TOEMAILS;
                    }
                    if(qName.equalsIgnoreCase("ID")){
                        ticketStates = TicketStates.ID;
                    }
                    if(qName.equalsIgnoreCase("REQUESTER-ID")){
                        ticketStates = TicketStates.REQUESTERID;
                    }
                    if(qName.equalsIgnoreCase("RESPONDER-ID")){
                        ticketStates = TicketStates.RESPONDERID;
                    }
                    if(qName.equalsIgnoreCase("STATUS")){
                        ticketStates = TicketStates.STATUSTYPE;
                    }
                    if(qName.equalsIgnoreCase("SOURCE")){
                        ticketStates = TicketStates.SOURCETYPE;
                    }
                    if(qName.equalsIgnoreCase("SPAM")){
                        ticketStates = TicketStates.SPAMTYPE;
                    }
                    if(qName.equalsIgnoreCase("DELETED")){
                        ticketStates = TicketStates.DELETEDTYPE;
                    }
                    if(qName.equalsIgnoreCase("CREATED-AT")){
                        ticketStates = TicketStates.CREATEDAT;
                    }
                    if(qName.equalsIgnoreCase("UPDATED-AT")){
                        ticketStates = TicketStates.UPDATEDAT;
                    }
                    if(qName.equalsIgnoreCase("SUBJECT")){
                        ticketStates = TicketStates.SUBJECT;
                    }
                    if(qName.equalsIgnoreCase("DISPLAY-ID")){
                        ticketStates = TicketStates.DISPLAYID;
                    }
                    if(qName.equalsIgnoreCase("OWNER-ID")){
                        ticketStates = TicketStates.OWNERID;
                    }
                    if(qName.equalsIgnoreCase("GROUP-ID")){
                        ticketStates = TicketStates.GROUPID;
                    }
                    if(qName.equalsIgnoreCase("DUE-BY")){
                        ticketStates = TicketStates.DUEBY;
                    }
                    if(qName.equalsIgnoreCase("FRDUEBY")){
                        ticketStates = TicketStates.FRDUEBY;
                    }
                    if(qName.equalsIgnoreCase("ISESCALATED")){
                        ticketStates = TicketStates.ISESCALATED;
                    }
                    if(qName.equalsIgnoreCase("PRIORITY")){
                        ticketStates = TicketStates.PRIORITY;
                    }
                    if(qName.equalsIgnoreCase("FR-ESCALATED")){
                        ticketStates = TicketStates.FRESCALATED;
                    }
                    if(qName.equalsIgnoreCase("TO-EMAIL")){
                        ticketStates = TicketStates.TOEMAIL;
                    }
                    if(qName.equalsIgnoreCase("EMAIL-CONFIG-ID")){
                        ticketStates = TicketStates.EMAILCONFIGID;
                    }
                    if(qName.equalsIgnoreCase("CC-EMAILS")){
                        ticketStates = TicketStates.CCEMAILS;
                    }
                    if(qName.equalsIgnoreCase("FWD-EMAILS")){
                        ticketStates = TicketStates.FWDEMAILS;
                    }
                    if(qName.equalsIgnoreCase("TICKET-TYPE")){
                        ticketStates = TicketStates.TICKETTYPE;
                    }
                    if(qName.equalsIgnoreCase("URGENCY")){
                        ticketStates = TicketStates.URGENCY;
                    }
                    if(qName.equalsIgnoreCase("IMPACT")){
                        ticketStates = TicketStates.IMPACT;
                    }
                    if(qName.equalsIgnoreCase("DEPARTMENT-ID-VALUE")){
                        ticketStates = TicketStates.DEPARTMENTIDVALUE;
                    }
                    if(qName.equalsIgnoreCase("CATEGORY")){
                        ticketStates = TicketStates.CATEGORY;
                    }
                    if(qName.equalsIgnoreCase("SUB-CATEGORY")){
                        ticketStates = TicketStates.SUBCATEGORY;
                    }
                    if(qName.equalsIgnoreCase("ITEM-CATEGORY")){
                        ticketStates = TicketStates.ITEMCATEGORY;
                    }
                    if(qName.equalsIgnoreCase("STATUS-NAME")){
                        ticketStates = TicketStates.STATUSNAME;
                    }
                    if(qName.equalsIgnoreCase("REQUESTER-STATUS-NAME")){
                        ticketStates = TicketStates.REQUESTERSTATUSNAME;
                    }
                    if(qName.equalsIgnoreCase("PRIORITY-NAME")){
                        ticketStates = TicketStates.PRIORITYNAME;
                    }
                    if(qName.equalsIgnoreCase("SOURCE-NAME")){
                        ticketStates = TicketStates.SOURCENAME;
                    }
                    if(qName.equalsIgnoreCase("REQUESTER-NAME")){
                        ticketStates = TicketStates.REQUESTERNAME;
                    }
                    if(qName.equalsIgnoreCase("RESPONDER-NAME")){
                        ticketStates = TicketStates.RESPONDERNAME;
                    }
                    if(qName.equalsIgnoreCase("ASSOC-PROBLEM")){
                        ticketStates = TicketStates.ASSOCPROBLEM;
                    }
                    if(qName.equalsIgnoreCase("ASSOC-CHANGE")){
                        ticketStates = TicketStates.ASSOCCHANGE;
                    }
                    if(qName.equalsIgnoreCase("ASSOC-CHANGE-CAUSE")){
                        ticketStates = TicketStates.ASSOCCHANGECAUSE;
                    }
                    if(qName.equalsIgnoreCase("DESCRIPTION")){
                        ticketStates = TicketStates.DESCRIPTION;
                    }
                    if(qName.equalsIgnoreCase("DESCRIPTION-HTML")){
                        ticketStates = TicketStates.DESCRIPTIONHTML;
                    }
                    if(qName.equalsIgnoreCase("ATTATCHMENTS")){
                        ticketStates = TicketStates.ATTACHMENTS;
                    }
                    if(qName.equalsIgnoreCase("TAGS")){
                        ticketStates = TicketStates.TAGS;
                    }
                    if(qName.equalsIgnoreCase("TO_EMAILS")){
                        state = States.TOEMAILS;
                    }
                    if(qName.equalsIgnoreCase("CUSTOM_FIELD")){
                        state = States.CUSTOMFIELD;
                    }
                    if(qName.equalsIgnoreCase("LOCATION_14966")){
                        ticketStates = TicketStates.LOCATION14966;
                    }
                    if(qName.equalsIgnoreCase("INCIDENT_TYPE_14966")){
                        ticketStates = TicketStates.INCIDENTTYPE14966;
                    }
                    if(qName.equalsIgnoreCase("PHONE_NUMBER_14966")){
                        ticketStates = TicketStates.PHONENUMBER14966;
                    }
                    if(qName.equalsIgnoreCase("what_did_you_msoe_it_employee_do_to_diagnose_or_resolve_this_issue_this_field_is_hidden_from_the_customer_14966")){
                        ticketStates = TicketStates.WHATDIDYOUDO;
                    }
                    if(qName.equalsIgnoreCase("DEPENDANT_FIELD_CHOOSE_14966")){
                        ticketStates = TicketStates.DEPENDANTFIELDCHOOSE14966;
                    }
                    if(qName.equalsIgnoreCase("trouble_shooting_questions_and_information_to_attempt_to_gather_has_the_customer_had_this_issue_before_if_so_is_there_a_previous_ticket_about_this_problem_14966")){
                        ticketStates = TicketStates.TROUBLESHOOTING;
                    }
                    if(qName.equalsIgnoreCase("STUDENT_ID_14966")){
                        ticketStates = TicketStates.STUDENTID14966;
                    }
                    if(qName.equalsIgnoreCase("ASSET_TAG_14966")){
                        ticketStates = TicketStates.ASSETTAG14966;
                    }
                    if(qName.equalsIgnoreCase("reply-cc")){
                        ticketStates = TicketStates.REPLYCC;
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
                    if(qName.equalsIgnoreCase("to_emails")){
                        state = States.HELPDESKTICKET;
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
                        if(ticketStates == TicketStates.ID){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.REQUESTERID){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.RESPONDERID){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.STATUSTYPE){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.SOURCETYPE){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.SPAMTYPE){
                            String answer = new String(ch, start, length);
                            if(answer.equalsIgnoreCase("true")){
                                ticketParser(true);
                            }else{
                                ticketParser(false);
                            }
                        }
                        if(ticketStates == TicketStates.DELETEDTYPE){
                            String answer = new String(ch, start, length);
                            if(answer.equalsIgnoreCase("true")){
                                ticketParser(true);
                            }else{
                                ticketParser(false);
                            }
                        }
                        if(ticketStates == TicketStates.CREATEDAT){
                            String sDate = new String(ch, start, length);
                            Date date = dateFormatting.parse(sDate);
                            ticketParser(date);
                        }
                        if(ticketStates == TicketStates.UPDATEDAT){
                            String sDate = new String(ch, start, length);
                            Date date = dateFormatting.parse(sDate);
                            ticketParser(date);
                        }
                        if(ticketStates == TicketStates.SUBJECT){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.DISPLAYID){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.OWNERID){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.GROUPID){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }




                        if(ticketStates == TicketStates.DUEBY){
                            String sDate = new String(ch, start, length);
                            ticketParser(sDate);
                        }





                        if(ticketStates == TicketStates.FRDUEBY){
                            String sDate = new String(ch, start, length);
                            Date date = dateFormatting.parse(sDate);
                            ticketParser(date);
                        }
                        if(ticketStates == TicketStates.ISESCALATED){
                            String answer = new String(ch, start, length);
                            if(answer.equalsIgnoreCase("true")){
                                ticketParser(true);
                            }else{
                                ticketParser(false);
                            }
                        }
                        if(ticketStates == TicketStates.PRIORITY){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.FRESCALATED){
                            String answer = new String(ch, start, length);
                            if(answer.equalsIgnoreCase("true")){
                                ticketParser(true);
                            }else{
                                ticketParser(false);
                            }
                        }
                        if(ticketStates == TicketStates.REPLYCC) {
                            if (length > 0) {
                                replyCcString += new String(ch, start, length) + ",,";
                            }
                        }
                        if(ticketStates == TicketStates.EMAILCONFIGID){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.CCEMAILS){
                            ticketParser(ccEmailString);
                            ticketParser(replyCcString);
                            ticketParser(fwdEmailString);
                        }
                        if(ticketStates == TicketStates.CCEMAIL) {
                            if (length > 0) {
                                ccEmailString += new String(ch, start, length) + ",,";
                            }
                        }
                        if(ticketStates == TicketStates.FWDEMAILS) {
                            if (length > 0) {
                                fwdEmailString += new String(ch, start, length) + ",,";
                            }
                        }
                        if(ticketStates == TicketStates.TICKETTYPE){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.URGENCY){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.IMPACT){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.DEPARTMENTIDVALUE){
                            int id = Integer.parseInt(new String(ch, start, length));
                            ticketParser(id);
                        }
                        if(ticketStates == TicketStates.CATEGORY){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.SUBCATEGORY){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.ITEMCATEGORY){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.STATUSNAME){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.REQUESTERSTATUSNAME){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.PRIORITYNAME){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.SOURCENAME){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.REQUESTERNAME){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.RESPONDERNAME){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.ASSOCPROBLEM){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.ASSOCCHANGE){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.ASSOCCHANGECAUSE){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.DESCRIPTION){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.DESCRIPTIONHTML){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.LOCATION14966){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.INCIDENTTYPE14966){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.PHONENUMBER14966){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.WHATDIDYOUDO){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.DEPENDANTFIELDCHOOSE14966){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.TROUBLESHOOTING){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.STUDENTID14966){
                            ticketParser(new String(ch, start, length));
                        }
                        if(ticketStates == TicketStates.ASSETTAG14966){
                            ticketParser(new String(ch, start, length));
                        }
                    }catch (Exception e){
                        System.out.println("FAIL");
                    }
                }
            };

            String filename = "C:\\Users\\jacob\\Desktop\\Fresh\\Freshservice-Gamification\\TicketDump\\TicketTest.xml";
            saxParser.parse(filename, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void ticketParser(String contents){
        if(ticketStates == TicketStates.DUEBY){
            ticket.setDueBy(contents);
        }
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
        if(ticketStates == TicketStates.STATUSNAME){
            ticket.setStatusName(contents);
        }
        if(ticketStates == TicketStates.REQUESTERSTATUSNAME){
            ticket.setRequesterStatusName(contents);
        }
        if(ticketStates == TicketStates.PRIORITYNAME){
            ticket.setPriorityName(contents);
        }
        if(ticketStates == TicketStates.SOURCENAME){
            ticket.setSourceName(contents);
        }
        if(ticketStates == TicketStates.REQUESTERNAME){
            ticket.setRequesterName(contents);
        }
        if(ticketStates == TicketStates.RESPONDERNAME){
            ticket.setResponderName(contents);
        }
        if(ticketStates == TicketStates.ASSOCPROBLEM){
            ticket.setAssocProblem(contents);
        }
        if(ticketStates == TicketStates.ASSOCCHANGE){
            ticket.setAssocChange(contents);
        }
        if(ticketStates == TicketStates.ASSOCCHANGECAUSE){
            ticket.setAssocChangeCause(contents);
        }
        if(ticketStates == TicketStates.DESCRIPTION){
            ticket.setDescription(contents);
        }
        if(ticketStates == TicketStates.DESCRIPTIONHTML){
            ticket.setDescriptionHtml(contents);
        }
        if(ticketStates == TicketStates.LOCATION14966){
            ticket.setLocation14966(contents);
        }
        if(ticketStates == TicketStates.INCIDENTTYPE14966){
            ticket.setIncidentType14966(contents);
        }
        if(ticketStates == TicketStates.PHONENUMBER14966){
            ticket.setPhoneNumber14966(contents);
        }
        if(ticketStates == TicketStates.WHATDIDYOUDO){
            ticket.setWhatDidYouDo(contents);
        }
        if(ticketStates == TicketStates.DEPENDANTFIELDCHOOSE14966){
            ticket.setDependantFieldChoose14966(contents);
        }
        if(ticketStates == TicketStates.TROUBLESHOOTING){
            ticket.setTroubleShooting(contents);
        }
        if(ticketStates == TicketStates.STUDENTID14966){
            ticket.setStudentId14966(contents);
        }
        if(ticketStates == TicketStates.ASSETTAG14966){
            ticket.setAssetTag14966(contents);
        }
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
        if(ticketStates == TicketStates.TAGS){
            ticket.setTags(contents);
        }
        if(ticketStates == TicketStates.ATTACHMENTS){
            ticket.setAttachments(contents);
        }
    }

    public static void ticketParser(Date contents){
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
    public static void ticketParser(boolean contents){
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
    public static void ticketParser(int contents){
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

    public static void noteParser(String[] contents){
        if(noteStates == NoteStates.HELPDESKNOTES){
            note.setHelpdeskNotes(contents);
        }
        if(noteStates == NoteStates.ATTACHMENTSNOTES){
            note.setAttachmentsNotes(contents);
        }
    }
    public static void noteParser(String contents){
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
    public static void noteParser(int contents){
        if(noteStates == NoteStates.USERIDNOTES){
            note.setUserIdNotes(contents);
        }
        if(noteStates == NoteStates.SOURCENOTES){
            note.setSourceNotes(contents);
        }
    }
    public static void noteParser(boolean contents){
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
    public static void noteParser(Date contents){
        if(noteStates == NoteStates.CREATEDATNOTES){
            note.setCreatedAtNotes(contents);
        }
        if(noteStates == NoteStates.UPDATEDATNOTES){
            note.setUpdatedAtNotes(contents);
        }
    }

}