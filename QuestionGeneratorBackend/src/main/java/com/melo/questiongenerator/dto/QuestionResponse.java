package com.melo.questiongenerator.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response object containing generated interview questions")
public record QuestionResponse(
        @Schema(description = "Generated interview questions formatted as a string with line breaks")
        String questions
) {}