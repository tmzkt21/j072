package org.zerock.j07.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.j07.board.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
}
