package com.skk.Seating_arrangement_system.auth;


import com.skk.Seating_arrangement_system.auth.dto.RegisterRequest;
import com.skk.Seating_arrangement_system.auth.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthentificationController {
    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping("/register")
    AuthResponse register(@RequestBody RegisterRequest registerRequest){
        return authentificationService.Register(registerRequest) ;
    }

    @PostMapping("/login")
    AuthResponse login(@RequestBody LoginRequest loginRequest){
        return authentificationService.Login(loginRequest);
    }
}
