<template>
  <div id="board">
    <h2>게시판 글쓰기 (Board List)</h2>
    <router-link :to="{ name: 'BoardRegisterPage' }">
      새로운 글 작성하기
    </router-link>
    <!-- components의 BoardList 의 값을 :boards="boards" 할당 -->
    <board-list :boards="boards"/>
  </div>
</template>

<script>
import BoardList from '@/components/board_components/BoardList'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardListPage',
  components: {
    BoardList
  },
  computed: {
    // state의 boards
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}

</script>