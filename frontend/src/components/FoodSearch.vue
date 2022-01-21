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

                  <v-menu offset-x
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
                      <v-list-item
                          v-for="(item, index) in items"
                          :key="index"
                          link
                      >
                        <v-list-item-title>{{ item.title }}</v-list-item-title>
                      </v-list-item>
                    </v-list>
                  </v-menu>
        </v-toolbar>
      </v-card>

    </v-container>
  </div>
</template>
<script>
export default {
  name: "FoodSearch",
  data: () => ({
    items: [
      { title: 'Rating' },
      { title: 'Something' },
    ],
    searchquery: null
  }),

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