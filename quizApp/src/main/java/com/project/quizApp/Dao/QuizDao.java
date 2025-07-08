package com.project.quizApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quizApp.Model.Quiz;


public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
