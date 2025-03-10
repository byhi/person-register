package hu.byhi.personregister.controller;

import hu.byhi.personregister.dto.TaskChangerRequestDto;
import hu.byhi.personregister.dto.TaskDto;
import hu.byhi.personregister.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("personregister")
public class TaskController {

    TaskManagerService taskManagerService;

    @GetMapping("/task/{taskId}")
    public ResponseEntity<TaskDto> findTaskById(@PathVariable Long taskId) {
        try {
            return ResponseEntity.ok(taskManagerService.findTaskById(taskId));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping("/task")
    public ResponseEntity<List<TaskDto>> findAllTask() {
        try {
            return ResponseEntity.ok(taskManagerService.findAllTask());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.emptyList());
        }
    }

    @PostMapping("/task")
    public ResponseEntity<String> createTask(@RequestBody TaskDto dto) {
        try {
            taskManagerService.createTask(dto);
            return ResponseEntity.ok(HttpStatus.ACCEPTED.name());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @PutMapping("/task")
    public ResponseEntity<String> updateTask(@RequestBody TaskDto dto) {
        try {
            taskManagerService.updateTask(dto);
            return ResponseEntity.ok(HttpStatus.ACCEPTED.name());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }

    }

    @PutMapping("/task/change")
    public ResponseEntity<String> changeTask(@RequestBody TaskChangerRequestDto dto) {
        try {
            taskManagerService.changeTaskByRequestDto(dto);
            return ResponseEntity.ok(HttpStatus.ACCEPTED.name());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }

    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long taskId) {
        try {
            taskManagerService.deleteTaskById(taskId);
            return ResponseEntity.ok(HttpStatus.ACCEPTED.name());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @Autowired
    public void setTaskManagerService(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }
}
