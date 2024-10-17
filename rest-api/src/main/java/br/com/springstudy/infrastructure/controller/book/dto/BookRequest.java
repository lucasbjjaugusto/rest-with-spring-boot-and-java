package br.com.springstudy.infrastructure.controller.book.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record BookRequest(
        @NotBlank
        String author,
        @NotBlank
        Date launchDate,
        @NotBlank
        Double price,
        @NotBlank
        String title) {
}
