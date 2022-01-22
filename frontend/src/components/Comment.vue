<template>
  <v-card min-height="150px">
    <v-row justify="space-around">

      <v-col cols="2">
        <v-row justify="center" >
          <v-avatar color="indigo" class="ma-2">
            <v-icon dark>mdi-account-circle</v-icon>
          </v-avatar>
        </v-row>
        <v-row justify="center">
          <!--TODO: use variable-->
          name
        </v-row>
        <v-row justify="center">
          time
        </v-row>
      </v-col>

      <v-col>
        <v-card-text>Comments</v-card-text>
      </v-col>


    </v-row>

  </v-card>
</template>

<script>
export default {
  name: "Comment",

  props:{
    comment: {required: true, type: Object}
  }
}
</script>

<style scoped>

</style>