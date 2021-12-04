package com.it.event.controller;

import com.it.event.model.AddEventRequest;
import com.it.event.model.AddEventResponse;
import com.it.event.model.Evenement;
import com.it.event.model.GetEventResponse;
import com.it.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@RestController
@RequestMapping
public class EventController {

    private Logger logger = LogManager.getLogger(EventController.class);
    SimpleDateFormat dateFormatIso = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
    @Autowired
    EventService eventService;


    @PostMapping("/AddEvent")
    public AddEventResponse addEvent(@RequestBody AddEventRequest addEventRequest) throws Exception {
        //Get GMT time Zone
        dateFormatIso.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date debutDateEvent = addEventRequest.getDebutDate();
        Date finDateEvent = addEventRequest.getFinDate();
        if (debutDateEvent != null) {
            dateFormatIso.format(debutDateEvent);
            addEventRequest.setDebutDate(debutDateEvent);
        }
        if (finDateEvent != null) {
            dateFormatIso.format(finDateEvent);
            addEventRequest.setFinDate(finDateEvent);
        }
        AddEventResponse addEvents = eventService.saveEventService(addEventRequest);

        return addEvents;
    }


    // Lister les événements
    @GetMapping("/GetEvent")
    public GetEventResponse eventList() throws Exception {
        GetEventResponse getEvents = eventService.getAllEventService();

        return getEvents;
    }


}
