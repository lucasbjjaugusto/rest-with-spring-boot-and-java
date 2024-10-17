package br.com.springstudy.usecase.person;

import br.com.springstudy.entity.person.gateway.PersonGateway;
import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.controller.person.dto.PersonResponse;
import br.com.springstudy.infrastructure.exception.ResourceNotFoundException;
import br.com.springstudy.infrastructure.util.person.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class FindPerson {

    private final PersonGateway personGateway;
    private final Logger logger = Logger.getLogger(FindPerson.class.getName());

    public FindPerson(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    public PersonResponse execute(Long id) {
        logger.info("Finding a person");
        Person person = personGateway.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Person find for this ID!"));
        return PersonMapper.MapperPersonResponse(person);
    }

}
