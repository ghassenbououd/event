package com.it.event.model;

import java.util.ArrayList;
import java.util.List;

public class GetEventResponse {

    private boolean success;
    private List<Evenement> EventList= new ArrayList<>();

    public List<Evenement> getEventList() {
        return EventList;
    }

    public void setEventList(List<Evenement> eventList) {
        EventList = eventList;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }



}
