<template>
  <v-card class="restaurant-card">

<!--    Display the logo at the top-->
    <v-img contain height="200px" :src="getImgUrl(restaurant.name)"></v-img>

<!--    Display the restaurant name-->
    <h2>{{restaurant.name}}</h2>

<!--    Create a dialog to display restaurant's menu-->
    <v-dialog v-model="dialog">
<!--      Template for the activator of the dialog-->
      <template v-slot:activator="{ on, attrs }">
<!--        A button to display the dialog when clicked-->
        <v-btn class="btn" color="primary"
               v-bind="attrs" v-on="on"
        >Menu</v-btn>
      </template>

<!--      Information in the dialog-->
      <Menu :restaurant="restaurant"></Menu>

    </v-dialog>
  </v-card>
</template>

<script>
import Menu from "@/components/Menu";
export default {
  name: "RestaurantCard",
  components: {Menu},
  // arguments passed in from parent component

  props:{
    // a restaurant object, in the form like {id: 1, name: Stevenson, bars: [...]}
    restaurant: {required: true, type: Object}
  },

  data(){
    return{
      dialog: false
    }
  },
  // methods to be used in this component
  methods:{
    // use the restaurant name to get its image path
    getImgUrl(name){
      return require('../assets/' + name + '.jpeg')
    }
  }
}
</script>

<style scoped>
.restaurant-card{
  height: 500px;
  width: 300px;
}
.btn{
  margin-top: 30px;
}
</style>