package com.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz.model.Question;

public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> findByCatagory(String catagory);

	@Query(value="SELECT * FROM question q where q.catagory=:catogary ORDER BY RANDOM() LIMIT :numQues",nativeQuery = true)
	List<Question> findRandomQuestionsByCatagory(int numQues, String catogary);

}
