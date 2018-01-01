package com.integritas.codingtest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.integritas.codingtest.business.TodoList;

@RepositoryRestResource(collectionResourceRel = "todoLists", path = "todoLists")
public interface TodoListRepository extends CrudRepository<TodoList, Integer> {
	// TODO
}
