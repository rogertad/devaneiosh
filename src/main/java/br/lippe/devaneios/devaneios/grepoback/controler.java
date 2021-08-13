package br.lippe.devaneios.devaneios.grepoback;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.springframework.ui.Model;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @CrossOrigin("http://localhost:8081")
public class controler {

    private static final Logger logger = LoggerFactory.getLogger(controler.class);

    @Autowired
    private EventRepo eventRepo;


    @Autowired
    private service s;

    @GetMapping("/timer")
    public String timer(Model model) {

        model.addAttribute("datahora", Instant.now().toEpochMilli() + 11000);
        logger.info("mandei a data " + Instant.now());
        return "timer";

    }

    @GetMapping("/ajax")
    @ResponseBody
    public String ajax() {

        // model.addAttribute("datahora", Instant.now().toEpochMilli()+11000);
        logger.info("------------------------mandei a data " + Instant.now());

        return "ajax_";

    }

    @GetMapping("/up")
    @ResponseBody
    public String upgradeBuilding(@RequestParam(name = "bid") String bid,
            @RequestParam(name = "cid") String cid) {

        // model.addAttribute("datahora", Instant.now().toEpochMilli()+11000);
        logger.info("------------------------mandei a data " + Instant.now());

        long x = Long.valueOf(cid);
        long y = Long.valueOf(bid);

        Long l = s.addEvent(x,y);

        return l.toString();

    }

 

    @GetMapping("/cities")
    public String cities(Model model) {

        model.addAttribute("events", eventRepo.findAll());
        // logger.info("mandei a data "+Instant.now());
        return "cities";

    }

}