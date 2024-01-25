package hu.byhi.personregister.controller;

import hu.byhi.personregister.dto.PersonDto;
import hu.byhi.personregister.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("personregister")
public class PersonController {

    PersonService personService;

    @GetMapping("/person/{personId}")
    public ResponseEntity<PersonDto> findPersonById(@PathVariable Long personId) {
        try {
            return ResponseEntity.ok(personService.findPersonById(personId));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping("/person")
    public ResponseEntity<List<PersonDto>> findAllPerson() {
        try {
            return ResponseEntity.ok(personService.findAllPerson());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.emptyList());
        }
    }

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@RequestBody PersonDto person) {
        try {
            personService.createPerson(person);
            return ResponseEntity.ok(HttpStatus.ACCEPTED.name());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/person")
    public ResponseEntity<String> updatePerson(@RequestBody PersonDto person) {
        try {
            personService.updatePerson(person);
            return ResponseEntity.ok(HttpStatus.ACCEPTED.name());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @DeleteMapping("/person/{personId}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long personId) {
        try {
            personService.deletePerson(personId);
            return ResponseEntity.ok(HttpStatus.ACCEPTED.name());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
