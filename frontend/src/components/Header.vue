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
        <v-tab @click="navigate('foodsearch')">Search Food</v-tab>
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

      <v-menu offset-y>
        <template v-slot:activator="{ on, attrs }">
          <v-btn
              icon
              v-bind="attrs"
              v-on="on"
          >
            <v-icon>
              {{ icons.mdiAccount }}
            </v-icon>
          </v-btn>
        </template>

        <v-list>
          <v-list-item
              v-for="(item, i) in items"
              :key="i"
              link
          >
<!--            <v-list-item-content>-->
<!--              <v-list-item-title v-text="item.text"></v-list-item-title>-->
<!--            </v-list-item-content>-->
            <v-list-item-title @click="navigate(item.route)">{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>

    </v-app-bar>
  </v-card>
</template>

<script>
import {
  mdiAccount
} from '@mdi/js'

export default {
  data: () => ({
    icons: {
      mdiAccount
    },
    items: [
      { title: 'Sign in', route : 'Login' },
      { title: 'Register', route: 'register' },
    ],
  }),
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