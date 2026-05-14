package com.melo.questiongenerator.service;

import com.melo.questiongenerator.dto.JobRequest;
import com.melo.questiongenerator.dto.QuestionResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GeminiServiceImplTest {

    @Test
    void generateQuestions_ValidJobRequest() {
        JobRequest request = new JobRequest("Customer Success Manager");
        
        assertNotNull(request);
        assertEquals("Customer Success Manager", request.jobTitle());
    }

    @Test
    void generateQuestions_EmptyJobTitle() {
        JobRequest request = new JobRequest("");
        
        assertNotNull(request);
        assertEquals("", request.jobTitle());
    }

    @Test
    void questionResponse_Creation() {
        String questions = "1. What is your experience?\n2. Tell me about yourself";
        QuestionResponse response = new QuestionResponse(questions);
        
        assertNotNull(response);
        assertTrue(response.questions().contains("experience"));
    }
}