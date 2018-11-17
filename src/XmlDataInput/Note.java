package XmlDataInput;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    SimpleDateFormat dateFormatting = new SimpleDateFormat("yyyyMMdd'T'HHmmss");

    //Note Variables
    private String[] helpdeskNotes;
    private int userIdNotes;
    private int sourceNotes;
    private boolean incomingNotes;
    private boolean privateNotes;
    private Date createdAtNotes;
    private Date updatedAtNotes;
    private boolean deletedNotes;
    private String supportEmailNotes;
    private String bodyNotes;
    private String bodyHtmlNotes;
    private String[] attachmentsNotes;


    public String toString(){
        return Integer.toString(userIdNotes) + " " + Integer.toString(sourceNotes) + createdAtNotes.toString() + privateNotes;
    }




    public String[] getHelpdeskNotes() {
        return helpdeskNotes;
    }
    public void setHelpdeskNotes(String[] helpdeskNotes) {
        this.helpdeskNotes = helpdeskNotes;
    }
    public int getUserIdNotes() {
        return userIdNotes;
    }
    public void setUserIdNotes(int userIdNotes) {
        this.userIdNotes = userIdNotes;
    }
    public int getSourceNotes() {
        return sourceNotes;
    }
    public void setSourceNotes(int sourceNotes) {
        this.sourceNotes = sourceNotes;
    }
    public boolean isIncomingNotes() {
        return incomingNotes;
    }
    public void setIncomingNotes(boolean incomingNotes) {
        this.incomingNotes = incomingNotes;
    }
    public boolean isPrivateNotes() {
        return privateNotes;
    }
    public void setPrivateNotes(boolean privateNotes) {
        this.privateNotes = privateNotes;
    }
    public Date getCreatedAtNotes() {
        return createdAtNotes;
    }
    public void setCreatedAtNotes(Date createdAtNotes) {
        this.createdAtNotes = createdAtNotes;
    }
    public Date getUpdatedAtNotes() {
        return updatedAtNotes;
    }
    public void setUpdatedAtNotes(Date updatedAtNotes) {
        this.updatedAtNotes = updatedAtNotes;
    }
    public boolean isDeletedNotes() {
        return deletedNotes;
    }
    public void setDeletedNotes(boolean deletedNotes) {
        this.deletedNotes = deletedNotes;
    }
    public String getSupportEmailNotes() {
        return supportEmailNotes;
    }
    public void setSupportEmailNotes(String supportEmailNotes) {
        this.supportEmailNotes = supportEmailNotes;
    }
    public String getBodyNotes() {
        return bodyNotes;
    }
    public void setBodyNotes(String bodyNotes) {
        this.bodyNotes = bodyNotes;
    }
    public String getBodyHtmlNotes() {
        return bodyHtmlNotes;
    }
    public void setBodyHtmlNotes(String bodyHtmlNotes) {
        this.bodyHtmlNotes = bodyHtmlNotes;
    }
    public String[] getAttachmentsNotes() {
        return attachmentsNotes;
    }
    public void setAttachmentsNotes(String[] attachmentsNotes) {
        this.attachmentsNotes = attachmentsNotes;
    }
}
