package com.springAPI.SpringProject.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String email;
    private String prenom;
    private String nom;
    private String username;
    private String password;
    private String role;

}
