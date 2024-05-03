package com.pfe.rechercheens.Auth.Service;

import com.pfe.rechercheens.Auth.DTO.RegisterRequest;
import com.pfe.rechercheens.Config.PasswordEncoder;
import com.pfe.rechercheens.Config.JwtService;
import com.pfe.rechercheens.Entity.User;
import com.pfe.rechercheens.Exeption.UserException;
import com.pfe.rechercheens.Repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Context;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private static final String CONFIRMATION_URL = "http://localhost:8080/succes/%s";
    private final PasswordEncoder passwordEncoder;
    private final EmailRegistrationService emailservice;
    private final JwtService jwtService;
    private final RedisService redisService;

    @Transactional
    public String  register(RegisterRequest request) {
        boolean userExists = userRepository.findByEmail(request.getEmail()).isPresent();
        if (userExists) {
            throw new UserException("A user already exists with the same email");
        }

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhoneNumber())
                .password(passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()))
                .role(request.getRole())
                .enabled(false)
                .build();
        userRepository.save(user);

        var jwtToken = jwtService.genToken((UserDetails) user,new HashMap<>());

        redisService.storeToken(jwtToken, user.getEmail());
        try {
            emailservice.send(
                    user.getEmail(),
                    user.getFirstName(),
                    "confirm-email",
                    String.format(CONFIRMATION_URL, jwtToken)
            );
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return jwtToken ;

    }

    public String confirm(String token) {

        String userEmail = jwtService.extractUsername(token);
        User user = (User) userRepository.findByEmail(userEmail)
                .orElseThrow(()->new UserException("User not found"+ userEmail));
        if (!user.isEnabled()) {
            user.setEnabled(true);
            userRepository.save(user);
            //redisService.removeToken(user.getEmail());
            return "succes";
        }
        else if (!user.isEnabled() && jwtService.isTokenExpired(token)){

            // Handle token expiration
            return handleExpiredToken(userEmail,token);
        }
        else {
            // Token is valid but user is already confirmed
            return "already";
        }
    }

    private String renderTemplate(String templateName) {

        // Add any necessary model attributes to the context
        return templateName;
    }


    private String handleExpiredToken(String userEmail, String token) {
        String RefreshedToken = jwtService.refreshExpiredToken(token);
        redisService.removeToken(userEmail);

        redisService.storeToken(RefreshedToken, userEmail);
        var user = userRepository.getUserByEmail(userEmail);

        try {
            emailservice.send(
                    userEmail,
                    String.valueOf(user.getClass()),
                    null,
                    String.format(CONFIRMATION_URL, RefreshedToken)
            );
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return  "Token expired, a new token has been sent to your email";
    }
}
