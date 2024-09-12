package br.com.springstudy.usecase.person;

import br.com.springstudy.entity.person.gateway.PersonGateway;
import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DeletePerson {

    private final PersonGateway personGateway;
    private Logger logger = Logger.getLogger(DeletePerson.class.getName());

    public DeletePerson(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    public void execute(Long id) {
        Optional<Person> personOptional = personGateway.findById(id);
        if (personOptional.isEmpty()) {
            throw new ResourceNotFoundException("Person not found.");
        }
        logger.info("Deleting one person");
        personGateway.remove(id);
    }
}
