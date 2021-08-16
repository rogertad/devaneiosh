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
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;
import br.lippe.devaneios.devaneios.grepoback.service;

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

    @GetMapping("/cb")
    public String cb(Model model,@RequestParam(required = false)  String ss) {

        //service get array resources e qty

        //Long l = 20L;

        Long l = s.getCityID();

        model.addAttribute("resource", s.getResourcesQty(l));
        model.addAttribute("buildings", s.getBuildings(l));
        model.addAttribute("idCity", l);
        
        //logger.info("mandei a data " + Instant.now());
        return "cb";

    }


    @GetMapping("/up")
    @ResponseBody
    public String upgradeBuilding(@RequestParam(name = "bid") String bid, @RequestParam(name = "cid") String cid) {

        // model.addAttribute("datahora", Instant.now().toEpochMilli()+11000);
        logger.info("------------------------mandei a data " + Instant.now());

        long x = Long.valueOf(cid);
        long y = Long.valueOf(bid);

        Long l = s.addEvent(x, y);

        return l.toString();

    }


    @GetMapping("/upBuilding")
    @ResponseBody
    public String upBuilding(@RequestParam(name = "bid") String bid, @RequestParam(name = "cid") String cid) {

        // model.addAttribute("datahora", Instant.now().toEpochMilli()+11000);
        logger.info("UPANDO BULDING");

        long x = Long.valueOf(cid);
        long y = Long.valueOf(bid);

        s.upBuilding(cid,bid);

        //Long l = s.addEvent(x, y);

        return "a".toString();

    }



    @MessageMapping("/msg")
    @SendTo("/topic/msg")
    public City msg() throws Exception {
        Thread.sleep(10000); // simulated delay
        City c = new City();
        c.setName("msg cidade");
        return c;
    }

    @GetMapping("/cities")
    public String cities(Model model) {

        model.addAttribute("events", eventRepo.findAll());
        // logger.info("mandei a data "+Instant.now());
        return "cities";

    }

}