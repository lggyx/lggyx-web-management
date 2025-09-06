<script lang="ts" setup>
import './assets/style.css'
function logout() {
  localStorage.removeItem('token')
  window.location.href = '/'
}
</script>

<template>
  <div id="DashBoard">
    <div id="RouterLinkTitle">
      <router-link to="/Login" style="margin-right: 10px">
        <el-button type="primary" size="small">登录</el-button>
      </router-link>
      <router-link to="/Emp" style="margin-right: 10px">
        <el-button type="primary" size="small">员工管理</el-button>
      </router-link>
      <router-link to="/Dept" style="margin-right: 10px">
        <el-button type="primary" size="small">部门管理</el-button>
      </router-link>
      <el-button type="primary" size="small"  @click="logout">
        退出
      </el-button>
    </div>
    <router-view/>
  </div>
</template>

<style scoped></style>
