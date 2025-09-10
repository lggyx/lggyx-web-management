import HomePage from "@/pages/HomePage.vue";
import {createRouter, createWebHashHistory} from "vue-router";


const routes=[
    {
        path:'/',
        name:'home',
        component:HomePage
    }
]
const router=createRouter({
    history:createWebHashHistory(),
    routes
})
export default router
