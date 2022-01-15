<!--Component that display information for a dish-->

<template>
  <v-card elevation="4" class="dish">
    <v-row class="dish-row" align="center" justify="space-around">

      <!--Dish image-->
      <!--If the url doesn't work, use the default image-->
      <v-col cols="2">
        <v-img :src="getImageUrl(dish.name)" contain max-height="80px" max-width="200px"></v-img>
      </v-col>

      <!--Dish name-->
      <v-col cols="2">
        <b>{{dish.name}}</b>
      </v-col>

      <!--Dish calories-->
      <v-col cols="1">
        <v-row justify="center"><b>Calories</b></v-row>
        <v-row justify="center">{{dish.calories}}</v-row>
      </v-col>

      <!--Dish price-->
      <v-col cols="1">
        <v-row justify="center"><b>Price</b></v-row>
        <v-row justify="center">$ {{dish.price}}</v-row>
      </v-col>

      <!--Dish rating-->
      <v-col cols="2">
        <v-rating half-increments hover dense size="20" readonly :value="rate">
        </v-rating>
      </v-col>



    </v-row>
  </v-card>
</template>

<script>
export default {
  name: "Dish",

  props:{
    // dish object
    dish: {required: true, type: Object}
  },

  data(){
    return{
      imageUrl: null,
      rate: null
    }
  },

  created() {
    // set the default url of the dish image
    // the image file must be in jpeg format and must have the same name as the dish
    // this.imageUrl = '../assets/dish/' + this.dish.name + '.jpeg'
    this.imageUrl = '@/assets/Umami.jpeg'
  },

  methods:{
    // get the url of the dish image
    // the image file must be in jpeg format and must have the same name as the dish
    getImageUrl(name){
      try{
        return require('@/assets/dish/' + name + '.jpeg')
      } catch {
        return require('@/assets/no image.jpeg')
      }

    }
  }
}
</script>

<style scoped>
.dish{
  margin: 10px;
  height: 100px;
}
.dish-row{
  margin: 0;
  height: 100px;
}

</style>