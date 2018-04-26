package bb.controller;

import bb.dto.LookupItem;
import bb.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LookupController {

    @Autowired
    private LookupService service;

    @RequestMapping(value = "/lookup/{lookupName}", method = RequestMethod.GET)
    public ResponseEntity<List<LookupItem>> getLookupItems(@PathVariable String lookupName) {
        List<LookupItem> items = service.getItems(lookupName);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
