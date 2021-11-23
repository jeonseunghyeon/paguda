package com.daelim.paguda.controller;

import com.daelim.paguda.dto.BoardDto;
import com.daelim.paguda.service.BoardService;
import com.daelim.paguda.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("/{id}/board/list")
    public String list(@PathVariable Long id, Model model) {
        List<BoardDto> boardDtoList = boardService.getBoardList();
        model.addAttribute("userResponseDto", userService.findById(id));
        return "boardlist";
    }

    @GetMapping("/{id}/board/post")
    public String post(@PathVariable Long id,
                       @ModelAttribute("boardDto") BoardDto boardDto) {
        return "post";
    }

    @PostMapping("/{id}/board/post")
    public String write(@PathVariable Long id,
                        @ModelAttribute BoardDto boardDto,
                        RedirectAttributes redirectAttributes) throws IOException {
        boardService.savePost(id, boardDto);
        return "redirect:/board/list";
    }
}
