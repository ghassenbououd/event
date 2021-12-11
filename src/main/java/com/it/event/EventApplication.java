package com.it.event;

import com.it.event.model.Evenement;
import com.it.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
@EntityScan("com.it.event.model")
@EnableJpaRepositories("com.it.event.repository")
public class EventApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);

    }


    @Autowired
    EventRepository eventRepository;


    @Override
    public void run(String... args) throws Exception {


        eventRepository.save(new Evenement(12L ,"Event2", "IT EVENT", new Date(), new Date(), "canada"));
        eventRepository.save(new Evenement(1L ,"Event3", "IT EVENT", new Date(), new Date(), "canada"));
        eventRepository.save(new Evenement(10L ,"Event1", "IT EVENT", new Date(), new Date(), "canada"));

        eventRepository.findAll().forEach(p->{
            System.out.println(p.toString());
                }


        );
    }

}
