package com.integritas.codingtest.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todoListManager")
public class TodoListManagerController {
	
	private static final Logger logger = Logger.getLogger(TodoListManagerController.class);

	@RequestMapping(name="/")
	public String index() {
		logger.info("TESTE");
		return "index";
	}

}
