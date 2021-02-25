package com.example.board.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

// sql과 뷰를 연결하기 위한 entity

@Getter
@Setter
@ToString
public class VueBoard {
    private long boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}
