package com.felipepinha.forumhub.controllers;

import com.felipepinha.forumhub.dto.auth.UserCreationDTO;
import com.felipepinha.forumhub.dto.auth.UserLoginDTO;
import com.felipepinha.forumhub.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserLoginDTO data) {
        var jwtToken = authService.login(data);

        return ResponseEntity.ok().body(jwtToken);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserCreationDTO data, UriComponentsBuilder uriBuilder) {
        var user = authService.register(data);
        var uri = uriBuilder.path("/register").buildAndExpand(data.email()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
}
