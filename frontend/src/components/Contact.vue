<template>
  <v-card flat>
    <br><br><br><br><br><br><br><br><br><br>
    <v-form v-model="valid">
      <v-container>
        <v-row align="center">
          <v-col
              cols="12"
              md="4"
          >
            <v-text-field
                v-model="email"
                :rules="emailRules"
                label="Your E-mail"
                required
            ></v-text-field>
          </v-col>
          <v-col
              cols="12"
              md="4"
          >
            <v-text-field
                label="Your Comments"
            ></v-text-field>
          </v-col>
          <v-col
              cols="12"
              md= "4">
            <v-btn>
              Send! <small>(Under Construction)</small>
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
  </v-card>
</template>

<script>
export default {
  name: "Contact",
  data: () => ({
    valid: false,
    email: '',
    comment: '',
    emailRules: [
      v => !!v || 'E-mail is required',
      v => /.+@.+/.test(v) || 'E-mail must be valid',
    ],
  }),
}
</script>

<style scoped>

</style>