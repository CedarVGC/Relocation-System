// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'babel-polyfill'
Vue.use(ElementUI);
var axios = require('axios')
axios.defaults.baseURL = 'http://www.lishan6.top:8888/api'
// 全局注册，让其它组件可以通过this.$axios发送数据
// http://www.lishan6.top:39661/api
Vue.prototype.$axios = axios
Vue.config.productionTip = false
/* eslint-disable no-new */
router.beforeEach((to,from,next)=> {
  let islogin = sessionStorage.getItem("islogin");
  islogin = Boolean(Number(islogin));
  if (to.path == "/Index")
  {
    if (islogin)
    {
      next("/Pdd");
    }
    else
      {
      next();
    }
  }
  else if(to.path == "/PwdModify")
  {
    next();
  }
  else {
    // requireAuth:可以在路由元信息指定哪些页面需要登录权限
    if (to.meta.requireAuth && islogin) {
      next();
    } else {
      next("/Index");
    }
  }
})
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

