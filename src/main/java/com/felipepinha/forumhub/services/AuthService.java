package com.felipepinha.forumhub.services;

import com.felipepinha.forumhub.dto.auth.UserCreationDTO;
import com.felipepinha.forumhub.dto.auth.UserDTO;
import com.felipepinha.forumhub.entities.User;
import com.felipepinha.forumhub.repositories.AuthRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO register(UserCreationDTO data) throws ValidationException {
        var userAlreadyExist = authRepository.findByEmail(data.email()).orElse(null);

        if(userAlreadyExist != null) {
            throw new ValidationException("User already exist");
        }

        var newUser = authRepository.save(new User(
                data.name(),
                data.email(),
                passwordEncoder.encode(data.password())
        ));

        return new UserDTO(newUser);
    }
}
