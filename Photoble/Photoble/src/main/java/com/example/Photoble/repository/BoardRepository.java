package com.example.Photoble.repository;

import com.example.Photoble.entity.Board;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "board")
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String searchKeyword);

    Board findByTitleAndUserAndDate(String title, String user, String Date);
    Board findById(Integer id);
}
