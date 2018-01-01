package com.integritas.codingtest.business;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class Todo {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="todo_id")
	 private int id;
	 
	 @ManyToOne
	 @JoinColumn(name="todo_list_id", nullable=false)
	 private TodoList todoList;
	 
	 @Column(name="todo_name")
	 private String todoName;
	 
	 @Column(name="todo_priority")
	 private String todoPriority;
	 
	 @Column(name="todo_status")
	 private String todoStatus;
	 
	 @Column(name="todo_created_time")
	 private Date todoCreatedTime;
	 
	 @Column(name="todo_closed_time")
	 private Date todoClosedTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public TodoList getTodoList() {
		return todoList;
	}
	
	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getTodoPriority() {
		return todoPriority;
	}

	public void setTodoPriority(String todoPriority) {
		this.todoPriority = todoPriority;
	}

	public String getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}

	public Date getTodoCreatedTime() {
		return todoCreatedTime;
	}

	public void setTodoCreatedTime(Date todoCreatedTime) {
		this.todoCreatedTime = todoCreatedTime;
	}

	public Date getTodoClosedTime() {
		return todoClosedTime;
	}

	public void setTodoClosedTime(Date todoClosedTime) {
		this.todoClosedTime = todoClosedTime;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", todoName=" + todoName + ", todoPriority="
				+ todoPriority + ", todoStatus=" + todoStatus
				+ ", todoCreatedTime=" + todoCreatedTime + ", todoClosedTime="
				+ todoClosedTime + "]";
	}
	 
}
