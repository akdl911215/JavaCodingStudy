<template>
  <form @submit.prevent="onSubmit">
    <h3>게시글 등록하기</h3>
    <table>
      <tr>
        <td>제목</td>
        <td><input type="text" v-model="title"></td>
      </tr>
      <tr>
        <td>작성자</td>
        <td><input type="text" v-model="writer"></td>
      </tr>
      <tr>
        <td>본문</td>
        <td><textarea v-model="content" rows="5"></textarea></td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td><input type="text" v-model="password"></td>
      </tr>
    </table>

    <div>
      <button type="submit">등록</button>
      <router-link :to="{ name: 'BoardListPage' }">
        취소
      </router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: "BoardRegisterForm",
  data () {
    return {
      title: '',
      writer: '',
      content: '',
      password: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, writer, content , password } = this
      // $emit: 이벤트 발생은 컴포넌트의 통신 방법 중 하위 컴포넌트에서
      // 상위 컴포넌트로 통신하는 방식.
      this.$emit('submit', { title, writer, content, password })
    }
  }
}
</script>

