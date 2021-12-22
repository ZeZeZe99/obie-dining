<template>
  <v-card class="restaurant-card">
    <v-img contain height="200px" :src="getImgUrl(imageName)"></v-img>
    <h2>{{restaurant}}</h2>
    <v-btn color="primary">Menu</v-btn>
  </v-card>
</template>

<script>
export default {
  name: "RestaurantCard",
  // arguments passed in from parent component
  props:{
    restaurant: {required: true, type: String},
    imageName: {required: true, type: String}
  },
  // methods to be used in this component
  methods:{
    getImgUrl(img){
      return require('../assets/' + img)
    }
  }
}
</script>

<style scoped>
.restaurant-card{
  height: 500px;
  width: 300px;
}
</style>