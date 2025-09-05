<script setup lang="ts">
let tableData = [{}]
import axios from "axios";
axios.get('/api/depts').then(res=>{
  console.log(res.data.data)
  tableData = res.data.data
  console.log(tableData)
})
</script>

<template>
<div>
  <el-table :data="tableData">
    <el-table-column label="部门编号" prop="id">
    </el-table-column>
    <el-table-column label="部门名称" prop="name">
    </el-table-column>
    <el-table-column label="操作">
      <template #default='scope'>
        <el-button type="primary" size="small">编辑</el-button>
        <el-button type="danger" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</div>
</template>

<style scoped>

</style>
