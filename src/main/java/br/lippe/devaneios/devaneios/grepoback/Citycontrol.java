package br.lippe.devaneios.devaneios.grepoback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.lippe.devaneios.devaneios.db.CausoRepository;
import br.lippe.devaneios.devaneios.grepoback.*;

@RestController
public class Citycontrol {

    private static final Logger logger = LoggerFactory.getLogger(Citycontrol.class);

    @Autowired
    private CityRepository cityRepo;

    @GetMapping("/city")
    public Iterable<City> cidades(@RequestParam(value = "name", defaultValue = "World") String name) {

        return fazAquilo();

    }

    @GetMapping("/mostracity")
    public Iterable<City> mostraCities(@RequestParam(value = "name", defaultValue = "World") String name) {

        return cityRepo.findAll();

    }



    public Iterable<City> fazAquilo() {

        logger.info("........................incluindo cidades");

        City c = new City();
        c.setName("cidade 001");

        Building b = new Building();
        b.setLevel(10L);
        b.setCity(c);

        Building b1 = new Building();
        b1.setLevel(1440L);
        b1.setCity(c);

        Building b2 = new Building();
        b2.setLevel(22210L);
        b2.setCity(c);

        c.getBuildings().add(b);
        c.getBuildings().add(b1);
        c.getBuildings().add(b2);

        Event e1 = new Event();
        e1.setCity(c);
        e1.setStatus(Event.BUILDING);
        long timeStampMillis = Instant.now().toEpochMilli();
        e1.setTick(new Timestamp(timeStampMillis));

        c.getEvents().add(e1);
        // Thread.sleep(3000);

        Event e2 = new Event();
        e2.setCity(c);
        e2.setStatus(Event.BUILDING);

        long timeStampMillis2 = Instant.now().toEpochMilli();
        e2.setTick(new Timestamp(timeStampMillis2));

        c.getEvents().add(e2);

        Resource r1 = new Resource("wood", 7);
		Resource r2 = new Resource("stone", 7);
		Resource r3 = new Resource("silver", 7);
		Resource r4 = new Resource("iron", 7);
        
        r1.setCity(c);
        r2.setCity(c);
        r3.setCity(c);
        r4.setCity(c);

		c.getResource().add(r1);
		c.getResource().add(r2);
		c.getResource().add(r3);
		c.getResource().add(r4);

        // User u = new User();
        // u.setCities(alc);
        // Thread.sleep(1000);
        logger.info("...........................S A L V A N D O..................");

        // Thread.sleep(1000);
        cityRepo.save(c);
        // Thread.sleep(1000);

        logger.info("...........................S A L V O..................");

        for (City l : cityRepo.findAll()) {

            for (Event eee : l.getEvents()) {

                // logger.info("TIMESTAMP é : " + eee.getTick());

            }

            // logger.info("====>>>>>>> " + l.toString());
            // Thread.sleep(1000);
        }

        return cityRepo.findAll();
    }

}