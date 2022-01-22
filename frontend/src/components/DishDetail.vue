<template>
  <v-card class="pa-5">
    <!--Dish name-->
    <v-row justify="center">
      <v-card-title class="text-h3">{{dish.name}}</v-card-title>
    </v-row>

   <!-- Dish price-->
   <v-row justify="center" class="text-h5">
     $ {{dish.price}}
   </v-row>

    <!--Dish image-->
    <v-row justify="center" class="ma-5">
      <!--Image-->
      <v-img :src="getImageUrl(dish.name)" contain max-height="300px" max-width="300px" class="ma-2"></v-img>

      <!--Allergen card-->
      <v-card class="pa-2 fill-height ma-2" max-width="30%">
        <!--Card title-->
        <v-card-title class="justify-center text-h5 ">Allergens</v-card-title>

        <!--<v-chip-group column>-->
          <v-chip v-for="item in allergens" :key="item.id"
                  label color="purple" text-color="white" class="text-h6 ma-1">
            {{item.name}}
          </v-chip>
        <!--</v-chip-group>-->
      </v-card>

      <!--Preference card-->
      <v-card class="pa-2 fill-height ma-2" max-width="30%">
        <!--Card title-->
        <v-card-title class="justify-center text-h5 ">Preferences</v-card-title>

        <!--<v-chip-group column>-->
          <v-chip v-for="item in preferences" :key="item.id" label
                  color="brown" text-color="white">
            {{item.name}}
          </v-chip>
        <!--</v-chip-group>-->
      </v-card>
    </v-row>

    <v-row justify="center">
      <!--Rating card-->
      <v-card class="elevation-8  ma-1" width="30%">
        <!--Card title-->
        <v-card-title class="justify-center text-h5">Rate this dish!</v-card-title>
        <!--Card text-->
        <!--<v-card-text class="text-center">-->
        <!--  Whether you are enjoying or not, please take a few seconds to rate your experience with this dish.It really helps!-->
        <!--</v-card-text>-->
        <!--Rating-->
        <v-rating half-increments hover dense size="20" :value="rating"></v-rating>
        <v-divider></v-divider>
        <v-card-actions class="justify-center">
          <v-btn
              text
              @click = "asklogin">
            Submit rating
          </v-btn>
        </v-card-actions>
      </v-card>

      <!--Comment card-->
      <v-card class="elevation-8 ma-1" width="65%">
        <v-card-title class="justify-center text-h5">Voice your comment!</v-card-title>
      </v-card>
    </v-row>

  </v-card>
</template>

<script>
export default {
  name: "DishDetail",

  props:{
    dish: {required: true, type: Object},
    avgRating: {require: true, type: Number}
  },

  data(){
    return{
      rating: this.avgRating,
      allergens: [{id: 1, name: 'peanut'}, {id: 2, name: 'peanut'}, {id: 3, name: 'peanut'}],
      preferences: []
    }
  },

  created() {
    // this.rating = this.avgRating
  },

  methods: {
    // get the url of the dish image
    // the image file must be in jpeg format and must have the same name as the dish
    getImageUrl(name) {
      try {
        return require('@/assets/dish/' + name + '.jpeg')
      } catch {
        return require('@/assets/no image.jpeg')
      }
    },
    asklogin() {
      this.$confirm("You need to sign in")
          .then((r) => {
            console.log(r);
            this.$router.replace({path: '/login'})
          })
          .catch(() => {
            console.log("OK not selected.");
          });
    }
  }
}
</script>

<style scoped>
.my-row{
  margin-top: 30px;
}
</style>