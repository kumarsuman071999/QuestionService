package com.question.controller;

import com.question.entity.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class Questioncontroller {

    @Autowired
    QuestionService questionService;

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody Question question){
        questionService.addQuestion(question);
        return new ResponseEntity<>("Added sussessfully", HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<List<Question>> getAll(){
        return new ResponseEntity<>(questionService.allQuestion(),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getOne(@PathVariable Long id){
        return  new ResponseEntity<>(questionService.getQuestion(id),HttpStatus.FOUND);
    }

    // get all question of specifi quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionOfQuiz(quizId);
    }

}

