package com.example.demo.controller.task;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.task.Task;
import com.example.demo.service.task.TaskService;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskService taskService;


    @Test
    @DisplayName("リクエストURL で指定された Task が存在する場合はそのタスクを返す")
    public void returnOK() throws Exception {
        // ## Arrange ##
        var taskId = 1L;
        var entity = new Task(taskId, "title task 1", "notes task 1");
        when(taskService.findById(taskId)).thenReturn(Optional.of(entity));

        // ## Act ##
        var result = mvc.perform(get("/tasks/" + taskId));

        // ## Assert $$
        result
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(entity.id()))
        .andExpect(jsonPath("$.title").value(entity.title()))
        .andExpect(jsonPath("$.note").value(entity.note()))
        ;
    }

    @Test
    public void return404() throws Exception {
        // ## Arrange ##
        var taskId = 99L;
        when(taskService.findById(taskId)).thenReturn(Optional.empty());

        // ## Act ##
        var result = mvc.perform(get("/tasks/" + taskId)).andDo(print());

        // ## Assert ##
        result
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.title").value("Not Found"))
        .andExpect(jsonPath("$.detail").isNotEmpty())
        .andExpect(jsonPath("$.instance").value("/tasks/" + taskId))
        ;
    }

}