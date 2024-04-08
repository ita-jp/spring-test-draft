package com.example.demo.controller.exception;

import com.example.demo.controller.dto.NotFoundError;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
    private final String title = "Not Found";
    private final String detail;
    private final String instance;

    public static NotFoundException of(String url) {
        return new NotFoundException("Task is not found.", url);
    }

    public NotFoundError toError() {
        return new NotFoundError(title, detail, instance);
    }
}
