<script setup lang="ts">
import { reactive, ref } from "vue";

const input1 = ref('');

// 使用统一的数据结构管理所有组件类别
const componentCategories = reactive([
  {
    title: "Basic 基础组件",
    items: [
      'button', 'border', 'color', 'container', 'icon', 'layout', 'link',
      'text', 'scrollbar', 'space', 'splitter', 'typography'
    ]
  },
  {
    title: "配置组件",
    items: ['Config Provider 全局配置']
  },
  {
    title: "Form 表单组件",
    items: [
      'autocomplete', 'cascader', 'checkbox', 'colorPickerPanel', 'colorPicker',
      'datePickerPanel', 'datePicker', 'datetimePicker', 'form', 'input',
      'inputNumber', 'inputTag', 'mention', 'radio', 'rate', 'select',
      'Virtualized Select 虚拟化选择器', 'slider', 'switch', 'timePicker',
      'transfer', 'treeSelect', 'upload'
    ]
  },
  {
    title: "Data 数据展示",
    items: [
      'avatar', 'badge', 'calender', 'card', 'carousel', 'collapse',
      'description', 'empty', 'image', 'infinite scroll', 'pagination',
      'progress', 'result', 'skeleton', 'table', 'virtualized table',
      'tag', 'timeline', 'tour', 'tree', 'virtualized tree', 'statistic',
      'segmented'
    ]
  },
  {
    title: 'Navigation 导航',
    items: [
      'affix', 'anchor', 'breadcrumb', 'dropdown', 'menu', 'pageHeader',
      'steps', 'tabs', 'backtop'
    ]
  },
  {
    title: 'Feedback 反馈组件',
    items: [
      'alert', 'dialog', 'message', 'messageBox', 'notification', 'popconfirm',
      'popover', 'drawer','tooltip','loading'
    ]
  },
  {
    title: 'Others 其他',
    items:[
        'divider',
        'watermark'
    ]
  }
]);
</script>


<template>
  <div>
    <div style="height: 5vh;display: flex;align-items: center;justify-content: center;margin-bottom: 10px">
      <el-input
        v-model="input1"
        style="width: 30vw"
        size="default"
        placeholder="Please Input"
      />
      <el-button type="primary" size="default" style="margin-left: 10px">
        搜索
      </el-button>
    </div>
    <div>
      <el-scrollbar height="70vh" style="border-radius: 5px;background-color: orange;padding: 10px">
        <div v-for="(category, index) in componentCategories" :key="index">
          <h2>{{ category.title }}</h2>
          <div style="display: flex; flex-wrap: wrap; gap: 10px;">
            <div
              v-for="item in category.items"
              :key="item"
              style="flex: 0 0 auto;"
            >
              <el-card style="width: 300px">
                <template #header>{{ item }}</template>
              </el-card>
            </div>
          </div>
        </div>
      </el-scrollbar>
    </div>
  </div>
</template>


<style scoped>
.search-container {
  height: 5vh;
  margin-bottom: 10px;
}

.search-input {
  width: 240px;
}

.search-button {
  margin-left: 10px;
}

.components-container {
  border-radius: 5px;
}

.category-title {
  margin: 20px 0 10px 0;
}

.items-container {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}

.item-card {
  flex: 0 0 auto;
  width: 300px;
}
</style>
