package hu.byhi.personregister.service;

import hu.byhi.personregister.dto.PersonDto;
import hu.byhi.personregister.entity.Person;
import hu.byhi.personregister.mapper.PersonMapper;
import hu.byhi.personregister.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{


    PersonRepository personRepository;

    PersonMapper personMapper;

    @Override
    public List<PersonDto> findAllPerson() {

        return personMapper.mapEntityListToDtoList(personRepository.findAll());
    }

    @Override
    public PersonDto findPersonById(Long personId) {
        return personMapper.entityToDto(personRepository.findById(personId).orElse(null));
    }

    @Override
    public void createPerson(PersonDto person) {
        personRepository.save( personMapper.dtoToEntity(person));
    }

    @Override
    public void updatePerson(PersonDto person) {
        personRepository.save( personMapper.dtoToEntity(person));
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired
    public void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }
}
