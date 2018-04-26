package bb.dto;

import java.util.Date;
import java.util.List;

public class SearchDto {
    private List<String> notificationReasons;
    private List<String> notificationTypes;
    private List<String> notificationStatuses;
    private Date fromDate;
    private Date untilDate;


    public List<String> getNotificationReasons() {
        return notificationReasons;
    }

    public void setNotificationReasons(List<String> notificationReasons) {
        this.notificationReasons = notificationReasons;
    }

    public List<String> getNotificationTypes() {
        return notificationTypes;
    }

    public void setNotificationTypes(List<String> notificationTypes) {
        this.notificationTypes = notificationTypes;
    }

    public List<String> getNotificationStatuses() {
        return notificationStatuses;
    }

    public void setNotificationStatuses(List<String> notificationStatuses) {
        this.notificationStatuses = notificationStatuses;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(Date untillDate) {
        this.untilDate = untillDate;
    }
}
