package bb.constants;

public enum NotificationReason {
    PAYMENT_REMINDER("Payment Reminder"), DEBT_REMINDER("Debt Reminder"), TROLOLOL("Trol"), REASON("Reason");

    String displayValue;

    NotificationReason(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
