<template>
  <div>
    <h1>Restaurants</h1>
<!--    use container to create a grid-like layout-->
    <v-container>
      <v-row>
<!--        Create a restaurant card for each restaurant-->
        <v-col v-for="item in restaurants" :key="item.id">
<!--          pass properties (arguments) to children component-->
<!--          Need the : for variables passing-->
          <RestaurantCard :restaurant="item"></RestaurantCard>
        </v-col>
      </v-row>
    </v-container>
  </div>

</template>

<script>
// import children component
import RestaurantCard from "@/components/RestaurantCard";
import axios from "axios";
export default {
  name: "Restaurants",
  // components imported
  components: {RestaurantCard},

  // data used in this component
  data(){
    // need to return the variables if you want to use it in the template
    return{
      restaurants: [],
    }
  },

  // codes that will run when the component is created (at the very beginning of its life cycle)
  created(){

  },

  // codes that will run when the component is mounted (after created)
  mounted() {
    this.getRestaurants()
  },

  // define methods
  methods:{
    // get the list of restaurant entities
    // async function
    async getRestaurants() {
      // await: wait until this step is complete, then move on to the second step
      // axios: send an http request to the backend
      await axios
          // use get method (since we don't need to provide any parameter)
          // url must correspond to the mapping of controller
          .get('/restaurants/get')
          // function after getting the response
          .then(response => {
            this.restaurants = response.data  // store the data
          })
      // if there is a second step, it will happen after the await is finished
      console.log(this.restaurants)
    }
  }

}
</script>

<style scoped>

</style>