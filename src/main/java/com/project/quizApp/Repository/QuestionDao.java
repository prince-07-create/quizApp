package com.project.quizApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.quizApp.Model.Question;

@Repository
public interface  QuestionDao extends JpaRepository<Question, Integer> {

    
    List<Question> findByTypeIgnoreCase(String type);

    @Query(value = "SELECT * FROM  quiz_questions q WHERE q.type=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
        


    
}