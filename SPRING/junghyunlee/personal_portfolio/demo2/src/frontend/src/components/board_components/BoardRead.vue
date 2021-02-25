<template>
  <div>
    <h3>게시글 보기</h3>
    <table>
      <tr>
        <td>번호</td>
        <td><input type="text" :value="board.boardNo" readonly></td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td><input type="text" :value="board.regDate" readonly></td>
      </tr>
      <tr>
        <td>작성자</td>
        <td><input type="text" :value="board.writer" readonly></td>
      </tr>
      <tr>
        <td>본문</td>
        <td><input type="text" :value="board.content" row="5" readonly></td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "BoardRead",
  props: {
    board: {
      type: Object,
      // required 속성은 폼 데이터가 서버로 제출되기 전
      // 반드시 채워져 있어야 하는 입력 필드를 명시.
      required: true
    }
  }
}
</script>

<style scoped>

</style>