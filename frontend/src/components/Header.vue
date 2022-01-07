<template>
  <v-card
      color="grey lighten-4"
      flat
      tile
  >
    <v-app-bar dense height="80%" color="white">
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
<!--title-->
      <v-toolbar-title class="bar-title">Obie Dining</v-toolbar-title>

<!--      tabs-->
      <v-tabs align-with-title class="tabs">
        <v-tab @click="navigate('restaurants')">Restaurants</v-tab>
        <v-tab>Search Food</v-tab>
        <v-tab>About</v-tab>
        <v-tab>Contact Us</v-tab>
      </v-tabs>

<!--      buttons-->
      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
    </v-app-bar>
  </v-card>
</template>

<script>

export default {
  name: "Header",

  methods:{
    // navigate to another page
    // @page should be a name defined in index.js
    navigate(page){
      this.$router.push(page)
    }
  }
}
</script>

<style scoped>
.bar-title{
  width: 200px !important;
}

</style>