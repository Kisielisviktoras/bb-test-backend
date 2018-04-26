package bb.service;

import bb.constants.NotificationReason;
import bb.constants.NotificationStatus;
import bb.constants.NotificationType;
import bb.dto.LookupItem;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LookupService {

    public List<LookupItem> getItems(String lookupName) {
        switch (lookupName) {
            case "NotificationStatus": {
                return Arrays.stream(NotificationStatus.values())
                        .map(value -> new LookupItem(value.getDisplayValue(), value.name()))
                        .collect(Collectors.toList());
            }
            case "NotificationReason": {
                return Arrays.stream(NotificationReason.values())
                        .map(value -> new LookupItem(value.getDisplayValue(), value.name()))
                        .collect(Collectors.toList());
            }
            case "NotificationType": {
                return Arrays.stream(NotificationType.values())
                        .map(value -> new LookupItem(value.getDisplayValue(), value.name()))
                        .collect(Collectors.toList());
            }
        }

        return Collections.emptyList();
    }
}
