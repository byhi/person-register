package hu.byhi.personregister.service;

import hu.byhi.personregister.dto.PersonDto;

import java.util.List;

public interface PersonService {
    void createPerson(PersonDto person);
    void updatePerson(PersonDto person);
    void deletePerson(Long personId);

    PersonDto findPersonById(Long personId);
    List<PersonDto> findAllPerson();
}
