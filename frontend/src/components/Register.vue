<template>
  <validation-observer
      ref="observer"
      v-slot="{ invalid }"
  >
    <body id="paper">
    <h1
        class="gen_title"
        type="text"
        @click="navigate('home')"
    >
      Obie Dining
    </h1>
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
          rules="required|max:10|min:3"
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
            userName: this.loginForm.username,
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
    }  ,
    navigate(page){
      this.$router.push(page)
    }
  },
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
  margin: -5px 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 30px auto;
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
.gen_title {
  margin: 70px;
  /*text-align: center;*/
  color: #111213;
}
</style>