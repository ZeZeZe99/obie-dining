<template>
  <v-card
      color="grey lighten-4"
      flat
      tile
  >
    <v-app-bar dense height="80%" color="white">
      <v-app-bar-nav-icon></v-app-bar-nav-icon>

      <v-toolbar-title class="bar-title">Obie Dining</v-toolbar-title>


      <v-tabs align-with-title class="tabs">
        <v-tab @click="getPage('restaurants')">Restaurants</v-tab>
      </v-tabs>

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
    getPage(page){
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