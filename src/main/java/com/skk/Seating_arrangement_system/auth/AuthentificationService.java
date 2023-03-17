package com.skk.Seating_arrangement_system.auth;

import com.skk.Seating_arrangement_system.auth.dto.AuthResponse;
import com.skk.Seating_arrangement_system.auth.dto.LoginRequest;
import com.skk.Seating_arrangement_system.auth.dto.RegisterRequest;
import com.skk.Seating_arrangement_system.config.JwtService;

import com.skk.Seating_arrangement_system.student.User;
import com.skk.Seating_arrangement_system.student.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthentificationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
private PasswordEncoder passwordEncoder;
    @Autowired
private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthResponse Register(RegisterRequest registerRequest){
        System.out.println(registerRequest);
        var user = User.builder().username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
               .build();
        var userrespons = userRepository.save(user);
        var token= jwtService.generateToken(userrespons);


        return AuthResponse.builder().username(userrespons.getUsername())
                .Token(token).build();


    }

    public AuthResponse Login(LoginRequest loginRequest){
        System.out.println("hh  "+loginRequest);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(

                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        var userespons= userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();

        var token= jwtService.generateToken(userespons);


        return AuthResponse.builder().username(userespons.getUsername())
                .Token(token).build();


    }

    /*User findOneuser(Long i){
        return  userRepository.getById(i);
    }
*/


}
