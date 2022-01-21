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
                      class="ma-2"
                      :loading="loading"
                      :disabled="loading"
                      color="secondary"
                      @click="loader = 'loading'">
                    Search!
                  </v-btn>
        </v-toolbar>
          <v-card flat style="margin-top: 5px" :key="dummy">
            sorted by: {{sortBy}}
          </v-card>
      </v-card>
    </v-container>
    <v-card flat>
      <EmptyCard v-show="dishes.length===0"></EmptyCard>
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
      { title: 'Rating' },
      { title: 'Popularity' },
    ],
    searchQuery: null,
    sortBy: 'Rating',
    loader: null,
    loading: false,
    dishes: [],
  }),

  watch: {
    loader () {
      const l = this.loader
      this[l] = !this[l]

      setTimeout(() => (this[l] = false), 3000)

      this.loader = null
    },
  },

  created() {

  },
  methods: {
    // search for the menu information based on selected bar, date, and time slot TODO
    async search(){
      // post body should consist bar, date, and slot
      const param = {bar: this.currentBar, date: this.date, slot: this.slot}
      await axios
          .post('/menu/findDishesByBarAndDateAndSlot', param)
          .then(response=>{
            this.dishes = response.data
          })
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