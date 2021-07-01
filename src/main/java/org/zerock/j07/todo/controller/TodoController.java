package org.zerock.j07.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.j07.todo.dto.TodoDTO;
import org.zerock.j07.todo.service.TodoService;

@RestController
@RequestMapping("/todos")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/{tno}")
    public ResponseEntity<TodoDTO> read(@PathVariable Long tno) {

        TodoDTO dto = todoService.read(tno);

        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/")
    public ResponseEntity<Long> register(@RequestBody TodoDTO todoDTO) {

        log.info("register" + todoDTO);

        Long tno = todoService.register(todoDTO);

        log.info("RESULT:" + tno);

//        return ResponseEntity.ok().body(100L);
        return ResponseEntity.ok().body(tno);
    }


}
