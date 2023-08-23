package com.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.quiz.model.Quiz;


public interface QuizDao extends JpaRepository<Quiz, Integer> {

	Quiz findByTitle(String title);

}
