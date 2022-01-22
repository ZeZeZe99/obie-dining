<!--Component that display information for a dish-->

<template>
  <v-card elevation="4" class="dish">

    <!--Click the dish card to open a dialog for detailed dish information-->
    <v-dialog v-model="dialog" max-width="80%">
      <!--Make the whole dish card a activator of dialog-->
      <template v-slot:activator="{ on, attrs }">
        <v-row class="dish-row" align="center" justify="space-around"
               v-on="on" v-bind="attrs">

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
            <v-rating half-increments hover dense size="20" readonly :value="rating">
            </v-rating>
          </v-col>

        </v-row>
      </template>

      <!--<v-card>Dish Detail</v-card>-->
      <DishDetail :dish="dish" :avg-rating="rating" class="dish-detail"></DishDetail>

    </v-dialog>

  </v-card>
</template>

<script>
import axios from "axios";
import DishDetail from "@/components/DishDetail";

export default {
  name: "Dish",
  components: {DishDetail},
  props:{
    // dish object
    dish: {required: true, type: Object}
  },

  data(){
    return{
      rating: null,
      dialog: null
    }
  },

  created() {

  },

  mounted() {
    this.getAvgRating()
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
    },

    // get the average rating of the current dish
    async getAvgRating(){
      // post body should consist dish
      const param = this.dish
      await axios
          .post('/rating/avg', param)
          .then(response=>{
            this.rating = response.data
          })
      if (this.rating === ''){
        this.rating = 0
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
.dish-detail{
  /*margin-left: 10%;*/
  /*max-width: 80%;*/
  min-height: 500px;
  max-height: 100%;
}
</style>