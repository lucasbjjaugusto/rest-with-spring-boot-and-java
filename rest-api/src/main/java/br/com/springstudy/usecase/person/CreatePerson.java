package br.com.springstudy.usecase.person;

import br.com.springstudy.entity.person.gateway.PersonGateway;
import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.controller.dto.PersonRequest;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreatePerson {

    private final PersonGateway personGateway;
    private Logger logger = Logger.getLogger(CreatePerson.class.getName());

    public CreatePerson(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    public Person execute(PersonRequest personRequest) {
        logger.info("Creating one person");
        return personGateway.create(new Person(personRequest.firstName(), personRequest.lastName(), personRequest.address(), personRequest.address()));
    }
}
