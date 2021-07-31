package br.lippe.devaneios.devaneios.db;

import java.util.ArrayList;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalService {
    
    Logger logger = LoggerFactory.getLogger(LocalService.class);

    @Autowired
    LocalRepository repository;

    public Iterable<Local> getAllLocals(){

        
        //return repository.findAll();
        logger.info("--------------------AQUI---------------");


        List<Local> list = new ArrayList<>();
        

        for (int x=1;x<22;x++){
            Local l = new Local("santos"+x, "cidade");
            list.add(l);
        }

        try{
            repository.saveAll(list);
            
            
         }catch(Exception e){
            logger.error("deu pau: ==="+e.getMessage());
         }


        for (Local l : repository.findAll()) {
            logger.info("====>>>>>>> "+l.toString());
            
          }

          logger.info("------------procurando pelo nro 5---------------");


        for (Local l : repository.findByNomeContaining("5")) {
            logger.info("====>>>>>>> "+l.toString());
        }

        logger.info("------------PRONTO ---------------");

          return list;

        
          
        
    }

}
