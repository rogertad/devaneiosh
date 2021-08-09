package br.lippe.devaneios.devaneios;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

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

@Component
//@Order(2)
//@EnableScheduling
public class MyRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

	// @Autowired
	// private CityRepository cityRepo;
	@Autowired
	private CityRepository cityRepo;

	public void run(String... args) throws Exception {

	}

	@Transactional
	//@Scheduled(fixedRate = 5000)
	public void addEvent() throws Exception {

		logger.info("...........adicionando evento.....................");

		for (City c : cityRepo.findAll()) {

			Event e2 = new Event();
			e2.setCity(c);
			e2.setStatus(Event.BUILDING);

			long timeStampMillis2 = Instant.now().toEpochMilli();
			e2.setTick(new Timestamp(timeStampMillis2));

			c.getEvents().add(e2);

			logger.info(".........................S A L V A N D O..................");

			cityRepo.save(c);

			logger.info("...........................S A L V O..................");

			long tp = 0;

			for (Event eee : c.getEvents()) {

				logger.info("TIMESTAMP é : " + eee.getTick());

				long diff = eee.getTick().getTime() - tp;

				logger.info("TIMESTAMP é : " + (diff / 1000) + " segundos");
				logger.info("TIMESTAMP é : " + (diff / (60 * 1000)) + " minutos");
				logger.info("TIMESTAMP é : " + (diff / (60 * 60 * 1000)) + " horas");
				logger.info("TIMESTAMP é : " + (diff / (24 * 60 * 60 * 1000)) + " dias");

				tp = eee.getTick().getTime();

			}

		}

	}

	@Transactional
	//@Scheduled(fixedRate = 140000)
	public void fazAquilo() throws Exception {

		logger.info("........................incluindo cidades");

		City c = new City();
		c.setName("cidade 001");
		c.setSilver(100L);
		c.setStone(100L);
		c.setWood(100L);

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

		Thread.sleep(3000);

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

		// Thread.sleep(1000);
		for (City l : cityRepo.findAll()) {

			for (Event eee : l.getEvents()) {

				logger.info("TIMESTAMP é : " + eee.getTick());

			}

			// logger.info("====>>>>>>> " + l.toString());
			// Thread.sleep(1000);
		}

	}

}