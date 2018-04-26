package bb.constants;

public enum NotificationStatus {
    SENT("Sent"), FAILED("Failed");

    String displayValue;

    NotificationStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
