package com.example.demo.service.task;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public Optional<Task> findById(long id) {
        return Optional.empty();
    }

}
