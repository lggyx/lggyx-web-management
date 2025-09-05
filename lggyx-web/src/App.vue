<script lang="ts" setup>
import './assets/style.css'
</script>

<template>
  <div id="DashBoard">
    <div id="RouterLinkTitle">
      <router-link to="/Login" style="margin-right: 10px">
        <el-button type="primary" size="small">登录</el-button>
      </router-link>
      <router-link to="/Emp">
        <el-button type="primary" size="small">员工管理</el-button>
      </router-link>
      <router-link to="/Dept" style="margin-left: 10px">
        <el-button type="primary" size="small">部门管理</el-button>
      </router-link>
    </div>
    <router-view/>
  </div>
</template>

<style scoped></style>
