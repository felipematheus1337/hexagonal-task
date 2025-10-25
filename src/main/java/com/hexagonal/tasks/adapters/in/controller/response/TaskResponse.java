package com.hexagonal.tasks.adapters.in.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TaskResponse(String description,  @JsonFormat(pattern = "yyyy-MM-dd") LocalDate savedAt) {
}
