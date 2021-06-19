package com.abc.todoAppApi.service;

import com.abc.todoAppApi.dao.TaskDao;
import com.abc.todoAppApi.dto.Todo;
import com.abc.todoAppApi.helper.GlobalConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public String addTask(Todo todo) {
        todo.setCreatedDate(new Date());
        todo.setActiveState(GlobalConst.TASK_STATUS_PENDING);
        taskDao.save(todo);
        return GlobalConst.RESPONSE_MSG_SUCCESS;
    }

    @Override
    public String removeTask(Integer id) {
        Optional<Todo> task = getTask(id);
        if (task.isPresent()) {
            taskDao.deleteById(id);
            return GlobalConst.RESPONSE_MSG_SUCCESS;
        } else {
            return GlobalConst.RESPONSE_MSG_NO_RECORDS;
        }
    }

    @Override
    public String markAsDone(Integer id) {
        Optional<Todo> task = getTask(id);
        if (task.isPresent()) {
            Todo existing = getTask(id).get();
            if (GlobalConst.TASK_STATUS_PENDING.equals(existing.getActiveState())) {
                existing.setActiveState(GlobalConst.TASK_STATUS_DONE);
                existing.setEndDate(new Date());
                taskDao.save(existing);
                return GlobalConst.RESPONSE_MSG_SUCCESS;
            } else {
                return "already mark as done";
            }
        } else {
            return GlobalConst.RESPONSE_MSG_NO_RECORDS;
        }
    }

    @Override
    public Optional<Todo> getTask(Integer id) {
        return taskDao.findById(id);
    }

    @Override
    public List<Todo> findAllTasks() {
        return taskDao.findAll();
    }
}
