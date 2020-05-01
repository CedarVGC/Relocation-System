<template>
  <div class="login-box">
    <el-form :model="form1" label-position="right" label-width="auto" show-message class="login-container">
      <div style="margin-top: 5px"></div>
      <el-form-item label="用户名" >
        <el-col :span="22">
          <el-input  v-model="form1.input1" clearable type="text" placeholder="请输入用户名"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="旧密码" >
        <el-col :span="22">
          <el-input  v-model="form1.input2" clearable type="password" placeholder="请输入旧密码"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="新密码" >
      <el-col :span="22">
        <el-input v-model="form1.input3" clearable type="password" placeholder="请输入新密码"></el-input>
      </el-col>
      </el-form-item>
      <el-form-item label="再次密码" >
        <el-col :span="22">
          <el-input v-model="form1.input4" clearable type="password" placeholder="请确认密码"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" round @click="go">修改密码</el-button>
        <el-button type="success" round @click="go2">退出</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
  //# sourceMappingURL=file.js.map
  export default {
    data() {
      return {
        form1:{
          input1:'', input2:'',input3:'',input4:''},
      }
    },
    methods:{
      go(){
        if(this.form1.input3!=this.form1.input4)
        {
          alert('新密码与确认密码不符！请重新输入！')
          document.getElementById('input3').value = '';
          document.getElementById('input4').value = '';
          document.getElementById('input3').focus();
        }
        else
        {
          this.$axios
            .post('/PwdModify', { username: this.form1.input1, password: this.form1.input2,newpassword:this.form1.input4})
            .then(successResponse => {
              if (successResponse.data.code == 200)
              {
                alert('修改成功！请重新登录！')
              }
              else if (successResponse.data.code == 400)
              {
                alert('用户名或密码错误！请重新输入！')
                document.getElementById('input1').value = '';
                document.getElementById('input2').value = '';
                document.getElementById('input3').value = '';
                document.getElementById('input4').value = '';
                document.getElementById('input1').focus();
              }
            })
            .catch(failResponse => {
            })
        }

      },
      go2(){this.$router.push('/Index')}
    }
  }
</script>
<style scoped>
  .login-box {
    background:url("../assets/a1.jpg") no-repeat;
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
