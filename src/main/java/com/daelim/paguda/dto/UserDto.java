package com.daelim.paguda.dto;

import com.daelim.paguda.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDto {
    private String name;
    private String email;
    private String password;

    @Builder
    public UserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

    public void encodePassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
