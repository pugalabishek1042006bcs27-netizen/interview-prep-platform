package com.interviewprep.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questions")
public class Question {

    @Id
    private String id;

    private String title;
    private String description;
    private String topic;
    private String difficulty;
    private String type;
    private String company;
    private String answer;
}