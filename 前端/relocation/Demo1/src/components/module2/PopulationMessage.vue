<template>
  <div id="all">
    <el-row>
      <el-col :span="12">
        <el-card class="box-card">
        <el-row type="flex"><span>户主信息</span></el-row>
        <el-row>
          <el-card class="box-card">
          <el-row type="flex"><span>动迁人口登记表</span></el-row>
          <el-row>
          <el-table v-loading="loading1"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(192,192, 192, 0.8)"
                    :data="tableData1"  border stripe style="width: 100%">
            <el-table-column prop="id" label="编号" width="120"></el-table-column>
            <el-table-column prop="name" label="户主姓名" width="120"></el-table-column>
            <el-table-column prop="address" label="地址" width="120"></el-table-column>
            <el-table-column prop="registerdate" label="登记日期" width="120"></el-table-column>
            <el-table-column prop="remark" label="需说明事项" width="120"></el-table-column>
            <el-table-column prop="autograph" label="户主签字" width="120"></el-table-column>
            <el-table-column prop="head" label="负责人" width="120"></el-table-column>
            <el-table-column prop="agent" label="经办人" width="120"></el-table-column>
            <el-table-column prop="writedate" label="填表日期" width="120"></el-table-column>
            <el-table-column prop="preparer" label="添表人" width="120"></el-table-column>
            <el-table-column prop="verify" label="审核情况" width="120"></el-table-column>
          </el-table>
          </el-row>
          </el-card>
        </el-row>
          <el-row>
            <el-col :span="8">
            <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible1 = true">全局显示</el-button>
            <el-dialog title="动迁人口登记表" :visible.sync="dialogTableVisible1" width="100%">
              <el-table :data="tableData1"  border stripe style="width: 100%" id="ssss">
                <el-table-column prop="id" label="编号" width="120"></el-table-column>
                <el-table-column prop="name" label="户主姓名" width="120"></el-table-column>
                <el-table-column prop="address" label="地址" width="120"></el-table-column>
                <el-table-column prop="registerdate" label="登记日期" width="120"></el-table-column>
                <el-table-column prop="remark" label="需说明事项" width="120"></el-table-column>
                <el-table-column prop="autograph" label="户主签字" width="120"></el-table-column>
                <el-table-column prop="head" label="负责人" width="120"></el-table-column>
                <el-table-column prop="agent" label="经办人" width="120"></el-table-column>
                <el-table-column prop="writedate" label="填表日期" width="120"></el-table-column>
                <el-table-column prop="preparer" label="添表人" width="120"></el-table-column>
                <el-table-column prop="verify" label="审核情况" width="120"></el-table-column>
              </el-table>
            </el-dialog>
            </el-col>
            <el-col :span="8">
              <el-button type="text" icon="el-icon-refresh-right" round @click="convert1">刷新</el-button>
            </el-col>
            <el-col :span="8">
              <el-button @click="Daochu1" type="text" icon="el-icon-download" round > 导出</el-button>
            </el-col>
          </el-row>
        <el-row>
          <el-card class="box-card">
          <el-form :model="form1"  label-position="right" label-width="140px" >
            <el-form-item label="编号" class="redItem">
              <el-col :span="16">
                <el-input v-model.number="form1.input1" clearable type="text"
                          placeholder="请输入正整数，例:'1'"
                          @blur="form1.input1=(form1.input1).replace(/[^\d]/g,'');"
                          @keyup.native="form1.input1=(form1.input1).replace(/[^\d]/g,'');" ></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="户主姓名" class="redItem">
              <el-col :span="16">
                <el-input v-model="form1.input2" clearable type="text"
                          maxLength='5'
                          placeholder="请输入户主姓名,不超过5个字，例:'王一飞'"
                          @blur="form1.input2=(form1.input2).replace(/[^\u4e00-\u9fa5]/g,'');"
                          @keyup.native="form1.input2=(form1.input2).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="地址" class="redItem">
              <el-col :span="16">
                <el-input v-model="form1.input3" clearable type="text"
                          maxLength='20'
                          placeholder="请输入地址,不超过20个字，例:'王家村'" ></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="登记日期" class="redItem">
              <el-col :span="16">
                <el-date-picker type="date" placeholder="选择日期" v-model="form1.input4" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>
            <el-form-item label="备注">
              <el-col :span="16">
                <el-input v-model="form1.input5" clearable type="textarea"
                          maxLength='50'
                          placeholder="请输入备注,不超过50个字，例:'村长'" ></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="户主签字" class="redItem">
              <el-col :span="16">
                <el-input v-model="form1.input6" clearabletype="text"
                          maxLength='5'
                          placeholder="请输入户主签字,不超过5个字，例:'王一飞'"
                          @blur="form1.input6=(form1.input6).replace(/[^\u4e00-\u9fa5]/g,'');"
                          @keyup.native="form1.input6=(form1.input6).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="负责人" class="redItem">
              <el-col :span="16">
                <el-input v-model="form1.input7" clearabletype="text"
                          maxLength='5'
                          placeholder="请输入负责人姓名,不超过5个字，例:'王一飞'"
                          @blur="form1.input7=(form1.input7).replace(/[^\u4e00-\u9fa5]/g,'');"
                          @keyup.native="form1.input7=(form1.input7).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="经办人" class="redItem">
              <el-col :span="16">
                <el-input v-model="form1.input8" clearable type="text"
                          maxLength='5'
                          placeholder="请输入经办人姓名,不超过5个字，例:'王一飞'"
                          @blur="form1.input8=(form1.input8).replace(/[^\u4e00-\u9fa5]/g,'');"
                          @keyup.native="form1.input8=(form1.input8).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="填表日期" class="redItem">
              <el-col :span="16">
                <el-date-picker type="date" placeholder="选择日期" v-model="form1.input9" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>
            <el-form-item label="添表人" class="redItem">
            <el-col :span="16">
              <el-input v-model="form1.input10" clearabletype="text"
                        maxLength='5'
                        placeholder="请输入添表人姓名,不超过5个字，例:'王一飞'"
                        @blur="form1.input10=(form1.input10).replace(/[^\u4e00-\u9fa5]/g,'');"
                        @keyup.native="form1.input10=(form1.input10).replace(/[^\u4e00-\u9fa5]/g,'');" ></el-input>
            </el-col>
            </el-form-item>
            <el-form-item >
            <el-button :disabled="right1" type="primary" round icon="el-icon-circle-plus-outline" @click="SubForm1">添加人口信息</el-button>
              <el-button :disabled="right1" type="success" round icon="el-icon-edit" @click="updateForm1">修改人口信息</el-button>
              <el-button :disabled="right2" type="danger" round icon="el-icon-delete" @click="delForm1">删除人口信息</el-button>
            </el-form-item>
          </el-form>
          </el-card>
        </el-row>
        </el-card>
      </el-col>
      <el-col :span="12"><!--右块1-->
        <el-card class="box-card">
        <el-row type="flex"><span>户主信息明细</span></el-row>
        <el-row>
          <el-card class="box-card">
          <el-row type="flex"><span>动迁人口明细登记表</span></el-row>
          <el-row>
          <el-table v-loading="loading2"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(192,192, 192, 0.8)"
                    :data="tableData2" border stripe style="width: 100%">
            <el-table-column prop="id" label="编号" width="120"></el-table-column>
            <el-table-column prop="mainid" label="户主编号" width="120"></el-table-column>
            <el-table-column prop="name" label="姓名" width="120"></el-table-column>
            <el-table-column prop="relationship" label="与户主关系" width="120"></el-table-column>
            <el-table-column prop="gender" label="性别" width="120"></el-table-column>
            <el-table-column prop="onlychild" label="是否是独生子女" width="120"></el-table-column>
            <el-table-column prop="birthday" label="出身年月日" width="120"></el-table-column>
            <el-table-column prop="residencefrom" label="户口本发证派出所" width="120"></el-table-column>
            <el-table-column prop="residenceid" label="户口本户口编号" width="120"></el-table-column>
            <el-table-column prop="residencedate" label="户口本立户时间" width="120"></el-table-column>
            <el-table-column prop="marryfrom" label="结婚证发证机关" width="120"></el-table-column>
            <el-table-column prop="marryid" label="结婚证编号" width="120"></el-table-column>
            <el-table-column prop="marrydate" label="结婚证登记时间" width="120"></el-table-column>
            <el-table-column prop="remark" label="备注" width="120"></el-table-column>
            <el-table-column prop="verify" label="审核情况" width="120"></el-table-column>
          </el-table>
          </el-row>
          </el-card>
        </el-row>
          <el-row>
            <el-col :span="8">
            <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible2 = true">全局显示</el-button>
            <el-dialog title="动迁人口登记明细表" :visible.sync="dialogTableVisible2" width="100%">
              <el-table :data="tableData2" border stripe style="width: 100%" id="tttt">
                <el-table-column prop="id" label="编号" width="120"></el-table-column>
                <el-table-column prop="mainid" label="户主编号" width="120"></el-table-column>
                <el-table-column prop="name" label="姓名" width="120"></el-table-column>
                <el-table-column prop="relationship" label="与户主关系" width="120"></el-table-column>
                <el-table-column prop="gender" label="性别" width="120"></el-table-column>
                <el-table-column prop="onlychild" label="是否是独生子女" width="120"></el-table-column>
                <el-table-column prop="birthday" label="出身年月日" width="120"></el-table-column>
                <el-table-column prop="residencefrom" label="户口本发证派出所" width="120"></el-table-column>
                <el-table-column prop="residenceid" label="户口本户口编号" width="120"></el-table-column>
                <el-table-column prop="residencedate" label="户口本立户时间" width="120"></el-table-column>
                <el-table-column prop="marryfrom" label="结婚证发证机关" width="120"></el-table-column>
                <el-table-column prop="marryid" label="结婚证编号" width="120"></el-table-column>
                <el-table-column prop="marrydate" label="结婚证登记时间" width="120"></el-table-column>
                <el-table-column prop="remark" label="备注" width="120"></el-table-column>
                <el-table-column prop="verify" label="审核情况" width="120"></el-table-column>
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
        <el-row>
          <el-card class="box-card">
          <el-form :model="form2" label-position="right" label-width="140px" >
            <el-form-item label="编号" class="redItem">
              <el-col :span="20">
                <el-input v-model="form2.input1" clearable type="text"
                          placeholder="请输入正整数，例:'1'"
                          @blur="form2.input1=(form2.input1).replace(/[^\d]/g,'');"
                          @keyup.native="form2.input1=(form2.input1).replace(/[^\d]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="户主编号" class="redItem">
              <el-col :span="20">
                <el-input v-model="form2.input2" clearable type="text"
                          placeholder="请输入正整数，例:'1'"
                          @blur="form2.input2=(form2.input2).replace(/[^\d]/g,'');"
                          @keyup.native="form2.input2=(form2.input2).replace(/[^\d]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="姓名" class="redItem">
              <el-col :span="20">
                <el-input v-model="form2.input3" clearable type="text"
                          maxLength='5'
                          placeholder="请输入姓名,不超过5个字，例:'王一飞'"
                          @blur="form2.input3=(form2.input3).replace(/[^\u4e00-\u9fa5]/g,'');"
                          @keyup.native="form2.input3=(form2.input3).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="与户主关系" class="redItem">
              <el-col :span="20">
                <el-select v-model="form2.input4" filterable placeholder="请选择">
                  <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-col>
            </el-form-item>
            <el-form-item label="性别" class="redItem">
              <el-col :span="20">
                <el-radio v-model="form2.input5" label=2 border>男</el-radio>
                <el-radio v-model="form2.input5" label=1 border>女</el-radio>
              </el-col>
            </el-form-item>
            <el-form-item label="是否是独生子女" class="redItem">
              <el-col :span="20">
                <el-radio v-model="form2.input6" label=1 border>独生子女</el-radio>
                <el-radio v-model="form2.input6" label=2 border>非独生子女</el-radio>
              </el-col>
            </el-form-item>
            <el-form-item label="出生年月日" class="redItem">
            <el-col :span="20">
              <el-date-picker type="date" placeholder="选择日期" v-model="form2.input7" style="width: 100%;"></el-date-picker>
            </el-col>
            </el-form-item>
            <el-form-item label="户口本发证派出所" class="redItem">
              <el-col :span="20">
                <el-input v-model="form2.input8" clearable type="text"
                          maxLength='20'
                          placeholder="请输入派出所名称，例:'辽宁省大连市开发区派出所'"
                          @blur="form2.input8=(form2.input8).replace(/[^\u4e00-\u9fa5]/g,'');"
                          @keyup.native="form2.input8=(form2.input8).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="户口本户口编号" class="redItem">
              <el-col :span="20">
                <el-input v-model="form2.input9" clearable type="text"
                          placeholder="请输入户口本户口编号，例:'111222202004013333'"
                          @blur="form2.input9=(form2.input9).replace(/[^\d]/g,'');"
                          @keyup.native="form2.input9=(form2.input9).replace(/[^\d]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="户口本立户时间" class="redItem">
              <el-col :span="20">
                <el-date-picker type="date" placeholder="选择日期" v-model="form2.input10" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>
            <el-form-item label="结婚证发证机关">
              <el-col :span="20">
                <el-input v-model="form2.input11" clearable type="text"
                          maxLength='20'
                          placeholder="请输入发证机关名称，例:'辽宁省大连市开发区民政局'"
                          @blur="form2.input11=(form2.input11).replace(/[^\u4e00-\u9fa5]/g,'');"
                          @keyup.native="form2.input11=(form2.input11).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="结婚证编号" >
              <el-col :span="20">
                <el-input v-model="form2.input12" clearabletype="text"
                          placeholder="请输入结婚证编号，例:'111222202004013333'"
                          @blur="form2.input12=(form2.input12).replace(/[^\d]/g,'');"
                          @keyup.native="form2.input12=(form2.input12).replace(/[^\d]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="结婚证登记时间" >
              <el-col :span="20">
                <el-date-picker type="date" placeholder="选择日期" v-model="form2.input13" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>
            <el-form-item label="备注" >
              <el-col :span="20">
                <el-input v-model="form2.input14" clearabletype="text"
                          maxLength='50'
                          placeholder="请输入备注，不超过50个字，例:'长子'"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item >
              <el-button :disabled="right1" type="primary" round icon="el-icon-circle-plus-outline" @click="SubForm2">添加明细信息</el-button>
              <el-button :disabled="right1" type="success" round icon="el-icon-edit" @click="updateForm2">修改明细信息</el-button>
              <el-button :disabled="right2" type="danger" round icon="el-icon-delete" @click="delForm2">删除明细信息</el-button>
            </el-form-item>
          </el-form>
          </el-card>
        </el-row>
        </el-card>
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
        form1:{input1:'', input2:'',input3:'',input4:'', input5:'',input6:'',input8:'',input9:'',input10:''},
        form2:{input1:'',input2:'',input3:'',input4:'', input5:'',input6:'',input8:'',input9:'',input10:'',input11:'',input12:'', input13:'',input14:'',},
        options: [{value: '父子', label: '父子'}, {value: '父女', label: '父女'},{value: '母子', label: '母子'},{value: '母女', label: '母女'}],
        tableData1: [], tableData2: [],
        loading1: true, dialogTableVisible1:false,
        loading2: true,dialogTableVisible2:false,
        right0:true,right1:true,right2:true,
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
            "户主表.xlsx"
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
            "明细户主表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      SubForm1()
      {
        if(this.form1.input1!==''&&this.form1.input2!==''&&this.form1.input3!==''&&this.form1.input4!==null&&this.form1.input6!==''&&this.form1.input7!==''&&this.form1.input8!==''&&this.form1.input9!==null&&this.form1.input10!==''){
          this.go1()
        }
        else {
          alert('信息输入不全，增加操作，编号.户主姓名.地址.登记日期.户主签字.负责人.经办人.填表日期.添表人 必须填写')
        }
      },
      SubForm2()
      {
        if(this.form2.input1!==''&&this.form2.input2!==''&&this.form2.input3!==''&&this.form2.input4!==''&&this.form2.input5!==''&&this.form2.input6!==''&&this.form2.input7!==null&&this.form2.input8!==''&&this.form2.input9!==''&&this.form2.input10!==null){
          this.go4()
        }
        else
        {
          alert('信息输入不全,增加操作，编号.户主编号.姓名.与户主关系.性别.是否是独生子女.出生年月日.户口本发证派出所.户口本户口编号.户口本立户时间 必须填写')
        }
      },
      updateForm1() {
        if(this.form1.input1!==''){
          this.go2()
        }
        else {
          alert('信息输入不全。修改操作，编号必须填写')
        }
      },
      updateForm2() {
        if(this.form2.input1!==''&&this.form2.input2!==''){
          this.go5()
        }
        else {
          alert('信息输入不全。修改操作，编号.户主编号必须填写')
        }
      },
      delForm1() {
        if(this.form1.input1!==''){
          this.open1();
        }
        else {
          alert('信息输入不全。删除操作，编号必须填写')
        }
      },
      delForm2() {
        if(this.form2.input1!==''){
          this.open2();
        }
        else {
          alert('信息输入不全。删除操作，编号必须填写')
        }
      },
      convert1: function () {
        var _this = this
        this.$axios.get('/Pdd/PopulationMessage/in1').then(resp => {
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
              if( _this.tableData1[i].verify===1) {
                _this.tableData1[i].verify='已审核'
              }
              else if( _this.tableData1[i].verify===0){
                _this.tableData1[i].verify='未审核'
              }
            }
            _this.loading1=false
          }
        })

      },
      convert2: function () {
        var _this = this
        this.$axios.get('/Pdd/PopulationMessage/in2').then(resp => {
          if (resp && resp.status === 200) {
            _this.right0= !Boolean(Number(sessionStorage.getItem("right0")));
            _this.right1= !Boolean(Number(sessionStorage.getItem("right1")));
            _this.right2= !Boolean(Number(sessionStorage.getItem("right2")));
            if(!_this.right0)
            {
              _this.tableData2= resp.data
            }
            var i;
            for (i = 0; i < _this.tableData2.length; i++) {
              if( _this.tableData2[i].gender===2) {
                _this.tableData2[i].gender='男'
              }
              else if( _this.tableData2[i].gender===1){
                _this.tableData2[i].gender='女'
              }
              if( _this.tableData2[i].onlychild===1) {
                _this.tableData2[i].onlychild='独生子女'
              }
              else if( _this.tableData2[i].onlychild===2){
                _this.tableData2[i].onlychild='非独生子女'
              }
              if( _this.tableData2[i].verify===1) {
                _this.tableData2[i].verify='已审核'
              }
              else if( _this.tableData2[i].verify===0){
                _this.tableData2[i].verify='未审核'
              }
            }
            _this.loading2=false
          }
        })
      },
      go1(){
        var _this = this
        _this.loading1=true
        this.$axios
          .post('/Pdd/PopulationMessage/add1', {
            id:this.form1.input1,
            name:this.form1.input2,
            address:this.form1.input3,
            registerdate:this.form1.input4,
            remark:this.form1.input5,
            autograph:this.form1.input6,
            head:this.form1.input7,
            agent:this.form1.input8,
            writedate:this.form1.input9,
            preparer:this.form1.input10})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert1();
              alert('添加户主成功')

            }
            else if (successResponse.data.code == 400)
            {
              _this.loading1=false
              alert('户主已存在')
            }
          })
          .catch(failResponse => {
          })
      },
      go2(){
        var _this = this
        _this.loading1=true
        this.$axios
          .post('/Pdd/PopulationMessage/update1', {
            id:this.form1.input1,
            name:this.form1.input2,
            address:this.form1.input3,
            registerdate:this.form1.input4,
            remark:this.form1.input5,
            autograph:this.form1.input6,
            head:this.form1.input7,
            agent:this.form1.input8,
            writedate:this.form1.input9,
            preparer:this.form1.input10})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert1();
              alert('修改户主成功')
            }
            else if (successResponse.data.code == 400)
            {
              _this.loading1=false
              alert('户主不存在')
            }
            else if (successResponse.data.code == 401)
            {
              _this.loading1=false
              alert('已审核的户主信息不允许修改')
            }
          })
          .catch(failResponse => {
          })
      },
      go3(){
        var _this = this
        _this.loading1=true
        this.$axios
          .post('/Pdd/PopulationMessage/delete1', { id:this.form1.input1})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert1();
              alert('删除户主成功')
            }
            else if (successResponse.data.code == 400)
            {
              _this.loading1=false
              alert('户主不存在')
            }
            else if (successResponse.data.code == 401)
            {
              _this.loading1=false
              alert('已审核的户主信息不允许删除')
            }
          })
          .catch(failResponse => {
          })
      },
      go4(){
        var _this = this
        _this.loading2=true
        this.$axios
          .post('/Pdd/PopulationMessage/add2', {
            id:this.form2.input1,
            mainid:this.form2.input2,
            name:this.form2.input3,
            relationship:this.form2.input4,
            gender:this.form2.input5,
            onlychild:this.form2.input6,
            birthday:this.form2.input7,
            residencefrom:this.form2.input8,
            residenceid:this.form2.input9,
            residencedate:this.form2.input10,
            marryfrom:this.form2.input11,
            marryid:this.form2.input12,
            marrydate:this.form2.input13,
            remark:this.form2.input14})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert2();
              alert('添加明细户主成功')

            }
            else if (successResponse.data.code == 400)
            {
              _this.loading2=false
              alert('明细户主已存在')
            }
            else if (successResponse.data.code == 401)
            {
              _this.loading2=false
              alert('户主不存在')
            }
          })
          .catch(failResponse => {
          })
      },
      go5(){
        var _this = this
        _this.loading2=true
        this.$axios
          .post('/Pdd/PopulationMessage/update2', {
            id:this.form2.input1,
            mainid:this.form2.input2,
            name:this.form2.input3,
            relationship:this.form2.input4,
            gender:this.form2.input5,
            onlychild:this.form2.input6,
            birthday:this.form2.input7,
            residencefrom:this.form2.input8,
            residenceid:this.form2.input9,
            residencedate:this.form2.input10,
            marryfrom:this.form2.input11,
            marryid:this.form2.input12,
            marrydate:this.form2.input13,
            remark:this.form2.input14})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert2();
              alert('修改明细户主成功')
            }
            else if (successResponse.data.code == 400)
            {
              _this.loading2=false
              alert('明细户主不存在')
            }
            else if (successResponse.data.code == 401)
            {
              _this.loading2=false
              alert('已审核的户主信息不允许修改')
            }
            else if (successResponse.data.code == 402)
            {
              _this.loading2=false
              alert('户主不存在')
            }
          })
          .catch(failResponse => {
          })
      },
      go6(){
        var _this = this
        _this.loading2=true
        this.$axios
          .post('/Pdd/PopulationMessage/delete2', { id:this.form2.input1})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert2();
              alert('删除明细户主成功')
            }
            else if (successResponse.data.code == 400)
            {
              _this.loading2=false
              alert('明细户主不存在')
            }
            else if (successResponse.data.code == 401)
            {
              _this.loading2=false
              alert('已审核的明细户主信息不允许删除')
            }
          })
          .catch(failResponse => {
          })
      },
      open1() {
        this.$confirm('此操作将永久删除该户主, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.go3();
        }).catch(() => {
        });
      },
      open2() {
        this.$confirm('此操作将永久删除该明细户主, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.go6();
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
