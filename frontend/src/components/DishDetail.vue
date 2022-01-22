<template>
  <v-card class="pa-5 overflow-y-auto">
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
      <v-img :src="getImageUrl(dish.name)" contain max-height="250px" max-width="250px" class="ma-2"></v-img>

      <!--Allergen card-->
      <v-card class="pa-2 fill-height ma-2" max-width="30%" elevation="0">
        <!--Card title-->
        <v-card-title class="justify-center text-h5 ">Allergens</v-card-title>

        <!--List of Allergens-->
        <v-list-item v-for="item in allergens" :key="item.id">
          <v-list-item-content >
            <v-list-item-title>{{item.name}}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-card>

      <!--Preference card-->
      <v-card class="pa-2 fill-height ma-2" max-width="30%" elevation="0">
        <!--Card title-->
        <v-card-title class="justify-center text-h5 ">Preferences</v-card-title>

        <!--List of preferences-->
        <v-list-item v-for="item in preferences" :key="item.id">
          <v-list-item-content >
            <v-list-item-title>{{item.name}}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

      </v-card>
    </v-row>

    <v-row justify="center" class="ma-1">
      <!--Rating card-->
      <v-card class="ma-1" width="30%">
        <!--Card title-->
        <v-card-title class="justify-center text-h5">Rate this dish!</v-card-title>

        <!--Card text-->
        <v-card-text class="text-center">
          Whether you are enjoying or not, please take a few seconds to rate your experience with this dish.
        </v-card-text>

        <!--Rating-->
        <v-rating half-increments hover dense size="25" :value="avgRating" v-model="rating"
                  :readonly="ratingSubmitted"></v-rating>
        <v-divider></v-divider>

        <!--Submit rating-->
        <v-card-actions class="justify-center">
          <!--Submit button-->
          <v-btn text :disabled="ratingSubmitted || !validRating" @click="submitRating">Submit rating</v-btn>

          <!--Overlay that displays success alert-->
          <v-overlay absolute :value="ratingAlert">
            <v-alert v-model="ratingAlert" dismissible dense type="success">
              Rating submitted!
            </v-alert>
          </v-overlay>
        </v-card-actions>
      </v-card>

      <!--Comment card-->
      <v-card class="ma-1 pa-1" width="65%">
        <!--Title-->
        <v-card-title class="justify-center text-h5">Voice your comment!</v-card-title>

        <!--Input text area-->
        <v-form ref="form" v-model="valid" lazy-validation>
          <!--Text area-->
          <v-textarea v-model="newComment" :counter="200" clearable :rules="rules" :disabled="commentSubmitted"
                      outlined no-resize rows="3"
                      placeholder="Please enter your comment here!"></v-textarea>
          <!--Buttons-->
          <v-btn text @click="cancel" :disabled="commentSubmitted">Cancel</v-btn>
          <v-btn text :disabled="!valid || commentSubmitted" @click="submitComment">Submit comment</v-btn>
          <!--Overlay that displays success alert-->
          <v-overlay absolute :value="commentAlert">
            <v-alert v-model="commentAlert" dismissible dense type="success">
              Rating submitted!
            </v-alert>
          </v-overlay>
        </v-form>
      </v-card>
    </v-row>

    <!--Comments-->
    <v-row justify="center">
      <v-card class="pa-2 overflow-y-auto" min-height="200px" width="95%">
        <Comment v-for="item in comments" :key="item.id" :comment="item"
                 class="ma-2 pa-5"></Comment>
      </v-card>
    </v-row>


  </v-card>
</template>

<script>
import Comment from "@/components/Comment";
import axios from "axios";
export default {
  name: "DishDetail",
  components: {Comment},
  props:{
    dish: {required: true, type: Object},
    avgRating: {require: true, type: Number}
  },

  data(){
    return{
      rating: null,
      allergens: [],
      preferences: [],
      comments: [],
      rules: [v => !!v || 'Cannot submit empty comment',
              v => (v && v.length <= 200) || 'Max length is 200'],
      valid: true,
      validRating: false,
      newComment: '',
      ratingSubmitted: false,
      commentSubmitted: false,
      ratingAlert: false,
      commentAlert: false

    }
  },

  created() {
    // this.rating = this.avgRating
  },

  mounted() {
    this.ratingSubmitted = false
    this.commentSubmitted = false
    this.ratingAlert = false
    this.commentAlert = false
    this.getComments()
    this.getPreferences()
    this.getAllergens()
  },

  watch: {
    // allow to submit rating only when a rating is selected
    rating: function (){
      if (this.rating) this.validRating = true
    }
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

    async getPreferences(){
      const param = this.dish
      await axios
          .post('/preference/findPreferencesByDish', param)
          .then(response=>{
            this.preferences = response.data
          })
    },

    async getAllergens(){
      const param = this.dish
      await axios
          .post('/allergen/findAllergensByDish', param)
          .then(response=>{
            this.allergens = response.data
          })
    },

    // method to load all comments
    // TODO: pagination?
    async getComments(){
      const param = this.dish
      await axios
          .post('/comment/findCommentsByDish', param)
          .then(response=>{
            this.comments = response.data
          })
    },

    // check whether the user has already login
    promptLogin() {
      this.$confirm("You need to sign in")
          .then((r) => {
            console.log(r)
            this.$router.replace({path: '/login'})
          })
          .catch(() => {
            console.log("OK not selected.");
          });
    },

    // method to submit current rating
    // TODO: pass in student
    async submitRating(){
      // if not logged in, prompt user to log in
      if (!this.$root.login){
        this.promptLogin()
      } else {
        const param = {rating: this.rating, dish: this.dish, student: this.$root.student}
        // TODO: handle failure alert
        await axios
            .post('/rating/newRating', param)
            .then(response=>{
              this.ratingSubmitted = true
              this.ratingAlert = true
              console.log(response.data)
            })
            .catch(error=>{
              console.log(error.response.data)
            })
      }
    },

    // validate and submit the comment
    async submitComment(){
      if (this.$refs.form.validate()){
        // if not logged in, prompt user to log in
        if (!this.$root.login){
          this.promptLogin()
        } else {
          const param = {content: this.newComment, dish: this.dish, student: this.$root.student}
          // TODO: handle failure alert
          await axios
              .post('/comment/newComment', param)
              .then(response=>{
                this.commentSubmitted = true
                this.commentAlert = true
                console.log(response.data)
              })
              .catch(error=>{
                console.log(error.response.data)
              })
        }
      } else {
        this.$alert("Your comment is not valid!")
      }
    },

    cancel(){
      this.$refs.form.reset()
    }
  }
}
</script>

<style scoped>
.my-row{
  margin-top: 30px;
}
</style>