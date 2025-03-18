/**
 * 
 */
package com.example.effiwork.controller;

import com.example.effiwork.entity.Task;
import com.example.effiwork.repository.TaskRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * タスクコントローラ
 */
@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;

	@GetMapping
	public String index(Model model) {
		
		Iterable<Task> taskList = taskRepository.findAll();
		
        // FullCalendar用のイベントデータリストを作成
        List<Map<String, Object>> tasksJson = new ArrayList<>();
		for(Task task : taskList) {
			Map<String, Object> event = new HashMap<>();
			event.put("title", task.getTitle());
			event.put("startOn", task.getStartOn());
			event.put("endOn", task.getEndOn());
            tasksJson.add(event);
		}
		
//		Task tasks = new Task();
//		tasks.setTaskId("00001");
//		tasks.setUserId("0001");
//		tasks.setTitle("タスク1");
//		tasks.setDescription("明日すること");
//		tasks.setStatus(0);
//		tasks.setStartOn(LocalDate.of(2025, 01, 10));
//		tasks.setEndOn(LocalDate.of(2025, 01, 10));
//		tasks.setCreatedAt(LocalDateTime.now());
//		tasks.setUpdatedAt(LocalDateTime.now());
		
		
		model.addAttribute("taskInfo", tasksJson);
		return "task/index";
	}
}
