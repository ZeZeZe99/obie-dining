<template>
  <v-card
      color="grey lighten-4"
      flat
      tile
  >
    <v-app-bar dense height="80%" color="white">
      <v-app-bar-nav-icon></v-app-bar-nav-icon>

      <v-toolbar-title>Obie Dining</v-toolbar-title>

      <v-spacer></v-spacer>

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
  name: "Header"
}
</script>

<style scoped>

</style>