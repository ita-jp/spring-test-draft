package com.example.demo.controller.task;

import com.example.demo.service.task.Task;

public record TaskDTO(
    long id,
    String title,
    String note
) {
    public static TaskDTO from(Task entity) {
        return new TaskDTO(entity.id(), entity.title(), entity.note());
    }
}
