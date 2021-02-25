import Vue from 'vue'
import App from './App.vue'
import router from './router/board_router'
import store from './store/board_store'
import vuetify from './plugins/board_plugins/vuetify';

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
