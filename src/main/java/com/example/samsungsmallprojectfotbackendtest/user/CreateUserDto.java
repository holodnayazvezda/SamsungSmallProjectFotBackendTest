package com.example.samsungsmallprojectfotbackendtest.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private int telephone;
}
