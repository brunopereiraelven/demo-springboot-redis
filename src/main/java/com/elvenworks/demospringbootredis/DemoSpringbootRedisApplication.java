package com.elvenworks.demospringbootredis;

import com.elvenworks.demospringbootredis.model.Elf;
import com.elvenworks.demospringbootredis.repo.ElfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DemoSpringbootRedisApplication {

    @Autowired
    private ElfRepository elfRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootRedisApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/elf")
    public String elf(@RequestParam(value = "name", defaultValue = "Legolas") String name) {
        String elfId = "" + System.currentTimeMillis();
        Elf elf = new Elf(elfId,name, Elf.Gender.MALE);
        elfRepository.save(elf);
        return String.format("Hail new Elf %s!", elf);
    }

    @GetMapping("/elves")
    public String elves() {
        List<Elf> elves = (List<Elf>) elfRepository.findAll();
        String elvesList = "";
        for (Elf e:elves) {
            elvesList = elvesList + String.format("Elf %s! <br>", e);
        }
        return elvesList;
    }
}