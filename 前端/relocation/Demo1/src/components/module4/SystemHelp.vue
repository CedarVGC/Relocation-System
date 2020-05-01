<template>
  <div >
    <div>操作详解(客服QQ:1966635780)</div>
    <el-collapse v-model="activeName" accordion>
      <el-collapse-item title="关于账号" name="1">
        <div>使用用户管理界面的用户名登录</div>
        <div>默认密码是123456</div>
      </el-collapse-item>
      <el-collapse-item title="关于权限" name="2">
        <div>查看权限可以观看各个界面的表格</div>
        <div>编辑权限可以操作各个界面的增加和修改按钮</div>
        <div>删除权限可以操作各个界面的删除按钮</div>
        <div>审核权限可以操作人口审核和企业审核界面的审核按钮</div>
        <div>权限分配权限可以在权限分配界面为各个账号分配权限</div>
        <div>用户权限不得超过其所在部门的权限</div>
      </el-collapse-item>
      <el-collapse-item title="关于审核" name="3">
        <div>在其它界面新增人口或企业信息时，默认审核状态为未审核</div>
        <div>新增人口或企业信息时，需要在审核界面点击刷新才能在审核表格里显示</div>
        <div>已审核的信息不允许修改</div>
      </el-collapse-item>
      <el-collapse-item title="关于增加" name="4">
        <div>各界面红色输入框为必填项</div>
        <div>新增的用户，部门默认无任何权限</div>
        <div>新增的户主，企业默认未审核</div>
        <div>已审核的户主，企业信息不允许增加</div>
      </el-collapse-item>
      <el-collapse-item title="关于修改" name="5">
        <div>修改操作必填项为编号</div>
        <div>默认动态修改，只会修改填了值的项</div>
        <div>已审核的户主，企业信息不允许修改</div>
      </el-collapse-item>
      <el-collapse-item title="关于删除" name="6">
        <div>删除操作只需要填编号</div>
        <div>已审核的户主，企业信息不允许删除</div>
      </el-collapse-item>
      <el-collapse-item title="关于查询" name="7">
        <div>默认动态查询，输入框可以任意填写来缩小查询范围</div>
        <div>什么都不填则默认查询全部信息</div>
      </el-collapse-item>
      <el-collapse-item title="关于结算" name="8">
        <div>兑现金额=兑现单价*兑现面积*(1+0.01*(兑现增加%-兑现减少%)),应分，增档，超档依次类推</div>
        <div>分配合计金额=兑现金额+应分金额-增档金额-超档金额</div>
        <div>分配楼房与原房结算金额=分配合计金额-其它项目费用-原房合计金额</div>
      </el-collapse-item>
    </el-collapse>
   <span>created by 蔡秋怡，王昊天，方若男，杨令仪，肖天，李山</span>

  </div>
</template>
<script>
  export default {
    data () {
      return {
        activeNames: ['1']
      }
    },
    methods: {
      handleChange(val) {
        console.log(val);
      },
    }
  }
</script>
