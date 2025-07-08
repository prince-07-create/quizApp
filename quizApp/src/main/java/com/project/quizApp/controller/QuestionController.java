package com.project.quizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizApp.Model.Question;
import com.project.quizApp.Service.QuestionService; 


@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquestion")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{type}")
    public ResponseEntity<List<Question>> getQuestionByType(@PathVariable String type){
        return questionService.getQuestionBytype(type);
    }

    @PostMapping("/addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/deletequestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        Question question = questionService.getQuestionById(id);
        if(question != null){
            questionService.deleteProduct(id);
            return new ResponseEntity<>("Question Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Question Not Found",HttpStatus.NOT_FOUND);
        }
    }
}