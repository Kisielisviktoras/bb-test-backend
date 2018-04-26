package bb.controller;

import bb.Notification;
import bb.dto.SearchDto;
import bb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NotificationController {


    @Autowired
    private Service service;

    @RequestMapping(value = "/notification/{from}/{to}", method = RequestMethod.GET)
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable int from, @PathVariable int to) {
        List<Notification> notifications = service.getNotifications();
        if (notifications.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        notifications = service.getNotifications().subList(from, to);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @RequestMapping(value = "/notification/search/{from}/{to}", method = RequestMethod.POST)
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable int from, @PathVariable int to, @RequestBody SearchDto criteria) {
        List<Notification> notifications = service.getNotifications();
        notifications = filter(criteria, notifications);

        if (notifications.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        notifications = notifications.subList(from, to);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    private List<Notification> filter(SearchDto criteria, List<Notification> notifications) {
        if (!criteria.getNotificationReasons().isEmpty()) {
            notifications = notifications.stream().filter(notification -> criteria.getNotificationReasons().contains(notification.getReason())).collect(Collectors.toList());
        }

        if (!criteria.getNotificationStatuses().isEmpty()) {
            notifications = notifications.stream().filter(notification -> criteria.getNotificationStatuses().contains(notification.getStatus().name())).collect(Collectors.toList());
        }

        if (!criteria.getNotificationTypes().isEmpty()) {
            notifications = notifications.stream().filter(notification -> criteria.getNotificationTypes().contains(notification.getType().name())).collect(Collectors.toList());
        }

        notifications = notifications.stream().filter(notification -> criteria.getFromDate().equals(notification.getSentDate()) || criteria.getFromDate().before(notification.getSentDate())).collect(Collectors.toList());
        notifications = notifications.stream().filter(notification -> criteria.getUntilDate().equals(notification.getSentDate()) || criteria.getUntilDate().after(notification.getSentDate())).collect(Collectors.toList());
        return notifications;
    }


    @RequestMapping(value = "/notification/total", method = RequestMethod.POST)
    public int getTotal(@RequestBody SearchDto criteria) {
        List<Notification> notifications = service.getNotifications();
        notifications = filter(criteria, notifications);
        return notifications.size();
    }

}
