<template>
  <body id="paper">
  <div
      class="login-container"
      labv-position="left"
      labv-width="0px"
      >
    <h3 class="login_title">
      System Sign in
    </h3>
    <v-text-field
        v-model= "loginForm.username"
        :rules="rules"
        label="Username"
        required
    ></v-text-field>
    <v-text-field
        v-model= "loginForm.password"
        :rules="rules"
        label="Password"
        type = "password"
        required
    ></v-text-field>
    <v-checkbox
        class="login_remember"
        v-model="checkbox"
        label="Remember User"
        type="checkbox">
    </v-checkbox>
    <v-btn
        type="primary"
        style="width: 40%;
        background: #a6abaf;
        border: none"
        @click="login">
      Sign in
    </v-btn>
      <v-btn
          type="primary"
          style="width: 40%;
          background: #a6abaf;
          border: none"
          @click= "navigate('register')">
        Register
      </v-btn>
  </div>
  </body>
</template>

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
  data () {
    return {
      rules: [
        value => !!value || 'Required.',
        value => (value && value.length >= 3) || 'Min 3 characters',
      ],
      checkbox: true,
      loginForm: {
        username: '',
        password: ''
      },
    }
  },
  methods: {
    async login() {
      await axios
          .post('/login', {
            userName: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(response => {
            this.$root.login = true
            this.$root.student = response.data
            this.$router.replace({path: '/home'})
          })
          .catch(() => {
            //window.alert("Your Username or password is wrong");
            this.$alert("Your Username or password is wrong")
            //this.$alert(error.response.headers.errormessage)
          })
    },
    navigate(page){
      this.$router.push(page)
    }
  }
}
</script>

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
