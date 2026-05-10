package com.melo.questiongenerator.service;

import com.melo.questiongenerator.dto.QuestionResponse;
import org.springframework.stereotype.Service;

@Service
public interface GeminiService {
    QuestionResponse generateQuestions(String jobTitle);
}
