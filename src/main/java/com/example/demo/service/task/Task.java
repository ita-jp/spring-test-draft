package com.example.demo.service.task;

/**
 * @see https://developers.google.com/tasks/reference/rest/v1/tasks
 */
public record Task(
    long id,
    String title,
    String note
) {

}
