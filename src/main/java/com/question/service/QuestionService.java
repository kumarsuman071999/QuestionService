package com.question.service;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public void addQuestion(Question question){
        questionRepository.save(question);
    }

    public List<Question> allQuestion(){
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id){
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Not found:"));
    }

    public List<Question> getQuestionOfQuiz(Long quizId){
        return questionRepository.findByQuizId(quizId);

    }
}
