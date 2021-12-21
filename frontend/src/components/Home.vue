<template>
  <v-app>
    <Header class="header"></Header>
    <v-main>
      <v-container>
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
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