package com.example.demo.controller.dto;

public record NotFoundError(
    String title,
    String detail,
    String instance
) {
}
