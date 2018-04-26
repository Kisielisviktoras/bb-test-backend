package bb.service;

import bb.Notification;
import bb.constants.NotificationReason;
import bb.constants.NotificationStatus;
import bb.constants.NotificationType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private static final List<Notification> notifications = buildNotifs();

    private static List<Notification> buildNotifs() {
        List<Notification> result = new ArrayList<>();
        result.add(new Notification(100, "content"+100, "user"+100+"@bigbank.lt",
                "bb@bigbank.lv", NotificationStatus.FAILED, NotificationType.EMAIL, new Date(), NotificationReason.PAYMENT_REMINDER.name()));
        for (int i = 0; i < 100; i++) {
            result.add(new Notification(i, "content"+i, "user"+i+"@bigbank.lt",
                    "bb@bigbank.lv", NotificationStatus.SENT, NotificationType.EMAIL, new Date(), NotificationReason.PAYMENT_REMINDER.name()));
        }

        for (int i = 101; i < 115; i++) {
            result.add(new Notification(i, "content"+i, "user"+i+"@bigbank.lt",
                    "bb@bigbank.lv", NotificationStatus.FAILED, NotificationType.EMAIL, new Date(), NotificationReason.PAYMENT_REMINDER.name()));
        }

        for (int i = 115; i < 200; i++) {
            result.add(new Notification(i, "content"+i, "user"+i+"@bigbank.lt",
                    "bb@bigbank.lv", NotificationStatus.SENT, NotificationType.SMS, new Date(), NotificationReason.PAYMENT_REMINDER.name()));
        }

        for (int i = 200; i < 300; i++) {
            result.add(new Notification(i, "content"+i, "user"+i+"@bigbank.lt",
                    "bb@bigbank.lv", NotificationStatus.SENT, NotificationType.EMAIL, new Date(), NotificationReason.DEBT_REMINDER.name()));
        }

        for (int i = 300; i < 315; i++) {
            result.add(new Notification(i, "content"+i, "user"+i+"@bigbank.lt",
                    "bb@bigbank.lv", NotificationStatus.FAILED, NotificationType.EMAIL, new Date(), NotificationReason.DEBT_REMINDER.name()));
        }

        for (int i = 315; i < 400; i++) {
            result.add(new Notification(i, "content"+i, "user"+i+"@bigbank.lt",
                    "bb@bigbank.lv", NotificationStatus.SENT, NotificationType.SMS, new Date(), NotificationReason.DEBT_REMINDER.name()));
        }

        for (int i = 400; i < 415; i++) {
            result.add(new Notification(i, "content"+i, "user"+i+"@bigbank.lt",
                    "bb@bigbank.lv", NotificationStatus.FAILED, NotificationType.SMS, new Date(), NotificationReason.PAYMENT_REMINDER.name()));
        }

        for (int i = 415; i < 430; i++) {
            result.add(new Notification(i, "content"+i, "user"+i+"@bigbank.lt",
                    "bb@bigbank.lv", NotificationStatus.FAILED, NotificationType.SMS, new Date(), NotificationReason.DEBT_REMINDER.name()));
        }
        Collections.shuffle(result);

        LocalDate yesterday = LocalDate.now().minusDays(1L);
        Date yday = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());
        for (int i = 430; i < 530; i++) {
            result.add(new Notification(i, "content"+i, "user"+i+"@bigbank.lt",
                    "bb@bigbank.lv", NotificationStatus.SENT, NotificationType.SMS, yday, NotificationReason.DEBT_REMINDER.name()));
        }
        return result;
    }

    public static List<Notification> getNotifications() {
        return notifications;
    }
}
