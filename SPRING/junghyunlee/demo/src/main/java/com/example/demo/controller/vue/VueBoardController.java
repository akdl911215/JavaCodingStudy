package com.example.demo.controller.vue;

import com.example.demo.entity.vue.VueBoard;
import com.example.demo.service.vue.VueBoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Log
@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueBoardController {

    @Autowired
    private VueBoardService service;

    @RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
    public ResponseEntity<VueBoard> read(
            @PathVariable("boardNo") Long boardNo) throws Exception {

        log.info("VueBoard read()");

        VueBoard board = service.read(boardNo);

        return new ResponseEntity<VueBoard>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<VueBoard>> list() throws Exception {
        log.info("VueBoard list()");

        return new ResponseEntity<>(
            //위와 동일하게 작동
                //return new ResponseEntity<List<VueBoard>>(
                service.list(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<VueBoard> register(
            @Validated @RequestBody VueBoard board,
            UriComponentsBuilder uriBuilder) throws Exception {

        log.info("VueBoard register");

        service.register(board);

        log.info("Register board.getBoardNo() = " + board.getBoardNo());

        /*
        URI resourceURI = uriBuilder.path("boards/{boardNo}")
                .buildAndExpand(board.getBoardNo())
                .encode()
                .toUri();
        return ResponseEntity.created(resourceURI).build();
         */

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "/{boardNo}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> remove(
            @PathVariable("boardNo") Long boardNo) throws Exception {

        log.info("remove");

        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT)
    public ResponseEntity<VueBoard> modify(
            @PathVariable("boardNo") Long boardNo,
            @Validated @RequestBody VueBoard board) throws Exception {

        log.info("modify");

        board.setBoardNo(boardNo);
        service.modify(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}

/* GET은 가져오는 것이고 POST는 수행하는 것이다. GET은 Select적인 성향을 가지고 있습니다.
* GET은 서버에서 어떤 데이터를 가져와서 보여준다거나 하는 용도, 서버의 값이나 상태들을 바꾸지 않는다.
* 게시판의 리스트라던지 글보기 기능 같은 것이 이에 해당됨 (방문자의 로그를 남긴다거나 글 읽은 횟수를
* 오ᇐ려준다거나 하는건 예외입니다.)
*
* POST는 서버의 값이나 상태를 바꾸기 위해서 사용된다. 글쓰기를 하면 글의 내용이 디비에 저장이 되고
* 수정을 하면 디비값이 수정이 된다. 이럴경우 POST를 사용한다.
*
* GET과 POST 차이점
* GET은 주소줄에 값이 ?뒤에 쌍으로 이어붙고 POST 는 숨겨져서(BODY 안에)보내진다. GET은
* URL에 이어붙기 때문에 길이의 제한이 있어 많은 양의 데이터는 보내기 어렵고 POST는 많은 양의
* 보내기에도 적합하다.(용량제한은 여전하다) */