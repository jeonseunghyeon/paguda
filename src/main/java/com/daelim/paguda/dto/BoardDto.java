package com.daelim.paguda.dto;

import com.daelim.paguda.domain.board.Board;
import com.daelim.paguda.domain.user.User;
import lombok.*;


@Getter
public class BoardDto {
    private Long id;
    private String title;
    private String contents;

    public Board toEntity(User user) {
        return Board.builder()
                .user(user)
                .title(title)
                .contents(contents)
                .build();
    }

    @Builder
    public BoardDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
