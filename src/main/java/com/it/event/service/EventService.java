package com.it.event.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.it.event.dao.EventDaoImp;
import com.it.event.model.AddEventRequest;
import com.it.event.model.AddEventResponse;
import com.it.event.model.GetEventResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventDaoImp eventDaoImp;
    private Logger logger = LogManager.getLogger(EventService.class.getName());

    public AddEventResponse saveEventService(AddEventRequest addEventRequest) {

        AddEventResponse AddEventResponse = new AddEventResponse();
        boolean finished;
        try {
            if (checkInput(addEventRequest)) {
                finished = eventDaoImp.createEvent(addEventRequest);
                AddEventResponse.setFinished(finished);
            } else {
                AddEventResponse.setComment("Event name ne depasse 32 char");
                AddEventResponse.setFinished(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("saveEventService run out");
        return AddEventResponse;

    }

    public GetEventResponse getAllEventService() {
        GetEventResponse getEventResponse = new GetEventResponse();
        try {
            getEventResponse = eventDaoImp.getAllEvent();

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("getAllEventService ryn out");
        return getEventResponse;
    }

    private boolean checkInput(AddEventRequest addEventRequest) {
        boolean checkName = true;
        if (addEventRequest.getEventName().length() >= 32) {
            logger.info("Event name ne depasse pas 32 char");
            checkName = false;
        }
        return checkName;
    }
}
