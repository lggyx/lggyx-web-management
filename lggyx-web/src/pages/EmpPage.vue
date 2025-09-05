<script lang="ts" setup>
import {ref} from "vue";
import axios from "axios";
/**
 * 根据id查询员工
 */
// let tableData = ref([[]])
// axios.get('/api/emps/1').then(res => {
//   console.log(res.data)
//   tableData.value = [res.data.data]
//   console.log(tableData)
// })
/**
 * 分页查询员工
 */
let tableData = ref()
axios.get('/api/emps', {
  params: {
    page: 1,
    pageSize: 10,
    name: '',
    gender: '',
    begin: '2010-01-01',
    end: '2020-01-01'
  }
}).then(res => {
  console.log(res.data.data.rows[0])
  tableData.value = res.data.data.rows[0]
})
</script>

<template>
  <div>
    <el-table :data="tableData" style="height: 50vh">
      <el-table-column fixed label="账号" prop="username"/>
      <el-table-column label="密码" prop="password"/>
      <el-table-column label="姓名" prop="name"/>
      <el-table-column label="性别" prop="gender">
        <template #default="scope">
          <el-tag v-if="scope.row.gender === 1">男</el-tag>
          <el-tag v-else type="danger">女</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="头像" prop="image">
        <template #default="scope">
          <el-image :src="scope.row.image" fit="fill" style="border-radius: 10%; height: 50px;"/>
        </template>
      </el-table-column>
      <el-table-column label="职位" prop="job">
        <template #default="scope">
          <el-tag v-if="scope.row.job === 1">部门经理</el-tag>
          <el-tag v-else-if="scope.row.job === 2" type="success">普通员工</el-tag>
          <el-tag v-else type="warning">老板</el-tag>
        </template>
      </el-table-column>
      <!--      <el-table-column label="入职时间" prop="entrydate"/>-->
      <!--      <el-table-column label="创建时间" prop="create_time"/>-->
      <!--      <el-table-column label="更新时间" prop="update_time"/>-->
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" type="primary">编辑</el-button>
          <el-button size="small" type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>

</style>
