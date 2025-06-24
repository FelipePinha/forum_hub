package com.felipepinha.forumhub.controllers;

import com.felipepinha.forumhub.dto.auth.UserCreationDTO;
import com.felipepinha.forumhub.dto.auth.UserDTO;
import com.felipepinha.forumhub.dto.auth.UserLoginDTO;
import com.felipepinha.forumhub.security.TokenJWTDTO;
import com.felipepinha.forumhub.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public TokenJWTDTO login(@RequestBody @Valid UserLoginDTO data) {
        var jwtToken = authService.login(data);

        return jwtToken;
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody @Valid UserCreationDTO data) {
        return authService.register(data);
    }
}
