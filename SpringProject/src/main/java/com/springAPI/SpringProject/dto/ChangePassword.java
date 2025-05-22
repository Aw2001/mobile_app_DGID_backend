package com.springAPI.SpringProject.dto;

import lombok.Getter;
import lombok.Setter;

public class ChangePassword {
    String password;
    String repeatPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }


}
