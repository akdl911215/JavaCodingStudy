<template>
  <div>
    <h3>수정 형식</h3>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>번호</td>
          <td><input type="text" :value="board.boardNo" disabled></td>
        </tr>
        <tr>
          <td>등록일자</td>
          <td><input type="text" :value="board.regDate" disabled></td>
        </tr>
        <tr>
          <td>제목</td>
          <!-- v-model로 입력받은 값은 new Vue로 입력값이 자동으로
                뷰 데이터에 연결된다.-->
          <td><input type="text" v-model="title"></td>
        </tr>
        <tr>
        <td>작성자</td>
        <td><input type="text" :value="board.writer" disabled></td>
        </tr>
        <tr>
          <td>본문</td>
          <td><textarea v-model="content" rows="5"></textarea></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="text" :value="board.password" disabled></td>
        </tr>
      </table>

      <div>
        <button type="submit">수정</button>
        <router-link :to="{ name: 'BoardReadPage', params: { boardNo: board.boardNo.toString() } }">
          취소
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'BoardModifyForm',
  props: {
    board: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      title: '',
      content: '',
      password: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, content, password } = this
      this.$emit('submit', { title, content, password })
    }
  },
  created () {
    this.title = this.board.title
    this.content = this.board.content
    this.password = this.board.password
  }
}
</script>