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
import org.zerock.j07.board.repository.BoardRepository;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class BoardRepositoryTests {
    @Autowired
    BoardRepository boardRepository;

    // 게시판에 1000개에 글을 작성하라
    // insert create
    @Test
    public void insertTest() {
        IntStream.rangeClosed(1, 1000).forEach(i -> {
          Board board  = Board.builder()
                    .title("게시판제목" + i)
                    .content("게시판내용" + i)
                    .writer("작성자" + i)
                    .build();
            boardRepository.save(board);
        });
    }
    // read select
    // board 에서 bno 46번째 정보를 읽어라
    @Test
    public void selectTest() {
        Optional<Board> board = boardRepository.findById(46L);
//        log.info(board + "46번쨰");
        board.ifPresent(i-> {
            log.info(i + "46번쨰");
        });
    }
    // update
    // board 에서 23번쨰 정보를 바꿔라
    @Test
    public void updateTest() {
        Optional<Board> result = boardRepository.findById(23L);
        log.info(result);
        result.ifPresent(todo -> {
            boardRepository.updateContent("23번째 내용수정",23L);
            // 집에서 나머지 진행
        });
    }

//    @Test
//    public void testUpdate() {
//
//        Optional<Todo> result = todoRepository.findById(299L);
//
//        result.ifPresent(todo -> {
//            todo.changeTitle("299번 내용 수정");
//            todoRepository.save(todo);
//        });
//
//    }
    // 페이징
    @Test
    public void pageTest() {
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno"));
//    log.info(pageable);
        Page<Board> result = boardRepository.findAll(pageable);

        result.getContent().forEach(todo -> log.info(todo));
    }

















//    @Test
//    public void testPaging() {
//
//        Pageable pageable = PageRequest.of(0,10, Sort.by("tno").descending());
//
//        Page<Todo> result = todoRepository.findAll(pageable);
//
//        log.info(result);
//
//        result.getContent().forEach(todo -> log.info(todo));
//
//    }
}
