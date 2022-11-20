package com.example.Photoble.Service;

import com.example.Photoble.Entity.Board;
import com.example.Photoble.Repository.BoardRepository;
import com.example.Photoble.SubClass.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    private DateTime datetime = new DateTime();

    public List<Board> boardlist() {
        List<Board> list = boardRepository.findAll();
        Collections.shuffle(list);

        return  list;
    }

    public void boardWrite(Board board) throws Exception{

        board.setUser("user1");
        board.setDate(datetime.timeNow());
        boardRepository.save(board);
    }

    public Board boardView(Integer id) {

        return boardRepository.findById(id);
    }
}