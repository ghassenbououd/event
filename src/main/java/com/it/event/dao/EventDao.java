package com.it.event.dao;

import com.it.event.model.AddEventRequest;
import com.it.event.model.GetEventResponse;

public interface EventDao {
    public boolean createEvent(AddEventRequest addEventRequest);
    public  GetEventResponse getAllEvent();

}
