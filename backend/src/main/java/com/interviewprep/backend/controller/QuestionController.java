package com.interviewprep.backend.controller;

import com.interviewprep.backend.model.Question;
import com.interviewprep.backend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping
    public ResponseEntity<List<Question>> getQuestions(
            @RequestParam(required = false) String topic,
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String company) {

        if (topic != null && difficulty != null) {
            return ResponseEntity.ok(
                questionRepository.findByTopicAndDifficulty(topic, difficulty));
        } else if (topic != null) {
            return ResponseEntity.ok(
                questionRepository.findByTopic(topic));
        } else if (difficulty != null) {
            return ResponseEntity.ok(
                questionRepository.findByDifficulty(difficulty));
        } else if (type != null) {
            return ResponseEntity.ok(
                questionRepository.findByType(type));
        } else if (company != null) {
            return ResponseEntity.ok(
                questionRepository.findByCompany(company));
        }

        return ResponseEntity.ok(questionRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(
            @RequestBody Question question) {
        return ResponseEntity.ok(questionRepository.save(question));
    }
}