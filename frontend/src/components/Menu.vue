<template>
  <v-card>

<!--    Toolbar at the top-->
    <v-toolbar>

<!--      Title-->
      <v-toolbar-title>Menu of {{restaurant.name}}</v-toolbar-title>
    </v-toolbar>

<!--    Tabs to navigate through all bars of the restaurant-->
    <v-tabs vertical>
      <v-tab v-for="item in restaurant.bars" :key="item.id">
        {{item.name}}
      </v-tab>
    </v-tabs>
  </v-card>
</template>

<script>
export default {
  name: "Menu",

  props:{
    restaurant: {required: true, type: Object}
  }
}
</script>

<style scoped>

</style>