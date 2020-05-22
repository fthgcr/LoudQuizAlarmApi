package com.LoudQuizAlarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.LoudQuizAlarm.repository.quesionsRepository;
import com.LoudQuizAlarm.entity.questions;

@Service
public class questionService {

	@Autowired
	private quesionsRepository repository;
	
	public List<questions> listQuestions(){
		return repository.findAll();
	}
	
	public ResponseEntity<questions> deleteById (int id){
		repository.deleteById(id);
		return new ResponseEntity<questions> (HttpStatus.ACCEPTED);
	}
	
	public questions create(@RequestBody questions questions) {
		repository.save(questions);
		return questions;
	}
	
	public questions findById (int id) {
		return repository.findById(id).orElse(null);
	}
	
}
