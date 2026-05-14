package com.melo.questiongenerator.controller;

import com.melo.questiongenerator.dto.JobRequest;
import com.melo.questiongenerator.dto.QuestionResponse;
import com.melo.questiongenerator.service.GeminiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:5173", "https://binawei.github.io"})
@Tag(name = "Interview Questions", description = "AI-powered interview question generation API")
public class InterviewQuestionController {
    private final GeminiService geminiService;

    public InterviewQuestionController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @Operation(
            summary = "Generate interview questions for a job role",
            description = "Uses Google Gemini AI to generate tailored interview questions based on the provided job title. " +
                         "Returns 3 professional, relevant questions suitable for interviewing candidates for the specified role."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully generated interview questions",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = QuestionResponse.class),
                            examples = @ExampleObject(
                                    name = "Customer Success Manager",
                                    value = "{\"questions\": " +
                                            "\"1. Describe a situation where a key account was showing early signs of disengagement; what specific data points or behaviors did you identify, and what was your multi-step strategy to re-align their business goals with the product’s value?" +
                                            "\\n2. How do you distinguish between a customer being \"satisfied\" with your relationship versus actually achieving their desired business outcomes, and how do you pivot your approach if those two metrics begin to diverge?" +
                                            "\\n3. When managing a high-volume portfolio, how do you mathematically or strategically prioritize your time to ensure you are driving long-term expansion for healthy accounts while still addressing the immediate needs of those at risk?\"}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request - job title is required"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error - AI service unavailable"
            )
    })
    @PostMapping("/generate-questions")
    public QuestionResponse generateQuestions(
            @Parameter(
                    description = "Job title for which to generate interview questions",
                    required = true,
                    example = "Customer Success Manager"
            )
            @RequestBody JobRequest request) {
        return geminiService.generateQuestions(request);
    }
}
