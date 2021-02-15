package com.listecreanciers.demo.Controller;


import com.listecreanciers.demo.Antities.Creancier;
import com.listecreanciers.demo.Repositories.Repocreancier;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin()
public class Controcreancier {

    @Autowired
    private Repocreancier rep;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/creanciers")
    public List<Creancier> getallcreanciers() {
        return rep.findAll();
    }

    @GetMapping("/factures/{idc}")
    public JSONObject getallfactureimpayee(@PathVariable Long idc) {
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));


        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://localhost:8006/factures/"+idc, HttpMethod.GET, entity, JSONObject.class).getBody();


    }

    //creer creancier
    @PostMapping("/creancier")
    public JSONObject creercreancier (@RequestBody Creancier c) {

        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));


        HttpEntity<Creancier> entity = new HttpEntity<Creancier>(c,headers);
         rep.save(c);
        return restTemplate.exchange(
                "http://localhost:8006/creancier", HttpMethod.POST, entity, JSONObject.class).getBody();
    }




}
