package com.todoapp.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.todoapp.domain.ToDo;

@Stateless
public class TodoService {
	@PersistenceContext
	private EntityManager entityManager;
	public ToDo create(ToDo todo) { entityManager.persist(todo); return todo;
	}
	public ToDo find(Long id) {
	ToDo todo = entityManager.find(ToDo.class, id);
	return todo;
	}

}
