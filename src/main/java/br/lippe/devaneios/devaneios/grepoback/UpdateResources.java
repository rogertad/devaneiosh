package br.lippe.devaneios.devaneios.grepoback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

@Service
public class UpdateResources {

  private static final Logger logger = LoggerFactory.getLogger(UpdateResources.class);

  @Autowired
  private CityRepository cityRepo;

  User results = new User();// = restTemplate.getForObject(url, User.class);

  @Async
  public CompletableFuture<User> fazIsso() throws InterruptedException {

    int x = 0;
    while (x == 0) {

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

      // User u = new User();
      // u.setCities(alc);

      logger.info("...........................S A L V A N D O..................");

      cityRepo.save(c);

      logger.info("...........................S A L V O..................");

      for (City l : cityRepo.findAll()) {
        // l.getBuildings();
        logger.info("====>>>>>>> " + l.toString());
      }

    }
    return CompletableFuture.completedFuture(results);

  }

}