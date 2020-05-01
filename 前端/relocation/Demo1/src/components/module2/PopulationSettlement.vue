<template>
  <div id="all">
    <el-row>
      <el-form :inline="true" :model="form12"  class="demo-form-inline">
          <el-form-item label="编号" class="redItem">
            <el-input v-model.number="form12.input1" clearable type="text"
                      placeholder="请输入正整数，例:'1'"
                      @blur="form12.input1=(form12.input1).replace(/[^\d]/g,'');"
                      @keyup.native="form12.input1=(form12.input1).replace(/[^\d]/g,'');"></el-input>
          </el-form-item>
        <el-form-item label="户主编号" class="redItem">
          <el-input v-model.number="form12.input2" clearable type="text"
                    placeholder="请输入正整数，例:'1'"
                    @blur="form12.input2=(form12.input2).replace(/[^\d]/g,'');"
                    @keyup.native="form12.input2=(form12.input2).replace(/[^\d]/g,'');"></el-input>
        </el-form-item>
        <el-form-item label="户主姓名" class="redItem">
          <el-input v-model="form12.input3" clearable type="text"
                    maxLength='5'
                    placeholder="请输入姓名,例:'王一飞'"
                    @blur="form12.input3=(form12.input3).replace(/[^\u4e00-\u9fa5]/g,'');"
                    @keyup.native="form12.input3=(form12.input3).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
        </el-form-item>
        <el-form-item label="原地址" class="redItem">
          <el-input v-model="form12.input4" clearable type="text"
                    maxLength='20'
                    placeholder="请输入地址,例:'王家村'" ></el-input>
        </el-form-item >
        <el-form-item label="分配室型" class="redItem">
          <el-input v-model="form12.input5" clearable type="text"
                    maxLength='10'
                    placeholder="请输入分配室型,例:'楼房'" ></el-input>
        </el-form-item>
        <el-form-item label="楼号" class="redItem">
          <el-input v-model="form12.input6" clearable type="text"
                    maxLength='10'
                    placeholder="请输入楼号,例:1栋'"></el-input>
        </el-form-item >
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6"><div >
        <el-card class="box-card">
        <el-row type="flex"><span>原房及设施金额</span></el-row>
        <el-row>
          <el-form :model="form1" label-position="right" label-width="110px" >
            <el-form-item label="间数" class="redItem">
              <el-col :span="20">
                <el-input v-model.number="form1.input1" clearable type="text"
                          placeholder="单位:间"
                          @blur="form1.input1=(form1.input1).replace(/[^\d]/g,'');"
                          @keyup.native="form1.input1=(form1.input1).replace(/[^\d]/g,'');"></el-input>
              </el-col >
            </el-form-item>
            <el-form-item label="面积" class="redItem">
              <el-col :span="20">
                <el-input v-model.number="form1.input2" clearable type="text"
                          placeholder="单位:平方米"
                          @blur="form1.input2=(form1.input2).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form1.input2=(form1.input2).replace(/[^0-9\.]/g,'');"></el-input>
              </el-col >
            </el-form-item>
            <el-form-item label="等级" class="redItem">
              <el-col :span="20">
                <el-input v-model.number="form1.input3" clearable type="text"
                          placeholder="单位:级"
                          @blur="form1.input3=(form1.input3).replace(/[^\d]/g,'');"
                          @keyup.native="form1.input3=(form1.input3).replace(/[^\d]/g,'');" ></el-input>
              </el-col >
            </el-form-item>
            <el-form-item label="单价" class="redItem">
              <el-col :span="20">
                <el-input v-model.number="form1.input4" clearable type="text"
                          placeholder="单位:元"
                          @blur="form1.input4=(form1.input4).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form1.input4=(form1.input4).replace(/[^0-9\.]/g,'');"></el-input>
              </el-col >
            </el-form-item>
            <el-form-item label="金额" >
              <el-col :span="20">
                {{sum1+'元'}}
              </el-col >
            </el-form-item>
            <el-form-item label="院内设施金额" class="redItem">
              <el-col :span="20">
                <el-input v-model.number="form1.input6" clearable type="text"
                          placeholder="单位:元"
                          @blur="form1.input6=(form1.input6).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form1.inpu6=(form1.input6).replace(/[^0-9\.]/g,'');"></el-input>
              </el-col >
            </el-form-item>
            <el-form-item label="合计金额" >
              <el-col :span="20">
                {{sum2+'元'}}
              </el-col >
            </el-form-item>
          </el-form>
        </el-row>
        </el-card>
        <el-row>
          <el-form :model="form2" label-position="right" label-width="110px" >
            <el-form-item label="其他项目费用" >
              <el-col :span="20">
                <el-input v-model.number="form2.input1" clearable type="text"
                          placeholder="单位:元"
                          @blur="form2.input1=(form2.input1).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form2.input1=(form2.input1).replace(/[^0-9\.]/g,'');"></el-input>
              </el-col >
            </el-form-item>
            <el-form-item label="分配楼房与原房结算（）金额" >
              <el-col :span="20">
                {{sum8+'元'}}
              </el-col >
            </el-form-item>
            <el-form-item label="备注 ">
              <el-col :span="20">
              <el-input type="textarea" :rows="10" placeholder="请输入内容" v-model="form2.input4"></el-input>
              </el-col >
            </el-form-item>
          </el-form>
        </el-row>
      </div></el-col>
      <el-col :span="18"><div >
        <el-card class="box-card">
        <el-row type="flex"><span>分配楼房及金额</span></el-row>
        <el-row>
          <el-form :inline="true" :model="form3" label-position="right" label-width="20px" class="demo-form-inline">
            <el-form-item>
              <el-col :span="12" class="red">
              <span class="redItem">分</span><el-input v-model.number="form3.input1" clearable type="text"
                                      @blur="form3.input1=(form3.input1).replace(/[^\d]/g,'');"
                                      @keyup.native="form3.input1=(form3.input1).replace(/[^\d]/g,'');"  ></el-input><span class="redItem">室</span>
              </el-col>
            </el-form-item>
            <el-form-item>
              <el-col :span="12" class="red">
                <span class="redItem">总</span><el-input v-model.number="form3.input2"  clearable type="text"
                                        @blur="form3.input2=(form3.input2).replace(/[^0-9\.]/g,'');"
                                        @keyup.native="form3.input2=(form3.input2).replace(/[^0-9\.]/g,'');"></el-input><span class="redItem">平方米</span>
              </el-col>
            </el-form-item>
          </el-form>
        </el-row>
        <el-row>
          <el-col :span="8"><div >
            <el-card class="box-card">
            <el-row type="flex"><span>面积</span></el-row>
            <el-row>
              <el-form :model="form4" label-position="right" label-width="40px" >
                <el-form-item label="兑现" >
                  <el-col :span="20">
                    <el-input v-model.number="form4.input1" clearable type="text"
                              placeholder="单位:平方米"
                              @blur="form4.input1=(form4.input1).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form4.input1=(form4.input1).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="应分" >
                  <el-col :span="20">
                    <el-input v-model.number="form4.input2" clearable type="text"
                              placeholder="单位:平方米"
                              @blur="form4.input2=(form4.input2).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form4.input2=(form4.input2).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="增档" >
                  <el-col :span="20">
                    <el-input v-model.number="form4.input3" clearable type="text"
                              placeholder="单位:平方米"
                              @blur="form4.input3=(form4.input3).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form4.input3=(form4.input3).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="超档" >
                  <el-col :span="20">
                    <el-input v-model.number="form4.input4" clearable type="text"
                              placeholder="单位:平方米"
                              @blur="form4.input4=(form4.input4).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form4.input4=(form4.input4).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
              </el-form>
            </el-row>
            </el-card>
            <el-card class="box-card">
            <el-row type="flex"><span>金额</span></el-row>
            <el-row>
              <el-form :model="form5" label-position="right" label-width="40px" >
                <el-form-item label="兑现" >
                  <el-col :span="20">
                   {{sum3+'元'}}
                  </el-col >
                </el-form-item>
                <el-form-item label="应分" >
                  <el-col :span="20">
                   {{sum4+'元'}}
                  </el-col >
                </el-form-item>
                <el-form-item label="增档" >
                  <el-col :span="20">
                    {{sum5+'元'}}
                  </el-col >
                </el-form-item>
                <el-form-item label="超档" >
                  <el-col :span="20">
                   {{sum6+'元'}}
                  </el-col >
                </el-form-item>
              </el-form>
            </el-row>
            </el-card>
          </div></el-col>
          <el-col :span="8"><div >
            <el-card class="box-card">
            <el-row type="flex"><span>增加%</span></el-row>
            <el-row>
              <el-form :model="form6" label-position="right" label-width="40px" >
                <el-form-item label="兑现" >
                  <el-col :span="20">
                    <el-input v-model="form6.input1" clearable type="text"
                              placeholder="单位:%"
                              @blur="form6.input1=(form6.input1).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form6.input1=(form6.input1).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="应分" >
                  <el-col :span="20">
                    <el-input v-model="form6.input2" clearable type="text"
                              placeholder="单位:%"
                              @blur="form6.input2=(form6.input2).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form6.input2=(form6.input2).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="增档" >
                  <el-col :span="20">
                    <el-input v-model="form6.input3" clearable type="text"
                              placeholder="单位:%"
                              @blur="form6.input3=(form6.input3).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form6.input3=(form6.input3).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="超档" >
                  <el-col :span="20">
                    <el-input v-model="form6.input4" clearable type="text"
                              placeholder="单位:%"
                              @blur="form6.input4=(form6.input4).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form6.input4=(form6.input4).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
              </el-form>
            </el-row>
            </el-card>
            <el-card class="box-card">
            <el-row type="flex"><span>单价</span></el-row>
            <el-row>
              <el-form :model="form7" label-position="right" label-width="40px" >
                <el-form-item label="兑现" >
                  <el-col :span="20">
                    <el-input v-model="form7.input1" clearable type="text"
                              placeholder="单位:元"
                              @blur="form7.input1=(form7.input1).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form7.input1=(form7.input1).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="应分" >
                  <el-col :span="20">
                    <el-input v-model="form7.input2" clearable type="text"
                              placeholder="单位:元"
                              @blur="form7.input2=(form7.input2).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form7.input2=(form7.input2).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="增档" >
                  <el-col :span="20">
                    <el-input v-model="form7.input3" clearable type="text"
                              placeholder="单位:元"
                              @blur="form7.input3=(form7.input3).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form7.input3=(form7.input3).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="超档" >
                  <el-col :span="20">
                    <el-input v-model="form7.input4" clearable type="text"
                              placeholder="单位:元"
                              @blur="form7.input4=(form7.input4).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form7.input4=(form7.input4).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
              </el-form>
            </el-row>
            </el-card>
          </div></el-col>
          <el-col :span="8"><div >
            <el-card class="box-card">
            <el-row type="flex"><span>减少%</span></el-row>
            <el-row>
              <el-form :model="form8" label-position="right" label-width="40px" >
                <el-form-item label="兑现" >
                  <el-col :span="20">
                    <el-input v-model="form8.input1" clearable type="text"
                              placeholder="单位:%"
                              @blur="form8.input1=(form8.input1).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form8.input1=(form8.input1).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="应分" >
                  <el-col :span="20">
                    <el-input v-model="form8.input2" clearable type="text"
                              placeholder="单位:%"
                              @blur="form8.input2=(form8.input2).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form8.input2=(form8.input2).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="增档" >
                  <el-col :span="20">
                    <el-input v-model="form8.input3" clearable type="text"
                              placeholder="单位:%"
                              @blur="form8.input3=(form8.input3).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form8.input3=(form8.input3).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
                <el-form-item label="超档" >
                  <el-col :span="20">
                    <el-input v-model="form8.input4" clearable type="text"
                              placeholder="单位:%"
                              @blur="form8.input4=(form8.input4).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form8.input4=(form8.input4).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-col >
                </el-form-item>
              </el-form>
            </el-row>
            </el-card>
            <el-card class="box-card">
            <el-row type="flex"><span>合计金额</span></el-row>
            <el-row>
              <el-form :model="form9" label-position="right" label-width="40px" >
                <el-form-item  >
                  <el-col :span="20">
                    {{sum7+'元'}}
                  </el-col >
                </el-form-item>
              </el-form>
            </el-row>
            </el-card>
          </div></el-col>
        </el-row>
        </el-card>
        <el-row>
          <el-col :span="8"><div >
            <el-form :model="form10" label-position="right" label-width="80px" >
              <el-form-item  label="所长" class="redItem">
                <el-col :span="24">
                  <el-input v-model="form10.input1" clearable type="text"
                            maxLength='5'
                            placeholder="请输入所长姓名,例:'王一飞'"
                            @blur="form10.input1=(form10.input1).replace(/[^\u4e00-\u9fa5]/g,'');"
                            @keyup.native="form10.input1=(form10.input1).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item  label="收款审核" class="redItem">
                <el-col :span="24">
                  <el-input v-model="form10.input2" clearable type="text"
                            maxLength='5'
                            placeholder="请输入收款审核姓名,例:'王一飞'"
                            @blur="form10.input2=(form10.input2).replace(/[^\u4e00-\u9fa5]/g,'');"
                            @keyup.native="form10.input2=(form10.input2).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
                </el-col >
              </el-form-item>
            </el-form>
          </div></el-col>
          <el-col :span="8"><div >
            <el-form :model="form11" label-position="right" label-width="80px" >
              <el-form-item  label="结算" class="redItem">
                <el-col :span="24">
                  <el-input v-model="form11.input1" clearable type="text"
                            maxLength='5'
                            placeholder="请输入结算姓名,例:'王一飞'"
                            @blur="form11.input1=(form11.input1).replace(/[^\u4e00-\u9fa5]/g,'');"
                            @keyup.native="form11.input1=(form11.input1).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item  label="动迁户" class="redItem">
                <el-col :span="24">
                  <el-input v-model="form11.input2" clearable type="text"
                            maxLength='5'
                            placeholder="请输入动迁户姓名,例:'王一飞'"
                            @blur="form11.input2=(form11.input2).replace(/[^\u4e00-\u9fa5]/g,'');"
                            @keyup.native="form11.input2=(form11.input2).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
                </el-col >
              </el-form-item>
            </el-form>
          </div></el-col>
          <el-col :span="8"><div >
            <el-button :disabled="right1" type="primary" icon="el-icon-circle-plus-outline" round @click="subForm">增加</el-button>
            <el-button :disabled="right1" type="success" round icon="el-icon-edit" @click="updateForm">修改</el-button>
            <el-button :disabled="right2" type="danger" round icon="el-icon-delete" @click="delForm">删除</el-button>
          </div></el-col>
        </el-row>
      </div></el-col>
    </el-row>
  </div>
