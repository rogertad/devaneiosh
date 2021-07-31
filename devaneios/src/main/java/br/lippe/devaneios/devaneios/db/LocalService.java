package br.lippe.devaneios.devaneios.db;

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


        for (int x=1;x<2;x++){
            Local l = new Local("santos"+x, "cidade");
            try{
               // repository.save(l);
            }catch(Exception e){
                logger.error("deu pau: ==="+e.getMessage());
            }
        }

        for (Local l : repository.findAll()) {
            logger.info("====>>>>>>> "+l.toString());
            
          }

          logger.info("--------------------AQUI---------------");


        for (Local l : repository.findByNomeContaining("5")) {
            logger.info("====>>>>>>> "+l.toString());
        }


          return repository.findAll();

        
          
        
    }

}
