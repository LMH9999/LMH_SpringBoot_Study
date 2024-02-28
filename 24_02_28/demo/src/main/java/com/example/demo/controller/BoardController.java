package com.example.demo.controller;

import com.example.demo.service.BoardService;
import com.example.demo.vo.QnaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public HashMap list(){
        return boardService.list();
    }

    @PostMapping("/write")
    public int write(@RequestBody QnaVO qnaVO){
        int status = boardService.write(qnaVO);
        return status;
    }

    @PutMapping("/update")
    public int update(@RequestBody QnaVO qnaVO){
        int status = boardService.update(qnaVO);
        return status;
    }

    @DeleteMapping("/delete")
    public int delete(@RequestParam Integer id){
        int status = boardService.delete(id);
        return status;
    }
}
