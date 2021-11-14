package com.daelim.paguda.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter   // lombok으로 getter 자동으로 만들어 줌
@NoArgsConstructor  // 기본생성자 만들어 줌
@Entity  // 테이블과 연계됨을 스프링에게 알려줌
public class User extends Timestamped{  // 생성,수정 시간을 자동으로 만들어줌
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
