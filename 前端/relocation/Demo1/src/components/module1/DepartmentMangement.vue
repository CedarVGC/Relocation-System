<template>
  <div id="all">
    <el-row type="flex">
      <el-col :span="24">
        <div id="a1">
          <el-table v-loading="loading"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(192,192, 192, 0.8)"
                    :data=" tableData1"  border stripe style="width: 100%">
            <el-table-column prop="number" label="部门编号" width="180"></el-table-column>
            <el-table-column prop="name" label="部门名称" width="120"></el-table-column>
            <el-table-column prop="describe" label="部门描述" width="120"></el-table-column>
            <el-table-column prop="managename" label="部门经理" width="120"></el-table-column>
          </el-table>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
      <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible = true">全局显示</el-button>
      <el-dialog title="部门表" :visible.sync="dialogTableVisible" width="100%">
        <div id="print">
        <el-table :data=" tableData1"  border stripe style="width: 100%" id="tt">
          <el-table-column prop="number" label="部门编号" width="180"></el-table-column>
          <el-table-column prop="name" label="部门名称" width="120"></el-table-column>
          <el-table-column prop="describe" label="部门描述" width="120"></el-table-column>
          <el-table-column prop="managename" label="部门经理" width="120"></el-table-column>
        </el-table>
        </div>
      </el-dialog>
      </el-col>
      <el-col :span="8">
        <el-button  type="text" icon="el-icon-refresh-right" round @click="convert">刷新</el-button>
      </el-col>
      <el-col :span="8">
        <el-button @click="Daochu" type="text" icon="el-icon-download" round > 导出</el-button>
      </el-col>
    </el-row>
    <el-row >
      <el-col :span="12">
        <el-card  class="box-card">
        <div class="a12">
          <el-form :model="form1" :rules="rules" ref="form1"label-position="right" label-width="80px" >
            <span class="login-title">部门信息</span>
            <div style="margin-top: 5px"></div>
            <el-form-item label="部门编号" class="redItem">
              <el-col :span="20">
                <el-input v-model="form1.input1" clearable type="text"
                          placeholder="请输入正整数，例:'1'"
                          @blur="form1.input1=(form1.input1).replace(/[^\d]/g,'');"
                          @keyup.native="form1.input1=(form1.input1).replace(/[^\d]/g,'');" ></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label=" 部门名称" prop="input2">
              <el-col :span="20">
                <el-input v-model="form1.input2" clearable type="text"
                          maxLength='36'
                          placeholder="请输入部门名称，不超过12个字，例:'测量部'"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="部门描述">
              <el-col :span="20">
                <el-input
                  type="textarea"
                  :rows="20"   maxLength='50'
                  placeholder="请输入部门描述,不超过20个字例:'大连分部'"
                  v-model="form1.input3">
                </el-input>
              </el-col>
            </el-form-item>
            <el-form-item label=" 部门经理" >
              <el-col :span="20">
                <el-input v-model="form1.input4" clearable type="text"
                          maxLength='5'
                          placeholder="请输入部门经理名称,不超过5个字，例:'王一飞'"
                          @blur="form1.input4=(form1.input4).replace(/[^\u4e00-\u9fa5]/g,'');"
                          @keyup.native="form1.input4=(form1.input4).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
          </el-form>
        </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <div class="a13 ">
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row ><el-button :disabled="right1" type="primary" round icon="el-icon-circle-plus-outline"@click="subForm">添加部门</el-button>  </el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row ><el-button :disabled="right1" type="success" round  icon="el-icon-edit"@click="updateForm">修改部门</el-button>  </el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><el-button type="danger" :disabled="right2" round icon="el-icon-delete"@click="delForm">删除部门</el-button>  </el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><el-button type="info" icon="el-icon-s-home" round @click="go4">取消</el-button>  </el-row>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
  import XLSX from 'xlsx'
  import FileSaver from 'file-saver'
  export default {
    data() {
      return {
        form1:{
          input1:'', input2:'',input3:'', input4:''},
        tableData1: [],
        loading: true,
        dialogTableVisible:false,
        right0:true,right1:true,right2:true,
      }
    },
    created(){
      this.convert();
    },
    methods: {
      Daochu() {
        var xlsxParam = { raw: true };//转换成excel时，使用原始的格式
        var wb = XLSX.utils.table_to_book(document.querySelector("#tt"),xlsxParam);//outTable为列表id
        var wbout = XLSX.write(wb, {
          bookType: "xlsx",
          bookSST: true,
          type: "array"
        });
        try {
          FileSaver.saveAs(
            new Blob([wbout], { type: "application/octet-stream;charset=utf-8" }),
            "部门表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      subForm() {
        if(this.form1.input1!==''){
          this.go1()
        }
        else
        {
          alert('信息输入不全,增加操作，编号必须填写')
        }
      },
      updateForm() {
        if(this.form1.input1!==''){
          this.go2()
        }
        else {
          alert('信息输入不全。修改操作，编号必须填写')
        }
      },
      delForm() {
        if(this.form1.input1!==''){
          this.open();
        }
        else {
          alert('信息输入不全。删除操作，编号必须填写')
        }
      },
      convert: function () {
        var _this = this
        this.$axios.get('/Pdd/in2').then(resp => {
          if (resp && resp.status === 200) {
            _this.right0= !Boolean(Number(sessionStorage.getItem("right0")));
            _this.right1= !Boolean(Number(sessionStorage.getItem("right1")));
            _this.right2= !Boolean(Number(sessionStorage.getItem("right2")));
            if(!_this.right0)
            {
              _this.tableData1 = resp.data
            }
            _this.loading=false
          }
        })
      },
      go1(){
        var _this = this
        _this.loading=true
        this.$axios
          .post('/Pdd/add2', {number:this.form1.input1,
                              name:this.form1.input2,
                              describe:this.form1.input3,
            managenumber:this.form1.input4})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert();
              alert('添加部门成功')
            }
            else if (successResponse.data.code == 400)
            {
              alert('部门已存在')
            }
          })
          .catch(failResponse => {
          })
        _this.loading=false
      },
      go2(){
        var _this = this
        _this.loading=true
        this.$axios
          .post('/Pdd/update2',  {number:this.form1.input1,
                                  name:this.form1.input2,
                                  describe:this.form1.input3,
            managename:this.form1.input4})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert();
              alert('修改部门成功')
            }
            else if (successResponse.data.code == 400)
            {
              alert('部门不存在')
            }
          })
          .catch(failResponse => {
          })
        _this.loading=false
      },
      go3(){
        var _this = this
        _this.loading=true
        this.$axios
          .post('/Pdd/delete2', {number:this.form1.input1})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert();
              alert('删除部门成功')
            }
            else if (successResponse.data.code == 400)
            {
              alert('部门不存在')
            }
          })
          .catch(failResponse => {
          })
        _this.loading=false
      },
      open() {
        this.$confirm('此操作将永久删除该部门, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.go3();
        }).catch(() => {
        });
      },
      go4() {
        for (let key in this.form1)
        {
          this.form1[key]='';
        }
      }
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
  .redItem .el-form-item__label{
    color: red;
  }
</style>
