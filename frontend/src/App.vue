<template>
<!--  <div id="app">-->
<!--&lt;!&ndash;    <img alt="Vue logo" src="./assets/logo.png">&ndash;&gt;-->
<!--&lt;!&ndash;    <HelloWorld msg="Welcome to Your Vue.js App"/>&ndash;&gt;-->
<!--    <router-view></router-view>-->
<!--  </div>-->
  <v-app>
    <router-view></router-view>
  </v-app>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  // components: {
  //   HelloWorld
  // }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>
