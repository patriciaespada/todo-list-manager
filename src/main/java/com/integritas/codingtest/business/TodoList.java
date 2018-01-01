package com.integritas.codingtest.business;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="todo_list")
public class TodoList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="todo_list_id")
	private int id;
	 
	@Column(name="todo_list_name")
	private String todoListName;
	 
	@OneToMany(mappedBy="todoList", cascade=CascadeType.ALL)
	private List<Todo> todos;
	 
	@Column(name="todo_list_created_time")
	private Date todoListCreatedTime;
	 
	@Column(name="todo_list_closed_time")
	private Date todoListClosedTime;

	public int getId() {
		return id;
	}
	 
	 public void setId(int id) {
		this.id = id;
	}

	public String getTodoListName() {
		return todoListName;
	}

	public void setTodoListName(String todoListName) {
		this.todoListName = todoListName;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public Date getTodoListCreatedTime() {
		return todoListCreatedTime;
	}

	public void setTodoListCreatedTime(Date todoListCreatedTime) {
		this.todoListCreatedTime = todoListCreatedTime;
	}

	public Date getTodoListClosedTime() {
		return todoListClosedTime;
	}

	public void setTodoListClosedTime(Date todoListClosedTime) {
		this.todoListClosedTime = todoListClosedTime;
	}

	@Override
	public String toString() {
		return "TodoList [id=" + id + ", todoListName=" + todoListName
				+ ", todos=" + todos + ", todoListCreatedTime="
				+ todoListCreatedTime + ", todoListClosedTime="
				+ todoListClosedTime + "]";
	}

}
