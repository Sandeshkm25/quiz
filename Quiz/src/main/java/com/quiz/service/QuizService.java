package com.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.quiz.dao.QuestionDao;
import com.quiz.dao.QuizDao;
import com.quiz.model.Question;
import com.quiz.model.Quiz;

public class QuizService {

    @Autowired
	QuizDao dao;
    @Autowired
    QuestionDao questionDao;
    
	public ResponseEntity<String> createQuiz(int numQues, String catogary, String title) {
	
		List<Question> questions=questionDao.findRandomQuestionsByCatagory(numQues,catogary);
		Quiz quiz=new Quiz();
		quiz.setQuestions(questions);
		quiz.setTitle(title);
		dao.save(quiz);
		return new ResponseEntity<>("Suecess",HttpStatus.CREATED);
	}

	public ResponseEntity<Quiz> getQuiz(String title) {
		
		return new ResponseEntity<>(dao.findByTitle(title),HttpStatus.OK);
	}

}
