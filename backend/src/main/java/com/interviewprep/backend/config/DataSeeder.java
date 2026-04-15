package com.interviewprep.backend.config;

import com.interviewprep.backend.model.Question;
import com.interviewprep.backend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    @Override
    public void run(String... args) {
        if (questionRepository.count() == 0) {
            questionRepository.saveAll(List.of(
                question("What is an Array?",
                    "An array is a collection of elements stored at contiguous memory locations.",
                    "DSA", "Easy", "Technical", "TCS"),
                question("Explain Binary Search",
                    "Binary search finds an element by repeatedly dividing the search interval in half.",
                    "DSA", "Medium", "Technical", "Infosys"),
                question("What is a Linked List?",
                    "A linked list is a linear data structure where elements are stored in nodes.",
                    "DSA", "Easy", "Technical", "Wipro"),
                question("Explain Stack and Queue",
                    "Stack follows LIFO, Queue follows FIFO principle.",
                    "DSA", "Easy", "Technical", "TCS"),
                question("What is a Binary Tree?",
                    "A binary tree is a tree where each node has at most two children.",
                    "DSA", "Medium", "Technical", "Google"),
                question("Explain Bubble Sort",
                    "Bubble sort repeatedly swaps adjacent elements if they are in wrong order.",
                    "DSA", "Easy", "Technical", "Infosys"),
                question("What is Dynamic Programming?",
                    "DP solves complex problems by breaking them into simpler subproblems.",
                    "DSA", "Hard", "Technical", "Amazon"),
                question("Explain HashMap",
                    "HashMap stores key-value pairs and provides O(1) average time complexity.",
                    "DSA", "Medium", "Technical", "Microsoft"),
                question("What is Recursion?",
                    "Recursion is when a function calls itself to solve smaller instances of a problem.",
                    "DSA", "Medium", "Technical", "Google"),
                question("Explain Graph BFS and DFS",
                    "BFS explores level by level, DFS explores as far as possible before backtracking.",
                    "DSA", "Hard", "Technical", "Amazon"),
                question("Tell me about yourself",
                    "Structure: Present, Past, Future. Keep it under 2 minutes.",
                    "HR", "Easy", "HR", "TCS"),
                question("What are your strengths?",
                    "Pick 2-3 strengths relevant to the job with examples.",
                    "HR", "Easy", "HR", "Infosys"),
                question("What are your weaknesses?",
                    "Pick a real weakness and explain how you are improving it.",
                    "HR", "Easy", "HR", "Wipro"),
                question("Why do you want to join our company?",
                    "Research the company and align their values with your goals.",
                    "HR", "Medium", "HR", "Google"),
                question("Where do you see yourself in 5 years?",
                    "Show ambition but stay realistic and aligned with the company.",
                    "HR", "Medium", "HR", "Microsoft"),
                question("Explain OOP concepts",
                    "OOP has 4 pillars: Encapsulation, Inheritance, Polymorphism, Abstraction.",
                    "Java", "Medium", "Technical", "TCS"),
                question("What is the difference between JDK, JRE and JVM?",
                    "JVM runs bytecode, JRE includes JVM + libraries, JDK includes JRE + dev tools.",
                    "Java", "Easy", "Technical", "Infosys"),
                question("What is Spring Boot?",
                    "Spring Boot is a framework that simplifies Spring application development.",
                    "Java", "Medium", "Technical", "Wipro"),
                question("Explain REST API",
                    "REST is an architectural style using HTTP methods: GET, POST, PUT, DELETE.",
                    "Java", "Medium", "Technical", "Amazon"),
                question("What is MongoDB?",
                    "MongoDB is a NoSQL database that stores data in JSON-like documents.",
                    "Database", "Easy", "Technical", "Microsoft")
            ));
            System.out.println("20 questions seeded successfully!");
        }
    }

    private Question question(String title, String description,
            String topic, String difficulty, String type, String company) {
        Question q = new Question();
        q.setTitle(title);
        q.setDescription(description);
        q.setTopic(topic);
        q.setDifficulty(difficulty);
        q.setType(type);
        q.setCompany(company);
        return q;
    }
}