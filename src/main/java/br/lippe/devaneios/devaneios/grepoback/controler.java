package br.lippe.devaneios.devaneios.grepoback;


import java.time.Instant;
import org.springframework.ui.Model;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
// @CrossOrigin("http://localhost:8081")
public class controler {

    private static final Logger logger = LoggerFactory.getLogger(controler.class);

    @Autowired
	private EventRepo eventRepo;

    @GetMapping("/timer")
    public String timer(Model model) {

        model.addAttribute("datahora", Instant.now().toEpochMilli()+11000);
        logger.info("mandei a data "+Instant.now());
        return "timer";

    }

    @GetMapping("/cities")
    public String cities(Model model) {
        
        model.addAttribute("events", eventRepo.findAll());
        //logger.info("mandei a data "+Instant.now());
        return "cities";

    }



}