package hu.byhi.personregister.mapper;

import hu.byhi.personregister.dto.TaskDto;
import hu.byhi.personregister.entity.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper extends BaseMapper<Task, TaskDto>{

}
