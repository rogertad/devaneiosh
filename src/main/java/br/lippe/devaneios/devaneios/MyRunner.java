package br.lippe.devaneios.devaneios;

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
@Order(2)
@EnableScheduling
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

//    @Autowired
//    private CityRepository cityRepo;
	@Autowired
	private CityRepository cityRepo;

	public void run(String... args) throws Exception {

			

	}

	@Transactional
	@Scheduled(fixedRate = 5000)
    public void fazAquilo() throws Exception {

		
        logger.info(".......................................initializing users");

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

//		User u = new User();
//		u.setCities(alc);
Thread.sleep(1000);
		logger.info("...........................S A L V A N D O..................");

		Thread.sleep(1000);
        cityRepo.save(c);
		Thread.sleep(1000);

		logger.info("...........................S A L V O..................");

		Thread.sleep(1000);
        for (City l : cityRepo.findAll()) {
			//l.getBuildings();
            logger.info("====>>>>>>> "+l.toString());
			Thread.sleep(1000);
        }

    }
}