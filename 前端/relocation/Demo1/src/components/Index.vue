<template>
  <div class="login-box">
    <el-form :model="form1" label-position="right" label-width="auto" show-message class="login-container">
      <span class="login-title">欢迎来到动迁所管理系统</span>
      <div style="margin-top: 5px"></div>
      <el-form-item label="用户名" >
        <el-col :span="22">
          <el-input id="input1" v-model="form1.input1" clearable type="text"  placeholder="请输入用户名"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="密码" >
        <el-col :span="22">
          <el-input id="input2" v-model="form1.input2" clearable type="password" placeholder="请输入密码"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" round @click="go">登录</el-button>
        <el-button type="success" round @click="go2">修改密码</el-button>
        <el-button type="info" round  @click="go3">退出</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
  export default {
    name:'Index',
    data() {
      return {
        form1:{input1:'', input2:''},
        responseResult: [],
        tableData1:{}
      }
    },
    methods:{
      convert1: function () {
        var _this = this
        this.$axios
          .post('/Pdd/Index/in', { username:this.form1.input1})
          .then(resp =>  {
            if (resp && resp.status === 200)
            {
              _this.tableData1=resp.data
              for(let key in _this.tableData1)
              {
                switch(key) {
                  case 'right0':
                    sessionStorage.setItem("right0",1);
                    break;
                  case 'right1':
                    sessionStorage.setItem("right1",1);
                    break;
                  case 'right2':
                    sessionStorage.setItem("right2",1);
                    break;
                  case 'right3':
                    sessionStorage.setItem("right3",1);
                    break;
                  case 'right4':
                    sessionStorage.setItem("right4",1);
                    break;
                }
              }
            }
          })
          .catch(failResponse => {
          })
      },
      go(){
        this.$axios
          .post('/Index', { username: this.form1.input1, password: this.form1.input2})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              let userObj = {name: this.form1.input1, pwd: this.form1.input2}
              sessionStorage.setItem("islogin", 1)
              this.convert1();
              this.$router.push('/Pdd')
            }
            else if (successResponse.data.code == 400)
            {
              alert('用户名或密码错误！请重新登录！')
              document.getElementById('input1').value = '';
              document.getElementById('input2').value = '';
              document.getElementById('input1').focus();
            }
          })
          // eslint-disable-next-line no-unused-vars
          .catch(failResponse => {
          })
      },
      go1()
      {
        sessionStorage.setItem("islogin", 1)
        this.$router.push('/Pdd')
      },
      go2(){
        this.$router.push('/PwdModify')
      },
      go3(){
        window.opener = null;
        window.open("about:blank", "_top").close()
      }
    }
  }
</script>
<style scoped>
  .login-box {
    background:url("../assets/eva.jpg") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  .login-title {
    text-align: center;
    margin: 0 auto 40px auto;
    color: #66CD00;
    font-size: 30px;
    font-weight: bold;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
</style>
