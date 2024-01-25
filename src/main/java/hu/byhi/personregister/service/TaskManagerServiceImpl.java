package hu.byhi.personregister.service;

import hu.byhi.personregister.dto.TaskDto;
import hu.byhi.personregister.mapper.TaskMapper;
import hu.byhi.personregister.mapper.TaskMapperImpl;
import hu.byhi.personregister.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskManagerServiceImpl implements TaskManagerService{


    TaskRepository taskRepository;
    TaskMapper taskMapper = new TaskMapperImpl();

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDto> findAllTask() {
        return taskMapper.mapEntityListToDtoList(taskRepository.findAll());
    }

    @Override
    public void createTask(TaskDto dto) {
        taskRepository.save(taskMapper.dtoToEntity(dto));
    }

    @Override
    public void updateTask(TaskDto dto) {
        taskRepository.save(taskMapper.dtoToEntity(dto));
    }

    @Override
    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskDto findTaskById(Long taskId) {
        return taskMapper.entityToDto(taskRepository.findById(taskId).orElse(null));
    }
}
