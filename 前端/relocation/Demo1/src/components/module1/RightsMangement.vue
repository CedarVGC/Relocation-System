<template>
  <div id="all">
    <el-row >
          <el-table v-loading="loading1"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(192,192, 192, 0.8)"
                    :data="tableData1"  border stripe style="width: 100%">
            <el-table-column prop="id" label="用户编号" width="180">
            </el-table-column>
            <el-table-column prop="name" label="用户姓名" width="180">
            </el-table-column>
            <el-table-column prop="dep" label="所属部门编号" width="180">
            </el-table-column>
            <el-table-column prop="right0" label="查看" width="180">
            </el-table-column>
            <el-table-column prop="right1" label="编辑" width="180">
            </el-table-column>
            <el-table-column prop="right2" label="删除" width="180">
            </el-table-column>
            <el-table-column prop="right3" label="审核" width="180">
            </el-table-column>
            <el-table-column prop="right4" label="权限分配" width="180">
            </el-table-column>
          </el-table>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible1 = true">全局显示</el-button>
        <el-dialog :visible.sync="dialogTableVisible1" width="100%">
          <el-table :data="tableData1"  border stripe style="width: 100%" id="ssss">
            <el-table-column prop="id" label="用户编号" width="120">
            </el-table-column>
            <el-table-column prop="name" label="用户姓名" width="120">
            </el-table-column>
            <el-table-column prop="dep" label="所属部门" width="120">
            </el-table-column>
            <el-table-column prop="right0" label="查看" width="120">
            </el-table-column>
            <el-table-column prop="right1" label="编辑" width="120">
            </el-table-column>
            <el-table-column prop="right2" label="删除" width="120">
            </el-table-column>
            <el-table-column prop="right3" label="审核" width="120">
            </el-table-column>
            <el-table-column prop="right4" label="权限分配" width="120">
            </el-table-column>
          </el-table>
        </el-dialog>
      </el-col>
      <el-col :span="8">
        <el-button  type="text" icon="el-icon-refresh-right" round @click="convert1">刷新</el-button>
      </el-col>
      <el-col :span="8">
        <el-button @click="Daochu1" type="text" icon="el-icon-download" round > 导出</el-button>
      </el-col>
    </el-row>
    <el-row >
      <el-col :span="12">
        <el-card  class="box-card">
        <div class="a12">
          <el-form :model="form1" label-position="right" label-width="80px" >
            <span class="login-title">权限信息</span>
            <div style="margin-top: 5px"></div>
            <el-form-item label=" 用户编号" class="redItem">
              <el-col :span="20">
                <el-input v-model="form1.input1" clearable type="text"
                          placeholder="请输入正整数，例:'1'"
                          @blur="form1.input1=(form1.input1).replace(/[^\d]/g,'');"
                          @keyup.native="form1.input1=(form1.input1).replace(/[^\d]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="信息权限" >
              <el-col :span="20">
                <el-checkbox-group v-model="checkList1">
                  <el-checkbox label="浏览"  border></el-checkbox>
                  <el-checkbox label="编辑"  border></el-checkbox>
                  <el-checkbox label="删除"  border></el-checkbox>
                </el-checkbox-group>
              </el-col>
            </el-form-item>
            <el-form-item label="管理权限" >
              <el-col :span="20">
                <el-checkbox-group v-model="checkList1">
                <el-checkbox label="审核"  border></el-checkbox>
                  <el-checkbox label="权限分配"  border></el-checkbox>
                </el-checkbox-group>
              </el-col>
            </el-form-item>
          </el-form>
        </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <div class="a13 ">
          <el-row><span ></span></el-row>
          <el-row ><el-button :disabled="right4" type="primary" @click="subForm1" round icon="el-icon-edit">分配用户权</el-button>  </el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><el-button type="info" round @click="go4" icon="el-icon-s-home">取消</el-button>  </el-row>
        </div>
      </el-col>
    </el-row>
    <el-row >
      <el-table v-loading="loading2"
                element-loading-text="拼命加载中"
                element-loading-spinner="el-icon-loading"
                element-loading-background="rgba(192,192, 192, 0.8)"
                :data="tableData2"  border stripe style="width: 100%">
        <el-table-column prop="id" label="部门编号" width="180">
        </el-table-column>
        <el-table-column prop="name" label=" 部门名称" width="180">
        </el-table-column>
        <el-table-column prop="right0" label="查看" width="180">
        </el-table-column>
        <el-table-column prop="right1" label="编辑" width="180">
        </el-table-column>
        <el-table-column prop="right2" label="删除" width="180">
        </el-table-column>
        <el-table-column prop="right3" label="审核" width="180">
        </el-table-column>
        <el-table-column prop="right4" label="权限分配" width="180">
        </el-table-column>
      </el-table>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible2 = true">全局显示</el-button>
        <el-dialog :visible.sync="dialogTableVisible2" width="100%">
          <el-table :data="tableData2"  border stripe style="width: 100%" id="tttt">
            <el-table-column prop="id" label="部门编号" width="120">
            </el-table-column>
            <el-table-column prop="name" label="部门名称" width="120">
            </el-table-column>
            <el-table-column prop="right0" label="查看" width="120">
            </el-table-column>
            <el-table-column prop="right1" label="编辑" width="120">
            </el-table-column>
            <el-table-column prop="right2" label="删除" width="120">
            </el-table-column>
            <el-table-column prop="right3" label="审核" width="120">
            </el-table-column>
            <el-table-column prop="right4" label="权限分配" width="120">
            </el-table-column>
          </el-table>
        </el-dialog>
      </el-col>
      <el-col :span="8">
        <el-button type="text" icon="el-icon-refresh-right" round @click="convert2">刷新</el-button>
      </el-col>
      <el-col :span="8">
        <el-button @click="Daochu2" type="text" icon="el-icon-download" round > 导出</el-button>
      </el-col>
    </el-row>
    <el-row >
      <el-col :span="12">
        <el-card  class="box-card">
          <div class="a12">
            <el-form :model="form2" label-position="right" label-width="80px" >
              <span class="login-title">权限信息</span>
              <div style="margin-top: 5px"></div>
              <el-form-item label=" 部门编号" class="redItem">
                <el-col :span="20">
                  <el-input v-model="form2.input1" clearable type="text"
                            placeholder="请输入正整数，例:'1'"
                            @blur="form2.input1=(form2.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form2.input1=(form2.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col>
              </el-form-item>
              <el-form-item label="信息权限" >
                <el-col :span="20">
                  <el-checkbox-group v-model="checkList2">
                    <el-checkbox label="浏览"  border></el-checkbox>
                    <el-checkbox label="编辑"  border></el-checkbox>
                    <el-checkbox label="删除"  border></el-checkbox>
                  </el-checkbox-group>
                </el-col>
              </el-form-item>
              <el-form-item label="管理权限" >
                <el-col :span="20">
                  <el-checkbox-group v-model="checkList2">
                    <el-checkbox label="审核"  border></el-checkbox>
                    <el-checkbox label="权限分配"  border></el-checkbox>
                  </el-checkbox-group>
                </el-col>
              </el-form-item>
            </el-form>
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <div class="a13 ">
          <el-row><span ></span></el-row>
          <el-row ><el-button  :disabled="right4" type="primary" @click="subForm2" round icon="el-icon-edit">分配部门权</el-button>  </el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><el-button type="info" round @click="go5" icon="el-icon-s-home">取消</el-button>  </el-row>
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
        form1:{input1:''},
        checkList1: [],
        loading1:true,dialogTableVisible1:false,
        tableData1:[],
        form2:{input1:''},
        checkList2: [],
        loading2:true,dialogTableVisible2:false,
        tableData2:[],
        right0:true,right4:true,
      }
    },
    created(){
      this.convert1();
      this.convert2();
    },
    methods: {
      Daochu1() {
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
            "用户权限表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      Daochu2() {
        var xlsxParam = { raw: true };//转换成excel时，使用原始的格式
        var wb = XLSX.utils.table_to_book(document.querySelector("#tttt"),xlsxParam);//outTable为列表id
        var wbout = XLSX.write(wb, {
          bookType: "xlsx",
          bookSST: true,
          type: "array"
        });
        try {
          FileSaver.saveAs(
            new Blob([wbout], { type: "application/octet-stream;charset=utf-8" }),
            "部门权限表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      convert1: function () {
        var _this = this
        this.$axios.get('/Pdd/RightsMangement/in').then(resp => {
          if (resp && resp.status === 200) {
            _this.right0= !Boolean(Number(sessionStorage.getItem("right0")));
            _this.right4= !Boolean(Number(sessionStorage.getItem("right4")));
            if (!_this.right0)
            {
              _this.tableData1=resp.data
            }
            _this.loading1=false
          }
        })
      },
      convert2: function () {
        var _this = this
        this.$axios.get('/Pdd/RightsMangement/in2').then(resp => {
          if (resp && resp.status === 200) {
            _this.right0= !Boolean(Number(sessionStorage.getItem("right0")));
            _this.right4= !Boolean(Number(sessionStorage.getItem("right4")));
            if (!_this.right0)
            {
              _this.tableData2=resp.data
            }
            _this.loading2=false
          }
        })
      },
      subForm1() {
        if(this.form1.input1!==''){
          this.go1()
        }
        else
        {
          alert('信息输入不全。编号必须填写')
        }
      },
      subForm2() {
        if(this.form2.input1!==''){
          this.go3()
        }
        else
        {
          alert('信息输入不全。编号必须填写')
        }
      },
      go1(){
        var _this = this
        var res={id:this.form1.input1}
        for (var i=0;i<_this.checkList1.length;i++)
        {
            switch (_this.checkList1[i])
            {
              case '浏览':
                res["right0"]='是';
                break;
              case '编辑':
                res["right1"]='是';
                break;
              case '删除':
                res["right2"]='是';
                break;
              case '审核':
                res["right3"]='是';
                break;
              case '权限分配':
                res["right4"]='是';
                break;
            }
        }
        this.$axios
          .post('/Pdd/RightsMangement/update', res)
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              alert('添加权限成功')

            }
            else if (successResponse.data.code == 400)
            {
              alert('用户不存在')
            }
            else if (successResponse.data.code == 401)
            {
              alert('该职工所属部门权限不够')
            }
          })
          .catch(failResponse => {
          })
      },
      go3(){
        var _this = this
        var res={id:this.form2.input1}
        for (var i=0;i<_this.checkList2.length;i++)
        {
          switch (_this.checkList2[i])
          {
            case '浏览':
              res["right0"]='是';
              break;
            case '编辑':
              res["right1"]='是';
              break;
            case '删除':
              res["right2"]='是';
              break;
            case '审核':
              res["right3"]='是';
              break;
            case '权限分配':
              res["right4"]='是';
              break;
          }
        }
        this.$axios
          .post('/Pdd/RightsMangement/update2', res)
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              alert('添加权限成功')

            }
            else if (successResponse.data.code == 400)
            {
              alert('部门不存在')
            }
          })
          .catch(failResponse => {
          })
      },
      go4() {
        for (let key in this.form1)
        {
          this.form1[key]='';
        }
        this.checkList1=[]
      },
      go5() {
        for (let key in this.form2)
        {
          this.form1[key]='';
        }
        this.checkList2=[]
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

