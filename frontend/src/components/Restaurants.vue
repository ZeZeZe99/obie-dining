<template>
  <div>
    <h1>Restaurants</h1>
<!--    use container to create a grid-like layout-->
    <v-container>
      <v-row>
        <v-col>
<!--          pass properties (arguments) to children component-->
          <RestaurantCard restaurant="Stevenson" imageName="stevenson_logo.jpeg"></RestaurantCard>
        </v-col>
        <v-col>
          <RestaurantCard restaurant="Lord Saunders" imageName="ls_logo.jpeg"></RestaurantCard>
        </v-col>
        <v-col>
          <RestaurantCard restaurant="Umami" imageName="umami.jpeg"></RestaurantCard>
        </v-col>
      </v-row>
    </v-container>
  </div>

</template>

<script>
// import children component
import RestaurantCard from "@/components/RestaurantCard";
export default {
  name: "Restaurants",
  components: {RestaurantCard}
}
</script>

<style scoped>

</style>