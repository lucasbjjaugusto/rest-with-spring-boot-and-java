package br.com.springstudy.entity.person.gateway;

import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.repository.person.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonGateway {

    private final PersonRepository personRepository;

    public PersonGateway(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        return this.personRepository.save(person);
    }

    public Person update(Person person) {
        return this.personRepository.save(person);
    }

    public Optional<Person> findById(Long id) {
        return this.personRepository.findById(id);
    }

    public void remove(Long id) {
        personRepository.deleteById(id);
    }

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }
}
