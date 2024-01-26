package hu.byhi.personregister.service;

import hu.byhi.personregister.common.IssueState;
import hu.byhi.personregister.dto.TaskChangerRequestDto;
import hu.byhi.personregister.entity.Person;
import hu.byhi.personregister.entity.Task;
import hu.byhi.personregister.repository.PersonRepository;
import hu.byhi.personregister.repository.TaskRepository;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static hu.byhi.personregister.common.IssueState.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskManagerServiceImplTest {

    @InjectMocks
    private TaskManagerService taskManagerService = new TaskManagerServiceImpl();
    private static final Long TASK_ID = 3L;
    private static final Long PERSON_ID = 4L;
    @Mock
    private TaskRepository taskRepository;
    @Mock
    private PersonRepository personRepository;



    TaskChangerRequestDto requestDto;
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        requestDto = new TaskChangerRequestDto();
        requestDto.setId(TASK_ID);
        requestDto.setAssignee(PERSON_ID);
        requestDto.setState(OPENED);

    }

    @Test
    void when_call_changeTaskByRequestDto_with_correct_request_dto() {
        Task testTask = getBaseTask();
        Person testPerson = getBasePerson();
        requestDto.setState(ASSIGNED);
        when(taskRepository.findById(TASK_ID)).thenReturn(Optional.of(testTask));
        when(personRepository.findById(PERSON_ID)).thenReturn(Optional.of(testPerson));

        taskManagerService.changeTaskByRequestDto(requestDto);
        verify(taskRepository, times(1)).save(testTask);
    }

    @Test
    void throw_illegal_state_exception_when_call_changeTaskByRequestDto_with_correct_state() {
        Task testTask = getBaseTask();
        Person testPerson = getBasePerson();
        requestDto.setState(CLOSED);
        when(taskRepository.findById(TASK_ID)).thenReturn(Optional.of(testTask));
        when(personRepository.findById(PERSON_ID)).thenReturn(Optional.of(testPerson));

        Exception actualException =
                assertThrows(IllegalStateException.class, () -> taskManagerService.changeTaskByRequestDto(requestDto));
        assertTrue(StringUtils.containsIgnoreCase( actualException.getMessage(), "Only opened task take to assigned"));
    }

    @Test
    void throw_illegal_state_exception_when_call_changeTaskByRequestDto_but_assignee_user_is_not_employee() {
        Task testTask = getBaseTask();
        Person testPerson = getBasePerson();
        testPerson.setEmployee(Boolean.FALSE);
        when(taskRepository.findById(TASK_ID)).thenReturn(Optional.of(testTask));
        when(personRepository.findById(PERSON_ID)).thenReturn(Optional.of(testPerson));

        Exception actualException =
                assertThrows(IllegalStateException.class, () -> taskManagerService.changeTaskByRequestDto(requestDto));
        assertTrue(StringUtils.containsIgnoreCase( actualException.getMessage(), "User is not employee"));
    }

    @Test
    void throw_null_pointer_exception_when_call_changeTaskByRequestDto_with_incorrect_user_id() {
        Task testTask = getBaseTask();
        when(taskRepository.findById(TASK_ID)).thenReturn(Optional.of(testTask));
        when(personRepository.findById(PERSON_ID)).thenReturn(Optional.empty());

        Exception actualException =
                assertThrows(NullPointerException.class, () -> taskManagerService.changeTaskByRequestDto(requestDto));
        assertTrue(StringUtils.containsIgnoreCase( actualException.getMessage(), "User not exist:"));
    }

    @Test
    void throw_null_pointer_exception_when_call_changeTaskByRequestDto_with_incorrect_task_id() {
        when(taskRepository.findById(TASK_ID)).thenReturn(Optional.empty());

        Exception actualException =
                assertThrows(NullPointerException.class, () -> taskManagerService.changeTaskByRequestDto(requestDto));
        assertTrue(StringUtils.containsIgnoreCase( actualException.getMessage(), "Task changer request is null"));
    }

    Task getBaseTask(){
        Task testTask = new Task();
        testTask.setState(OPENED);
        testTask.setId(TASK_ID);
         return testTask;
    }

    Person getBasePerson(){
        Person testPerson = new Person();
        testPerson.setId(PERSON_ID);
        testPerson.setEmployee(Boolean.TRUE);
        return testPerson;
    }
}