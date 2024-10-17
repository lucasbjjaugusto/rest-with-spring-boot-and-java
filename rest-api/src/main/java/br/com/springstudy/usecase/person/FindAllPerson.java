package br.com.springstudy.usecase.person;

import br.com.springstudy.entity.person.gateway.PersonGateway;
import br.com.springstudy.infrastructure.controller.person.dto.PersonResponse;
import br.com.springstudy.infrastructure.util.person.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FindAllPerson {

    private final PersonGateway personGateway;
    private final Logger logger = Logger.getLogger(FindAllPerson.class.getName());

    public FindAllPerson(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    public List<PersonResponse> execute() {
        logger.info("Find all person's");
        return personGateway.findAll().stream().map(PersonMapper::MapperPersonResponse).toList();
    }
}
