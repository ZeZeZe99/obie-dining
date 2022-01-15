<template>
  <div>
    <h2>To search, or not to search, that is the question,</h2>
    <p>&nbsp;</p>
    <v-container
        class="px-0"
        fluid
    >
      <v-radio-group v-model="radioGroup">
        <div @click="toggleFoodSearchToTrue">
          <v-radio
              label="Search"
              value="searchFood"
          ></v-radio>
        </div>
        <div @click="toggleFoodSearchToFalse">
          <v-radio
              label="Sort"
              value="sortFood"
          ></v-radio>
        </div>
      </v-radio-group>
    </v-container>
    <div v-if="selectFoodSearch">
      <v-card>
        <v-container fluid>
          <v-row
              align="center"
          >
            <v-col cols="12">
              <v-autocomplete
                  v-model="value"
                  :items="items"
                  dense
                  filled
                  label="For the dish!"
              ></v-autocomplete>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </div>
    <p>&nbsp;</p>
    <div v-if="selectFoodSearch===false">
      <h3>Sort by ratings! Desc or Ascd?</h3>
      <v-radio-group v-model="radioGroup2">
        <div style="width:300px; margin:0 auto;">
          <v-radio
              label="Descending"
              value="desc"
          ></v-radio>
        </div>
        <div style="width:300px; margin:0 auto;">
          <v-radio
              label="Ascending"
              value="ascd"
          ></v-radio>
        </div>
      </v-radio-group>
    </div>
  </div>
</template>
<script>
export default {
  name: "FoodSearch",
  data: () => ({
    items: ['foo', 'bar', 'fizz', 'buzz'],
    value: null,
    selectFoodSearch: true,
    radioGroup: 1,
    radioGroup2: 2,
  }),
  created() {
    this.toggleFoodSearchToTrue()
  },
  methods: {
    toggleFoodSearchToTrue(){
        this.selectFoodSearch = true
    },
    toggleFoodSearchToFalse(){
      this.selectFoodSearch = false
    }
  }
}
</script>

<style scoped>

</style>