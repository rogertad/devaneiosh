package br.lippe.devaneios.devaneios.db;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class controle {
    
    @Autowired
    LocalService service;

    @GetMapping("/devaneios")
    public String devaneios(@RequestParam(name="nomes") String namea, Model model) {

        service.getAllLocals();
        model.addAttribute("nome",namea);
        return "devaneiosview";
        
    }
    
   
}
