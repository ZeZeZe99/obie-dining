<!--Basic Layout-->
<template>
  <v-app>
<!--    header-->
    <Header class="header"></Header>
<!--    body-->
    <v-main>
      <v-container>
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
// import children components
import Header from "@/components/Header";
export default {
  name: "Home",
  components: {Header}
}
</script>

<style scoped>
.header{
  height: 80px;
}
</style>