package com.idip.idiptecnologia.controllers;

import com.idip.idiptecnologia.exceptions.PasswordInvalidException;
import com.idip.idiptecnologia.models.entities.UserModel;
import com.idip.idiptecnologia.models.payload.request.CredentialRequest;
import com.idip.idiptecnologia.models.payload.response.TokenResponse;
import com.idip.idiptecnologia.security.JWT.JwtService;
import com.idip.idiptecnologia.security.Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("v1/login")
public class LoginController{

    @Autowired
    private UserDetailsServiceImpl userService;
    private JwtService jwtService;

    @PostMapping
    public TokenResponse authenticate(@RequestBody CredentialRequest credential) {
        try {
            UserModel user = (UserModel) User.builder()
                                             .username(credential.getLogin())
                                             .password(credential.getPassword())
                                             .build();
            UserDetails userAuthenticate = userService.authenticate(user);
            String token = jwtService.generateJwtToken(user);

            return new TokenResponse(user.getUserEmail(), token);
        } catch ( UsernameNotFoundException | PasswordInvalidException e ) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}