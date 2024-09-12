package br.com.springstudy.usecase.person;

import br.com.springstudy.entity.person.gateway.PersonGateway;
import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.controller.dto.PersonRequest;
import br.com.springstudy.infrastructure.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UpdatePerson {

    private final PersonGateway personGateway;
    private Logger logger = Logger.getLogger(CreatePerson.class.getName());

    public UpdatePerson(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    public Person execute(Long id, PersonRequest personRequest) {

        Optional<Person> personOptional = personGateway.findById(id);
        if (personOptional.isEmpty()) {
            throw new ResourceNotFoundException("Person not found.");
        }
        logger.info("Updating one person");
        Person person = personOptional.get();
        person.setFirstName(personRequest.firstName());
        person.setLastName(personRequest.lastName());
        person.setAddress(personRequest.address());
        person.setGender(personRequest.gender());

        return personGateway.update(person);
    }

}
