<template >
  <div id="all">
    <el-row type="flex">
      <el-col :span="24">
        <div id="a1">
          <el-table v-loading="loading"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(192,192, 192, 0.8)"
                    :data="books"    border stripe style="width: 100%">
            <el-table-column prop="number" label="用户编号" width="120"></el-table-column>
            <el-table-column prop="username" label="用户姓名" width="120"></el-table-column>
            <el-table-column prop="e_email" label="电子邮件" width="120"></el-table-column>
            <el-table-column prop="depnumber" label="所属部门" width="120"></el-table-column>
            <el-table-column prop="e_gender" label="性别" width="120"></el-table-column>
            <el-table-column prop="e_phone" label="用户电话" width="120"></el-table-column>
            <el-table-column prop="e_birthday" label="出身日期" width="120"></el-table-column>
            <el-table-column prop="e_job" label="职位" width="120"></el-table-column>
            <el-table-column prop="e_remark" label="备注" width="120"></el-table-column>
          </el-table>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
      <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible = true">全局显示</el-button>
      <el-dialog title="用户表" :visible.sync="dialogTableVisible" width="100%">
        <div id="print">
          <el-table :data="books"   border stripe style="width: 100%" id="ssss">
          <el-table-column prop="number" label="用户编号" width="120"></el-table-column>
          <el-table-column prop="username" label="用户姓名" width="120"></el-table-column>
          <el-table-column prop="e_email" label="电子邮件" width="120"></el-table-column>
          <el-table-column prop="depnumber" label="所属部门" width="120"></el-table-column>
          <el-table-column prop="e_gender" label="性别" width="120"></el-table-column>
          <el-table-column prop="e_phone" label="用户电话" width="120"></el-table-column>
          <el-table-column prop="e_birthday" label="出身日期" width="120"></el-table-column>
          <el-table-column prop="e_job" label="职位" width="120"></el-table-column>
          <el-table-column prop="e_remark" label="备注" width="120"></el-table-column>
          </el-table>
        </div>
      </el-dialog>
      </el-col>
      <el-col :span="8">
        <el-button type="text" icon="el-icon-refresh-right" round  @click="convert">刷新</el-button>
      </el-col>
      <el-col :span="8">
        <el-button @click="Daochu" type="text" icon="el-icon-download" round > 导出</el-button>
      </el-col>
    </el-row>
    <el-row >
      <el-col :span="12">
        <el-card  class="box-card">
        <div class="a12">
          <el-form :model="form1" label-position="right" label-width="80px" >
            <span class="login-title" >用户信息</span>
            <div style="margin-top: 5px"></div>
            <el-form-item label="用户编号" class="redItem">
              <el-col :span="20">
                <el-input v-model.number="form1.input1" clearable type="text"
                          placeholder="请输入正整数，例:'1'"
                          @blur="form1.input1=(form1.input1).replace(/[^\d]/g,'');"
                          @keyup.native="form1.input1=(form1.input1).replace(/[^\d]/g,'');" ></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="用户名" class="redItem" >
              <el-col :span="20">
                <el-input v-model="form1.input2" clearable type="text"  maxLength='6'
                          placeholder="请输入数字和英文,不超过6位,例:'admin'"
                          @blur="form1.input2=(form1.input2).replace(/[^a-z0-9]/g,'');"
                          @keyup.native="form1.input2=(form1.input2).replace(/[^a-z0-9]/g,'');" ></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="性别" class="redItem" >
              <el-col :span="20">
                <el-radio v-model="form1.input4" label= 2 border>男</el-radio>
                <el-radio v-model="form1.input4" label= 1 border>女</el-radio>
              </el-col>
            </el-form-item>
            <el-form-item label="出生年月"  >
              <el-col :span="20">
                <el-date-picker type="date" placeholder="选择日期" v-model="form1.input5" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>
            <el-form-item label="用户电话" class="redItem">
              <el-col :span="20">
                <el-input v-model.trim="form1.input6" clearabletype="text"
                          placeholder="请输入电话，例:'18711111111'"
                          @blur="form1.input6=(form1.input6).replace(/[^\d.]/g,'');"
                          @keyup.native="form1.input6=(form1.input6).replace(/[^\d.]/g,'');" ></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="电子邮箱" >
              <el-col :span="20">
                <el-input v-model="form1.input7" clearable type="text"
                          placeholder="请输入邮箱，例:'12345@qq.com'"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="所属部门"  class="redItem">
              <el-col :span="20">
                <el-select v-model="form1.input8" filterable placeholder="请选择">
                  <el-option v-for="item in rest" :key="item.value" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-col>
            </el-form-item>
            <el-form-item label=" 职位"  >
              <el-col :span="20">
                <el-input v-model="form1.input9" clearabletype="text" maxLength='36'
                          placeholder="请输入职位，不超过12个字，例:'测量员'"
                ></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label=" 备注" >
              <el-col :span="20">
                <el-input v-model="form1.input10" clearabletype="text" maxLength='50'
                          placeholder="请输入备注，不超过50个字，例:'新入职'"></el-input>
              </el-col>
            </el-form-item>
          </el-form>
        </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <div id="z">
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row ><el-button :disabled="right1" type="primary" round icon="el-icon-circle-plus-outline" @click="subForm" >添加新用户</el-button>  </el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row ><el-button :disabled="right1" type="success" round icon="el-icon-edit" @click="updateForm">修改用户</el-button>  </el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><el-button :disabled="right2" type="danger" icon="el-icon-delete"round @click="delForm">删除用户</el-button>  </el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><span ></span></el-row>
          <el-row><el-button type="info"  icon="el-icon-s-home" round @click="go4">取消</el-button>  </el-row>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
  import XLSX from 'xlsx'
  import FileSaver from 'file-saver'
  //# sourceMappingURL=file.js.map
  export default {
    data() {
      return {
        form1: {
          input1: '',
          input2: '',
          input4: '',
          input5: '',
          input6: '',
          input7: '',
          input8:'',
          input9: '',
          input10: ''
        },
        options: [{value: 1, label: "开发部"}, {value: 2, label: "宣传部"}],
        rest:[],
        books: [],
        loading: true,
        dialogTableVisible: false,
        right0:true,right1:true,right2:true,
      }
      },
    created(){
      this.convert();
    },
    methods: {
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
            "用户表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      subForm() {
        if(this.form1.input1!==''&&this.form1.input2!==''&&this.form1.input4!==''&&this.form1.input6!==''&&this.form1.input8!==''){
          this.go1()
        }
        else
        {
          alert('信息输入不全。增加操作，编号.姓名.性别.电话.部门 必须填写')
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
        this.$axios.get('/Pdd/in').then(resp => {
          if (resp && resp.status === 200) {
            _this.right0= !Boolean(Number(sessionStorage.getItem("right0")));
            _this.right1= !Boolean(Number(sessionStorage.getItem("right1")));
            _this.right2= !Boolean(Number(sessionStorage.getItem("right2")));
            if(!_this.right0)
            {
              _this.books = resp.data
            }
            var i;
            for (i = 0; i <  _this.books.length; i++) {
              if( _this.books[i].e_gender===2) {
                _this.books[i].e_gender='男'
              }
              else if( _this.books[i].e_gender===1){
                _this.books[i].e_gender='女'
              }
            }
            _this.loading=false
          }
        })
        this.convert2();
      },
      convert2: function () {
        var _this = this
        this.$axios.get('/Pdd/getdep').then(resp => {
          if (resp && resp.status === 200) {
            _this.rest= resp.data
            }
        })
      },
      go1(){
        var _this = this
        _this.loading=true
        this.$axios
          .post('/Pdd/add', { number:this.form1.input1,
            username:this.form1.input2,
            e_email:this.form1.input7,
            depnumber:this.form1.input8,
            e_gender:this.form1.input4,
            e_phone:this.form1.input6,
            e_birthday:this.form1.input5,
            e_remark :this.form1.input10,
            e_job:this.form1.input9})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert();
              alert('添加成功')

            }
            else if (successResponse.data.code == 400)
            {
              _this.loading=false
              alert('用户编号已存在')
            }
            else if (successResponse.data.code == 401)
            {
              _this.loading=false
              alert('用户名已存在')
            }
          })
          .catch(failResponse => {
          })
      },
      go2(){
        var _this = this
        _this.loading=true
        this.$axios
          .post('/Pdd/update', { number:this.form1.input1,
            username :this.form1.input2,
            e_email:this.form1.input7,
            depnumber:this.form1.input8,
            e_gender:this.form1.input4,
            e_phone:this.form1.input6,
            e_birthday:this.form1.input5,
            e_remark :this.form1.input10,
            e_job:this.form1.input9})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert();
              alert('修改成功')
            }
            else if (successResponse.data.code == 400)
            {
              _this.loading=false
              alert('用户不存在')
            }
          })
          .catch(failResponse => {
          })
      },
      go3:function(){
        var _this = this
        _this.loading=true
        this.$axios
          .post('/Pdd/delete', { number:this.form1.input1})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert();
              alert('删除成功')
            }
            else if (successResponse.data.code == 400)
            {
              _this.loading=false
              alert('用户不存在')
            }
          })
          .catch(failResponse => {
          })
      },
      open() {
        this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
         this.go3();
        }).catch(() => {
        });
      },
      go4()
      {
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
