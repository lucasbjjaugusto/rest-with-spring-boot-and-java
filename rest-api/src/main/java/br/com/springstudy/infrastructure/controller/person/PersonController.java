package br.com.springstudy.infrastructure.controller.person;

import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.controller.person.dto.PersonRequest;
import br.com.springstudy.infrastructure.controller.person.dto.PersonResponse;
import br.com.springstudy.usecase.person.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @CrossOrigin(origins = "http://localhost:8090")//No postman colocar no headers o origin um outro url para testar
    @Operation(summary = "Find person", description = "service for find a person by ID.",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Person.class))),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    @GetMapping(value = "/{id}"
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonResponse findById(@PathVariable Long id) {
        return findPerson.execute(id);
    }

    @Operation(summary = "Find all person", description = "service for find all person.",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Person.class)))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PersonResponse> findAll() {
        return findAllPerson.execute();
    }

    @Operation(summary = "Create person", description = "service for creating a person.",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Person.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonResponse create(@RequestBody PersonRequest personRequest) {
        return createPerson.execute(personRequest);
    }

    @Operation(summary = "Update person", description = "service for updating a person.",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Person.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    @PutMapping(value = "/{id}"
            , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonResponse update(@PathVariable Long id, @RequestBody PersonRequest personRequest) {
        return updatePerson.execute(id, personRequest);
    }

    @Operation(summary = "Delete person", description = "service for deleting a person.",
            tags = {"Person"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        deletePerson.execute(id);
        return ResponseEntity.noContent().build();
    }

}
