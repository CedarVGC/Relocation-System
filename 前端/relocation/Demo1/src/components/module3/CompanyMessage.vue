<template>
<div class="a1" >
    <el-row>
      <el-row type="flex"><span>企业信息列表</span></el-row>
      <el-row>
        <el-table v-loading="loading"
                  element-loading-text="拼命加载中"
                  element-loading-spinner="el-icon-loading"
                  element-loading-background="rgba(192,192, 192, 0.8)"
                  :data="tableData1" border stripe style="width: 100%">
          <el-table-column prop="id" label="测量表序号" width="120"></el-table-column>
          <el-table-column prop="measuredate" label="测量日期" width="120"></el-table-column>
          <el-table-column prop="name" label="企业名称" width="120"></el-table-column>
          <el-table-column prop="address" label="地址" width="120"></el-table-column>
          <el-table-column prop="project" label="征占项目" width="120"></el-table-column>
          <el-table-column prop="recorder" label="记录员" width="120"></el-table-column>
          <el-table-column prop="measurer" label="测量人员" width="120"></el-table-column>
          <el-table-column prop="autograph" label="动迁人签字" width="120"></el-table-column>
          <el-table-column prop="dautograph" label="被动迁人签字" width="120"></el-table-column>
          <el-table-column prop="writedate" label="填写日期" width="120"></el-table-column>
          <el-table-column prop="writer" label="填写人" width="120"></el-table-column>
          <el-table-column prop="verify" label="审核情况" width="120"></el-table-column>
        </el-table>
      </el-row>
    </el-row>
  <el-row>
    <el-col :span="8">
    <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible = true">全局显示</el-button>
    <el-dialog title="企业信息表" :visible.sync="dialogTableVisible" width="100%">
      <el-table :data="tableData1" border stripe style="width: 100%" id="ssss">
        <el-table-column prop="id" label="测量表序号" width="120"></el-table-column>
        <el-table-column prop="measuredate" label="测量日期" width="120"></el-table-column>
        <el-table-column prop="name" label="企业名称" width="120"></el-table-column>
        <el-table-column prop="address" label="地址" width="120"></el-table-column>
        <el-table-column prop="project" label="征占项目" width="120"></el-table-column>
        <el-table-column prop="recorder" label="记录员" width="120"></el-table-column>
        <el-table-column prop="measurer" label="测量人员" width="120"></el-table-column>
        <el-table-column prop="autograph" label="动迁人签字" width="120"></el-table-column>
        <el-table-column prop="dautograph" label="被动迁人签字" width="120"></el-table-column>
        <el-table-column prop="writedate" label="填写日期" width="120"></el-table-column>
        <el-table-column prop="writer" label="填写人" width="120"></el-table-column>
        <el-table-column prop="verify" label="审核情况" width="120"></el-table-column>
      </el-table>
    </el-dialog>
    </el-col>
    <el-col :span="8">
      <el-button type="text" icon="el-icon-refresh-right" round @click="convert">刷新</el-button>
    </el-col>
    <el-col :span="8">
      <el-button @click="Daochu" type="text" icon="el-icon-download" round > 导出</el-button>
    </el-col>
  </el-row>
    <el-row>
      <el-card  class="box-card">
      <el-form :model="ruleForm"  label-position="right" label-width="100px" >
        <el-card  class="box-card">
        <el-row type="flex"> <span>信息</span></el-row>
        <el-row>
          <el-col :span='8'>
            <el-form-item label="测量表序号" class="redItem">
              <el-col :span='12'>
                <el-input v-model="ruleForm.input7" clearable type="text"
                          placeholder="请输入正整数，例:'1'"
                          @blur="ruleForm.input7=(ruleForm.input7).replace(/[^\d]/g,'');"
                          @keyup.native="ruleForm.input7=(ruleForm.input7).replace(/[^\d]/g,'');"></el-input>
              </el-col>
            </el-form-item>
          </el-col>
          <el-col :span='8'>
            <el-form-item label="企业名称" class="redItem">
              <el-col :span='24'>
              <el-input v-model="ruleForm.input1" clearable type="text" maxLength='15'
                        placeholder="请输入企业名称,不超过15个字，例:'动迁公司'"
                        @blur="ruleForm.input1=(ruleForm.input1).replace(/[^\u4e00-\u9fa5]/g,'');"
                        @keyup.native="ruleForm.input1=(ruleForm.input1).replace(/[^\u4e00-\u9fa5]/g,'');">></el-input>
              </el-col>
            </el-form-item>
          </el-col>
          <el-col :span='8'>
            <el-form-item label="地址" class="redItem">
              <el-col :span='24'>
              <el-input v-model="ruleForm.input2" clearable type="text"
                        maxLength='20'
                        placeholder="请输入地址,不超过20个字，例:'大连开发区'"></el-input>
              </el-col>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span='8'>
            <el-form-item label="记录人" class="redItem">
              <el-col :span='24'>
              <el-input v-model="ruleForm.input3" clearable type="text"
                        maxLength='5'
                        placeholder="请输入记录人姓名,不超过5个字，例:'王一飞'"
                        @blur="ruleForm.input3=(ruleForm.input3).replace(/[^\u4e00-\u9fa5]/g,'');"
                        @keyup.native="ruleForm.input3=(ruleForm.input3).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
          </el-col>
          <el-col :span='8'>
            <el-form-item label="征占项目" class="redItem">
              <el-col :span='24'>
              <el-input v-model="ruleForm.input4" clearable type="text"
                        maxLength='10'
                        placeholder="请输入项目名称,不超过10个字，例:'动迁项目'"></el-input>
              </el-col>
            </el-form-item>
          </el-col>
          <el-col :span='8'>
            <el-form-item label="测量日期" class="redItem">
              <el-col :span='12'>
              <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.input5" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span='8'>
            <el-form-item label="测量人员" class="redItem">
              <el-col :span='24'>
              <el-input v-model="ruleForm.input6" clearable type="text"
                        maxLength='5'
                        placeholder="请输入测量人员姓名,不超过5个字，例:'王一飞'"
                        @blur="ruleForm.input6=(ruleForm.input6).replace(/[^\u4e00-\u9fa5]/g,'');"
                        @keyup.native="ruleForm.input6=(ruleForm.input6).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
          </el-col>
          <el-col :span='8'>
            <el-form-item label="填表日期" class="redItem">
              <el-col :span='12'>
              <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.input8" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>
          </el-col>
        </el-row>
        </el-card>
        <el-card  class="box-card">
        <el-row>
          <el-col :span='8'>
            <el-form-item label="动迁人签名" class="redItem">
              <el-col :span='22'>
              <el-input v-model="ruleForm.input9" clearable type="text"
                        maxLength='5'
                        placeholder="请输入动迁人签名,不超过5个字,例:'王一飞'"
                        @blur="ruleForm.input9=(ruleForm.input9).replace(/[^\u4e00-\u9fa5]/g,'');"
                        @keyup.native="ruleForm.input9=(ruleForm.input9).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
          </el-col>
          <el-col :span='8'>
            <el-form-item label="被动迁人签名" class="redItem">
              <el-col :span='23'>
              <el-input v-model="ruleForm.input10" clearable type="text"
                        maxLength='5'
                        placeholder="请输入被动迁人签名,不超过5个字，例:'王一飞'"
                        @blur="ruleForm.input10=(ruleForm.input10).replace(/[^\u4e00-\u9fa5]/g,'');"
                        @keyup.native="ruleForm.input10=(ruleForm.input10).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
          </el-col>
          <el-col :span='8'>
            <el-form-item label="填写人" class="redItem">
              <el-col :span='22'>
              <el-input v-model="ruleForm.input11" clearable type="text"
                        maxLength='5'
                        placeholder="请输入填写人姓名,不超过5个字，例:'王一飞'"
                        @blur="ruleForm.input11=(ruleForm.input11).replace(/[^\u4e00-\u9fa5]/g,'');"
                        @keyup.native="ruleForm.input11=(ruleForm.input11).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
          </el-col>
        </el-row>
        </el-card>
        <el-row>
          <el-button :disabled="right1" type="primary" icon="el-icon-circle-plus-outline" round @click="subForm">添加企业信息</el-button>
          <el-button :disabled="right1" type="success" icon="el-icon-edit" round @click="updateForm">修改企业信息</el-button>
          <el-button :disabled="right2" type="danger" icon="el-icon-delete" round @click="delForm">删除企业信息</el-button>
          <el-button type="info" icon="el-icon-s-home" round @click="go4">取消</el-button>
        </el-row>
      </el-form>
      </el-card>
    </el-row>
  </div>
