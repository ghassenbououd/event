package com.it.event;


import static org.hamcrest.Matchers.hasItem;

import com.it.event.model.Evenement;
import com.it.event.repository.EventRepository;
import org.junit.jupiter.api.BeforeAll;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EventApplicationTests {


    @Autowired
    EventRepository eventRepo;


    @BeforeAll
    @Test
    public void createEventTest() {


        Evenement evenement = new Evenement();
        evenement.setId(10L);
        evenement.setEventName("Event1");

        evenement.setEventDescription("IT EVENT");
        evenement.setLieu("CANADA");
        evenement.setDebutDate(new Date());
        evenement.setFinDate(new Date());
        eventRepo.save(evenement);

        eventRepo.findAll().forEach(p -> {
            System.out.print("evenement created");
                    System.out.println(p.toString());
                }
        );

    }


    @BeforeAll
    @Test
    public void getAllEventTest() {
        eventRepo.findAll().forEach(p -> {
                    System.out.println(p.toString());
                }
        );
        List<Evenement> eventList = eventRepo.findAll();

        //Test equals
        assertNotEquals(eventList, hasItem(new Evenement(3L, "Event2", "IT EVENT", new Date(), new Date(), "canada")));
        assertNotNull(eventList);

        // assertThat(eventList, containsInAnyOrder(new Evenement(10L, "event one", "event1", new Date(), new Date(), "Canada")));
    }


}