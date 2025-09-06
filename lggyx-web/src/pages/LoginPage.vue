<script lang="ts" setup>
import {ref} from "vue";
import axios from "axios";
import router from "@/router";

const LoginForm = ref({
  username: '',
  password: ''
});

const formRef = ref(); // 表单引用

function submit() {
  console.log(LoginForm.value);
  axios.post('/api/login', LoginForm.value).then(res => {
    console.log(res.data)
    localStorage.setItem('token', res.data.data)
    console.log("token:",localStorage.getItem('token'))
    window.location.href = '/Emp'
  })
}
</script>

<template>
<div id="loginBox">
  <el-card style="width: 50vw">
    <el-form ref="formRef" :model="LoginForm">
      <el-form-item label="用户名">
        <el-input v-model="LoginForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="LoginForm.password" type="password"></el-input>
      </el-form-item>
      <div class="button-group">
        <el-button type="primary" @click="submit">登录</el-button>
        <el-button>取消</el-button>
      </div>
    </el-form>
  </el-card>
</div>
</template>



<style scoped>
#loginBox{
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 40px;
}
.button-group{
  display: flex;
  justify-content: center;
}
</style>
