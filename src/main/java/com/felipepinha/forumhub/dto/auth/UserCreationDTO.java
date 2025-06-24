package com.felipepinha.forumhub.dto.auth;

import com.felipepinha.forumhub.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreationDTO(
        @NotBlank
        @NotNull
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @NotNull
        String password
) {
}
