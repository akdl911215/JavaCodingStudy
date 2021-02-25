// FETCH_BOARD_LIST, FETCH_BOARD 사용하기 위해서 from
// './mutation-types' 선언된 값을 불러온다.
import {
    FETCH_BOARD_LIST,
    FETCH_BOARD
} from './mutation-types'

// 자바내에 선언되어있는 axios값을 사용한다.
import axios from "axios";

export default  {
    // commit은 여러개의 값이 존재할 수 있기에 { } 를 사용해준다.
    fetchBoardList ({ commit }) {
        // axios는 브라우저, Node.js를 위한 Promise API를 활용하는
        // HTTP 비동기 통신 라이브러리. 백엔드와 플론트엔드 통신하기 위해사용.
        return axios.get('http://localhost:7799/boards')
            .then(res => {
                commit(FETCH_BOARD_LIST, res.data)
            })
    },
    fetchBoard ({ commit }, boardNo) {
        console.log('fetchBoard ' + commit + ', boardNo = ' + boardNo)
        return axios.get('http://localhost:7799/boards/{$bpoardNo}')
            .then(res => {
                console.log('fetchBoard - res: ' + res.data)
                commit(FETCH_BOARD, res.data)
            })
    }
}