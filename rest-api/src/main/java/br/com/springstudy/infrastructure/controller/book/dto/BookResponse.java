package br.com.springstudy.infrastructure.controller.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record BookResponse(
        @NotNull
        long id,
        @NotBlank
        String author,
        @NotBlank
        Date launchDate,
        @NotBlank
        Double price,
        @NotBlank
        String title) {
}
