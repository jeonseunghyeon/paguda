package com.daelim.paguda.domain.board;

import com.daelim.paguda.domain.user.Timestamped;
import com.daelim.paguda.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 연관관계 매핑
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Board(User user, String title, String contents) {
        this.setUser(user);
        this.title = title;
        this.contents = contents;
    }

    //==연관관계 편의 메서드==//
    public void setUser(User user) {
        this.user = user;
        user.getBoards().add(this);
    }
}
