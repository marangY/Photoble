package com.example.Photoble.Controller;

import com.example.Photoble.Entity.Board;
import com.example.Photoble.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("board/main")
    public String boardMain(Model model){

        List<Board> list = null;

        list = boardService.boardlist();

        model.addAttribute("list", list);

        return  "Board/BoardMain";
    }

    @GetMapping("/board/upload")
    public String boardWriteForm(Board board, Model model) {

        return "Board/BoardUpload";
    }

    @PostMapping("/board/uploading")
    public String boardUploding(){

        return  "Board/BoardUploading";
    }
}
