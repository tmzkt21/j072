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
                    .title("제목~" + i)
                    .content("내용" + i)
                    .writer("작성자" + i)
                    .build();
            boardRepository.save(board);
        });
    }

    // read select
    // board 에서 bno 46번째 정보를 읽어라
    @Test
    public void testSelect() {
        Optional<Board> result = boardRepository.findById(46L);
        result.ifPresent(i -> {
            log.info(i);
        });
    }

    // update
    // board 에서 23번쨰 정보를 바꿔라
    @Test
    public void testChange() {
        Optional<Board> board = boardRepository.findById(23L);
        board.ifPresent(i -> {
            i.change("수정완료", "수정완료", "수정완료");
            boardRepository.save(i);
        });
    }

    // 페이징 0 10 게시판 pk를 기준으로 역순으로 페이징 해보아라
    @Test
    public void testPage() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        //log.info(boardRepository.findAll(pageable));
        Page<Board> page = boardRepository.findAll(pageable);
        log.info(page);
    }

    // delete 241번을 지워라
    @Test
    public void testDelete() {
        boardRepository.delete(Board.builder().bno(241L).build());
    }


    // 댓글 Reply replyText 랜덤 만들기 1~ 200 개의 랜덤댓글 생성
    @Test
    public void testRandom() {
        long random = (int) (Math.random() * 200) + 1;
        Reply reply = Reply.builder().board(boardRepository.findById(random).get()).replyText("댓글").build();
        replyRepository.save(reply);
    }


    //
   /* @Test
    public void testByBoard() {
        Board board = Board.builder().bno(12L).build();
        Pageable pageable = PageRequest.of(0, 10);
        replyRepository.getByBoard(board, pageable);
    } */
}