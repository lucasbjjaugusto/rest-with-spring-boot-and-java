package br.com.springstudy.usecase.person;

import br.com.springstudy.entity.person.gateway.PersonGateway;
import br.com.springstudy.entity.person.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllPerson {

    private final PersonGateway personGateway;

    public FindAllPerson(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    public List<Person> execute() {
        return personGateway.findAll();
    }
}
