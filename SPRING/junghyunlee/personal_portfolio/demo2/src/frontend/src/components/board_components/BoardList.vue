<template>
  <div>
    <h3>게시판</h3>
    <table border="1">
      <tr>
        <th align="center" width="120">번호</th>
        <th align="center" width="320">제목</th>
        <th aling="center" width="120">작성자</th>
        <th align="center" width="180">등록일자</th>
      </tr>

      <!-- 데이터가 없을 경우 실행 -->
      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <!-- colspan 속성 - 열 합치기 -->
        <td colspan="4">
          List is empty(내용이 없을때만 출력쓰!)
        </td>
      </tr>

      <!-- 데이터가 있을경우 실행 -->
      <tr v-else v-for="board in boards" :key="board.boardNo">
        <!-- board에 들어 있는 boardNo(넘버값)을 출력한다 -->
        <td align="center">{{ board.boardNo }}</td>
        <td align="left">
          <router-link :to="{ name: 'BoardReadPage',
                  params: { boardNo: board.boardNo.toString() } }">
            {{ board.title }}
          </router-link>
        </td>
        <td align="right">{{ board.writer }}</td>
        <td align="center">{{ board.regData }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "BoardList",
  // props = properties 줄임말
  // 어떠한 값을 컴포넌트에게 전달해줘야 할 때, props를 사용한다.
  props: {
    boards: {
      // 보드는 배열 타입으로 받는다.
      type: Array
    }
  }
}
</script>

<style scoped>

</style>