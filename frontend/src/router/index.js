import Vue from 'vue';
import Router from 'vue-router';
// import components
import Home from '@/components/Home'
import HelloWorld from "@/components/HelloWorld"
import Restaurants from "@/components/Restaurants";
import FoodSearch from "@/components/FoodSearch";
import Login from '@/components/Login';
import Register from '@/components/Register';
import Contact from "@/components/Contact";
import About from "@/components/About";

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
                path: '/foodsearch',
                name: 'foodsearch',
                title: 'foodsearch',
                component: FoodSearch
            },
            {
                path: '/hello',
                name: 'hello',
                title: 'Hello World',
                component: HelloWorld
            },
            {
                path: '/contact',
                name: 'contact',
                title: 'contact',
                component: Contact
            },
            {
                path: '/about',
                name: 'about',
                title: 'about',
                component: About
            },
        ]
    },
    {
        path: '/',
        redirect: {name: 'home'}
    },
    {
        path: '/login',
        name: 'Login',
        title: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'register',
        title: 'register',
        component: Register
    }
];

export default new Router({
    mode:"history",
    routes
})

