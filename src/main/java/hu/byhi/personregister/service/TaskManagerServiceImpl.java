package hu.byhi.personregister.service;

import hu.byhi.personregister.common.IssueState;
import hu.byhi.personregister.dto.TaskChangerRequestDto;
import hu.byhi.personregister.dto.TaskDto;
import hu.byhi.personregister.entity.Person;
import hu.byhi.personregister.entity.Task;
import hu.byhi.personregister.mapper.TaskMapper;
import hu.byhi.personregister.mapper.TaskMapperImpl;
import hu.byhi.personregister.repository.PersonRepository;
import hu.byhi.personregister.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static hu.byhi.personregister.common.IssueState.*;

@Service
public class TaskManagerServiceImpl implements TaskManagerService{


    TaskRepository taskRepository;
    PersonRepository personRepository;
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

    public void change(Long taskId) {

        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskDto findTaskById(Long taskId) {
        return taskMapper.entityToDto(taskRepository.findById(taskId).orElse(null));
    }

    @Override
    public void changeTaskByRequestDto(TaskChangerRequestDto dto) {
        Task task = taskRepository.findById(dto.getId()).orElseThrow(() -> new NullPointerException("Task changer request is null"));
        if (Objects.nonNull(dto.getAssignee())) {
            Person employee = personRepository.findById(dto.getAssignee()).orElseThrow(() -> new NullPointerException("User not exist: " + dto.getAssignee()));
            if (!employee.getEmployee())
                throw new IllegalStateException("User is not employee");

            task.setAssignee(employee);
        }

        if (Objects.nonNull(dto.getComment())) {
            task.setComment(dto.getComment());
        }

        if (Objects.nonNull(dto.getState())) {
            task.setState(changeStateValidation(task.getState(), dto.getState()));
        }
        taskRepository.save(task);
    }

    private IssueState changeStateValidation(IssueState orignalState, IssueState newState) {
        switch (orignalState){
            case OPENED -> {if (!newState.equals(ASSIGNED))
                throw new IllegalStateException("Only opened task take to assigned");}
            case ASSIGNED -> {if (!newState.equals(IN_PROGRESS))
                throw new IllegalStateException("Only assigne task take to in progress");}
            case IN_PROGRESS -> {
                if (!Arrays.asList(SUSPENDED, RESOLVED).contains(newState))
                    throw new IllegalStateException("Only take to suspeded or resolved to an in progress task");}
            case RESOLVED -> {if (!newState.equals(CLOSED))
                throw new IllegalStateException("Only close a resolved task");}
        }
        return newState;
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
