package org.zerock.j07.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.j07.board.entity.Board;
import org.zerock.j07.board.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    //   void getByBoard(Board board, Pageable page);
    //Page<Board> getByBoard(Board board, Pageable paging);
}
