package br.lippe.devaneios.devaneios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.lippe.devaneios.devaneios.grepoback.*;

@SpringBootApplication
@EnableScheduling
public class DevaneiosApplication {

	public static void main(String[] args) {
		
		
		//SpringApplication.run(DevaneiosApplication.class, args);
		
		ConfigurableApplicationContext ctx = SpringApplication.run(DevaneiosApplication.class, args);
		
		//ctx.getBean(arg0)
		

			


	}

	@Scheduled(fixedRate =  5000)
	public void fazIsso(){

		System.out.println("to aqui a cada 5 seg :-)");
	}


}
