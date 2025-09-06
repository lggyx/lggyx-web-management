<script lang="ts" setup>
import {ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";

/**
 * 根据id查询员工
 */
// let tableData = ref([[]])
// axios.get('/api/emps/1').then(res => {
//   console.log(res.data)
//   tableData.value = [res.data.data]
//   console.log(tableData)
// })

function getNowFormatDate() {
  const date = new Date();
  const year = date.getFullYear();
  const month = (date.getMonth() + 1).toString().padStart(2, '0');
  const strDate = date.getDate().toString().padStart(2, '0');
  return `${year}-${month}-${strDate}`;
}

var end_time = getNowFormatDate()
/**
 * 分页查询员工
 */

let DeptData = ref()
axios.get('/api/depts',{
  headers:{
    token: localStorage.getItem('token')
  }
}).then(res => {
  DeptData.value = res.data.data
})
let tableData = ref()
axios.get('/api/emps', {
  params: {
    page: 1,
    pageSize: 10,
    name: '',
    gender: '',
    begin: '2010-01-01',
    end: end_time
  },
  headers:{
    token: localStorage.getItem('token')
  }
}).then(res => {
  console.log(res.data.data.rows[0])
  tableData.value = res.data.data.rows[0]
})


let handleCurrentChange = (val: number) => {
  console.log(end_time)
  axios.get('/api/emps', {
    params: {
      page: val,
      pageSize: 10,
      name: '',
      gender: '',
      begin: '2010-01-01',
      end: end_time
    },
    headers:{
      token: localStorage.getItem('token')
    }
  }).then(res => {
    console.log(res.data.data.rows[0])
    tableData.value = res.data.data.rows[0]
  })
}
const DialogVisible = ref(false)
const DialogForm = ref(
    {
      id: 0,
      username: '',
      password: '',
      name: '',
      gender: 1,
      job: '',
      image: '',
      entrydate: '',
      create_time: '',
      update_time: ''
    }
)
const DialogTitle = ref('添加员工')
const handleEdit = (scope: any) => {
  DialogTitle.value = '编辑员工'
  DialogVisible.value = true
  DialogForm.value = scope.row
  console.log(DialogForm.value)

}
const DialogCancel = () => {
  DialogVisible.value = false
}
const DialogConfirm = (DialogTitle: any) => {
  console.log("发送表单")
  console.log(DialogTitle.value)
  console.log(DialogForm.value)
  if (DialogTitle === '添加员工') {
    axios.post('/api/emps', {
      username: DialogForm.value.username,
      password: DialogForm.value.password,
      name: DialogForm.value.name,
      gender: DialogForm.value.gender,
      job: DialogForm.value.job,
      image: DialogForm.value.image,
      entrydate: DialogForm.value.entrydate,
    },{
      headers:{
        token: localStorage.getItem('token')
      }
    }).then(res => {
      if (res.data.code === 1) {
        handleCurrentChange(1)
      } else {
        // 弹窗提示信息
        ElMessage.error(res.data.msg)
      }
      DialogCancel()
      clearDialog()
    })
  } else if (DialogTitle === '编辑员工') {
    axios.put('/api/emps/' + DialogForm.value.id.toString(), DialogForm.value, {
      headers:{
        token: localStorage.getItem('token')
      }
    }).then(res => {
      if (res.data.code === 1) {
        handleCurrentChange(1)
      } else {
        // 弹窗提示信息
        ElMessage.error(res.data.msg)
      }
      DialogCancel()
      clearDialog()
    })
  }

}
const handleDelete = (scope: any) => {
  axios.delete('/api/emps/' + scope.row.id, {
    headers:{
      token: localStorage.getItem('token')
    }
  }).then(res => {
    if (res.data.code === 1) {
      handleCurrentChange(1)
    }
  })
}
const handleAdd = () => {
  DialogTitle.value = '添加员工'
  DialogVisible.value = true
}
const clearDialog = () => {
  DialogForm.value =
      {
        id: 0,
        username: '',
        password: '',
        name: '',
        gender: 1,
        job: '',
        image: '',
        entrydate: '',
        create_time: '',
        update_time: ''
      }
}
const uploadToken = {
  token: localStorage.getItem('token')
}
</script>

<template>
  <div>
    <el-table :data="tableData" style="height: 70vh">
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
          <el-tag v-if="DeptData">
            {{ DeptData.find((item: any) => item.id === scope.row.job).name }}
          </el-tag>
        </template>
      </el-table-column>
      <!--      <el-table-column label="入职时间" prop="entrydate"/>-->
      <!--      <el-table-column label="创建时间" prop="create_time"/>-->
      <!--      <el-table-column label="更新时间" prop="update_time"/>-->
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" type="primary" @click="handleEdit(scope)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="display: flex;justify-content: center;align-items: center;margin-top: 8px;">
      <el-pagination
          :total="50"
          background
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
      />
      <el-button size="small" type="primary" @click="handleCurrentChange(1)">刷新</el-button>
      <el-button size="small" type="primary" @click="handleAdd">添加</el-button>
    </div>


    <el-dialog v-model="DialogVisible" :title="DialogTitle">
      <el-form :model="DialogForm" label-width="80px">
        <el-form-item label="账号">
          <el-input v-model="DialogForm.username"/>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="DialogForm.password"/>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="DialogForm.name"/>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="DialogForm.gender">
            <el-radio :label="1">男</el-radio>
            <el-radio :label="0">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="职位">
          <el-select v-model="DialogForm.job" placeholder="请选择职位">
            <el-option
                v-for="item in DeptData"
                :key="item.id"
                :label="item.name"
                :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="头像">
          <el-upload
              :before-upload="(file: any) => {
        const isImage = file.type.startsWith('image/');
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isImage) {
          ElMessage.error('上传头像图片只能是 JPG/PNG 格式!');
        }
        if (!isLt2M) {
          ElMessage.error('上传头像图片大小不能超过 2MB!');
        }
        return isImage && isLt2M;
      }"
              :on-error="(error: any) => {
        console.error('上传失败:', error);
        ElMessage.error('上传失败');
      }"
              :on-success="(res: any, file: any, fileList: any) => {
        if (res.code === 1 && res.data) {
          DialogForm.image = res.data;
          ElMessage.success('上传成功');
        } else {
          ElMessage.error(res.msg || '上传失败');
        }
      }"
              action="http://127.0.0.1:8080/upload"
name="image"
:headers="uploadToken"
              class="upload-demo"
              multiple
          >
            <el-image
                v-if="DialogForm.image"
                :src="DialogForm.image"
                fit="fill"
                style="border-radius: 10%; height: 50px;"
            />
            <el-button v-else size="small" type="primary">点击上传</el-button>
          </el-upload>
        </el-form-item>


      </el-form>
      <div slot="footer" class="dialog-footer" style="display: flex;justify-content: flex-end;">
        <el-button @click="DialogCancel">取 消</el-button>
        <el-button type="primary" @click="DialogConfirm(DialogTitle)">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<style scoped>

</style>
