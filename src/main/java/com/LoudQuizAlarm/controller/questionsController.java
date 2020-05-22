package com.LoudQuizAlarm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoudQuizAlarm.entity.questions;
import com.LoudQuizAlarm.service.questionService;

@RestController
public class questionsController {
	
	@Autowired
	private questionService service;
	
	@GetMapping("/")
	public List<questions> listQuestions () {
		return service.listQuestions();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<questions> deleteById (@PathVariable int id){
		return service.deleteById(id);
	}
	
	@PostMapping("/{id}")
	public questions create(@RequestBody questions questions) {
		return service.create(questions);
	}
	
	@GetMapping("/{id}")
	public questions findById (@PathVariable int id) {
		return service.findById(id);
	}
}
