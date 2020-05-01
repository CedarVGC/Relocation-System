import Vue from 'vue'
import Router from 'vue-router'
import Pdd from '@/components/Pdd'
import PwdModify from '@/components/PwdModify'
import  Index from '@/components/Index'
import  HelloWorld from '@/components/HelloWorld'
import  UserMangement from '@/components/module1/UserMangement'
import  DepartmentMangement from '@/components/module1/DepartmentMangement'
import RightsMangement from '@/components/module1/RightsMangement'
import PopulationQuery from '@/components/module4/PopulationQuery'
import CompanyQuery from '@/components/module4/CompanyQuery'
import CompanyMessage  from  '@/components/module3/CompanyMessage'
import CompanyDetail from  '@/components/module3/CompanyDetail'
import PopulationCheck from '@/components/module2/PopulationCheck'
import ComCheck from '@/components/module3/ComCheck'
import PopulationMessage from '@/components/module2/PopulationMessage'
import PopulationCul from  '@/components/module2/PopulationCul'
import PopulationSettlement from  '@/components/module2/PopulationSettlement'
import CompanySettle from  '@/components/module3/CompanySettle'
import SystemHelp from '@/components/module4/SystemHelp'
Vue.use(Router)
export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/Index',
      name: 'Index',
      component: Index
    },
    {
      path: '/PwdModify',
      name: 'PwdModify',
      component: PwdModify,
    },
    {
      path: '/UserMangement',
      name: 'UserMangement',
      component: UserMangement
    },
    {
      path: '/DepartmentMangement',
      name: 'DepartmentMangement',
      component:DepartmentMangement
    },
    {
      path: '/RightsMangement',
      name: 'RightsMangement',
      component:RightsMangement
    },
    {
      path: '/Pdd',
      name: 'Pdd',
      component:Pdd,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/PopulationQuery',
      name: 'PopulationQuery',
      component:PopulationQuery
    },
    {
      path: '/CompanyQuery',
      name: 'CompanyQuery',
      component:CompanyQuery
    },
    {
      path: '/CompanyMessage',
      name: 'CompanyMessage',
      component:CompanyMessage
    },
    {
      path: '/CompanyDetail',
      name: 'CompanyDetail',
      component:CompanyDetail
    },
    {
      path: '/PopulationCheck',
      name: 'PopulationCheck',
      component:PopulationCheck
    },
    {
      path: '/ ComCheck',
      name: ' ComCheck',
      component: ComCheck
    },
    {
      path: '/PopulationMessage',
      name: 'PopulationMessage',
      component:PopulationMessage
    },
    {
      path: '/PopulationCul',
      name: 'PopulationCul',
      component:PopulationCul
    },
    {
      path: '/PopulationSettlement',
      name: 'PopulationSettlement',
      component:PopulationSettlement
    },
    {
      path: '/CompanySettle',
      name: 'CompanySettle',
      component:CompanySettle
    },
    {
      path: '/SystemHelp',
      name: 'SystemHelp',
      component:SystemHelp
    },
    {
      path: '/',
      name: 'HelloWorld',
      component:HelloWorld
    },
  ]
})
