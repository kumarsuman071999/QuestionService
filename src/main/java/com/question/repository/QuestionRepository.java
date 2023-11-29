package com.question.repository;

import com.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    // Custon finder method findBy entity properties in camel case
    List<Question> findByQuizId(Long quiz);
}
