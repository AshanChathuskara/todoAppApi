package com.abc.todoAppApi.controller;

import com.abc.todoAppApi.dto.Todo;
import com.abc.todoAppApi.dto.responce.CommonResponse;
import com.abc.todoAppApi.helper.GlobalConst;
import com.abc.todoAppApi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/add")
    public ResponseEntity<CommonResponse> addTask(@RequestBody Todo todo) {
        return getResponse(taskService.addTask(todo), "");
    }

    @GetMapping(value = "/done")
    public ResponseEntity<CommonResponse> markAsDone(@RequestParam Integer id) {
        return getResponse(taskService.markAsDone(id), "");
    }

    @GetMapping(value = "/remove")
    public ResponseEntity<CommonResponse> removeTask(@RequestParam Integer id) {
        return getResponse(taskService.removeTask(id), "");
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<CommonResponse> findAllTasks() {
        List<Todo> allTasks = taskService.findAllTasks();
        String msg;
        if (allTasks != null && allTasks.size() > 0) {
            msg = GlobalConst.RESPONSE_MSG_SUCCESS;
        } else {
            msg = GlobalConst.RESPONSE_MSG_NO_RECORDS;
        }
        return getResponse(msg, allTasks);
    }

    private ResponseEntity<CommonResponse> getResponse(String msg, Object data) {
        String code;
        if (GlobalConst.RESPONSE_MSG_SUCCESS.equals(msg)) {
            code = GlobalConst.RESPONSE_CODE_OK;
        } else {
            code = GlobalConst.RESPONSE_CODE_FAIL;
        }
        CommonResponse commonResponse = new CommonResponse(code, msg, data);
        return new ResponseEntity<CommonResponse>(commonResponse, HttpStatus.OK);
    }

}
