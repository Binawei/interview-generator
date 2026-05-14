package com.melo.questiongenerator.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtoTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jobRequest_ValidConstruction() {
        JobRequest request = new JobRequest("Customer Success Manager");
        
        assertEquals("Customer Success Manager", request.jobTitle());
    }

    @Test
    void jobRequest_JsonSerialization() throws Exception {
        JobRequest request = new JobRequest("Customer Success Manager");
        
        String json = objectMapper.writeValueAsString(request);
        JobRequest deserialized = objectMapper.readValue(json, JobRequest.class);
        
        assertEquals(request.jobTitle(), deserialized.jobTitle());
    }


    @Test
    void questionResponse_JsonSerialization() throws Exception {
        String questions = "Question 1\nQuestion 2";
        QuestionResponse response = new QuestionResponse(questions);
        
        String json = objectMapper.writeValueAsString(response);
        QuestionResponse deserialized = objectMapper.readValue(json, QuestionResponse.class);
        
        assertEquals(response.questions(), deserialized.questions());
    }
}