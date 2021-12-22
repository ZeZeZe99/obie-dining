import Vue from 'vue';
import Router from 'vue-router';
// import components
import Home from '@/components/Home'
import HelloWorld from "@/components/HelloWorld"
import Restaurants from "@/components/Restaurants";

Vue.use(Router)

const routes = [
    {
        path: '/home',
        name: 'home',
        title: 'Home',
        component: Home,
        children:[
            {
                path: '/restaurants',
                name: 'restaurants',
                title: 'restaurants',
                component: Restaurants
            },
            {
                path: '/hello',
                name: 'hello',
                title: 'Hello World',
                component: HelloWorld
            }
        ]
    },
    {
        path: '/',
        redirect: {name: 'home'}
    },
    {
        path: '*',
        redirect: {name: 'home'}
    }
];

export default new Router({
    mode:"history",
    routes
})