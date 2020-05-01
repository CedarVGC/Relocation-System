<template>
  <div id="al">
    <el-row class="header">
      <span>动迁所管理系统</span><el-button class="el-icon-switch-button" type="info" round  @click="logout" style="float:right;font-size: 20px;color: #222;padding: 10px">退出登录</el-button>
    </el-row>
    <el-row>
      <el-tabs type="border-card" >
        <el-tab-pane > <span slot="label"><i class="el-icon-setting"></i>系统管理</span>
          <el-tabs type="border-card">
            <el-tab-pane label="用户管理"><UserMangement></UserMangement></el-tab-pane>
            <el-tab-pane label="部门管理"><DepartmentMangement></DepartmentMangement></el-tab-pane>
            <el-tab-pane label="权限管理"><rights-mangement></rights-mangement></el-tab-pane>
          </el-tabs>
        </el-tab-pane>
        <el-tab-pane ><span slot="label"><i class="el-icon-user"></i>动迁人口管理</span>
          <el-tabs type="border-card">
            <el-tab-pane label="动迁人口信息"><PopulationMessage></PopulationMessage></el-tab-pane>
            <el-tab-pane label="动迁补偿计算"><PopulationCul></PopulationCul></el-tab-pane>
            <el-tab-pane label="动迁分配结算"><PopulationSettlement></PopulationSettlement></el-tab-pane>
            <el-tab-pane label="动迁信息审核"><PopulationCheck></PopulationCheck></el-tab-pane>
          </el-tabs>
        </el-tab-pane>
        <el-tab-pane ><span slot="label"><i class="el-icon-user-solid"></i>动迁企业管理</span>
          <el-tabs type="border-card">
            <el-tab-pane label="企业信息管理"><CompanyMessage></CompanyMessage></el-tab-pane>
            <el-tab-pane label="企业补偿计算"><CompanyDetail></CompanyDetail></el-tab-pane>
            <el-tab-pane label="企业分配结算"><CompanySettle></CompanySettle></el-tab-pane>
            <el-tab-pane label="企业信息审核"><ComCheck></ComCheck></el-tab-pane>
          </el-tabs>
        </el-tab-pane>
        <el-tab-pane ><span slot="label"><i class="el-icon-search"></i>信息查询</span>
          <el-tabs type="border-card">
            <el-tab-pane label="动迁人口查询"><PopulationQuery></PopulationQuery></el-tab-pane>
            <el-tab-pane label="动迁企业查询"><CompanyQuery></CompanyQuery></el-tab-pane>
          </el-tabs>
        </el-tab-pane>
        <el-tab-pane ><span slot="label"><i class="el-icon-question"></i>帮助</span>
          <SystemHelp></SystemHelp>
        </el-tab-pane>
      </el-tabs>
    </el-row>
  </div>
</template>
<script>
  //# sourceMappingURL=file.js.map
  import UserMangement from './module1/UserMangement'
  import DepartmentMangement from './module1/DepartmentMangement'
  import RightsMangement from './module1/RightsMangement'
  import PopulationMessage from './module2/PopulationMessage'
  import PopulationCul from  './module2/PopulationCul'
  import PopulationSettlement from  './module2/PopulationSettlement'
  import PopulationCheck from   './module2/PopulationCheck'
  import CompanyMessage from  './module3/CompanyMessage'
  import CompanyDetail from  './module3/CompanyDetail'
  import CompanySettle from './module3/CompanySettle'
  import ComCheck from  './module3/ComCheck'
  import PopulationQuery from  './module4/PopulationQuery'
  import CompanyQuery from  './module4/CompanyQuery'
  import  SystemHelp from  './module4/SystemHelp'
  export default {
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    components: {
      UserMangement, DepartmentMangement, RightsMangement,PopulationMessage,PopulationCul,CompanySettle,
      PopulationSettlement,PopulationCheck,CompanyMessage,CompanyDetail,ComCheck,PopulationQuery,CompanyQuery, SystemHelp
    },
    destroyed()
    {
      sessionStorage.clear();
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      logout(){
        sessionStorage.clear();
        this.$router.push('/Index');
      },
    }

  }
  </script>
<style>
  .header {
    background-color: #aef0ed;
    color: #000000;
    line-height:60px;
  }
 </style>
