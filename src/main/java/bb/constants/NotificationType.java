package bb.constants;

public enum NotificationType {
    SMS("Sms"), EMAIL("Email"), LETTER("Letter");

    String displayValue;

    NotificationType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