</template>
<script>
  import XLSX from 'xlsx'
  import FileSaver from 'file-saver'
  export default {
    data() {
      return {
        ruleForm:{input1:'', input2:'', input3:'', input4:'', input5:'', input6:'',input7:'', input8:'', input9:'', input10:'',
          input11:''},
        tableData1: [],
        loading: true,
        dialogTableVisible :false,
        right0:true,right1:true,right2:true,
      }
    },
    created(){
      this.convert();
    },
    methods:{
      Daochu() {
        var xlsxParam = { raw: true };//转换成excel时，使用原始的格式
        var wb = XLSX.utils.table_to_book(document.querySelector("#ssss"),xlsxParam);//outTable为列表id
        var wbout = XLSX.write(wb, {
          bookType: "xlsx",
          bookSST: true,
          type: "array"
        });
        try {
          FileSaver.saveAs(
            new Blob([wbout], { type: "application/octet-stream;charset=utf-8" }),
            "企业表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      convert: function () {
        var _this = this
        this.$axios.get('/Pdd/CompanyMessage/in1').then(resp => {
          if (resp && resp.status === 200) {
            _this.right0= !Boolean(Number(sessionStorage.getItem("right0")));
            _this.right1= !Boolean(Number(sessionStorage.getItem("right1")));
            _this.right2= !Boolean(Number(sessionStorage.getItem("right2")));
            if(!_this.right0)
            {
              _this.tableData1 = resp.data
            }
            var i;
            for (i = 0; i < _this.tableData1.length; i++) {
              if (_this.tableData1[i].verify === 1) {
                _this.tableData1[i].verify = '已审核'
              } else if (_this.tableData1[i].verify === 0) {
                _this.tableData1[i].verify = '未审核'
              }
            }
            _this.loading = false
          }
        })
      },
      subForm() {
        if(this.ruleForm.input1!==''&&this.ruleForm.input2!==''&&this.ruleForm.input3!==''&&this.ruleForm.input4!==''&&this.ruleForm.input5!==''&&this.ruleForm.input6!==null&&this.ruleForm.input7!==''&&this.ruleForm.input8!==null
          &&this.ruleForm.input9!==''&&this.ruleForm.input10!==''&&this.ruleForm.input11!==''){
          this.go1()
        }
        else
        {
          alert('信息输入不全。增加操作，编号.企业名称.地址.征占项目.测量日期.记录人.测量人员.动迁人签字.被动迁人签字.填写日期.填写人必须填写')
        }
      },
      updateForm() {
        if(this.ruleForm.input1!==''){
          this.go2()
        }
        else {
          alert('信息输入不全。修改操作，编号必须填写')
        }
      },
      delForm() {
        if(this.ruleForm.input1!==''){
          this.open();
        }
        else {
          alert('信息输入不全。删除操作，编号必须填写')
        }
      },
      go1(){
        var _this = this
        _this.loading=true
        this.$axios
          .post('/Pdd/CompanyMessage/add1', {
        id:this.ruleForm.input7,
        measuredate:this.ruleForm.input5,
        name:this.ruleForm.input1,
        address:this.ruleForm.input2,
        project:this.ruleForm.input4,
        recorder:this.ruleForm.input3,
        measurer:this.ruleForm.input6,
        autograph:this.ruleForm.input9,
        dautograph:this.ruleForm.input10,
        writedate:this.ruleForm.input8,
        writer:this.ruleForm.input11})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert();
              alert('添加企业成功')

            }
            else if (successResponse.data.code == 400)
            {
              _this.loading=false
              alert('企业已存在')
            }
          })
          .catch(failResponse => {
          })
      },
      go2(){
        var _this = this
        _this.loading=true
        this.$axios
          .post('/Pdd/CompanyMessage/update1', { id:this.ruleForm.input7,
            measuredate:this.ruleForm.input5,
            name:this.ruleForm.input1,
            address:this.ruleForm.input2,
            project:this.ruleForm.input4,
            recorder:this.ruleForm.input3,
            measurer:this.ruleForm.input6,
            autograph:this.ruleForm.input9,
            dautograph:this.ruleForm.input10,
            writedate:this.ruleForm.input8,
            writer:this.ruleForm.input11 })
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert();
              alert('修改企业成功')
            }
            else if (successResponse.data.code == 400)
            {
              _this.loading=false
              alert('企业不存在')
            }
            else if (successResponse.data.code == 401)
            {
              _this.loading=false
              alert('已审核的企业信息不允许修改')
            }
          })
          .catch(failResponse => {
          })
      },
      go3:function(){
        var _this = this
        _this.loading=true
        this.$axios
          .post('/Pdd/CompanyMessage/delete1', { id:this.ruleForm.input7})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert();
              alert('删除企业成功')
            }
            else if (successResponse.data.code == 400)
            {
              _this.loading=false
              alert('企业不存在')
            }
            else if (successResponse.data.code == 401)
            {
              _this.loading=false
              alert('已审核的企业信息不允许删除')
            }
          })
          .catch(failResponse => {
          })
      },
      go4()
      {
        for (let key in this.ruleForm)
        {
          this.ruleForm[key]='';
        }
      },
      open() {
        this.$confirm('此操作将永久删除该企业, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.go3();
        }).catch(() => {
        });
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

