<template>
  <validation-observer
      ref="observer"
      v-slot="{ invalid }"
  >
    <body id="paper">
    <div
        @submit.prevent="submit"
        :model="loginForm"
        class="login-container"
        label-position="left"
        label-width="0px"
    >
      <h3 class="login_title">User Register</h3>
      <validation-provider
          v-slot="{ errors }"
          name="UserName"
          rules="required|max:10"
      >
        <v-text-field
            v-model="loginForm.username"
            :counter="10"
            :error-messages="errors"
            label="User Name"
            required
        ></v-text-field>
      </validation-provider>
<!--      <validation-provider-->
<!--          v-slot="{ errors }"-->
<!--          name="PhoneNumber"-->
<!--          :rules="{-->
<!--          required: true,-->
<!--          digits: 10-->
<!--          //regex: '^(71|72|74|76|81|82|84|85|86|87|88|89)\\d{5}$'-->
<!--        }"-->
<!--      >-->
<!--        <v-text-field-->
<!--            v-model="loginForm.phoneNumber"-->
<!--            :counter="10"-->
<!--            :error-messages="errors"-->
<!--            label="Phone Number"-->
<!--            required-->
<!--        ></v-text-field>-->
<!--      </validation-provider>-->
      <validation-provider
          v-slot="{ errors }"
          name="email"
          rules="required|email"
      >
        <v-text-field
            v-model="loginForm.email"
            :error-messages="errors"
            label="E-mail"
            required
        ></v-text-field>
      </validation-provider>
      <validation-provider
          v-slot="{ errors }"
          name="T_number"
          rules="required|max:9|min:9"
      >
        <v-text-field
            v-model="loginForm.tnumber"
            :counter="9"
            :error-messages="errors"
            label="T number"
            required
        ></v-text-field>
      </validation-provider>
      <validation-provider
          v-slot="{ errors }"
          name="password"
          rules="required|max:20|min:6"
      >
        <v-text-field
            v-model="loginForm.password"
            type = "password"
            :counter="20"
            :error-messages="errors"
            label="Password"
            required
        ></v-text-field>
      </validation-provider>

      <v-btn
          class="mr-4"
          type="submit"
          :disabled="invalid"
          @click = "register"
      >
        submit
      </v-btn>
      <v-btn @click="clear">
        clear
      </v-btn>
    </div>
    </body>
  </validation-observer>
</template>

<script>
import { required, digits, email, max, regex, min} from 'vee-validate/dist/rules'
import { extend, ValidationObserver, ValidationProvider, setInteractionMode } from 'vee-validate'
import axios from "axios";

setInteractionMode('eager')

extend('digits', {
  ...digits,
  message: '{_field_} needs to be {length} digits. ({_value_})',
})

extend('required', {
  ...required,
  message: '{_field_} can not be empty',
})

extend('max', {
  ...max,
  message: '{_field_} may not be greater than {length} characters',
})

extend('min', {
  ...min,
  message: '{_field_} may not be less than {length} characters',
})

extend('regex', {
  ...regex,
  message: '{_field_} {_value_} does not match {regex}',
})

extend('email', {
  ...email,
  message: 'Email must be valid',
})

export default {
  components: {
    ValidationProvider,
    ValidationObserver,
  },

  data () {
    return {
      loginForm: {
        tnumber: '',
        username: '',
        password: '',
        email: ''
      }
    }
  },

  methods: {
    submit () {
      this.$refs.observer.validate()
    },
    clear () {
      this.loginForm.email = ''
      this.loginForm.username = ''
      this.loginForm.password = ''
      this.loginForm.tnumber = ''
      this.$refs.observer.reset()
    },
    async register () {
      await axios
          .post('/register', {
            username: this.loginForm.username,
            password: this.loginForm.password,
            name: this.loginForm.name,
            email: this.loginForm.email,
            tnumber: this.loginForm.tnumber
          })
          .then(() => {
            this.$alert(
                "Registration success",
                "Success")
            this.$router.replace({path: '/login'})
          })
          .catch(() => {
            //window.alert("Your Username or password is wrong");
            this.$alert("Your Username or password is wrong")
          })
    }
  },
}
</script>

