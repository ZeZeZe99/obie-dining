<!--<template>-->
<!--  <div>-->
<!--    Username: <input type = "text" v-model="loginForm.username" placeholder="Please input your username"/>-->
<!--    <br><br>-->
<!--    Password: <input type="password" v-model="loginForm.password" placeholder="Please input your password"/>-->
<!--    <br><br>-->
<!--    <button v-on:click="login">login</button>-->
<!--  </div>-->

<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "Login",-->
<!--  data () {-->
<!--    return {-->
<!--      loginForm: {-->
<!--        username: '',-->
<!--        password: ''-->
<!--      },-->
<!--      responseResult: []-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    login() {-->
<!--      this.$axios-->
<!--      .post('/login',{-->
<!--        username: this.loginForm.username,-->
<!--        password: this.loginForm.password-->
<!--      })-->
<!--      .then(successResponse => {-->
<!--        if(successResponse.data.code === 200) {-->
<!--          this.$route.replace({path: '/home'})-->
<!--        }-->
<!--      })-->
<!--      // .catch(failResponse => {-->
<!--      // })-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->

<template>
  <body id="paper">
  <v-form :model="loginForm" :rules="ruless" class="login-container" labv-position="left"
           labv-width="0px" v-loading="loading">
    <h3 class="login_title">System Sign in</h3>
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
        required
    ></v-text-field>
    <v-checkbox class="login_remember" v-model="checkbox" label="Remember User"
                type="checkbox"></v-checkbox>
      <v-btn type="primary" style="width: 40%;background: #505458;border: none" v-on:click="login">Sign in</v-btn>
      <router-link to="register"><v-btn type="primary" style="width: 40%;background: #505458;border: none">Register</v-btn></router-link>
  </v-form>
  </body>
</template>
<script>

 import {required} from 'vee-validate/dist/rules'
 import {extend} from 'vee-validate'

 extend('required', {
   ...required,
   message: '{_field_} can not be empty',
 })
export default{
  data () {
    return {
      rules: [
        value => !!value || 'Required.',
        value => (value && value.length >= 3) || 'Min 3 characters',
      ],
      ruless: {
        username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
      },
      checkbox: true,
      loginForm: {
        username: '',
        password: ''
      },
      loading: false
    }
  },
  methods: {
    login () {
      var _this = this
      this.$axios
          .post('/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(resp => {
            if (resp.data.code === 200) {
              var data = resp.data.result
              _this.$store.commit('login', data)
              var path = _this.$route.query.redirect
              _this.$router.replace({path: path === '/' || path === undefined ? '/admin/dashboard' : path})
            } else {
              this.$alert(resp.data.message, '提示', {
                confirmbuttonText: '确定'
              })
            }
          })
          // .catch(failResponse => {})
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
