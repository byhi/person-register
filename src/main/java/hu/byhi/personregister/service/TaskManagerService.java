package hu.byhi.personregister.service;

import hu.byhi.personregister.dto.TaskDto;
import java.util.List;

public interface TaskManagerService {
    List<TaskDto> findAllTask();

    void createTask(TaskDto dto);

    void updateTask(TaskDto dto);

    void deleteTaskById(Long taskId);

    TaskDto findTaskById(Long taskId);

}
