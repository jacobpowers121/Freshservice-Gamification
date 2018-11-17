package XmlDataInput;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {

    SimpleDateFormat dateFormatting = new SimpleDateFormat("yyyyMMdd'T'HHmmss");

    //Main ticket variables and cc/fwd variables

    private String category;
    private String subCategory;
    private String itemCategory;
    private String subject;
    private String ticketType;
    private String[] ccEmails;
    private String[] fwdEmails;
    private String[] replyCc;
    private String[] tktCc;
    private String[] toEmail;
    private Date dueBy;
    private Date frDueBy;
    private Date createdAt;
    private Date updatedAt;
    private boolean spamType;
    private boolean deletedType;
    private boolean isEscalated;
    private boolean frEscalated;
    private int id;
    private int requesterId;
    private int responderId;
    private int statusType;
    private int sourceType;
    private int displayId;
    private int ownerId;
    private int groupId;
    private int priority;
    private int emailConfigId;
    private int urgency;
    private int impact;
    private int departmentIdValue;


    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSubCategory() {
        return subCategory;
    }
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
    public String getItemCategory() {
        return itemCategory;
    }
    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public String[] getCcEmails() {
        return ccEmails;
    }
    public void setCcEmails(String[] ccEmails) {
        this.ccEmails = ccEmails;
    }
    public String[] getFwdEmails() {
        return fwdEmails;
    }
    public void setFwdEmails(String[] fwdEmails) {
        this.fwdEmails = fwdEmails;
    }
    public String[] getReplyCc() {
        return replyCc;
    }
    public void setReplyCc(String[] replyCc) {
        this.replyCc = replyCc;
    }
    public String[] getTktCc() {
        return tktCc;
    }
    public void setTktCc(String[] tktCc) {
        this.tktCc = tktCc;
    }
    public String[] getToEmail() {
        return toEmail;
    }
    public void setToEmail(String[] toEmail) {
        this.toEmail = toEmail;
    }
    public Date getDueBy() {
        return dueBy;
    }
    public void setDueBy(Date dueBy) {
        this.dueBy = dueBy;
    }
    public Date getFrDueBy() {
        return frDueBy;
    }
    public void setFrDueBy(Date frDueBy) {
        this.frDueBy = frDueBy;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public boolean isSpamType() {
        return spamType;
    }
    public void setSpamType(boolean spamType) {
        this.spamType = spamType;
    }
    public boolean isDeletedType() {
        return deletedType;
    }
    public void setDeletedType(boolean deletedType) {
        this.deletedType = deletedType;
    }
    public boolean isEscalated() {
        return isEscalated;
    }
    public void setEscalated(boolean escalated) {
        isEscalated = escalated;
    }
    public boolean isFrEscalated() {
        return frEscalated;
    }
    public void setFrEscalated(boolean frEscalated) {
        this.frEscalated = frEscalated;
    }
    public int getRequesterId() {
        return requesterId;
    }
    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getResponderId() {
        return responderId;
    }
    public void setResponderId(int responderId) {
        this.responderId = responderId;
    }
    public int getStatusType() {
        return statusType;
    }
    public void setStatusType(int statusType) {
        this.statusType = statusType;
    }
    public int getSourceType() {
        return sourceType;
    }
    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }
    public int getDisplayId() {
        return displayId;
    }
    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }
    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getEmailConfigId() {
        return emailConfigId;
    }
    public void setEmailConfigId(int emailConfigId) {
        this.emailConfigId = emailConfigId;
    }
    public int getUrgency() {
        return urgency;
    }
    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }
    public int getImpact() {
        return impact;
    }
    public void setImpact(int impact) {
        this.impact = impact;
    }
    public int getDepartmentIdValue() {
        return departmentIdValue;
    }
    public void setDepartmentIdValue(int departmentIdValue) {
        this.departmentIdValue = departmentIdValue;
    }

    private enum statusName {OPEN, PENDING, RESOLVED, CLOSED}
    private String requesterStatusName;
    private enum priorityName {LOW, MEDIUM, HIGH, URGENT}
    private enum sourceName {EMAIL, PORTAL, PHONE, CHAT}
    private String requesterName;
    private String responderName;
    private String assocProblem;
    private String assocChange;
    private String assocChangeCause;
    private String description;
    private String descriptionHtml;
    private String[] attachments;
    private String[] tags;
    private String[] toEmails;
    private String location14966;
    private String incidentType14966;
    private String departmentName;
    private String urgencyName;
    private String impactName;
    private String phoneNumber14966;
    private String whatDidYouDo;
    private String dependantFieldChoose14966;
    private String troubleShooting;
    private String studentId14966;
    private String assetTag14966;

}
