<template>
  <div>
    Username: <input type = "text" v-model="loginForm.username" placeholder="Please input your username"/>
    <br><br>
    Password: <input type="password" v-model="loginForm.password" placeholder="Please input your password"/>
    <br><br>
    <v-btn
        type="primary"
        style="width: 40%;
        background: #505458;
        border: none"
        @click="login">
      Sign in
    </v-btn>
<!--    <button @click="login">login</button>-->
  </div>

</template>

<!--<template>-->
<!--  <body id="paper">-->
<!--  <v-form-->
<!--      :model="loginForm"-->
<!--      class="login-container"-->
<!--      labv-position="left"-->
<!--      labv-width="0px"-->
<!--      >-->
<!--    <h3 class="login_title">-->
<!--      System Sign in-->
<!--    </h3>-->
<!--    <v-text-field-->
<!--        v-model= "loginForm.username"-->
<!--        :rules="rules"-->
<!--        label="Username"-->
<!--        required-->
<!--    ></v-text-field>-->
<!--    <v-text-field-->
<!--        v-model= "loginForm.password"-->
<!--        :rules="rules"-->
<!--        label="Password"-->
<!--        type = "password"-->
<!--        required-->
<!--    ></v-text-field>-->
<!--&lt;!&ndash;    <v-checkbox&ndash;&gt;-->
<!--&lt;!&ndash;        class="login_remember"&ndash;&gt;-->
<!--&lt;!&ndash;        v-model="checkbox"&ndash;&gt;-->
<!--&lt;!&ndash;        label="Remember User"&ndash;&gt;-->
<!--&lt;!&ndash;        type="checkbox">&ndash;&gt;-->
<!--&lt;!&ndash;    </v-checkbox>&ndash;&gt;-->
<!--    <v-btn-->
<!--        type="primary"-->
<!--        style="width: 40%;-->
<!--        background: #505458;-->
<!--        border: none"-->
<!--        @click="login">-->
<!--      Sign in-->
<!--    </v-btn>-->
<!--    <router-link to="register">-->
<!--      <v-btn-->
<!--          type="primary"-->
<!--          style="width: 40%;-->
<!--          background: #505458;-->
<!--          border: none">-->
<!--        Register-->
<!--      </v-btn>-->
<!--    </router-link>-->
<!--  </v-form>-->
<!--  </body>-->
<!--</template>-->

<script>
import Vue from "vue"
import axios from "axios";
import {required} from 'vee-validate/dist/rules'
import {extend} from 'vee-validate'
import VueSimpleAlert from "vue-simple-alert"

Vue.use(VueSimpleAlert)

extend('required', {
  ...required,
  message: '{_field_} can not be empty',
})

export default {
  name: "Login",
  data () {
    return {
      rules: [
        value => !!value || 'Required.',
        value => (value && value.length >= 3) || 'Min 3 characters',
      ],
      // checkbox: true,
      loginForm: {
        username: '',
        password: ''
      }
      // loading: false
    }
  },
  methods: {
    async login() {
      await axios
          .post('/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(() => {
            this.$router.replace({path: '/home'})
          })
          .catch(() => {
            // window.alert("Your Username or password is wrong");
            this.$alert("Your Username or password is wrong")
          })
    }
  }
}
</script>


<!--<script>-->


<!--export default{-->

<!--  methods: {-->
<!--    login () {-->
<!--      var _this = this-->
<!--      this.$axios-->
<!--          .post('/login', {-->
<!--            username: this.loginForm.username,-->
<!--            password: this.loginForm.password-->
<!--          })-->
<!--          .then(resp => {-->
<!--            if (resp.data.code === 200) {-->
<!--              var data = resp.data.result-->
<!--              _this.$store.commit('login', data)-->
<!--              var path = _this.$route.query.redirect-->
<!--              _this.$router.replace({path: path === '/' || path === undefined ? '/admin/dashboard' : path})-->
<!--            } else {-->
<!--              this.$alert(resp.data.message, '提示', {-->
<!--                confirmbuttonText: '确定'-->
<!--              })-->
<!--            }-->
<!--          })-->
<!--          // .catch(failResponse => {})-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<style>
#paper {
  background:url("../assets/login.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body{
  margin: 0;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
