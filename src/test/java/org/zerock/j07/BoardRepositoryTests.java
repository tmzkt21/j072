package org.zerock.j07;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.zerock.j07.board.entity.Board;
import org.zerock.j07.board.entity.Reply;
import org.zerock.j07.board.repository.BoardRepository;
import org.zerock.j07.board.repository.ReplyRepository;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class BoardRepositoryTests {
    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    BoardRepository boardRepository;

    // 게시판에 1000개에 글을 작성하라
    // insert create
    @Test
    public void testInsult() {
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            Board board = Board.builder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .writer("작성자" + i)
                    .build();
            boardRepository.save(board);
        });
    }

}