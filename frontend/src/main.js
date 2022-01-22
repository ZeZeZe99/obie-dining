import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from "@/plugins/vuetify";

import Vuex from 'vuex'
Vue.use(Vuex)

Vue.config.productionTip = false


new Vue({
  el: '#app',
  router,
  vuetify,
  // define global variables
  data: function(){
    return{
      login: false,
      student: null
    }
  },
  render: h => h(App)


}).$mount('#app')
