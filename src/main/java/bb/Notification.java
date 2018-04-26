package bb;

import bb.constants.NotificationStatus;
import bb.constants.NotificationType;

import java.util.Date;

public class Notification {

    private long id;
    private String content;
    private String reciever;
    private String sender;
    private NotificationStatus status;
    private NotificationType type;
    private Date sentDate;
    private String reason;

    public Notification(long id, String content, String recevier, String sender,
                        NotificationStatus status, NotificationType type, Date sentDate, String reason) {
        this.id = id;
        this.content = content;
        this.reciever = recevier;
        this.sender = sender;
        this.status = status;
        this.type = type;
        this.sentDate = sentDate;
        this.reason = reason;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String recevier) {
        this.reciever = recevier;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
