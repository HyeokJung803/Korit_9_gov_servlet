package com.korit.servlet_study.ch07;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    public Board toBoard;
    private String title;
    private String content;
    private String writer;

    public Board toBoard() {
        return Board.builder()
                .title(title)

                .build();
    }
}
