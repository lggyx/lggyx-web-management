import {createRouter, createWebHistory} from "vue-router";
import EmpPage from "@/pages/EmpPage.vue";
import DeptPage from "@/pages/DeptPage.vue";
import LoginPage from "@/pages/LoginPage.vue";

const routes = [{
    path: "/", redirect: "/Login"
}, {
    path: "/Login", name: "Login", component: LoginPage
}, {
    path: "/Emp", name: "Emp", component: EmpPage
}, {
    path: "/Dept", name: "Dept", component: DeptPage
}];


const router = createRouter({
    history: createWebHistory(), routes,
});
// router.beforeEach((to, from, next) => {
//     if (to.name === "Login" && localStorage.getItem("token")) {
//         next({name: "Emp"});
//     } else {
//         next();
//     }
// });
export default router;
