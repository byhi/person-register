package hu.byhi.personregister.mapper;

import java.util.List;

public interface BaseMapper<ENTITY, DTO > {
    ENTITY dtoToEntity(DTO dto);
    DTO entityToDto(ENTITY entity);

    List<ENTITY> mapDtoListToEntityList(List<DTO> dto);
    List<DTO> mapEntityListToDtoList(List<ENTITY> entity);
}
