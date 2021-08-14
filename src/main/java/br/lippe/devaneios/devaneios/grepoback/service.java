package br.lippe.devaneios.devaneios.grepoback;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lippe.devaneios.devaneios.grepoback.*;

@Service
public class service {

    @Autowired
    BuildingRepo b;

	@Autowired
    CityRepository c;

	private static final Logger logger = LoggerFactory.getLogger(controler.class);

    public Long addEvent(long cid, long bid) {

		// Thread.sleep(1000);
		
        City cc =c.findById(cid);

        Event e2 = new Event();
		e2.setCity(cc);
		e2.setStatus(Event.BUILDING);

		long timeStampMillis2 = Instant.now().toEpochMilli();

		timeStampMillis2=timeStampMillis2+30000;

		e2.setTick(new Timestamp(timeStampMillis2));

		cc.getEvents().add(e2);

		// User u = new User();
		// u.setCities(alc);
		// Thread.sleep(1000);
		logger.info("...........................S A L V A N D O..................");

		// Thread.sleep(1000);
		c.save(cc);
		// Thread.sleep(1000);

		logger.info("...........................S A L V O..................");




        return timeStampMillis2;

    }

	public List<Resource> getResourcesQty(long x){

		//List l = new ArrayList<Resource>();
				
		City ci = c.findById(x);

		return ci.getResource();

	}

	public List<Building> getBuildings(long x){

		//List l = new ArrayList<Resource>();
				
		City ci = c.findById(x);

		return ci.getBuildings();

	}
	  
}