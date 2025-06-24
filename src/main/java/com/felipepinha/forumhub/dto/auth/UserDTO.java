package com.felipepinha.forumhub.dto.auth;

import com.felipepinha.forumhub.entities.User;

public record UserDTO(String name, String email) {
    public UserDTO(User user) {
        this(user.getName(), user.getEmail());
    }
}
