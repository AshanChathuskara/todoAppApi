package com.abc.todoAppApi.controller;

import com.abc.todoAppApi.dto.Todo;
import com.abc.todoAppApi.helper.GlobalConst;
import com.abc.todoAppApi.service.TaskService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskControllerTest {

    @Autowired
    private TaskService taskService;

    @Test
    @Order(1)
    void addTaskTest() {
        Todo todo = new Todo("Test1", "Testing Api");
        taskService.addTask(todo);
        Optional<Todo> task = taskService.getTask(1);
        assertTrue(task.isPresent());
        assertEquals(todo.getTitle(),task.get().getTitle());
    }

    @Test
    @Order(2)
    void markAsDoneTest() {
        Optional<Todo> task = taskService.getTask(1);
        assertTrue(task.isPresent());
        String msg = taskService.markAsDone(1);
        assertEquals(GlobalConst.RESPONSE_MSG_SUCCESS,msg);
    }

    @Test
    @Order(3)
    void findAllTasksTest() {
        List<Todo> allTasks = taskService.findAllTasks();
        assertTrue(allTasks.size() > 0);
    }

    @Test
    @Order(4)
    void removeTaskTest() {
        taskService.removeTask(1);
        Optional<Todo> task = taskService.getTask(1);
        assertFalse(task.isPresent());
    }

}