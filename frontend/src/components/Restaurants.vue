<template>
  <div>
    <h1>Restaurants</h1>
    <v-container>
      <v-row>
        <v-col>
          <RestaurantCard restaurant="Stevenson" imageName="stevenson_logo.jpeg"></RestaurantCard>
        </v-col>
        <v-col>
          <RestaurantCard restaurant="Lord Saunders" imageName="ls_logo.jpeg"></RestaurantCard>
        </v-col>
      </v-row>
    </v-container>
  </div>

</template>

<script>
import RestaurantCard from "@/components/RestaurantCard";
export default {
  name: "Restaurants",
  components: {RestaurantCard}
}
</script>

<style scoped>

</style>