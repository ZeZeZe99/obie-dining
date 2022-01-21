import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from "@/plugins/vuetify";

// var axios = require('axios')
// //giaxios.defaults.baseURL = 'http://localhost:8080/api'
//
// Vue.prototype.$axios = axios
// Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  vuetify,
  render: h => h(App),
}).$mount('#app')
