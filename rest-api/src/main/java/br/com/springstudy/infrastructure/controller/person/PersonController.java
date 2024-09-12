package br.com.springstudy.infrastructure.controller.person;

import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.controller.dto.PersonRequest;
import br.com.springstudy.usecase.person.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "Service for management persons")
public class PersonController {

    private final CreatePerson createPerson;
    private final UpdatePerson updatePerson;
    private final DeletePerson deletePerson;
    private final FindPerson findPerson;
    private final FindAllPerson findAllPerson;

    public PersonController(CreatePerson createPerson, UpdatePerson updatePerson, DeletePerson deletePerson, FindPerson findPerson, FindAllPerson findAllPerson) {
        this.createPerson = createPerson;
        this.updatePerson = updatePerson;
        this.deletePerson = deletePerson;
        this.findPerson = findPerson;
        this.findAllPerson = findAllPerson;
    }

    @Operation(summary = "Find person", description = "service for find a person by ID.")
    @GetMapping(value = "/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Person findById(@PathVariable Long id) {
        return findPerson.execute(id);
    }

    @Operation(summary = "Find all person", description = "service for find all person.")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Person> findAll() {
        return findAllPerson.execute();
    }


    @Operation(summary = "Create person", description = "service for creating a person.")
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Person create(@RequestBody PersonRequest personRequest) {
        return createPerson.execute(personRequest);
    }

    @Operation(summary = "Update person", description = "service for updating a person.")
    @PutMapping(value = "/{id}"
            , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Person update(@PathVariable Long id, @RequestBody PersonRequest personRequest) {
        return updatePerson.execute(id, personRequest);
    }


    @Operation(summary = "Delete person", description = "service for deleting a person.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deletePerson.execute(id);
    }

}
