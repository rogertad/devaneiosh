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
    
    @Autowired
    private service s;

    @GetMapping("/city")
    public Iterable<City> cidades(@RequestParam(value = "name", defaultValue = "World") String name) {

        return s.fazAquilo();

    }

    @GetMapping("/mostracity")
    public Iterable<City> mostraCities(@RequestParam(value = "name", defaultValue = "World") String name) {

        return cityRepo.findAll();

    }


}