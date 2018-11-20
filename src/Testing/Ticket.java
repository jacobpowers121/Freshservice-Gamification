package Testing;

import java.util.LinkedList;
import java.util.List;

public class Ticket {

    private String displayid;
    private String responderid;
    private String requesterid;
    private String groupid;
    private String tickettype;
    private String subject;
    private String description;
    private String status;
    private String priority;
    private String source;
    private String isescalated;
    private static List<Note> noteList;

    public Ticket(){
        noteList = new LinkedList<>();
    }

    public Note getNote(int index){
        return noteList.get(index);
    }

    public int noteListSize(){
        return noteList.size();
    }

    public String toString(){
        return "\nTICKET::\n" + displayid + "\n" + responderid + "\n" + requesterid + "\n" + groupid + "\n" +
                tickettype + "\n" + subject + "\n" + description + "\n" + status + "\n" +
                priority + "\n" + source + "\n" + isescalated + "\n" + "\nNOTES::\n" + noteString() + "\n";
    }

    public static String noteString(){
        String noteParsed = "";
        for(Note note : noteList){
            noteParsed += "\n";
            noteParsed += note.toString();
        }
        return noteParsed;
    }

    public void addNote(Note note){
        noteList.add(note);
    }

    public void setDisplayid(String displayid) {
        this.displayid = displayid;
    }
    public void setResponderid(String responderid) {
        this.responderid = responderid;
    }
    public void setRequesterid(String requesterid) {
        this.requesterid = requesterid;
    }
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    public void setTickettype(String tickettype) {
        this.tickettype = tickettype;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setIsescalated(String isescalated) {
        this.isescalated = isescalated;
    }
    public String getDisplayid(){return displayid;}
    public String getResponderid(){return responderid;}
    public String getRequesterid(){return requesterid;}
    public String getGroupid(){return groupid;}
    public String getTickettype(){return tickettype;}
    public String getSubject(){return subject;}
    public String getDescription(){return description;}
    public String getStatus(){return status;}
    public String getPriority(){return priority;}
    public String getSource(){return source;}
    public String getIsescalated(){return isescalated;}
}