package com.springAPI.SpringProject.service;


import com.springAPI.SpringProject.dto.ChangePassword;
import com.springAPI.SpringProject.dto.LoginUserDto;
import com.springAPI.SpringProject.dto.RegisterUserDto;
import com.springAPI.SpringProject.dto.VerifyUserDto;
import com.springAPI.SpringProject.model.utilisateur.Utilisateur;
import com.springAPI.SpringProject.repository.UtilisateurRepository;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthenticationService {
    private final UtilisateurRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthenticationService(
            UtilisateurRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            EmailService emailService
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public Utilisateur signup(RegisterUserDto input) {
        Utilisateur user = new Utilisateur(input.getEmail(), input.getPrenom(), input.getNom(), input.getUsername(), passwordEncoder.encode(input.getPassword()), input.getRole());
        user.setVerificationCode(generateVerificationCode());
        user.setVerificationCodeExpiresAt(LocalDateTime.now().plusMinutes(15));
        user.setEnabled(false);
        System.out.println("Verification code generated: " + user.getVerificationCode()); // Log pour débogage
        sendVerificationEmail(user);
        return userRepository.save(user);
    }

    public Utilisateur authenticate(LoginUserDto input) {
        try {

            Utilisateur user = userRepository.findByUsername(input.getUsername());
            if (user == null) {
                throw new UsernameNotFoundException("User not found");

            }
            // Vérifiez le mot de passe
            if (!passwordEncoder.matches(input.getPassword(), user.getPassword())) {
                throw new BadCredentialsException("Mot de passe incorrect");
            }

            if (!user.isEnabled()) {
                throw new RuntimeException("Account not verified. Please verify your account.");
            }
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getUsername(),
                            input.getPassword()
                    )
            );

            return user;

        }catch (Exception e) {
            System.err.println("Error during authentication: " + e.getMessage());
            throw e;
        }

    }

    public void logout(String email) {
        Utilisateur user = userRepository.findByEmail(email);
        if (user != null) {
            user.setLastLogoutTime(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()); // Enregistre la date de déconnexion
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec cet email: " + email);
        }
    }


    public void verifyUser(VerifyUserDto input) {
        Optional<Utilisateur> optionalUser = userRepository.findByIdentifiant(input.getEmail());
        if (optionalUser.isPresent()) {
            Utilisateur user = optionalUser.get();
            if (user.getVerificationCodeExpiresAt().isBefore(LocalDateTime.now())) {
                throw new RuntimeException("Verification code has expired");
            }
            if (user.getVerificationCode().equals(input.getVerificationCode())) {
                user.setEnabled(true);
                user.setVerificationCode(null);
                user.setVerificationCodeExpiresAt(null);
                userRepository.save(user);
            } else {
                throw new RuntimeException("Invalid verification code");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void resendVerificationCode(String email) {
        Optional<Utilisateur> optionalUser = userRepository.findByIdentifiant(email);
        if (optionalUser.isPresent()) {
            Utilisateur user = optionalUser.get();
            if (user.isEnabled()) {
                throw new RuntimeException("Account is already verified");
            }
            user.setVerificationCode(generateVerificationCode());
            user.setVerificationCodeExpiresAt(LocalDateTime.now().plusHours(1));
            sendVerificationEmail(user);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    private void sendVerificationEmail(Utilisateur user) { //TODO: Update with company logo
        String subject = "Account Verification";
        String verificationCode = "VERIFICATION CODE " + user.getVerificationCode();
        String htmlMessage = "<html>"
                + "<body style=\"font-family: Arial, sans-serif;\">"
                + "<div style=\"background-color: #f5f5f5; padding: 20px;\">"
                + "<h2 style=\"color: #333;\">Welcome to our app!</h2>"
                + "<p style=\"font-size: 16px;\">Please enter the verification code below to continue:</p>"
                + "<div style=\"background-color: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1);\">"
                + "<h3 style=\"color: #333;\">Verification Code:</h3>"
                + "<p style=\"font-size: 18px; font-weight: bold; color: #007bff;\">" + verificationCode + "</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";

        try {
            emailService.sendVerificationEmail(user.getIdentifiant(), subject, htmlMessage);
        } catch (MessagingException e) {
            // Handle email sending exception
            e.printStackTrace();
        }
    }
    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }

    public void initiatePasswordReset(String email) {
        Utilisateur user = userRepository.findByEmail(email);
        if (user != null) {
            user.setVerificationCode(generateVerificationCode());
            user.setVerificationCodeExpiresAt(LocalDateTime.now().plusMinutes(15));
            user.setEnabled(false);
            System.out.println("Verification code generated: " + user.getVerificationCode()); // Log pour débogage
            sendVerificationEmail(user);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec cet email : " + email);
        }
    }

    public ResponseEntity<String> resetPassword(String email, ChangePassword changePassword) {
        Utilisateur user = userRepository.findByEmail(email);
        if (user != null) {
            if(!Objects.equals( changePassword.getRepeatPassword(), changePassword.getPassword())) {
                return new ResponseEntity<String>("Svp, entrer de nouveau le mot de passe", HttpStatus.EXPECTATION_FAILED);
            }
            user.setPassword(passwordEncoder.encode(changePassword.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<String>("Mot de passe modifié", HttpStatus.OK);

        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec cet email."+ email);
        }
    }
}
