package XmlDataInput;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {

    SimpleDateFormat dateFormatting = new SimpleDateFormat("yyyyMMdd'T'HHmmss");

    //Main ticket variables and cc/fwd variables

    private String category = null;
    private String subCategory = null;
    private String itemCategory = null;
    private String subject = null;
    private String ticketType = null;
    private String location14966 = null;
    private String incidentType14966 = null;
    private String phoneNumber14966 = null;
    private String whatDidYouDo = null;
    private String dependantFieldChoose14966 = null;
    private String troubleShooting = null;
    private String studentId14966 = null;
    private String assetTag14966 = null;
    private String requesterName = null;
    private String responderName = null;
    private String assocProblem = null;
    private String assocChange = null;
    private String assocChangeCause = null;
    private String description = null;
    private String descriptionHtml = null;
    private String requesterStatusName = null;
    private String StatusName = null;
    private String PriorityName = null;
    private String SourceName = null;
    private String ccEmails = null;
    private String fwdEmails = null;
    private String replyCc = null;
    private String tktCc = null;
    private String toEmail = null;
    private String attachments = null;
    private String tags = null;
    private String toEmails = null;
    private Date dueBy = null;
    private Date frDueBy = null;
    private Date createdAt = null;
    private Date updatedAt = null;
    private boolean spamType = false;
    private boolean deletedType = false;
    private boolean isEscalated = false;
    private boolean frEscalated = false;
    private int id = -1;
    private int requesterId = -1;
    private int responderId = -1;
    private int statusType = -1;
    private int sourceType = -1;
    private int displayId = -1;
    private int ownerId = -1;
    private int groupId = -1;
    private int priority = -1;
    private int emailConfigId = -1;
    private int urgency = -1;
    private int impact = -1;
    private int departmentIdValue = -1;

    public String toString(){
        return category + "\n" + subCategory + "\n" + itemCategory + "\n" + subject + "\n" + ticketType + "\n" + location14966 + "\n" + incidentType14966 + "\n" + phoneNumber14966
                + "\n" + whatDidYouDo + "\n" + dependantFieldChoose14966 + "\n" + troubleShooting + "\n" + studentId14966
                + "\n" + assetTag14966 + "\n" + requesterName + "\n" + responderName + "\n" + assocChange
                + "\n" + assocProblem + "\n" + assocChangeCause + "\n" + description + "\n" + descriptionHtml
                + "\n" + requesterStatusName + "\n" + StatusName + "\n" + PriorityName + "\n" + SourceName
                + "\n" + ccEmails + "\n" + fwdEmails + "\n" + replyCc + "\n" + tktCc
                + "\n" + toEmail + "\n" + dueBy + "\n" + attachments + "\n" + tags
                + "\n" + toEmails + "\n" + dueBy + "\n" + frDueBy.toString() + "\n" + createdAt.toString()
                + "\n" + updatedAt.toString() + "\n" + spamType + "\n" + deletedType + "\n" + isEscalated
                + "\n" + frEscalated + "\n" + id + "\n" + requesterId + "\n" + responderId
                + "\n" + statusType + "\n" + sourceType + "\n" + displayId + "\n" + ownerId
                + "\n" + priority + "\n" + emailConfigId + "\n" + urgency + "\n" + impact
                + "\n" + departmentIdValue;
    }

    public String getLocation14966() {
        return location14966;
    }
    public void setLocation14966(String location14966) {
        this.location14966 = location14966;
    }
    public String getIncidentType14966() {
        return incidentType14966;
    }
    public void setIncidentType14966(String incidentType14966) {
        this.incidentType14966 = incidentType14966;
    }
    public String getPhoneNumber14966() {
        return phoneNumber14966;
    }
    public void setPhoneNumber14966(String phoneNumber14966) {
        this.phoneNumber14966 = phoneNumber14966;
    }
    public String getWhatDidYouDo() {
        return whatDidYouDo;
    }
    public void setWhatDidYouDo(String whatDidYouDo) {
        this.whatDidYouDo = whatDidYouDo;
    }
    public String getDependantFieldChoose14966() {
        return dependantFieldChoose14966;
    }
    public void setDependantFieldChoose14966(String dependantFieldChoose14966) {
        this.dependantFieldChoose14966 = dependantFieldChoose14966;
    }
    public String getTroubleShooting() {
        return troubleShooting;
    }
    public void setTroubleShooting(String troubleShooting) {
        this.troubleShooting = troubleShooting;
    }
    public String getStudentId14966() {
        return studentId14966;
    }
    public void setStudentId14966(String studentId14966) {
        this.studentId14966 = studentId14966;
    }
    public String getAssetTag14966() {
        return assetTag14966;
    }
    public void setAssetTag14966(String assetTag14966) {
        this.assetTag14966 = assetTag14966;
    }
    public String getRequesterName() {
        return requesterName;
    }
    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }
    public String getResponderName() {
        return responderName;
    }
    public void setResponderName(String responderName) {
        this.responderName = responderName;
    }
    public String getAssocProblem() {
        return assocProblem;
    }
    public void setAssocProblem(String assocProblem) {
        this.assocProblem = assocProblem;
    }
    public String getAssocChange() {
        return assocChange;
    }
    public void setAssocChange(String assocChange) {
        this.assocChange = assocChange;
    }
    public String getAssocChangeCause() {
        return assocChangeCause;
    }
    public void setAssocChangeCause(String assocChangeCause) {
        this.assocChangeCause = assocChangeCause;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescriptionHtml() {
        return descriptionHtml;
    }
    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }
    public String getRequesterStatusName() {
        return requesterStatusName;
    }
    public void setRequesterStatusName(String requesterStatusName) {
        this.requesterStatusName = requesterStatusName;
    }
    public String getAttachments() {
        return attachments;
    }
    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
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
    public String getCcEmails() {
        return ccEmails;
    }
    public void setCcEmails(String ccEmails) {
        this.ccEmails = ccEmails;
    }
    public String getFwdEmails() {
        return fwdEmails;
    }
    public void setFwdEmails(String fwdEmails) {
        this.fwdEmails = fwdEmails;
    }
    public String getReplyCc() {
        return replyCc;
    }
    public void setReplyCc(String replyCc) {
        this.replyCc = replyCc;
    }
    public String getTktCc() {
        return tktCc;
    }
    public void setTktCc(String tktCc) {
        this.tktCc = tktCc;
    }
    public String getToEmail() {
        return toEmail;
    }
    public void setToEmail(String toEmail) {
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
    public String getStatusName() {
        return StatusName;
    }
    public void setStatusName(String statusName) {
        StatusName = statusName;
    }
    public String getPriorityName() {
        return PriorityName;
    }
    public void setPriorityName(String priorityName) {
        PriorityName = priorityName;
    }
    public String getSourceName() {
        return SourceName;
    }
    public void setSourceName(String sourceName) {
        SourceName = sourceName;
    }
}
