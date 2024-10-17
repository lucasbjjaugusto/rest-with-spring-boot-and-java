package br.com.springstudy.usecase.person;

import br.com.springstudy.entity.person.gateway.PersonGateway;
import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.controller.person.dto.PersonRequest;
import br.com.springstudy.infrastructure.controller.person.dto.PersonResponse;
import br.com.springstudy.infrastructure.util.person.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreatePerson {

    private final PersonGateway personGateway;
    private final Logger logger = Logger.getLogger(CreatePerson.class.getName());

    public CreatePerson(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    public PersonResponse execute(PersonRequest personRequest) {
        logger.info("Creating a person");
        return PersonMapper.MapperPersonResponse(personGateway.create(new Person(personRequest.firstName(), personRequest.lastName(), personRequest.address(), personRequest.gender())));
    }
}
