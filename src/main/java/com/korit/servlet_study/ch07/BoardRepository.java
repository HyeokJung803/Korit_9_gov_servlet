package com.korit.servlet_study.ch07;


import com.korit.servlet_study.ch03.User;
import com.korit.servlet_study.ch03.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoardRepository {
    private static BoardRepository instance;
    private List<Board> boards;
    private Long autoId = 0L;

    private BoardRepository() {
        boards = new ArrayList<>();
    }

    public static BoardRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new BoardRepository();
        }
        return instance;
    }

    public void insert(Board board) {
        board.setId(++autoId);
        boards.add(board);
    }

}
