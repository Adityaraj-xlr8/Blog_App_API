package com.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min=4,message = "Username must be atleast 4 characters !!")
    private String name;

    @NotEmpty
    @Size(min = 4,max = 10,message = "Password must be between 4-10 characters")
    //@Pattern()
    private String password;

    @Email(message = "Email address is not valid !!")
    private String email;

    @NotNull
    private String about;

}
