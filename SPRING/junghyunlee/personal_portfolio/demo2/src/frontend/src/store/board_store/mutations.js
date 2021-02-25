// 안정적인 처리를 위해서 존재한다.
import {
    FETCH_BOARD_LIST,
    FETCH_BOARD
} from './mutation-types'

// mutations 에 들어온것은 안정적으로 처리된다.
export default {
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    }
}