import {createRouter, createWebHistory} from "vue-router";
import EmpPage from "@/pages/EmpPage.vue";
import DeptPage from "@/pages/DeptPage.vue";
import LoginPage from "@/pages/LoginPage.vue";

const routes = [{
    path: "/Emp", name: "Emp", component: EmpPage
}, {
    path: "/Dept", name: "Dept", component: DeptPage
}, {
    path: "/Login", name: "Login", component: LoginPage
}];


const router = createRouter({
    history: createWebHistory(), routes,
});
export default router;
