package com.example.board.controller;

import com.example.board.entity.VueBoard;
import com.example.board.service.VueBoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Log
@RestController
@RequestMapping("/boards")
// 8080 서버에서 들어오는 모든 요청을 허용한다는 의미 // * 은 모든을 의미한다.
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueBoardController {
    //static final Logger log = LoggerFactory.getLogger(VueBoardController.class);

    // @Autowired 를 사용해서 VueBoardService의 정보를 service로 사용할 수 있게 된다.
    @Autowired
    private VueBoardService service;

    @GetMapping("/{boardNo}")
    public ResponseEntity<VueBoard> read(
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("read()");

        VueBoard board = service.read(boardNo);
        System.out.println("VueBoardController: " + board);

        return new ResponseEntity<VueBoard>(board, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<VueBoard>> list() throws Exception {
        log.info("list()");

        // service.list() 는 전체 배열을 던져준다.
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<VueBoard> register(
            @Validated @RequestBody VueBoard board,
            UriComponentsBuilder uriBuilder) throws Exception {
        log.info("POST register()");

        service.register(board);

        log.info("register board.getBoardNo() = " + board.getBoardNo());

        /*
        URI resourceURI = uriBuilder.path("boards/{boardNo}")
                .buildAndExpand(board.getBoardNo())
                .encode()
                .toUri();

        return ResponseEntity.created(resourceURI).build();
         */

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        // 삭제는 지우기만 하면 되기에 Void
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<VueBoard> modify(
            @PathVariable("boardNo") Long boardNo,
            @Validated @RequestBody VueBoard board) throws Exception {
        log.info("Put - modify()");
        System.out.println(board);

        board.setBoardNo(boardNo);
        service.modify(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}
