<template>
  <div id="all">
    <el-row >
      <el-col :span="12">
        <el-card  class="box-card">
        <el-row>
          <el-card  class="box-card">
          <el-form :model="form1" label-position="right" label-width="100px" >
            <span class="login-title">户主信息</span>
            <div style="margin-top: 5px"></div>
            <el-form-item label=" 户主姓名" >
              <el-col :span="20">
                <el-input v-model="form1.input1" clearable type="text"
                          maxLength='5'
                          placeholder="请输入户主姓名,不超过5个字，例:'王一飞'"
                          @blur="form1.input1=(form1.input1).replace(/[^\u4e00-\u9fa5]/g,'');"
                          @keyup.native="form1.input1=(form1.input1).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="家庭居住地" >
              <el-col :span="20">
              <el-input v-model="form1.input2" clearable type="text"
                        maxLength='20'
                        placeholder="请输入家庭居住地,不超过20个字，例:'王家村'" ></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label=" 登记时间" >
              <el-col :span="20">
                <el-date-picker type="date" placeholder="选择日期" v-model="form1.input3" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>
            <el-form-item>
              <el-button :disabled="right0" type="primary" icon="el-icon-search" round @click="go1">查询</el-button>
              <el-button type="info" icon="el-icon-delete" round @click="clean1">清空</el-button>
            </el-form-item>
          </el-form>
          </el-card>
        </el-row>
        <el-row>
          <el-row><span>户主信息列表</span></el-row>
          <el-row>
              <el-table v-loading="loading1"
                        element-loading-text="拼命加载中"
                        element-loading-spinner="el-icon-loading"
                        element-loading-background="rgba(192,192, 192, 0.8)"
                        :data="tableData1" border stripe style="width: 100%">
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
              </el-table>
          </el-row>
          <el-row>
            <el-col :span="12">
            <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible1 = true">全局显示</el-button>
            <el-dialog title="动迁人口登记表" :visible.sync="dialogTableVisible1" width="100%">
              <el-table :data="tableData1"  border stripe style="width: 100%" id="sss1">
                <el-table-column prop="id" label="编号" width="100"></el-table-column>
                <el-table-column prop="name" label="户主姓名" width="100"></el-table-column>
                <el-table-column prop="address" label="地址" width="100"></el-table-column>
                <el-table-column prop="registerdate" label="登记日期" width="100"></el-table-column>
                <el-table-column prop="remark" label="需说明事项" width="100"></el-table-column>
                <el-table-column prop="autograph" label="户主签字" width="100"></el-table-column>
                <el-table-column prop="head" label="负责人" width="100"></el-table-column>
                <el-table-column prop="agent" label="经办人" width="100"></el-table-column>
                <el-table-column prop="writedate" label="填表日期" width="100"></el-table-column>
                <el-table-column prop="preparer" label="添表人" width="100"></el-table-column>
              </el-table>
            </el-dialog>
              </el-col>
            <el-col :span="12">
              <el-button @click="Daochu1" type="text" icon="el-icon-download" round > 导出</el-button>
            </el-col>
          </el-row>
        </el-row>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card  class="box-card">
        <el-row >
          <el-card  class="box-card">
            <el-form :model="form2" label-position="right" label-width="100px" >
              <span class="login-title">亲属信息</span>
              <div style="margin-top: 5px"></div>
              <el-form-item label=" 亲属姓名" >
                <el-col :span="20">
                  <el-input v-model="form2.input1" clearable type="text"
                            maxLength='5'
                            placeholder="请输入亲属姓名,不超过5个字，例:'王一飞'"
                            @blur="form2.input1=(form2.input1).replace(/[^\u4e00-\u9fa5]/g,'');"
                            @keyup.native="form2.input1=(form2.input1).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
                </el-col>
              </el-form-item>
              <el-form-item label="户口本编号" >
                <el-col :span="20">
                  <el-input v-model="form2.input2" clearable type="text"
                            placeholder="请输入户口本编号，例:'111222202004013333'"
                            @blur="form2.input2=(form2.input2).replace(/[^\d]/g,'');"
                            @keyup.native="form2.input2=(form2.input2).replace(/[^\d]/g,'');"></el-input>
                </el-col>
              </el-form-item>
              <el-form-item label="出生日期" >
                <el-col :span="20">
                  <el-date-picker type="date" placeholder="选择日期" v-model="form2.input3" style="width: 100%;"></el-date-picker>
                </el-col>
              </el-form-item>
              <el-form-item>
                <el-button :disabled="right0" type="primary" icon="el-icon-search" round @click="go2">查询</el-button>
                <el-button type="info" icon="el-icon-delete" round @click="clean2">清空</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </el-row>
        <el-row>
          <el-row><span>明细列表</span></el-row>
          <el-row>
            <el-table v-loading="loading2"
                      element-loading-text="拼命加载中"
                      element-loading-spinner="el-icon-loading"
                      element-loading-background="rgba(192,192, 192, 0.8)"
                      :data="tableData2"  border stripe style="width: 100%">
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
            </el-table>
          </el-row>
          <el-row>
            <el-col :span="12">
            <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible2 = true">全局显示</el-button>
            <el-dialog title="动迁人口登记明细表" :visible.sync="dialogTableVisible2" width="100%">
              <el-table :data="tableData2"  border stripe style="width: 100%" id="sss2">
                <el-table-column prop="id" label="编号" width="100"></el-table-column>
                <el-table-column prop="mainid" label="户主编号" width="100"></el-table-column>
                <el-table-column prop="name" label="姓名" width="100"></el-table-column>
                <el-table-column prop="relationship" label="与户主关系" width="100"></el-table-column>
                <el-table-column prop="gender" label="性别" width="100"></el-table-column>
                <el-table-column prop="onlychild" label="是否是独生子女" width="100"></el-table-column>
                <el-table-column prop="birthday" label="出身年月日" width="100"></el-table-column>
                <el-table-column prop="residencefrom" label="户口本发证派出所" width="100"></el-table-column>
                <el-table-column prop="residenceid" label="户口本户口编号" width="100"></el-table-column>
                <el-table-column prop="residencedate" label="户口本立户时间" width="100"></el-table-column>
                <el-table-column prop="marryfrom" label="结婚证发证机关" width="100"></el-table-column>
                <el-table-column prop="marryid" label="结婚证编号" width="100"></el-table-column>
                <el-table-column prop="marrydate" label="结婚证登记时间" width="100"></el-table-column>
                <el-table-column prop="remark" label="备注" width="100"></el-table-column>
              </el-table>
            </el-dialog>
            </el-col>
            <el-col :span="12">
              <el-button @click="Daochu2" type="text" icon="el-icon-download" round > 导出</el-button>
            </el-col>
          </el-row>
        </el-row>
        </el-card>
      </el-col>
    </el-row>
    <el-card  class="box-card">
    <el-row>
      <el-card  class="box-card">
      <el-col :span="12">
        <el-form :model="form3" label-position="right" label-width="100px" >
          <span class="login-title">补偿信息</span>
          <div style="margin-top: 5px"></div>
          <el-form-item label=" 补偿表编号" >
            <el-col :span="20">
              <el-input v-model="form3.input1" clearable type="text"
                        placeholder="请输入正整数，例:'1'"
                        @blur="form3.input1=(form3.input1).replace(/[^\d]/g,'');"
                        @keyup.native="form3.input1=(form3.input1).replace(/[^\d]/g,'');"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item label=" 户主编号">
            <el-col :span="20">
              <el-input v-model="form3.input2" clearable type="text"
                        placeholder="请输入正整数，例:'1'"
                        @blur="form3.input2=(form3.input2).replace(/[^\d]/g,'');"
                        @keyup.native="form3.input2=(form3.input2).replace(/[^\d]/g,'');"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item label=" 丈量时间" >
            <el-col :span="20">
              <el-date-picker type="date" placeholder="选择日期" v-model="form3.input3" style="width: 100%;"></el-date-picker>
            </el-col>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col :span="12">
        <el-row><span ></span></el-row>
        <el-row><el-button :disabled="right0" type="primary" icon="el-icon-search" round @click="go3">查询</el-button></el-row>
        <el-row><span ></span></el-row>
        <el-row> <el-button type="info" icon="el-icon-delete" round @click="clean3">清空</el-button></el-row>
      </el-col>
      </el-card>
    </el-row>
    <el-row>
      <el-row type="flex"><span >补偿信息列表</span></el-row>
      <el-row>
        <el-table v-loading="loading3"
                  element-loading-text="拼命加载中"
                  element-loading-spinner="el-icon-loading"
                  element-loading-background="rgba(192,192, 192, 0.8)"
          :data="tableData3"  border stripe style="width: 100%">
          <el-table-column prop="id" label="编号" width="120"></el-table-column>
          <el-table-column prop="mainid" label="户主编号" width="120"></el-table-column>
          <el-table-column prop="name" label="户主姓名" width="120"></el-table-column>
          <el-table-column prop="address" label="原住址" width="120"></el-table-column>
          <el-table-column prop="measuredate" label="丈量时间" width="120"></el-table-column>
          <el-table-column prop="housenum" label="房屋数量" width="120"></el-table-column>
          <el-table-column prop="housearea" label="房屋面积" width="120"></el-table-column>
          <el-table-column prop="houselv" label="房屋等级" width="120"></el-table-column>
          <el-table-column prop="houseuprice" label="房屋单价" width="120"></el-table-column>
          <el-table-column prop="houseprice" label="房屋金额" width="120"></el-table-column>
          <el-table-column prop="wellnum" label="水井数量" width="120"></el-table-column>
          <el-table-column prop="welluprice" label="水井单价" width="120"></el-table-column>
          <el-table-column prop="wellprice" label="水井金额" width="120"></el-table-column>
          <el-table-column prop="phonenum" label="电话迁移盘数" width="120"></el-table-column>
          <el-table-column prop="phoneuprice" label="电话迁移单价" width="120"></el-table-column>
          <el-table-column prop="phoneprice" label="电话迁移金额" width="120"></el-table-column>
          <el-table-column prop="cellanum" label="小房数量" width="120"></el-table-column>
          <el-table-column prop="cellaarea" label="小房面积" width="120"></el-table-column>
          <el-table-column prop="cellalv" label="小房等级" width="120"></el-table-column>
          <el-table-column prop="cellauprice" label="小房单价" width="120"></el-table-column>
          <el-table-column prop="cellaprice" label="小房金额" width="120"></el-table-column>
          <el-table-column prop="digesternum" label="沼气池数量" width="120"></el-table-column>
          <el-table-column prop="digesteruprice" label="沼气池单价" width="120"></el-table-column>
          <el-table-column prop="digesterprice" label="沼气池金额" width="120"></el-table-column>
          <el-table-column prop="wallnum" label="围墙数量" width="120"></el-table-column>
          <el-table-column prop="walluprice" label="围墙单价" width="120"></el-table-column>
          <el-table-column prop="wallprice" label="围墙金额" width="120"></el-table-column>
          <el-table-column prop="pigpennum" label="猪圈数量" width="120"></el-table-column>
          <el-table-column prop="pigpenuprice" label="猪圈单价" width="120"></el-table-column>
          <el-table-column prop="pigpenprice" label="猪圈金额" width="120"></el-table-column>
          <el-table-column prop="wcnum" label="厕所数量" width="120"></el-table-column>
          <el-table-column prop="wcuprice" label="厕所单价" width="120"></el-table-column>
          <el-table-column prop="wcprice" label="厕所金额" width="120"></el-table-column>
          <el-table-column prop="concretenum" label="水泥地数量" width="120"></el-table-column>
          <el-table-column prop="concreteuprice" label="水泥地单价" width="120"></el-table-column>
          <el-table-column prop="concreteprice" label="水泥地金额" width="120"></el-table-column>
          <el-table-column prop="cellarnum" label="地窖数量" width="120"></el-table-column>
          <el-table-column prop="cellaruprice" label="地窖单价" width="120"></el-table-column>
          <el-table-column prop="cellarprice" label="地窖金额" width="120"></el-table-column>
          <el-table-column prop="shacknum" label="畜禽舍棚数量" width="120"></el-table-column>
          <el-table-column prop="shackuprice" label="畜禽舍棚单价" width="120"></el-table-column>
          <el-table-column prop="shackprice" label="畜禽舍棚金额" width="120"></el-table-column>
          <el-table-column prop="waternum" label="自来水数量" width="120"></el-table-column>
          <el-table-column prop="wateruprice" label="自来水单价" width="120"></el-table-column>
          <el-table-column prop="waterprice" label="自来水金额" width="120"></el-table-column>
          <el-table-column prop="tvnum" label="有线电视迁移数量" width="120"></el-table-column>
          <el-table-column prop="tvuprice" label="有线电视迁移单价" width="120"></el-table-column>
          <el-table-column prop="tvprice" label="有线电视迁移金额" width="120"></el-table-column>
          <el-table-column prop="archnum" label="门楼数量" width="120"></el-table-column>
          <el-table-column prop="archuprice" label="门楼单价" width="120"></el-table-column>
          <el-table-column prop="archprice" label="门楼金额" width="120"></el-table-column>
          <el-table-column prop="tree7num" label="果树1-7年数量" width="120"></el-table-column>
          <el-table-column prop="tree7uprice" label="果树1-7年单价" width="120"></el-table-column>
          <el-table-column prop="tree7price" label="果树1-7年金额" width="120"></el-table-column>
          <el-table-column prop="tree8num" label="果树1-8年数量" width="120"></el-table-column>
          <el-table-column prop="tree8uprice" label="果树1-8年单价" width="120"></el-table-column>
          <el-table-column prop="tree8price" label="果树1-8年金额" width="120"></el-table-column>
          <el-table-column prop="treespnum" label="果树（特殊）数量" width="120"></el-table-column>
          <el-table-column prop="treespuprice" label="果树（特殊）单价" width="120"></el-table-column>
          <el-table-column prop="treespprice" label="果树（特殊）金额" width=120"></el-table-column>
          <el-table-column prop="remark" label="备注" width="120"></el-table-column>
          <el-table-column prop="totalmoney" label="总金额" width="120"></el-table-column>
        </el-table>
      </el-row>
      <el-row>
        <el-col :span="12">
        <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible3 = true">全局显示</el-button>
        <el-dialog title="动迁人口补偿表" :visible.sync="dialogTableVisible3" width="100%">
          <el-table :data="tableData3"  border stripe style="width: 100%" id="sss3">
            <el-table-column prop="id" label="编号" width="60"></el-table-column>
            <el-table-column prop="mainid" label="户主编号" width="60"></el-table-column>
            <el-table-column prop="name" label="户主姓名" width="60"></el-table-column>
            <el-table-column prop="address" label="原住址" width="60"></el-table-column>
            <el-table-column prop="measuredate" label="丈量时间" width="60"></el-table-column>
            <el-table-column prop="housenum" label="房屋数量" width="60"></el-table-column>
            <el-table-column prop="housearea" label="房屋面积" width="60"></el-table-column>
            <el-table-column prop="houselv" label="房屋等级" width="60"></el-table-column>
            <el-table-column prop="houseuprice" label="房屋单价" width="60"></el-table-column>
            <el-table-column prop="houseprice" label="房屋金额" width="60"></el-table-column>
            <el-table-column prop="wellnum" label="水井数量" width="60"></el-table-column>
            <el-table-column prop="welluprice" label="水井单价" width="60"></el-table-column>
            <el-table-column prop="wellprice" label="水井金额" width="60"></el-table-column>
            <el-table-column prop="phonenum" label="电话迁移盘数" width="60"></el-table-column>
            <el-table-column prop="phoneuprice" label="电话迁移单价" width="60"></el-table-column>
            <el-table-column prop="phoneprice" label="电话迁移金额" width="60"></el-table-column>
            <el-table-column prop="cellanum" label="小房数量" width="60"></el-table-column>
            <el-table-column prop="cellaarea" label="小房面积" width="60"></el-table-column>
            <el-table-column prop="cellalv" label="小房等级" width="60"></el-table-column>
            <el-table-column prop="cellauprice" label="小房单价" width="60"></el-table-column>
            <el-table-column prop="cellaprice" label="小房金额" width="60"></el-table-column>
            <el-table-column prop="digesternum" label="沼气池数量" width="60"></el-table-column>
            <el-table-column prop="digesteruprice" label="沼气池单价" width="60"></el-table-column>
            <el-table-column prop="digesterprice" label="沼气池金额" width="60"></el-table-column>
            <el-table-column prop="wallnum" label="围墙数量" width="60"></el-table-column>
            <el-table-column prop="walluprice" label="围墙单价" width="60"></el-table-column>
            <el-table-column prop="wallprice" label="围墙金额" width="60"></el-table-column>
            <el-table-column prop="pigpennum" label="猪圈数量" width="60"></el-table-column>
            <el-table-column prop="pigpenuprice" label="猪圈单价" width="60"></el-table-column>
            <el-table-column prop="pigpenprice" label="猪圈金额" width="60"></el-table-column>
            <el-table-column prop="wcnum" label="厕所数量" width="60"></el-table-column>
            <el-table-column prop="wcuprice" label="厕所单价" width="60"></el-table-column>
            <el-table-column prop="wcprice" label="厕所金额" width="60"></el-table-column>
            <el-table-column prop="concretenum" label="水泥地数量" width="60"></el-table-column>
            <el-table-column prop="concreteuprice" label="水泥地单价" width="60"></el-table-column>
            <el-table-column prop="concreteprice" label="水泥地金额" width="60"></el-table-column>
            <el-table-column prop="cellarnum" label="地窖数量" width="60"></el-table-column>
            <el-table-column prop="cellaruprice" label="地窖单价" width="60"></el-table-column>
            <el-table-column prop="cellarprice" label="地窖金额" width="60"></el-table-column>
            <el-table-column prop="shacknum" label="畜禽舍棚数量" width="60"></el-table-column>
            <el-table-column prop="shackuprice" label="畜禽舍棚单价" width="60"></el-table-column>
            <el-table-column prop="shackprice" label="畜禽舍棚金额" width="60"></el-table-column>
            <el-table-column prop="waternum" label="自来水数量" width="60"></el-table-column>
            <el-table-column prop="wateruprice" label="自来水单价" width="60"></el-table-column>
            <el-table-column prop="waterprice" label="自来水金额" width="60"></el-table-column>
            <el-table-column prop="tvnum" label="有线电视迁移数量" width="60"></el-table-column>
            <el-table-column prop="tvuprice" label="有线电视迁移单价" width="60"></el-table-column>
            <el-table-column prop="tvprice" label="有线电视迁移金额" width="60"></el-table-column>
            <el-table-column prop="archnum" label="门楼数量" width="60"></el-table-column>
            <el-table-column prop="archuprice" label="门楼单价" width="60"></el-table-column>
            <el-table-column prop="archprice" label="门楼金额" width="60"></el-table-column>
            <el-table-column prop="tree7num" label="果树1-7年数量" width="60"></el-table-column>
            <el-table-column prop="tree7uprice" label="果树1-7年单价" width="60"></el-table-column>
            <el-table-column prop="tree7price" label="果树1-7年金额" width="60"></el-table-column>
            <el-table-column prop="tree8num" label="果树1-8年数量" width="60"></el-table-column>
            <el-table-column prop="tree8uprice" label="果树1-8年单价" width="60"></el-table-column>
            <el-table-column prop="tree8price" label="果树1-8年金额" width="60"></el-table-column>
            <el-table-column prop="treespnum" label="果树（特殊）数量" width="60"></el-table-column>
            <el-table-column prop="treespuprice" label="果树（特殊）单价" width="60"></el-table-column>
            <el-table-column prop="treespprice" label="果树（特殊）金额" width="60"></el-table-column>
            <el-table-column prop="remark" label="备注" width="60"></el-table-column>
            <el-table-column prop="totalmoney" label="总金额" width="60"></el-table-column>
          </el-table>
        </el-dialog>
        </el-col>
        <el-col :span="12">
          <el-button @click="Daochu3" type="text" icon="el-icon-download" round > 导出</el-button>
        </el-col>
      </el-row>
    </el-row>
    </el-card>
    <el-card  class="box-card">
      <el-row>
        <el-card  class="box-card">
          <el-col :span="12">
            <el-form :model="form3" label-position="right" label-width="100px" >
              <span class="login-title">结算信息</span>
              <div style="margin-top: 5px"></div>
              <el-form-item label=" 结算表编号" >
                <el-col :span="20">
                  <el-input v-model="form4.input1" clearable type="text"
                            placeholder="请输入正整数，例:'1'"
                            @blur="form4.input1=(form4.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form4.input1=(form4.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col>
              </el-form-item>
              <el-form-item label=" 户主编号" >
                <el-col :span="20">
                  <el-input v-model="form4.input2" clearable type="text"
                            placeholder="请输入正整数，例:'1'"
                            @blur="form4.input2(form4.input2).replace(/[^\d]/g,'');"
                            @keyup.native="form4.input2=(form4.input2).replace(/[^\d]/g,'');"></el-input>
                </el-col>
              </el-form-item>
              <el-form-item label=" 户主姓名" >
                <el-col :span="20">
                  <el-input v-model="form4.input3" clearable type="text"
                            maxLength='5'
                            placeholder="请输入户主姓名,不超过5个字，例:'王一飞'"
                            @blur="form4.input3=(form4.input3).replace(/[^\u4e00-\u9fa5]/g,'');"
                            @keyup.native="form4.input3=(form4.input3).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
                </el-col>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="12">
            <el-row><span ></span></el-row>
            <el-row><el-button :disabled="right0" type="primary" icon="el-icon-search" round @click="go4">查询</el-button></el-row>
            <el-row><span ></span></el-row>
            <el-row> <el-button type="info" icon="el-icon-delete" round @click="clean4">清空</el-button> </el-row>
          </el-col>
        </el-card>
      </el-row>
      <el-row>
        <el-row type="flex"><span >结算信息列表</span></el-row>
        <el-row>
          <el-table v-loading="loading4"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(192,192, 192, 0.8)"
                    :data="tableData4"  border stripe style="width: 100%">
            <el-table-column prop="id" label="编号" width="120"></el-table-column>
            <el-table-column prop="mainid" label="户主编号" width="120"></el-table-column>
            <el-table-column prop="name" label="户主姓名" width="120"></el-table-column>
            <el-table-column prop="oldaddress" label="原住址" width="120"></el-table-column>
            <el-table-column prop="chambertype" label="分配室型" width="120"></el-table-column>
            <el-table-column prop="buildingnumber" label="楼号" width="120"></el-table-column>
            <el-table-column prop="housenum" label="原房间数" width="120"></el-table-column>
            <el-table-column prop="housearea" label="原房面积" width="120"></el-table-column>
            <el-table-column prop="houselv" label="原房等级" width="120"></el-table-column>
            <el-table-column prop="houseuprice" label="原房单价" width="120"></el-table-column>
            <el-table-column prop="houseprice" label="原房金额" width="120"></el-table-column>
            <el-table-column prop="facilitiesprice" label="原房院内设施金额" width="120"></el-table-column>
            <el-table-column prop="allprice1" label="合计金额" width="120"></el-table-column>
            <el-table-column prop="distributionnum" label="分配楼房室数" width="120"></el-table-column>
            <el-table-column prop="distributionarea" label="分配楼房平数" width="120"></el-table-column>
            <el-table-column prop="areacash" label="分配楼房面积兑现" width="120"></el-table-column>
            <el-table-column prop="areadivided" label="分配楼房面积应分" width="120"></el-table-column>
            <el-table-column prop="areaadd" label="分配楼房面积增档" width="120"></el-table-column>
            <el-table-column prop="areaover" label="分配楼房面积超档" width="120"></el-table-column>
            <el-table-column prop="upcash" label="分配楼房增加兑现" width="120"></el-table-column>
            <el-table-column prop="updivided" label="分配楼房增加应分" width="120"></el-table-column>
            <el-table-column prop="upadd" label="分配楼房增加增档" width="120"></el-table-column>
            <el-table-column prop="upover" label="分配楼房增加超档" width="120"></el-table-column>
            <el-table-column prop="downcash" label="分配楼房减少兑现" width="120"></el-table-column>
            <el-table-column prop="downdivided" label="分配楼房减少应分" width="120"></el-table-column>
            <el-table-column prop="downadd" label="分配楼房减少增档" width="120"></el-table-column>
            <el-table-column prop="downover" label="分配楼房减少超档" width="120"></el-table-column>
            <el-table-column prop="pricecash" label="分配楼房金额兑现" width="120"></el-table-column>
            <el-table-column prop="pricedivided" label="分配楼房金额应分" width="120"></el-table-column>
            <el-table-column prop="priceadd" label="分配楼房金额增档" width="120"></el-table-column>
            <el-table-column prop="priceover" label="分配楼房金额超档" width="120"></el-table-column>
            <el-table-column prop="upricecash" label="分配楼房单价兑现" width="120"></el-table-column>
            <el-table-column prop="upricedivided" label="分配楼房单价应分" width="120"></el-table-column>
            <el-table-column prop="upriceadd" label="分配楼房单价增档" width="120"></el-table-column>
            <el-table-column prop="upriceover" label="分配楼房单价超档" width="120"></el-table-column>
            <el-table-column prop="allprice2" label="合计金额" width="120"></el-table-column>
            <el-table-column prop="otherprice" label="其它计费项目" width="120"></el-table-column>
            <el-table-column prop="settlementprice1" label="分配楼房与原房结算金额" width="120"></el-table-column>
            <el-table-column prop="remark" label="备注" width="120"></el-table-column>
            <el-table-column prop="director" label="所长" width="120"></el-table-column>
            <el-table-column prop="examine" label="收款审核" width="120"></el-table-column>
            <el-table-column prop="settlement" label="结算" width="120"></el-table-column>
            <el-table-column prop="people" label="动迁户" width="120"></el-table-column>
          </el-table>
        </el-row>
        <el-row>
          <el-col :span="12">
          <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible4 = true">全局显示</el-button>
          <el-dialog title="动迁人口结算表" :visible.sync="dialogTableVisible4" width="100%">
            <el-table :data="tableData4"  border stripe style="width: 100%" id="sss4">
              <el-table-column prop="id" label="编号" width="60"></el-table-column>
              <el-table-column prop="mainid" label="户主编号" width="60"></el-table-column>
              <el-table-column prop="name" label="户主姓名" width="60"></el-table-column>
              <el-table-column prop="oldaddress" label="原住址" width="60"></el-table-column>
              <el-table-column prop="chambertype" label="分配室型" width="60"></el-table-column>
              <el-table-column prop="buildingnumber" label="楼号" width="60"></el-table-column>
              <el-table-column prop="housenum" label="原房间数" width="60"></el-table-column>
              <el-table-column prop="housearea" label="原房面积" width="60"></el-table-column>
              <el-table-column prop="houselv" label="原房等级" width="60"></el-table-column>
              <el-table-column prop="houseuprice" label="原房单价" width="60"></el-table-column>
              <el-table-column prop="houseprice" label="原房金额" width="60"></el-table-column>
              <el-table-column prop="facilitiesprice" label="原房院内设施金额" width="60"></el-table-column>
              <el-table-column prop="allprice1" label="合计金额" width="60"></el-table-column>
              <el-table-column prop="distributionnum" label="分配楼房室数" width="60"></el-table-column>
              <el-table-column prop="distributionarea" label="分配楼房平数" width="60"></el-table-column>
              <el-table-column prop="areacash" label="分配楼房面积兑现" width="60"></el-table-column>
              <el-table-column prop="areadivided" label="分配楼房面积应分" width="60"></el-table-column>
              <el-table-column prop="areaadd" label="分配楼房面积增档" width="60"></el-table-column>
              <el-table-column prop="areaover" label="分配楼房面积超档" width="60"></el-table-column>
              <el-table-column prop="upcash" label="分配楼房增加兑现" width="60"></el-table-column>
              <el-table-column prop="updivided" label="分配楼房增加应分" width="60"></el-table-column>
              <el-table-column prop="upadd" label="分配楼房增加增档" width="60"></el-table-column>
              <el-table-column prop="upover" label="分配楼房增加超档" width="60"></el-table-column>
              <el-table-column prop="downcash" label="分配楼房减少兑现" width="60"></el-table-column>
              <el-table-column prop="downdivided" label="分配楼房减少应分" width="60"></el-table-column>
              <el-table-column prop="downadd" label="分配楼房减少增档" width="60"></el-table-column>
              <el-table-column prop="downover" label="分配楼房减少超档" width="60"></el-table-column>
              <el-table-column prop="pricecash" label="分配楼房金额兑现" width="60"></el-table-column>
              <el-table-column prop="pricedivided" label="分配楼房金额应分" width="60"></el-table-column>
              <el-table-column prop="priceadd" label="分配楼房金额增档" width="60"></el-table-column>
              <el-table-column prop="priceover" label="分配楼房金额超档" width="60"></el-table-column>
              <el-table-column prop="upricecash" label="分配楼房单价兑现" width="60"></el-table-column>
              <el-table-column prop="upricedivided" label="分配楼房单价应分" width="60"></el-table-column>
              <el-table-column prop="upriceadd" label="分配楼房单价增档" width="60"></el-table-column>
              <el-table-column prop="upriceover" label="分配楼房单价超档" width="60"></el-table-column>
              <el-table-column prop="allprice2" label="合计金额" width="60"></el-table-column>
              <el-table-column prop="otherprice" label="其它计费项目" width="60"></el-table-column>
              <el-table-column prop="settlementprice1" label="分配楼房与原房结算金额" width="60"></el-table-column>
              <el-table-column prop="remark" label="备注" width="60"></el-table-column>
              <el-table-column prop="director" label="所长" width="60"></el-table-column>
              <el-table-column prop="examine" label="收款审核" width="60"></el-table-column>
              <el-table-column prop="settlement" label="结算" width="60"></el-table-column>
              <el-table-column prop="people" label="动迁户" width="60"></el-table-column>
            </el-table>
          </el-dialog>
          </el-col>
          <el-col :span="12">
            <el-button @click="Daochu4" type="text" icon="el-icon-download" round > 导出</el-button>
          </el-col>
        </el-row>
      </el-row>
    </el-card>
  </div>
