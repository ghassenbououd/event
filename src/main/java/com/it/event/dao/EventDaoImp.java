package com.it.event.dao;

import com.it.event.model.AddEventRequest;
import com.it.event.model.Evenement;
import com.it.event.model.GetEventResponse;
import com.it.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

@Repository
public class EventDaoImp implements EventDao {

    private Logger logger = LogManager.getLogger(EventDaoImp.class.getName());
    @Autowired
    EventRepository eventRepository;

    // insertion dans la table Event avec jba
    public boolean createEvent(AddEventRequest addEventRequest) {
        this.logger.info("createEvent run In");
        Boolean finished = false;
        try {
            Evenement evenement = new Evenement();
            evenement.setEventName(addEventRequest.getEventName());
            evenement.setEventDescription(addEventRequest.getEventDescription());
            evenement.setLieu(addEventRequest.getLieu());
            evenement.setDebutDate(addEventRequest.getDebutDate());
            evenement.setFinDate(addEventRequest.getFinDate());
            eventRepository.save(evenement);

        } catch (Exception e) {
            finished = false;
            e.printStackTrace();
            throw e;
        }

        this.logger.info("createEvent run out");
        return finished;
    }


    public GetEventResponse getAllEvent() {
        this.logger.info("getAllEvent run In");
        GetEventResponse getEventResponse = new GetEventResponse();
        try {
            List<Evenement> eventList = eventRepository.findAll();
            getEventResponse.setEventList(eventList);
            getEventResponse.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            getEventResponse.setSuccess(false);
            throw e;
        }
        this.logger.info("getAllEvent run out");
        return getEventResponse;
    }
}
