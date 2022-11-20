package com.example.Photoble.Service;

import com.example.Photoble.Entity.Board;
import com.example.Photoble.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> boardlist() {
        List<Board> list = boardRepository.findAll();
        Collections.shuffle(list);


        return  list;
    }
}