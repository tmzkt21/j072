package org.zerock.j07.todo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data                       //Getter Setter에 자유로움 = 수정이 자유로움
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long tno;
    private String content;
    private boolean del;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
