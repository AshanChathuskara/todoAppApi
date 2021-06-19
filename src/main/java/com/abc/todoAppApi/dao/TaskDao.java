package com.abc.todoAppApi.dao;

import com.abc.todoAppApi.dto.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskDao extends MongoRepository<Todo,Integer> {

}
