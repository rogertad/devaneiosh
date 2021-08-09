package br.lippe.devaneios.devaneios.grepoback;


import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.ui.Model;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.lippe.devaneios.devaneios.db.controle;

@Controller
// @CrossOrigin("http://localhost:8081")
public class controler {

    private static final Logger logger = LoggerFactory.getLogger(controle.class);

    @GetMapping("/timer")
    public String timer(Model model) {

        model.addAttribute("datahora", Instant.now().toEpochMilli()+11000);
        logger.info("mandei a data "+Instant.now());
        return "timer";

    }

}