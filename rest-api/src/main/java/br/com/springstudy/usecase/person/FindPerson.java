package br.com.springstudy.usecase.person;

import br.com.springstudy.entity.person.gateway.PersonGateway;
import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class FindPerson {

    private final PersonGateway personGateway;
    private Logger logger = Logger.getLogger(FindPerson.class.getName());

    public FindPerson(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    public Person execute(Long id) {
        logger.info("Finding one person");
        return this.personGateway.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Person find for this ID!"));
    }

}
