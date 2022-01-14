<template>
  <div>
    <h2>To search, or not to search, that is the question,</h2>
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
                label="Filled"
            ></v-autocomplete>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </div>
</template>
<script>
export default {
  name: "FoodSearch",
  data: () => ({
    items: ['foo', 'bar', 'fizz', 'buzz'],
    values: ['foo', 'bar'],
    value: null,
  }),
}
</script>

<style scoped>

</style>