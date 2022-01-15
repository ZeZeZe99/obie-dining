<!--Component for menu dialog-->
<template>
  <v-card min-height="600px">

    <!--Toolbar at the top-->
    <v-toolbar class="toolbar" height="100px">

      <!--Title-->
      <v-col cols="2">
        <v-toolbar-title class="title">{{ restaurant.name }} Menu</v-toolbar-title>
      </v-col>

      <!--Empty columns as spacer-->
      <v-col cols="1"></v-col>

      <!--Date picker-->
      <v-col cols="2">
        <v-menu v-model="datePicker" :close-on-content-click="false"
            :nudge-right="40" transition="scale-transition" offset-y min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field v-model="date" label="Pick a date"
                prepend-icon="mdi-calendar" readonly
                v-bind="attrs" v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker v-model="date" @input="datePicker = false"></v-date-picker>
        </v-menu>
      </v-col>

      <!--Empty columns as spacer-->
      <v-col cols="1"></v-col>

      <!--Selector to select time slot (breakfast, lunch, dinner, etc.)-->
      <v-col cols="2">
        <v-select label="Pick a time slot" class="select" v-model="slot" :items="slotOptions">

        </v-select>
      </v-col>

      <!--Empty columns as spacer-->
      <v-col cols="1"></v-col>

      <!--Button to search for the menu-->
      <v-col cols="1">
        <v-btn class="btn" color="primary" @click="search">
          Search
        </v-btn>
      </v-col>

      <!--Empty columns as spacer-->
      <v-col cols="1"></v-col>

    </v-toolbar>

    <!--Menu-->
    <v-tabs vertical class="tabs" v-model="tab">

      <!--Tabs to navigate through all bars of the restaurant-->
      <v-tab v-for="item in restaurant.bars" :key="item.id" class="my-tab">
        {{ item.name }}
      </v-tab>

      <!--Content of each tab-->
      <v-tab-item v-for="item in restaurant.bars" :key="item.id">
        <v-card>
          <v-card-title>{{item.name}}</v-card-title>
        </v-card>

        <!--If there is no dish information available, show the empty card-->
        <EmptyCard v-show="dishes.length===0"></EmptyCard>

        <!--Display dish information-->
        <Dish v-for="d in dishes" :key="d.id" :dish="d"></Dish>


      </v-tab-item>
    </v-tabs>

    <!--<v-tabs-items v-model="tab">-->
    <!--  <v-tab-item v-for="item in restaurant.bars" :key="item.id">-->
    <!--    <v-card>-->
    <!--      {{item.name}}-->
    <!--    </v-card>-->
    <!--  </v-tab-item>-->
    <!--</v-tabs-items>-->

  </v-card>
</template>

<script>
import axios from "axios";
import EmptyCard from "@/components/EmptyCard";
import Dish from "@/components/Dish";

export default {
  name: "Menu",
  components: {Dish, EmptyCard},
  props:{
    restaurant: {required: true, type: Object}
  },

  data(){
    return{
      datePicker: false, // display the date picker\
      dateTime: null,
      date: null,
      slot: null,
      slotOptions: ['Breakfast', 'Lunch', 'Dinner'],
      tab: null,
      currentBar: null,
      dishes: [],
      // empty: false // whether the dish list is empty
    }
  },

  created() {
    // set default date and slot when created
    this.defaultDateAndSlot()
  },

  mounted() {
    // set default bar when mounted
    this.currentBar = this.restaurant.bars[this.tab]
    // this.search()
  },

  // watcher for the attributes, call functions when attributes changed
  watch:{
    // when the selected tab changes, update the current bar and its menu
    tab: function (){
      this.currentBar = this.restaurant.bars[this.tab]
      this.search()
    }
  },

  methods:{
    // set the default date and slot based on current time
    defaultDateAndSlot(){
      // get current date time in ISO format
      this.date = (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)
      const hour = new Date().getHours()
      if (hour < 10){
        this.slot = 'Breakfast'
      } else if (hour < 14 ){
        this.slot = 'Lunch'
      } else if (hour < 20){
        this.slot = 'Dinner'
      } else {
        this.slot = 'Dinner'
      }
    },

    // search for the menu information based on selected bar, date, and time slot
    async search(){
      const param = {bar: this.currentBar, date: this.date, slot: this.slot}
      console.log(param)
      await axios
          .post('/menu/findDishesByBarAndDateAndSlot', param)
          .then(response=>{
            this.dishes = response.data
            console.log(this.dishes)
          })
      // if there is no dish information available, display the EmptyCard
      // this.empty = this.dishes.length === 0;
    }
  }
}
</script>

<style scoped>
.my-tab{
  width: 300px;
}
.toolbar{
  padding-top: 10px;
}
.title{
  margin-bottom: 30px;
}
.btn{
  margin-bottom: 25px;
  margin-right: 0;
}
</style>