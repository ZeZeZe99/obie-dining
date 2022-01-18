<!--This component is used as a place holder when there is no data available-->
<template>
  <v-card>
    <!--Card title-->
    <h2>
      Menu not available yet : (
    </h2>
    <h3>Please come back later!</h3>

    <v-row justify="center">
      <v-col>
        <v-img contain :src="require('../assets/squirrel.png')" max-width="200px"></v-img>
      </v-col>
      <v-col>
        <v-img contain :src="require('../assets/squirrel.png')" max-width="200px"></v-img>
      </v-col>
      <v-col>
        <v-img contain :src="require('../assets/squirrel.png')" max-width="200px"></v-img>
      </v-col>

    </v-row>

  </v-card>
</template>

<script>
export default {
  name: "EmptyCard"
}
</script>

<style scoped>

</style>