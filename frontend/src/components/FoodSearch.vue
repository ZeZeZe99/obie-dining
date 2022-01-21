<template>
  <div>
    <h2>To search, or not to search, that is the question,</h2>
    <v-container>
      <v-card class="bar"
          flat
      >
        <v-toolbar>
                  <v-text-field
                      hide-details
                      prepend-icon="mdi-magnify"
                      single-line
                      v-model="searchquery"
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
                          v-model="sortby"
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
      </v-card>
      {{sortby}}
    </v-container>
  </div>
</template>
<script>
export default {
  name: "FoodSearch",
  data: () => ({
    sortItems: [
      { title: 'Rating' },
      { title: 'Popularity' },
    ],
    searchquery: null,
    sortby: 'Rating',
    loader: null,
    loading: false,

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

  }
}
</script>

<style scoped>
.bar{
  width: 80%;
  left: 10%;
}
</style>