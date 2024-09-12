package br.com.springstudy.infrastructure.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record PersonRequest(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String address,
        @NotBlank
        String gender) {
}