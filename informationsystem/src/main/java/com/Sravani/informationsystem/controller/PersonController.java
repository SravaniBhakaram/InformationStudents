package com.Sravani.informationsystem.controller;

import com.Sravani.informationsystem.model.Person;
import com.Sravani.informationsystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Person person){
        try {
            personService.savePerson(person);
            return ResponseEntity.ok("New person is added");
        } catch (Exception e) {
            e.printStackTrace();  // 👈 Logs the real issue in your IntelliJ console
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }

    }

    @GetMapping("/getAll")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }
}
