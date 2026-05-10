package com.melo.questiongenerator.controller;

import com.melo.questiongenerator.dto.JobRequest;
import com.melo.questiongenerator.dto.QuestionResponse;
import com.melo.questiongenerator.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "https://binawei.github.io"})
public class InterviewQuestionController {
    private final GeminiService geminiService;

    public InterviewQuestionController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/generate-questions")
    public QuestionResponse generateQuestions(@RequestBody JobRequest request) {
        return geminiService.generateQuestions(request.jobTitle());
    }
}