</template>
<script>
  //# sourceMappingURL=file.js.map
  export default {
    data() {
      return {
        form1:{input1:'', input2:'',input3:'',input4:'', input5:0,input6:'', input7:0},
        form2:{input1:'', input2:'',input3:'',input4:''},
        form3:{input1:'', input2:''},
        form4:{input1:'', input2:'',input3:'',input4:''},
        form5:{input1:'', input2:'',input3:'',input4:'',},
        form6:{input1:'', input2:'',input3:'',input4:''},
        form7:{input1:'', input2:'',input3:'',input4:''},
        form8:{input1:'', input2:'',input3:'',input4:''},
        form9:{input1:''},
        form10:{input1:'', input2:''},
        form11:{input1:'', input2:''},
        form12:{input1:'', input2:'',input3:'',input4:'',input5:'',input6:''},
        right0:true,right1:true,right2:true,
      }
    },
    computed:{
      sum1: function () {
       this.form1.input5=this.form1.input1*this.form1.input2*this.form1.input3*this.form1.input4;
        return this.form1.input5;
      },
      sum2: function () {
        this.form1.input7=Number(this.form1.input5)+Number(this.form1.input6);
        return this.form1.input7;
      },
      sum3: function () {
        this.form5.input1=this.form4.input1*this.form7.input1*(1+0.01*(this.form6.input1-this.form8.input1));
        return this.form5.input1;
      },
      sum4: function () {
        this.form5.input2=this.form4.input2*this.form7.input2*(1+0.01*(this.form6.input2-this.form8.input2));
        return this.form5.input2;
      },
      sum5: function () {
        this.form5.input3=this.form4.input3*this.form7.input3*(1+0.01*(this.form6.input3-this.form8.input3));
        return this.form5.input3;
      },
      sum6: function () {
        this.form5.input4=this.form4.input4*this.form7.input4*(1+0.01*(this.form6.input4-this.form8.input4));
        return this.form5.input4;
      },
      sum7: function () {
        this.form9.input1=this.form5.input1+this.form5.input2-this.form5.input3-this.form5.input4;
        return this.form9.input1;
      },
      sum8: function () {
        this.form2.input2=this.form9.input1-this.form1.input7-this.form2.input1;
        return this.form2.input2;
      },
    },
    created()
    {
    this.convert1();
    },
   methods:{
     convert1: function ()
     {
       var _this = this;
       this.$axios.get('/Pdd/rightinit').then(resp => {
         if (resp && resp.status === 200) {
           _this.right0 = !Boolean(Number(sessionStorage.getItem("right0")));
           _this.right1 = !Boolean(Number(sessionStorage.getItem("right1")));
           _this.right2 = !Boolean(Number(sessionStorage.getItem("right2")));
         }
       })
     },
     subForm() {
       if(this.form12.input1!==''&&this.form12.input2!==''&&this.form12.input3!==''&&this.form12.input4!==''&&this.form12.input5!==''&&this.form12.input6!==''&&
         this.form1.input1!==''&&this.form1.input2!==''&&this.form1.input3!==''&&this.form1.input4!==''&&this.form1.input6!==''&&
         this.form3.input1!==''&&this.form3.input2!==''&&this.form10.input1!==''&&this.form10.input2!==''&&this.form11.input1!==''&&this.form11.input2!==''){
         this.go1()
       }
       else
       {
         alert('信息输入不全。增加操作，编号.户主编号.户主姓名.原住址.分配室型.楼号.' +
           '原房间数.原房面积.原房等级.原房单价.原房院内设施金额.' +
           '分配楼房室数.分配楼房平数.' +
           '所长.收款审核.结算.动迁户 必须填写')
       }
     },
     updateForm() {
       if(this.form12.input2!==''&&this.form12.input1!==''){
         this.go2()
       }
       else {
         alert('信息输入不全。修改操作，编号.户主编号必须填写')
       }
     },
     delForm() {
       if(this.form12.input1!==''){
         this.open();
       }
       else {
         alert('信息输入不全。删除操作，编号必须填写')
       }
     },
     go1(){
       var _this = this
       var p={
      id:this.form12.input1,
      mainid:this.form12.input2,
      name :this.form12.input3,
      oldaddress:this.form12.input4,
      chambertype :this.form12.input5,
      buildingnumber:this.form12.input6,
      housenum:this.form1.input1,
      housearea :this.form1.input2,
      houselv :this.form1.input3,
      houseuprice :this.form1.input4,
      houseprice :this.form1.input5,
      facilitiesprice :this.form1.input6,
      allprice1:this.form1.input7,
      distributionnum :this.form3.input1,
      distributionarea :this.form3.input2,
      areacash:this.form4.input1,
      areadivided :this.form4.input2,
      areaadd  :this.form4.input3,
      areaover :this.form4.input4,
      upcash :this.form6.input1,
      updivided :this.form6.input2,
      upadd:this.form6.input3,
      upover  :this.form6.input4,
      downcash :this.form8.input1,
      downdivided:this.form8.input2,
         downadd  :this.form8.input3,
        downover  :this.form8.input4,
        pricecash :this.form5.input1,
       pricedivided :this.form5.input2,
        priceadd  :this.form5.input3,
       priceover  :this.form5.input4,
       upricecash :this.form7.input1,
       upricedivided  :this.form7.input2,
       upriceadd   :this.form7.input3,
       upriceover  :this.form7.input4,
       allprice2  :this.form9.input1,
       otherprice  :this.form2.input1,
      settlementprice1  :this.form2.input2,
      remark   :this.form2.input4,
      director :this.form10.input1,
      examine :this.form10.input2,
      settlement:this.form11.input1,
      people :this.form11.input2};
       this.$axios
         .post('/Pdd/PopulationSettlement/add',p)
         .then(successResponse => {
           if (successResponse.data.code == 200)
           {
             alert('添加成功')
           }
           else if (successResponse.data.code == 400)
           {
             alert('户主不存在，添加失败')
           }
           else if (successResponse.data.code == 401)
           {
             alert('结算表已存在，添加失败')
           }
           else if (successResponse.data.code == 402)
           {
             alert('户主信息已审核，不允许更改，修改失败')
           }
         })
         .catch(failResponse => {
         })
     },
     go2(){
       var _this = this
       _this.loading1=true
       var p={ id:this.form12.input1,
         mainid:this.form12.input2};
       if(this.form12.input3!=='')
       {
         p["name"]=this.form12.input3;
       }
       if(this.form12.input4!=='')
       {
         p["oldaddress"]=this.form12.input4;
       }
       if(this.form12.input5!=='')
       {
         p["chambertype"]=this.form12.input5;
       }
       if (this.form12.input6!=='')
       {
         p["buildingnumber"]=this.form12.input6
       }
       if(this.form1.input1!=='')
       {
         p["housenum"]=this.form1.input1;
         p["housearea"]=this.form1.input2;
         p["houselv"]=this.form1.input3;
         p["houseuprice"]=this.form1.input4;
         p["houseprice"]=this.form1.input5;
       }
       if(this.form1.input6!=='')
       {
         p["facilitiesprice"]=this.form1.input6;
       }
       if(this.form3.input1!=='')
       {
         p["distributionnum"]=this.form3.input1;
         p["distributionarea"]=this.form3.input2;
       }
       if(this.form4.input1!=='')
       {
         p["areacash"]=this.form4.input1;
         p["upcash"]=this.form6.input1;
         p["downcash"]=this.form8.input1;
         p["pricecash"]=this.form5.input1;
         p["upricecash"]=this.form7.input1;
       }
       if(this.form4.input2!=='')
       {
         p["areadivided"]=this.form4.input2;
         p["updivided"]=this.form6.input2;
         p["downdivided"]=this.form8.input2;
         p["pricedivided"]=this.form5.input2;
         p["upricedivided"]=this.form7.input2;
       }
       if(this.form4.input3!=='')
       {
         p["areaadd"]=this.form4.input3;
         p["upadd"]=this.form6.input3;
         p["downadd"]=this.form8.input3;
         p["priceadd"]=this.form5.input3;
         p["upriceadd"]=this.form7.input3;
       }
       if(this.form4.input4!=='')
       {
         p["areaover"]=this.form4.input4;
         p["upover"]=this.form6.input4;
         p["downover"]=this.form8.input4;
         p["priceover"]=this.form5.input4;
         p["upriceover"]=this.form7.input4;
       }
       if(this.form2.input1!=='')
       {
         p["otherprice"]=this.form2.input1;
       }
       if(this.form2.input4!=='')
       {
         p["remark"]=this.form2.input4;
       }
       if(this.form10.input1!=='')
       {
         p["director"]=this.form10.input1;
       }
       if(this.form10.input2!=='')
       {
         p["examine"]=this.form10.input2;
       }
       if(this.form11.input1!=='')
       {
         p["settlement"]=this.form11.input1;
       }
       if(this.form11.input2!=='')
       {
         p["people"]=this.form11.input2;
       }
       this.$axios
         .post('/Pdd/PopulationSettlement/update',p)
         .then(successResponse => {
           if (successResponse.data.code == 200)
           {
             alert('信息修改成功')
           }
           else if (successResponse.data.code == 400)
           {
             alert('户主不存在,修改失败')
           }
           else if (successResponse.data.code == 401)
           {
             alert('结算表不存在，修改失败')
           }
           else if (successResponse.data.code == 402)
           {
             alert('户主信息已审核，不允许更改，修改失败')
           }
         })
         .catch(failResponse => {
         })
     },
     go3(){
       this.$axios
         .post('/Pdd/PopulationSettlement/delete',{ id:this.form12.input1})
         .then(successResponse => {
           if (successResponse.data.code == 200)
           {
             alert('删除成功')
           }
           else if (successResponse.data.code == 400)
           {
             alert('结算表不存在，删除失败')
           }
           else if (successResponse.data.code == 401)
           {
             alert('户主信息已审核，不允许删除')
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
  .red {
    color:red;
  }
</style>