<!--<template>-->
<!--  <body id="paper">-->
<!--  <v-form-->
<!--      :model="loginForm"-->
<!--      :rules="rules"-->
<!--      class="login-container"-->
<!--      label-position="left"-->
<!--      label-width="0px">-->
<!--    <h3 class="login_title">用户注册</h3>-->
<!--    <v-text-field>-->
<!--&lt;!&ndash;      <v-input&ndash;&gt;-->
<!--          type="text"-->
<!--          v-model="loginForm.username"-->
<!--          auto-complete="off"-->
<!--          placeholder="账号">-->
<!--&lt;!&ndash;      </v-input>&ndash;&gt;-->
<!--    </v-text-field>-->
<!--    <v-text-field>-->
<!--&lt;!&ndash;      <v-input&ndash;&gt;-->
<!--          type="password"-->
<!--          v-model="loginForm.password"-->
<!--          auto-complete="off"-->
<!--          placeholder="密码">-->
<!--&lt;!&ndash;      </v-input>&ndash;&gt;-->
<!--    </v-text-field>-->
<!--    <v-text-field>-->
<!--&lt;!&ndash;      <v-input&ndash;&gt;-->
<!--          type="text"-->
<!--          v-model="loginForm.name"-->
<!--          auto-complete="off"-->
<!--          placeholder="真实姓名">-->
<!--&lt;!&ndash;      </v-input>&ndash;&gt;-->
<!--    </v-text-field>-->
<!--    <v-text-field>-->
<!--&lt;!&ndash;      <v-input&ndash;&gt;-->
<!--          type="text"-->
<!--          v-model="loginForm.phone"-->
<!--          auto-complete="off"-->
<!--          placeholder="电话号码">-->
<!--&lt;!&ndash;      </v-input>&ndash;&gt;-->
<!--    </v-text-field>-->
<!--    <v-text-field>-->
<!--&lt;!&ndash;      <v-input&ndash;&gt;-->
<!--          type="text"-->
<!--          v-model="loginForm.email"-->
<!--          auto-complete="off"-->
<!--          placeholder="E-Mail">-->
<!--&lt;!&ndash;      </v-input>&ndash;&gt;-->
<!--    </v-text-field>-->
<!--&lt;!&ndash;    <v-text-field style="width: 100%">&ndash;&gt;-->
<!--      <v-btn-->
<!--          type="primary"-->
<!--          style="width: 40%;-->
<!--          background: #a6abaf;-->
<!--          border: none"-->
<!--          v-on:click="register">-->
<!--        注册-->
<!--      </v-btn>-->
<!--&lt;!&ndash;    </v-text-field>&ndash;&gt;-->
<!--  </v-form>-->
<!--  </body>-->
<!--</template>-->
<!--<script>-->
<!--export default{-->
<!--  data () {-->
<!--    return {-->
<!--      // rules: {-->
<!--      //   username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],-->
<!--      //   password: [{required: true, message: '密码不能为空', trigger: 'blur'}]-->
<!--      // },-->
<!--      checked: true,-->
<!--      loginForm: {-->
<!--        username: '',-->
<!--        password: '',-->
<!--        name: '',-->
<!--        phone: '',-->
<!--        email: ''-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    submit () {-->
<!--      this.$refs.observer.validate()-->
<!--    },-->
<!--    clear () {-->
<!--      this.name = ''-->
<!--      this.phoneNumber = ''-->
<!--      this.email = ''-->
<!--      this.$refs.observer.reset()-->
<!--    },-->
<!--    register () {-->
<!--      var _this = this-->
<!--      this.$axios-->
<!--          .post('/register', {-->
<!--            username: this.loginForm.username,-->
<!--            password: this.loginForm.password,-->
<!--            name: this.loginForm.name,-->
<!--            phone: this.loginForm.phone,-->
<!--            email: this.loginForm.email-->
<!--          })-->
<!--          .then(resp => {-->
<!--            if (resp.data.code === 200) {-->
<!--              this.$alert('注册成功', '提示', {-->
<!--                confirmButtonText: '确定'-->
<!--              })-->
<!--              _this.$router.replace('/login')-->
<!--            } else {-->
<!--              this.$alert(resp.data.message, '提示', {-->
<!--                confirmButtonText: '确定'-->
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
  margin: -5px 0px;
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