</template>
<script>
  import XLSX from 'xlsx'
  import FileSaver from 'file-saver'
  export default {
    data() {
      return {
        form1:{input1:'', input2:'',input3:''},
        form2:{input1:'',value: '',input3:''},
        form3:{input1:'',input2:'',input3:''},
        form4:{input1:'',input2:'',input3:''},
        tableData1: [],
        tableData2: [],
        tableData3: [],
        tableData4: [],
        loading1:false,dialogTableVisible1:false,
        loading2:false,dialogTableVisible2:false,
        loading3:false,dialogTableVisible3:false,
        loading4:false,dialogTableVisible4:false,
        right0:true,
      }
    },
    created()
    {
      this.convert1();
    },
    methods:{
      Daochu1() {
        var xlsxParam = { raw: true };//转换成excel时，使用原始的格式
        var wb = XLSX.utils.table_to_book(document.querySelector("#sss1"),xlsxParam);//outTable为列表id
        var wbout = XLSX.write(wb, {
          bookType: "xlsx",
          bookSST: true,
          type: "array"
        });
        try {
          FileSaver.saveAs(
            new Blob([wbout], { type: "application/octet-stream;charset=utf-8" }),
            "人口查询表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      Daochu2() {
        var xlsxParam = { raw: true };//转换成excel时，使用原始的格式
        var wb = XLSX.utils.table_to_book(document.querySelector("#sss2"),xlsxParam);//outTable为列表id
        var wbout = XLSX.write(wb, {
          bookType: "xlsx",
          bookSST: true,
          type: "array"
        });
        try {
          FileSaver.saveAs(
            new Blob([wbout], { type: "application/octet-stream;charset=utf-8" }),
            "明细人口查询表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      Daochu3() {
        var xlsxParam = { raw: true };//转换成excel时，使用原始的格式
        var wb = XLSX.utils.table_to_book(document.querySelector("#sss3"),xlsxParam);//outTable为列表id
        var wbout = XLSX.write(wb, {
          bookType: "xlsx",
          bookSST: true,
          type: "array"
        });
        try {
          FileSaver.saveAs(
            new Blob([wbout], { type: "application/octet-stream;charset=utf-8" }),
            "人口补偿表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      Daochu4() {
        var xlsxParam = { raw: true };//转换成excel时，使用原始的格式
        var wb = XLSX.utils.table_to_book(document.querySelector("#sss4"),xlsxParam);//outTable为列表id
        var wbout = XLSX.write(wb, {
          bookType: "xlsx",
          bookSST: true,
          type: "array"
        });
        try {
          FileSaver.saveAs(
            new Blob([wbout], { type: "application/octet-stream;charset=utf-8" }),
            "人口结算表.xlsx"
          );
        } catch (e) {
          if (typeof console !== "undefined") console.log(e, wbout);
        }
        return wbout;
      },
      convert1: function ()
      {
        var _this = this;
        this.$axios.get('/Pdd/rightinit').then(resp => {
          if (resp && resp.status === 200) {
            _this.right0 = !Boolean(Number(sessionStorage.getItem("right0")));
          }
        })
      },
      go1(){
        var _this = this
        _this.loading1=true
        if(_this.form1.input1==='')
        {_this.form1.input1=null}
        if(_this.form1.input2==='')
        {_this.form1.input2=null}
        this.$axios
          .post('/Pdd/PopulationQuery/in1', { name:this.form1.input1,
            address:this.form1.input2,
            registerdate:this.form1.input3})
          .then(resp => {
            if (resp && resp.status === 200) {
              _this.tableData1 = resp.data
              var i;
              for (i = 0; i < _this.tableData1.length; i++) {
                if (_this.tableData1[i].verify === 1) {
                  _this.tableData1[i].verify = '已审核'
                } else if (_this.tableData1[i].verify === 0) {
                  _this.tableData1[i].verify = '未审核'
                }
              }
            }
          })
        _this.loading1=false;
      },
      go2(){
        var _this = this
        _this.loading2=true
        if(_this.form2.input1==='')
        {_this.form2.input1=null}
        if(_this.form2.input2==='')
        {_this.form2.input2=null}
        this.$axios
          .post('/Pdd/PopulationQuery/in2', { name:this.form2.input1,
            residenceid:this.form2.input2,
            birthday:this.form2.input3})
          .then(resp => {
            if (resp && resp.status === 200) {
              _this.tableData2 = resp.data
              var i;
              for (i = 0; i < _this.tableData2.length; i++) {
                if (_this.tableData2[i].gender === 2) {
                  _this.tableData2[i].gender = '男'
                } else if (_this.tableData2[i].gender === 1) {
                  _this.tableData2[i].gender = '女'
                }
                if (_this.tableData2[i].onlychild === 1) {
                  _this.tableData2[i].onlychild = '独生子女'
                } else if (_this.tableData2[i].onlychild === 2) {
                  _this.tableData2[i].onlychild = '非独生子女'
                }
                if (_this.tableData2[i].verify === 1) {
                  _this.tableData2[i].verify = '已审核'
                } else if (_this.tableData2[i].verify === 0) {
                  _this.tableData2[i].verify = '未审核'
                }
              }
            }
          })
        _this.loading2=false;
      },
      go3(){
        var _this = this
        _this.loading3=true
        this.$axios
          .post('/Pdd/PopulationQuery/in3', { id:this.form3.input1,
            mainid:this.form3.input2,
            measuredate:this.form3.input3})
          .then(resp => {
            if (resp && resp.status === 200) {
              _this.tableData3 = resp.data
            }
          })
        _this.loading3=false;
      },
      go4(){
        var _this = this
        _this.loading4=true
        if(_this.form4.input3==='')
        {_this.form4.input3=null}
        this.$axios
          .post('/Pdd/PopulationQuery/in4', { id:this.form4.input1,
            mainid:this.form4.input2,
            name:this.form4.input3})
          .then(resp => {
            if (resp && resp.status === 200) {
              _this.tableData4 = resp.data
            }
          })
        _this.loading4=false;
      },
     clean1()
     {
       var _this=this;
       _this.tableData1=[]
     },
      clean2()
      {
        var _this=this;
        _this.tableData2=[]
      },
      clean3()
      {
        var _this=this;
        _this.tableData3=[]
      },
      clean4()
      {
        var _this=this;
        _this.tableData4=[]
      },
    },
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
