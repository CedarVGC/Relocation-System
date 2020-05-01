<template>
  <div id="all">
    <el-card class="box-card">
    <el-row>
      <el-row type="flex"><span>户主信息</span></el-row>
      <el-row>
        <el-radio v-model="radio1" label=1 border>已审核</el-radio>
        <el-radio v-model="radio1" label=0 border>未审核</el-radio>
      </el-row>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-card class="box-card">
          <el-checkbox-group v-model=" resList1" >
            <el-checkbox v-for="city in checkList1" :label="city" :key="city" style="display:block;">
              {{"编号:"+city.id+" 姓名:"+city.name}}
            </el-checkbox>
          </el-checkbox-group>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-row><span></span></el-row>
        <el-row><span></span></el-row>
          <el-row>
            <el-row>
            <el-button icon="el-icon-refresh-right" round @click="convert">刷新</el-button>
            </el-row>
            <el-row>
            <el-button :disabled="right3" type="primary" round icon="el-icon-edit" @click="subForm1">审核</el-button>
            </el-row>
          </el-row>
      </el-col>
    </el-row>
    </el-card>
    <el-card class="box-card">
      <el-row>
        <el-row type="flex"><span>户主明细</span></el-row>
        <el-row>
          <el-radio v-model="radio2" label=1 border>已审核</el-radio>
          <el-radio v-model="radio2" label=0 border>未审核</el-radio>
        </el-row>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-card class="box-card">
            <el-checkbox-group v-model=" resList2" >
              <el-checkbox v-for="city in checkList2" :label="city" :key="city" style="display:block;">
                {{"编号:"+city.id+" 姓名:"+city.name}}
              </el-checkbox>
            </el-checkbox-group>
          </el-card>
        </el-col>
        <el-col :span="12">
          <el-row><span></span></el-row>
          <el-row><span></span></el-row>
          <el-row>
            <el-button icon="el-icon-refresh-right" round @click="convert2">刷新</el-button>
          </el-row>
          <el-row><span></span></el-row>
          <el-row>
            <el-button :disabled="right3" type="primary" icon="el-icon-edit" round @click="subForm2">审核</el-button>
          </el-row>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>
<script>
  //# sourceMappingURL=file.js.map
  export default {
    data() {
      return {
        radio1:'', radio2: '',
        checkList1: [], checkList2: [],
        resList1: [], resList2: [],
        right0:true,right3:true,
      }
    },
        created(){
        this.convert();
        this.convert2();
      },
      methods: {
        convert: function () {
          var _this=this
          this.$axios.get('/Pdd/PopulationCheck/in1').then(resp => {
            if (resp && resp.status === 200) {
              _this.right0= !Boolean(Number(sessionStorage.getItem("right0")));
              _this.right3= !Boolean(Number(sessionStorage.getItem("right3")));
              if(!_this.right0)
              {
                _this.checkList1= resp.data
              }
            }
          })
        },
        convert2: function () {
          var _this=this
          this.$axios.get('/Pdd/PopulationCheck/in2').then(resp => {
            if (resp && resp.status === 200) {
              _this.right0= !Boolean(Number(sessionStorage.getItem("right0")));
              _this.right3= !Boolean(Number(sessionStorage.getItem("right3")));
              if(!_this.right0)
              {
                _this.checkList2= resp.data
              }
            }
          })
        },
        subForm1() {
          if(this.radio1!==''){
            this.go1()
          }
          else
          {
            alert('信息输入不全。审核.未审核必需选择其一')
          }
        },
        subForm2() {
          if(this.radio2!==''){
            this.go2()
          }
          else
          {
            alert('信息输入不全。审核.未审核必需选择其一')
          }
        },
        go1(){
          var _this = this
         var m = {}
         var j=0
          for(var i = 0; i < this.resList1.length; i++) {
            var params = {}
              params["id"]=this.resList1[i]["id"];
              params["choose"]=this.radio1;
              m["key"+i]=params;
          }
          this.$axios
            .post('Pdd/PopulationCheck/update1',m)
            .then(successResponse => {
              if (successResponse.data.code == 200)
              {
                alert('添加成功')

              }
              else if (successResponse.data.code == 400)
              {
                alert('用户已存在')
              }
            })
            .catch(failResponse => {
            })
        },
        go2(){
          var _this = this
          var m = {}
          var j=0
          for(var i = 0; i < this.resList2.length; i++) {
            var params = {}
            params["id"]=this.resList2[i]["id"];
            params["choose"]=this.radio2;
            m["key"+i]=params;
          }
          this.$axios
            .post('Pdd/PopulationCheck/update2',m)
            .then(successResponse => {
              if (successResponse.data.code == 200)
              {
                alert('添加成功')

              }
              else if (successResponse.data.code == 400)
              {
                alert('用户已存在')
              }
            })
            .catch(failResponse => {
            })
        },
      }
  }
</script>
<style>
  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
