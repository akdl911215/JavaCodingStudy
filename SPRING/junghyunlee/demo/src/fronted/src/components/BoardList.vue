<template>
  <div>
    <h3>게시판 보기</h3>
    <table border="1">
      <tr>
        <th align="center" width="80">번호</th>
        <th align="center" width="320">제목</th>
        <th align="center" width="100">글쓴이</th>
        <th align="center" width="180">등록일자</th>
      </tr>

      <!-- boards에 값이 없으면 목록이 비었습니다. 출력 -->
      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <!-- colspan 셀 병함 -->
        <td colspan="4">
          목록이 비었습니다.
        </td>
      </tr>

      <!-- key 를 사용하면 키의 순서 변경에 따라 요소를 재정렬하고 더 이상
      존재하지 않는 키가 있는 요소는 항상 제거 / 파괴됩니다 -->
      <tr v-else v-for="board in boards" :key="board.boardNo">
        <td align="center">{{ board.boardNo }}</td>
        <td align="left">
          <!-- router-link , routes , router.push -->
          <router-link :to="{ name: 'BoardReadPage',
                    // HTML <param> 요소는 <object>요소의 매개변수를 정의함.
                        params: { boardNo: board.boardNo.toString() } }">
            {{ board.title }}
          </router-link>
        </td>
        <td align="right">{{ board.writer }}</td>
        <td align="center">{{ board.regDate }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "BoardList",
  // 링크의 대상 라우트를 나타냅니다. 클릭하면, to prop의
  // 내부적으로 router.push()에 전달 될 것이므로 값은 문자열이나
  // 값은 문자열이나 위치 디스크립터 객체가 될 수 있습니다.
  props: {
    boards: {
      type: Array
    }
  },
  beforeCreate: function () {
    console.log("BoardList Before Create: ")
  },
  created: function () {
    console.log("BoardList Created: ")
  },
  beforeMount: function () {
    console.log("BoardList Before Mount: ")
  },
  mounted: function () {
    console.log("BoardList Mounted: " + this.boards)
  },
  beforeUpdate: function() {
    console.log("BoardList Before Update: ")
  },
  updated: function () {
    console.log("BoardList Updated: ")
  },
  beforeDestroy: function () {
    console.log("BoardList Before Destroy: ")
  },
  destroyed: function () {
    console.log("BoardList Destroyed: ")
  }
}
</script>

<style scoped>
</style>