package br.lippe.devaneios.devaneios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.lippe.devaneios.devaneios.grepoback.*;

@SpringBootApplication
public class DevaneiosApplication {

	public static void main(String[] args) {
		
		
		//SpringApplication.run(DevaneiosApplication.class, args);
		
		ConfigurableApplicationContext ctx = SpringApplication.run(DevaneiosApplication.class, args);
		
		//ctx.getBean(arg0)
		

			



	}

}
