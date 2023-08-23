package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.dao.QuestionDao;
import com.quiz.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao dao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		  return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public  ResponseEntity<List<Question>> getAllQuestionsByCatagory(String category) {
		// TODO Auto-generated method stub
		return  new ResponseEntity<>(dao.findByCatagory(category),HttpStatus.OK);
	}

	public  ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		dao.save(question);
		return new ResponseEntity<>("sucess",HttpStatus.CREATED);
	}

	public  ResponseEntity<Question> updateQuestion(Question question) {
		Question question2=dao.findById(question.getId()).orElse(null);
		question2.setCatagory(question.getCatagory());
		question2.setOption1(question.getOption1());
		question2.setOption2(question.getOption2());
		question2.setOption3(question.getOption3());
		question2.setOption4(question.getOption4());
		question2.setRightAns(question.getRightAns());
		question2.setQuestionTitle(question.getQuestionTitle());
		question2.setDifficulty(question.getDifficulty());
		return new ResponseEntity<>(question2,HttpStatus.ACCEPTED);
	}
	public  ResponseEntity<String> deleteQuestion(Question question) {
		// TODO Auto-generated method stub
		dao.delete(question);
		return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
	}

}
