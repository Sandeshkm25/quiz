package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.model.Question;
import com.quiz.model.Quiz;
import com.quiz.service.QuizService;

@RequestMapping("/Quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	public ResponseEntity<String> createQuiz(int numQues,String catogary,String title)
	{
		return quizService.createQuiz(numQues,catogary,title);
	}
	public ResponseEntity<Quiz> getQuiz(String title)
	{
		return quizService.getQuiz(title);
	}
	
}
