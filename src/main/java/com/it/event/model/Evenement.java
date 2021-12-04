package com.it.event.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "EVENT_TABLE")
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(max = 32)
    @NotNull
    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_description")
    private String eventDescription;


    @Column(name = "date_start_event")
    private Date debutDate;


    @Column(name = "date_end_event")
    private Date finDate;

    private String lieu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(Date debutDate) {
        this.debutDate = debutDate;
    }

    public Date getFinDate() {
        return finDate;
    }

    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Evenement(Long id, String eventName, String eventDescription, Date debutDate, Date finDate, String lieu) {
        this.id = id;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.debutDate = debutDate;
        this.finDate = finDate;
        this.lieu = lieu;
    }

    public Evenement() {
        super();
    }

}

