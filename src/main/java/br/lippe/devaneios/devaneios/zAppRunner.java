package br.lippe.devaneios.devaneios;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import br.lippe.devaneios.devaneios.grepoback.*;

import java.util.concurrent.CompletableFuture;

@Component
public class zAppRunner {//implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(zAppRunner.class);

  private final UpdateResources ur;

	@Autowired
	private CityRepository cityRepo;


  public zAppRunner(UpdateResources ur) {
    this.ur = ur;
  }

//  @Override
  public void run(String... args) throws Exception {
    // Start the clock
    long start = System.currentTimeMillis();

    // Kick of multiple, asynchronous lookups
//    CompletableFuture<User> page1 = ur.findUser("PivotalSoftware");
  //  CompletableFuture<User> page2 = ur.findUser("CloudFoundry");
  //  CompletableFuture<User> page3 = ur.findUser("Spring-Projects");

  CompletableFuture<User> page1 = ur.fazIsso();

    // Wait until they are all done

    // Print results, including elapsed time

  }



}