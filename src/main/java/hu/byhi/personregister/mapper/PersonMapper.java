package hu.byhi.personregister.mapper;

import hu.byhi.personregister.dto.PersonDto;
import hu.byhi.personregister.entity.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper extends BaseMapper<Person, PersonDto>{

}
