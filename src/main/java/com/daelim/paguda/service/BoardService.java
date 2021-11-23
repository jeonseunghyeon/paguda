package com.daelim.paguda.service;

import com.daelim.paguda.domain.board.Board;
import com.daelim.paguda.domain.board.BoardRepository;
import com.daelim.paguda.domain.user.User;
import com.daelim.paguda.domain.user.UserRepository;
import com.daelim.paguda.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long savePost(Long id, BoardDto boardDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다. " + id)
        );
        return boardRepository.save(boardDto.toEntity(user)).getId();
    }

    @Transactional
    public List<BoardDto> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boardList) {
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .contents(board.getContents())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }
}
