<script setup lang="ts">
import './assets/style.css'
</script>

<template>
  <div id="DashBoard">
    <div id="RouterLinkTitle">
    <router-link to="/Login">Login</router-link>|
    <router-link to="/Emp">Emp</router-link>|
    <router-link to="/Dept">Dept</router-link>
    </div>
    <hr/>
    <router-view/>
  </div>
</template>

<style scoped></style>
