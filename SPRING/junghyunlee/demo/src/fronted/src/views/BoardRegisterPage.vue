<template>
  <div align="center">
    <h2>게시판 글쓰기</h2>
    <board-register-form @submit="onsubmit"/>
  </div>
</template>

<script>
import BoardRegisterForm from "@/components/BoardRegisterForm";
// Axios란 브라우저, Node.js를 위한 Promise API를 활용하는
// HTTP비동기 통신 라이브러리
import axios from 'axios'
export default {
  // Register 는 등록
  name: "BoardRegisterPage",
  components: {
    BoardRegisterForm
  },
  methods: {
    // payload 사용에 있어서 전송되는 데이터.
    onsubmit (payload) {
      console.log('BoardRegisterPage onSubmit()')
      const { title, content, writer } = payload
      axios.post('http://localhost:7777/boards',
          { title, content, writer})
          // then(res => 는 axios.post가 성공했을 경우
          // { title, content, writer} 전송한다.
          .then(res => {
            console.log(res)
            alert('등록이 잘 되었습니다.')
            this.$router.push({
              name: 'BoardReadPage',
              params: { boardNo: res.data.boardNo.toString() }
            })
          })
    }
  },
  beforeCreate: function () {
    console.log("BoardRegisterPage Before Create: ")
  },
  created: function () {
    console.log("BoardRegisterPage Created: ")
  },
  beforeMount: function () {
    console.log("BoardRegisterPage Before Mount: ")
  },
  mounted: function () {
    console.log("BoardRegisterPage Mounted: ")
  },
  beforeUpdate: function() {
    console.log("BoardRegisterPage Before Update: ")
  },
  updated: function () {
    console.log("BoardRegisterPage Updated: ")
  },
  beforeDestroy: function () {
    console.log("BoardRegisterPage Before Destroy: ")
  },
  destroyed: function () {
    console.log("BoardRegisterPage Destroyed: ")
  }
}
</script>

<style scoped>
</style>
