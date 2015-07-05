package com.task.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.task.jpa.TaskHibDAO;
import com.task.model.Task;
@Controller
public class TaskController {
	@Autowired
	private TaskHibDAO taskHib;
	@RequestMapping("hello")
	public String userPage(@RequestParam("user") String user, Model m){
		
		m.addAttribute("user",user);
		return "index";
	}
	@Transactional
	@RequestMapping(value = "addTask", method= RequestMethod.POST)
	public String addTask(Writer writer, Model m) throws IOException{
		Task task = new Task("Task","Content","1");
		try{
			taskHib.create(task);
			writer.write("success");
		}
		catch(Exception e){
			writer.write("fail");
		}
		writer.write("finish");
		return "index";
	}
}
