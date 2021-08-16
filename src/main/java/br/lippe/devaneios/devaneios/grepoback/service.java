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
	CityRepository cityRepo;

	@Autowired
	private KindOfBuildingRepo kobRepo;

	@Autowired
	private ResourceRepo resourceRepo;

	private static final Logger logger = LoggerFactory.getLogger(controler.class);

	public Long addEvent(long cid, long bid) {

		// Thread.sleep(1000);

		City cc = cityRepo.findById(cid);

		Event e2 = new Event();
		e2.setCity(cc);
		e2.setStatus(Event.BUILDING);

		long timeStampMillis2 = Instant.now().toEpochMilli();

		timeStampMillis2 = timeStampMillis2 + 30000;

		e2.setTick(new Timestamp(timeStampMillis2));

		cc.getEvents().add(e2);

		// User u = new User();
		// u.setCities(alc);
		// Thread.sleep(1000);
		logger.info("...........................S A L V A N D O..................");

		// Thread.sleep(1000);
		cityRepo.save(cc);
		// Thread.sleep(1000);

		logger.info("...........................S A L V O..................");

		return timeStampMillis2;

	}

	public List<ResourceCity> getResourcesQty(long x) {

		// List l = new ArrayList<Resource>();

		City ci = cityRepo.findById(x);

		return ci.getResourceCities();

	}

	public List<Building> getBuildings(long x) {

		// List l = new ArrayList<Resource>();

		City ci = cityRepo.findById(x);

		return ci.getBuildings();

	}

	public Long getCityID() {

		City ci = cityRepo.findFirstByOrderByNameAsc();

		if (ci != null) {
			return ci.getId();
		} else {
			fazAquilo();
			ci = cityRepo.findFirstByOrderByNameAsc();
			return ci.getId();
		}
		
	}

	public Iterable<City> fazAquilo() {

		addResources();
		addKindOfBuilding();
		addBuildingsLevels();

		logger.info("........................incluindo cidades");

		City c = new City();
		c.setName("cidade 001");

		for (KindOfBuilding l : kobRepo.findAll()) {

			Building b = new Building();
			b.setLevel(1L);
			b.setCity(c);
			b.setKob(l);
			c.getBuildings().add(b);

			cityRepo.save(c);

		}

		for (Resource rr : resourceRepo.findAll()) {

			ResourceCity rc = new ResourceCity();
			rc.setCity(c);
			rc.setResource(rr);
			rc.setQty(1L);
			c.getResourceCities().add(rc);

			cityRepo.save(c);

		}

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

		// User u = new User();
		// u.setCities(alc);
		// Thread.sleep(1000);
		logger.info("...........................S A L V A N D O..................");

		// Thread.sleep(1000);
		cityRepo.save(c);
		// Thread.sleep(1000);

		logger.info("...........................S A L V O..................");

/* 		for (City l : cityRepo.findAll()) {

			for (Event eee : l.getEvents()) {

				// logger.info("TIMESTAMP é : " + eee.getTick());

			}

			// logger.info("====>>>>>>> " + l.toString());
			// Thread.sleep(1000);
		}
 */
		return cityRepo.findAll();
	}

	public void addKindOfBuilding() {

		KindOfBuilding k1 = new KindOfBuilding();
		k1.setName("Farm");
		KindOfBuilding k2 = new KindOfBuilding();
		k2.setName("Quarry");
		KindOfBuilding k3 = new KindOfBuilding();
		k3.setName("SilverMine");

		kobRepo.save(k1);
		kobRepo.save(k2);
		kobRepo.save(k3);

	}

	public void addResources() {

		Resource r1 = new Resource();
		Resource r2 = new Resource();
		Resource r3 = new Resource();
		Resource r4 = new Resource();
		r1.setName("Wood");
		r2.setName("Stone");
		r3.setName("Silver");
		r4.setName("Iron");
		resourceRepo.save(r1);
		resourceRepo.save(r2);
		resourceRepo.save(r3);
		resourceRepo.save(r4);

	}

	public void addBuildingsLevels() {

		for (KindOfBuilding k : kobRepo.findAll()) {

			// logger.info("-----> add level resource of building: ".concat(k.getName()));

			for (Resource rr : resourceRepo.findAll()) {

				for (int x = 1; x <= 10; x++) {

					BuildingLevelsResources blr = new BuildingLevelsResources();

					blr.setLevel(Long.valueOf(x));
					blr.setQty(Long.valueOf(x) * 100);
					blr.setTimeBuilding(Long.valueOf(x * 10000) * 20);

					blr.setResource(rr);
					blr.setKob(k);

					k.getBuildingLevelsResources().add(blr);

				}

			}

			kobRepo.save(k);

		}

	}

	public void upBuilding(String cid, String bid) {

		




	}

}