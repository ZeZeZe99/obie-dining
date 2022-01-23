<template>
  <div>
    <h2>To search, or not to search, that is the question.</h2>
    <v-container>
      <v-card class="bar"
          flat
      >
        <v-toolbar>
                  <v-text-field
                      hide-details
                      prepend-icon="mdi-magnify"
                      single-line
                      v-model="searchQuery"
                  ></v-text-field>

                  <v-menu offset-y
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                          v-bind="attrs"
                          v-on="on"
                      >
                        Sort By
                      </v-btn>
                    </template>

                    <v-list>
                      <v-list-item-group
                          v-model="sortBy"
                          mandatory>
                        <v-list-item
                            v-for="(item, index) in sortItems"
                            :key="index"
                            :value="item.title"
                            link
                        >
                          <v-list-item-title>{{ item.title }}</v-list-item-title>
                        </v-list-item>
                      </v-list-item-group>
                    </v-list>

                  </v-menu>
                  <v-btn
                      color="primary"
                      @click="changeSeq">
                    {{ sequence }}
                  </v-btn>
                  <v-btn
                      class="ma-2"
                      :loading="loading"
                      :disabled="loading"
                      color="secondary"
                      @click="searchTheFood(); loader = 'loading'">
                    Search!
                  </v-btn>
        </v-toolbar>
          <v-card flat style="margin-top: 5px">
            searching: {{searchQuery}},
            sorted by: {{sortBy}} {{sequence}}
          </v-card>
      </v-card>
    </v-container>
    <v-card flat>
      <Dish v-for="d in dishes" :key="d.id" :dish="d"></Dish>
    </v-card>
  </div>
</template>

<script>
import axios from "axios";
import EmptyCard from "@/components/EmptyCard";
import Dish from "@/components/Dish";

export default {
  name: "FoodSearch",
  // eslint-disable-next-line vue/no-unused-components
  components: {Dish, EmptyCard},
  data: () => ({
    sortItems: [
      { title: 'name'},
      { title: 'calories' },
      { title: 'price' },
    ],
    searchQuery: null,
    sortBy: 'name',
    loader: null,
    loading: false,
    dishes: [],
    sequence: 'asc',
  }),

  watch: {
    loader () {
      const l = this.loader
      this[l] = !this[l]

      setTimeout(() => (this[l] = false), 1000)

      this.loader = null
    },
  },

  created() {

  },
  methods: {
    // search for the dishes like searchQuery, sorted by sortBy.
    async searchTheFood(){
      // post body should consist of bar, date, and slot
      const param = {searchQuery: this.searchQuery, sortBy: this.sortBy, sequence: this.sequence}
      console.log(param)
      await axios
          .post('/foodSearch/findDishesIDByRating', null, {params: param})
          .then(response=>{
            this.dishes = response.data
            console.log(this.dishes)
          })
    },

    changeSeq: function(){
      if(this.sequence == 'asc'){
        this.sequence = 'desc'
      } else {
        this.sequence = 'asc'
      }
    }

  }
}
</script>

<style scoped>
.bar{
  width: 80%;
  left: 10%;
}
</style>