package com.example.project02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Request {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private String phone;

    private String address;

    private String gender;

    private String status;

    private String type;
}
