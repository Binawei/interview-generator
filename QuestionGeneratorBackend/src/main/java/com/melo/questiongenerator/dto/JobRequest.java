package com.melo.questiongenerator.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request object for generating interview questions")
public record JobRequest(
        @Schema(description = "The job title for which to generate interview questions", 
                example = "Customer Success Manager",
                required = true)
        String jobTitle
) {}
