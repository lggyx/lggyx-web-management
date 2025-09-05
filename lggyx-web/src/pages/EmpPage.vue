<script setup lang="ts">
import {reactive} from "vue";
import axios from "axios";
let data = reactive({
  username:'',
  password:'',
  name:'',
  gender:'',
  image:'',
  job:'',
  entrydate:'',
  create_time:'',
  update_time:'',
})
let tableData = [
  {
    username:'zhangsan',
    password:'123456',
    name:'张三',
    gender:'1',
    image:'111',
    job:'111',
    entrydate:'111',
    create_time:'111',
    update_time:'111',
  }
]
axios.get('/api/emps/1').then(res=>{
  console.log(res.data)
  tableData.push(res.data.data)
  console.log(tableData)
})

</script>

<template>
  <div>
    <el-table :data="tableData">
      <el-table-column label="账号" prop="username"/>
      <el-table-column label="密码" prop="password"/>
      <el-table-column label="姓名" prop="name" />
      <el-table-column label="性别" prop="gender"/>
      <el-table-column label="头像" prop="image">
        <template #default="scope">
          <el-image :src="scope.row.image" fit="fill"/>
        </template>
      </el-table-column>
      <el-table-column label="职位" prop="job"/>
<!--      <el-table-column label="入职时间" prop="entrydate"/>-->
<!--      <el-table-column label="创建时间" prop="create_time"/>-->
<!--      <el-table-column label="更新时间" prop="update_time"/>-->
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="primary" size="small">编辑</el-button>
          <el-button type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>

</style>
