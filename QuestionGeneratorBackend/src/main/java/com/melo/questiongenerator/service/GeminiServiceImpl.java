package com.melo.questiongenerator.service;

import com.melo.questiongenerator.dto.JobRequest;
import com.melo.questiongenerator.dto.QuestionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;
@Service
public class GeminiServiceImpl implements GeminiService {
    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestClient restClient = RestClient.create();

    @Override
    public QuestionResponse generateQuestions(JobRequest request) {
        String prompt = """
                Generate exactly 3 thoughtful interview questions for a %s role.
                Return only a numbered list.
                """.formatted(request.jobTitle());

        Map<String, Object> body = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        var response = restClient.post()
                .uri("https://generativelanguage.googleapis.com/v1beta/models/gemini-flash-latest:generateContent?key=" + apiKey)
                .body(body)
                .retrieve()
                .body(Map.class);

        String questions = extractText(response);

        return new QuestionResponse(questions);
    }

    private String extractText(Map response) {
        List candidates = (List) response.get("candidates");
        Map candidate = (Map) candidates.get(0);
        Map content = (Map) candidate.get("content");
        List parts = (List) content.get("parts");
        Map part = (Map) parts.get(0);

        return part.get("text").toString();
    }
}
