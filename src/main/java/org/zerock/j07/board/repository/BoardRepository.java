package org.zerock.j07.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.j07.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board,Long> {

//    @Modifying
  //  @Query("update Board set title =:title where bno = :bno")
    //void updateContent(String title, Long bno);
}
