<template>
  <div class="all">
    <el-card  class="box-card">
    <el-row>
      <el-card  class="box-card">
    <el-form :model="form1" label-position="right" label-width="100px" >
      <span class="login-title">企业信息</span>
      <div style="margin-top: 5px"></div>
      <el-form-item label="企业名称" >
        <el-col :span="22">
          <el-input v-model="form1.input1" clearable type="text"
                    maxLength='15'
                    placeholder="请输入企业名称,不超过15个字，例:'动迁公司'"
                    @blur="form1.input1=(form1.input1).replace(/[^\u4e00-\u9fa5]/g,'');"
                    @keyup.native="form1.input1=(form1.input1).replace(/[^\u4e00-\u9fa5]/g,'');"> </el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="地址">
        <el-col :span="12">
          <el-input v-model="form1.input2" clearable type="text"
                    maxLength='20'
                    placeholder="请输入家庭居住地,不超过20个字，例:'王家村'" ></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="测量日期">
        <el-col :span="12">
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
        <el-row type="flex"><span>企业信息列表</span></el-row>
        <el-row>
          <el-table v-loading="loading1"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(192,192, 192, 0.8)"
                    :data="tableData1"  border stripe style="width: 100%">
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
        <el-col :span="12">
          <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible1 = true">全局显示</el-button>
          <el-dialog title="企业信息表" :visible.sync="dialogTableVisible1" width="100%">
            <el-table :data="tableData1"  border stripe style="width: 100%" id="sss1">
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
        <el-col :span="12">
          <el-button @click="Daochu1" type="text" icon="el-icon-download" round > 导出</el-button>
        </el-col>
      </el-row>
    </el-card>
    <el-card  class="box-card">
    <el-row>
      <el-card  class="box-card">
      <el-form :model="form2" label-position="right" label-width="100px" >
        <span class="login-title">补偿信息</span>
        <div style="margin-top: 5px"></div>
        <el-form-item label="补偿表id" >
          <el-col :span="12">
            <el-input v-model="form2.input1" clearable type="text"
                      placeholder="请输入正整数，例:'1'"
                      @blur="form2.input1=(form2.input1).replace(/[^\d]/g,'');"
                      @keyup.native="form2.input1=(form2.input1).replace(/[^\d]/g,'');"> </el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="企业id">
          <el-col :span="12">
            <el-input v-model="form2.input2" clearable type="text"
                      placeholder="请输入正整数，例:'1'"
                      @blur="form2.input2=(form2.input2).replace(/[^\d]/g,'');"
                      @keyup.native="form2.input2=(form2.input2).replace(/[^\d]/g,'');"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="企业名称">
          <el-col :span="12">
            <el-input v-model="form2.input3" clearable type="text"
                      maxLength='15'
                      placeholder="请输入企业名称,不超过15个字，例:'动迁公司'"
                      @blur="form2.input3=(form2.input3).replace(/[^\u4e00-\u9fa5]/g,'');"
                      @keyup.native="form2.input3=(form2.input3).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
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
        <el-row type="flex"><span>企业补偿信息列表</span></el-row>
        <el-row>
          <el-table v-loading="loading2"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(192,192, 192, 0.8)"
                    :data="tableData2"  border stripe style="width: 100%">
            <el-table-column prop="id" label="补偿表序号" width="120"></el-table-column>
            <el-table-column prop="mainid" label="企业id" width="120"></el-table-column>
            <el-table-column prop="name" label="企业名称" width="120"></el-table-column>
            <el-table-column prop="totalmoney" label="总金额" width="120"></el-table-column>
            <el-table-column prop="asphaltroadnum" label="沥青路面积" width="120"></el-table-column>
            <el-table-column prop="asphaltroaduprice" label="沥青路单价" width="120"></el-table-column>
            <el-table-column prop="asphaltroadprice" label="沥青路金额" width="120"></el-table-column>
            <el-table-column prop="cementroadnum" label="水泥路面积" width="120"></el-table-column>
            <el-table-column prop="cementroaduprice" label="水泥路单价" width="120"></el-table-column>
            <el-table-column prop="cementroadprice" label="水泥路金额" width="120"></el-table-column>
            <el-table-column prop="concretenum" label="水泥地面积" width="120"></el-table-column>
            <el-table-column prop="concreteuprice" label="水泥地单价" width="120"></el-table-column>
            <el-table-column prop="concreteprice" label="水泥地金额" width="120"></el-table-column>
            <el-table-column prop="houseletnum" label="小楼面积" width="120"></el-table-column>
            <el-table-column prop="houseletuprice" label="小楼单价" width="120"></el-table-column>
            <el-table-column prop="houseletprice" label="小楼金额" width="120"></el-table-column>
            <el-table-column prop="officenum" label="办公楼面积" width="120"></el-table-column>
            <el-table-column prop="officelv" label="办公楼等级" width="120"></el-table-column>
            <el-table-column prop="officeuprice" label="办公楼单价" width="120"></el-table-column>
            <el-table-column prop="officeprice" label="办公楼金额" width="120"></el-table-column>
            <el-table-column prop="plantnum" label="厂房面积" width="120"></el-table-column>
            <el-table-column prop="plantlv" label="厂房等级" width="120"></el-table-column>
            <el-table-column prop="plantuprice" label="厂房单价" width="120"></el-table-column>
            <el-table-column prop="plantprice" label="厂房金额" width="120"></el-table-column>
            <el-table-column prop="retainwallnum" label="挡土墙面积" width="120"></el-table-column>
            <el-table-column prop="retainwalluprice" label="挡土墙单价" width="120"></el-table-column>
            <el-table-column prop="retainwallprice" label="挡土墙金额" width="120"></el-table-column>
            <el-table-column prop="slopewallnum" label="护坡墙面积" width="120"></el-table-column>
            <el-table-column prop="slopewalluprice" label="护坡墙单价" width="120"></el-table-column>
            <el-table-column prop="slopewallprice" label="护坡墙金额" width="120"></el-table-column>
            <el-table-column prop="tilenum" label="砖地面积" width="120"></el-table-column>
            <el-table-column prop="tileuprice" label="砖地单价" width="120"></el-table-column>
            <el-table-column prop="tileprice" label="砖地金额" width="120"></el-table-column>
            <el-table-column prop="wallnum" label="围墙面积" width="120"></el-table-column>
            <el-table-column prop="walluprice" label="围墙单价" width="120"></el-table-column>
            <el-table-column prop="wallprice" label="围墙金额" width="120"></el-table-column>
            <el-table-column prop="shednum" label="棚厦个数" width="120"></el-table-column>
            <el-table-column prop="sheduprice" label="棚厦单价" width="120"></el-table-column>
            <el-table-column prop="shedprice" label="棚厦金额" width="120"></el-table-column>
            <el-table-column prop="wellnum" label="水井个数" width="120"></el-table-column>
            <el-table-column prop="welluprice" label="水井单价" width="120"></el-table-column>
            <el-table-column prop="wellprice" label="水井金额" width="120"></el-table-column>
            <el-table-column prop="doornum" label="院门个数" width="120"></el-table-column>
            <el-table-column prop="dooruprice" label="院门单价" width="120"></el-table-column>
            <el-table-column prop="doorpricre" label="院门金额" width="120"></el-table-column>
            <el-table-column prop="fencenum" label="栅栏个数" width="120"></el-table-column>
            <el-table-column prop="fenceuprice" label="栅栏单价" width="120"></el-table-column>
            <el-table-column prop="fenceprice" label="栅栏金额" width="120"></el-table-column>
            <el-table-column prop="phonenum" label="电话个数" width="120"></el-table-column>
            <el-table-column prop="phoneuprice" label="电话单价" width="120"></el-table-column>
            <el-table-column prop="phoneprice" label="电话金额" width="120"></el-table-column>
            <el-table-column prop="tvnum" label="有线电视个数" width="120"></el-table-column>
            <el-table-column prop="tvuprice" label="有线电视单价" width="120"></el-table-column>
            <el-table-column prop="tvprice" label="有线电视金额" width="120"></el-table-column>
            <el-table-column prop="remark" label="其他" width="120"></el-table-column>
          </el-table>
        </el-row>
      </el-row>
      <el-row>
        <el-col :span="12">
        <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible2 = true">全局显示</el-button>
        <el-dialog title="企业补偿信息表" :visible.sync="dialogTableVisible2" width="100%">
          <el-table :data="tableData2"  border stripe style="width: 100%" id="sss2">
          <el-table-column prop="id" label="补偿表序号" width="60"></el-table-column>
          <el-table-column prop="mainid" label="企业id" width="60"></el-table-column>
          <el-table-column prop="name" label="企业名称" width="60"></el-table-column>
          <el-table-column prop="totalmoney" label="总金额" width="60"></el-table-column>
          <el-table-column prop="asphaltroadnum" label="沥青路面积" width="60"></el-table-column>
          <el-table-column prop="asphaltroaduprice" label="沥青路单价" width="60"></el-table-column>
          <el-table-column prop="asphaltroadprice" label="沥青路金额" width="60"></el-table-column>
          <el-table-column prop="cementroadnum" label="水泥路面积" width="60"></el-table-column>
          <el-table-column prop="cementroaduprice" label="水泥路单价" width="60"></el-table-column>
          <el-table-column prop="cementroadprice" label="水泥路金额" width="60"></el-table-column>
          <el-table-column prop="concretenum" label="水泥地面积" width="60"></el-table-column>
          <el-table-column prop="concreteuprice" label="水泥地单价" width="60"></el-table-column>
          <el-table-column prop="concreteprice" label="水泥地金额" width="60"></el-table-column>
          <el-table-column prop="houseletnum" label="小楼面积" width="60"></el-table-column>
          <el-table-column prop="houseletuprice" label="小楼单价" width="60"></el-table-column>
          <el-table-column prop="houseletprice" label="小楼金额" width="60"></el-table-column>
          <el-table-column prop="officenum" label="办公楼面积" width="60"></el-table-column>
          <el-table-column prop="officelv" label="办公楼等级" width="60"></el-table-column>
          <el-table-column prop="officeuprice" label="办公楼单价" width="60"></el-table-column>
          <el-table-column prop="officeprice" label="办公楼金额" width="60"></el-table-column>
          <el-table-column prop="plantnum" label="厂房面积" width="60"></el-table-column>
          <el-table-column prop="plantlv" label="厂房等级" width="60"></el-table-column>
          <el-table-column prop="plantuprice" label="厂房单价" width="60"></el-table-column>
          <el-table-column prop="plantprice" label="厂房金额" width="60"></el-table-column>
          <el-table-column prop="retainwallnum" label="挡土墙面积" width="60"></el-table-column>
          <el-table-column prop="retainwalluprice" label="挡土墙单价" width="60"></el-table-column>
          <el-table-column prop="retainwallprice" label="挡土墙金额" width="60"></el-table-column>
          <el-table-column prop="slopewallnum" label="护坡墙面积" width="60"></el-table-column>
          <el-table-column prop="slopewalluprice" label="护坡墙单价" width="60"></el-table-column>
          <el-table-column prop="slopewallprice" label="护坡墙金额" width="60"></el-table-column>
          <el-table-column prop="tilenum" label="砖地面积" width="60"></el-table-column>
          <el-table-column prop="tileuprice" label="砖地单价" width="60"></el-table-column>
          <el-table-column prop="tileprice" label="砖地金额" width="60"></el-table-column>
          <el-table-column prop="wallnum" label="围墙面积" width="60"></el-table-column>
          <el-table-column prop="walluprice" label="围墙单价" width="60"></el-table-column>
          <el-table-column prop="wallprice" label="围墙金额" width="60"></el-table-column>
          <el-table-column prop="shednum" label="棚厦个数" width="60"></el-table-column>
          <el-table-column prop="sheduprice" label="棚厦单价" width="60"></el-table-column>
          <el-table-column prop="shedprice" label="棚厦金额" width="60"></el-table-column>
          <el-table-column prop="wellnum" label="水井个数" width="60"></el-table-column>
          <el-table-column prop="welluprice" label="水井单价" width="60"></el-table-column>
          <el-table-column prop="wellprice" label="水井金额" width="60"></el-table-column>
          <el-table-column prop="doornum" label="院门个数" width="60"></el-table-column>
          <el-table-column prop="dooruprice" label="院门单价" width="60"></el-table-column>
          <el-table-column prop="doorpricre" label="院门金额" width="60"></el-table-column>
          <el-table-column prop="fencenum" label="栅栏个数" width="60"></el-table-column>
          <el-table-column prop="fenceuprice" label="栅栏单价" width="60"></el-table-column>
          <el-table-column prop="fenceprice" label="栅栏金额" width="60"></el-table-column>
          <el-table-column prop="phonenum" label="电话个数" width="60"></el-table-column>
          <el-table-column prop="phoneuprice" label="电话单价" width="60"></el-table-column>
          <el-table-column prop="phoneprice" label="电话金额" width="60"></el-table-column>
          <el-table-column prop="tvnum" label="有线电视个数" width="60"></el-table-column>
          <el-table-column prop="tvuprice" label="有线电视单价" width="60"></el-table-column>
          <el-table-column prop="tvprice" label="有线电视金额" width="60"></el-table-column>
          <el-table-column prop="remark" label="其他" width="60"></el-table-column>
          </el-table>
        </el-dialog>
        </el-col>
        <el-col :span="12">
          <el-button @click="Daochu2" type="text" icon="el-icon-download" round > 导出</el-button>
        </el-col>
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
                  <el-input v-model="form3.input1" clearable type="text"
                            placeholder="请输入正整数，例:'1'"
                            @blur="form3.input1=(form3.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form3.input1=(form3.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col>
              </el-form-item>
              <el-form-item label=" 企业编号" >
                <el-col :span="20">
                  <el-input v-model="form3.input2" clearable type="text"
                            placeholder="请输入正整数，例:'1'"
                            @blur="form3.input2=(form3.input2).replace(/[^\d]/g,'');"
                            @keyup.native="form3.input2=(form3.input2).replace(/[^\d]/g,'');"></el-input>
                </el-col>
              </el-form-item>
              <el-form-item label=" 企业名称" >
                <el-col :span="20">
                  <el-input v-model="form3.input3" clearable type="text"
                            maxLength='15'
                            placeholder="请输入企业名称,不超过15个字，例:'动迁公司'"
                            @blur="form3.input3=(form3.input3).replace(/[^\u4e00-\u9fa5]/g,'');"
                            @keyup.native="form3.input3=(form1.input3).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
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
        <el-row type="flex"><span >结算信息列表</span></el-row>
        <el-row>
          <el-table v-loading="loading3"
                    element-loading-text="拼命加载中"
                    element-loading-spinner="el-icon-loading"
                    element-loading-background="rgba(192,192, 192, 0.8)"
                    :data="tableData3"  border stripe style="width: 100%">
            <el-table-column prop="id" label="编号" width="120"></el-table-column>
            <el-table-column prop="mainid" label="户主编号" width="120"></el-table-column>
            <el-table-column prop="name" label="户主姓名" width="120"></el-table-column>
            <el-table-column prop="oldaddress" label="原住址" width="120"></el-table-column>
            <el-table-column prop="allocationaddress" label="分配地址" width="120"></el-table-column>
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
          <el-button type="text" icon="el-icon-view" round @click="dialogTableVisible3= true">全局显示</el-button>
          <el-dialog title="动迁企业结算表" :visible.sync="dialogTableVisible3" width="100%">
            <el-table :data="tableData3"  border stripe style="width: 100%" id="sss3">
              <el-table-column prop="id" label="编号" width="60"></el-table-column>
              <el-table-column prop="mainid" label="户主编号" width="60"></el-table-column>
              <el-table-column prop="name" label="户主姓名" width="60"></el-table-column>
              <el-table-column prop="oldaddress" label="原住址" width="60"></el-table-column>
              <el-table-column prop="allocationaddress" label="分配室型" width="60"></el-table-column>
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
            <el-button @click="Daochu3" type="text" icon="el-icon-download" round > 导出</el-button>
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
        form2:{input1:'',input2:'',input3:''},
        form3:{input1:'',input2:'',input3:''},
        tableData1: [],
        tableData2: [],
        tableData3: [],
        loading1:false,dialogTableVisible1:false,
        loading2:false,dialogTableVisible2:false,
        loading3:false,dialogTableVisible3:false,
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
            "企业查询表.xlsx"
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
            "企业补偿表.xlsx"
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
            "企业结算表.xlsx"
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
      if(_this.form1.input1==='')
      {_this.form1.input1=null}
        if(_this.form1.input2==='')
        {_this.form1.input2=null}
        this.$axios
          .post('/Pdd/CompanyQuery/in1', { name:this.form1.input1,
            address:this.form1.input2,
            measuredate:this.form1.input3})
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
        this.$axios
          .post('/Pdd/CompanyQuery/in2', { id:this.form2.input1,
            mainid:this.form2.input2})
          .then(resp => {
            if (resp && resp.status === 200) {
              _this.tableData2 = resp.data
            }
          })
        _this.loading2=false;
      },
      go3(){
        var _this = this
        _this.loading3=true
        if(_this.form3.input3==='')
        {_this.form3.input3=null}
        this.$axios
          .post('/Pdd/PopulationQuery/in3', { id:this.form3.input1,
            mainid:this.form3.input2,
            name:this.form3.input3})
          .then(resp => {
            if (resp && resp.status === 200) {
              _this.tableData3 = resp.data
            }
          })
        _this.loading3=false;
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

