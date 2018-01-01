/**
 * 
 */
  var app = angular.module('todoListManagerApp', []);
  app.controller('todoListManagerController', function($scope, $http) {
	  $scope.selection = [];
	  $scope.todoListSelectedId = "";
	  $scope.todosUrlSelected = "";
	  $scope.statuses=['ACTIVE','COMPLETED'];
	  $scope.priorities=['HIGH','MEDIUM','LOW'];
	  $http.defaults.headers.post["Content-Type"] = "application/json";
				
	  function getAllTodoList() {
		  $http.get('/todoLists').
		  success(function (data) {
			  if (data._embedded != undefined) {
				  $scope.todoLists = data._embedded.todoLists;
			  } else {
				  $scope.todoLists = [];
			  }
			  
			  $scope.todoListName = "";
		  });
	  }

	  getAllTodoList();

	  $scope.getTodosByTodoList = function getTodosByTodoList(todosUrl, selfUrl) {
		  $http.get(todosUrl).
		  success(function (data) {
			  if (data._embedded != undefined) {
				  $scope.todos = data._embedded.todos;
			  } else {
				  $scope.todos = [];
			  }
			  $scope.todoListSelectedUrl = selfUrl;
			  $scope.todosUrlSelected = todosUrl;
		  });
	  }

	  $scope.deleteTodo = function deleteTodo(todoUrl) {
		  $http.delete(todoUrl).
		  success(function(data, status, headers) {
			  $scope.getTodosByTodoList($scope.todosUrlSelected, $scope.todoListSelectedUrl);
		  });
	  }

	  $scope.updateTodo = function updateTodo($event, todo) {
		  var checkbox = $event.target;
		  var status = (checkbox.checked ? "COMPLETED" : "ACTIVE");
		  var date = null;
		  if (status == "COMPLETE") {
			  date = new Date();
		  }
		  $http.put(todo._links.self.href, {
			  todoList: $scope.todoListSelectedUrl,
			  todoName: todo.todoName,
			  todoPriority: todo.todoPriority,
			  todoStatus: status,
			  todoCreatedTime: todo.todoCreatedTime,
			  todoClosedTime: date
		  }).
		  success(function(data, status, headers) {
			  $scope.getTodosByTodoList($scope.todosUrlSelected, $scope.todoListSelectedUrl);
		  });
	  }

	  $scope.addTodo = function addTodo(newTodoName, newTodoPriority) {
		  if (newTodoName == undefined || newTodoPriority == undefined || newTodoName == "" || newTodoPriority == "") {
			  alert("Please provide the todo item name and the todo item priority!");
		  } else {
			  $http.post('/todos', {
				  todoList: $scope.todoListSelectedUrl,
				  todoName: newTodoName,
				  todoPriority: newTodoPriority,
				  todoStatus: "ACTIVE",
				  todoCreatedTime: new Date()
			  }).
			  success(function(data, status, headers) {
				  $scope.getTodosByTodoList($scope.todosUrlSelected, $scope.todoListSelectedUrl);
			  });
		  }
	  }

	  $scope.addTodoList = function addTodoList() {
		  if ($scope.todoListName == "") {
			  alert("Please provide the todo list name!");
		  } else {
			  $http.post('/todoLists', {
				  todoListName: $scope.todoListName,
				  todoListCreatedTime: new Date()
			  }).
			  success(function(data, status, headers) {
				  getAllTodoList();
			  });
		  }
	  }

	  function getTodoListById(url) {
		  $http.get(url).
		  success(function (data) {
			  return data;
		  });
	  }
  });