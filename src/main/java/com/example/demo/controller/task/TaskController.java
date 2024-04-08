package com.example.demo.controller.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.NotFoundError;
import com.example.demo.controller.exception.NotFoundException;
import com.example.demo.service.task.TaskService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> show(@PathVariable("id") long id) {
        return taskService.findById(id)
        .map(TaskDTO::from)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> NotFoundException.of("/tasks/" + id));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundError> handleNotFound(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.toError());
    }
    
}
