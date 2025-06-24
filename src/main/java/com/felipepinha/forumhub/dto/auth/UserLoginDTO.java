package com.felipepinha.forumhub.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserLoginDTO(
        @NotBlank
        @Email
        String email,

        @NotBlank
        @NotNull
        String password
) {
}
