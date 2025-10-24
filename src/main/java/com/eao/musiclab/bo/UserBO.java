package com.eao.musiclab.bo;

import com.eao.musiclab.model.User;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserBO implements Serializable {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private Long mobileNo;

    public static User from(UserBO bo) {
        return User.builder()
                .firstname(bo.firstname)
                .lastname(bo.lastname)
                .email(bo.email)
                .username(bo.username)
                .password(bo.password)
                .mobileNo(bo.mobileNo).build();
    }

    public static UserBO from(User user) {
        return UserBO.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .email(user.getEmail())
                .mobileNo(user.getMobileNo())
                .build();
    }
}
