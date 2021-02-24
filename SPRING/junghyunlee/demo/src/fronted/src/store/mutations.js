// mutation: 돌연변이(과정), (형태 구조상의)변화
import {
    FETCH_BOARD_LIST,
    FETCH_BOARD
} from './mutation-types'


export default {
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards
        this.$cookies.set('boards', boards)
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
        this.$cookies.set('board', board)
    }
}