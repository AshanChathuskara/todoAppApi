package com.abc.todoAppApi.service;

import com.abc.todoAppApi.dto.Todo;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    String addTask(Todo todo);

    String removeTask(Integer id);

    String markAsDone(Integer id);

    Optional<Todo> getTask(Integer id);

    List<Todo> findAllTasks();

}
