package org.zerock.j07.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.j07.todo.dto.TodoDTO;
import org.zerock.j07.todo.entity.Todo;
import org.zerock.j07.todo.repository.TodoRepository;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor            // ...1
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;            // ...2 1+2로 알아서 todoRepository를 주입해줌

    @Override
    public Long register(TodoDTO dto) {

        Todo entity = dtoToEntity(dto);

        todoRepository.save(entity);

        log.info(dto);

        return entity.getTno();
    }

    @Override
    public TodoDTO read(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);

        result.ifPresent(read -> {
            log.info(read);
        });
        if(result.isPresent()) {
            Todo todo = result.get();
            return entityToDTO(todo);
        }
        return null;
    }
}
