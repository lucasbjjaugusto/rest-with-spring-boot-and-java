package br.com.springstudy.infrastructure.util.person;

import br.com.springstudy.entity.person.model.Person;
import br.com.springstudy.infrastructure.controller.person.dto.PersonResponse;

public class PersonMapper {

    public static PersonResponse MapperPersonResponse(Person person) {
        return new PersonResponse(person.getId(), person.getFirstName(), person.getLastName(), person.getAddress(), person.getGender());
    }
}
