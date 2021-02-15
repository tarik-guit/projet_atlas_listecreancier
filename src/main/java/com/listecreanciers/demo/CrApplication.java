package com.listecreanciers.demo;

import com.listecreanciers.demo.Antities.Creancier;
import com.listecreanciers.demo.Controller.Controcreancier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
public class CrApplication implements CommandLineRunner {
   @Autowired
   private Controcreancier cr;

    public static void main(String[] args) {
        SpringApplication.run(CrApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }





    @Override
    public void run(String... args) throws Exception {
        Creancier c1=new Creancier(700L,"creancier1",new Date(),700L);
        Creancier c2=new Creancier(701L,"creancier2",new Date(),701L);
        Creancier c3=new Creancier(702L,"creancier3",new Date(),702L);
        Creancier c4=new Creancier(703L,"creancier4",new Date(),703L);
        cr.creercreancier(c1);
        cr.creercreancier(c2);
        cr.creercreancier(c3);
        cr.creercreancier(c4);

    }
}
