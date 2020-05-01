<template>
  <div id="all">
    <el-row>
      <el-form :inline="true" :model="form1"  class="demo-form-inline">
        <el-form-item label="编号" class="redItem">
          <el-input v-model.number="form1.input6"
                    clearable type="text"
                    placeholder="请输入正整数，例:'1'"
                    @blur="form1.input6(form1.input6).replace(/[^\d]/g,'');"
                    @keyup.native="form1.input6=(form1.input6).replace(/[^\d]/g,'');"></el-input>
        </el-form-item>
        <el-form-item label="户主编号"  class="redItem">
          <el-input v-model.number="form1.input1"
                    clearable type="text"
                    placeholder="请输入正整数，例:'1'"
                    @blur="form1.input1=(form1.input1).replace(/[^\d]/g,'');"
                    @keyup.native="form1.input1=(form1.input1).replace(/[^\d]/g,'');"></el-input>
        </el-form-item>
        <el-form-item label="户主姓名"  class="redItem">
          <el-input v-model="form1.input2"  clearable type="text"
                    maxLength='5'
                    placeholder="请输入姓名,不超过5个字，例:'王一飞'"
                    @blur="form1.input2=(form1.input2).replace(/[^\u4e00-\u9fa5]/g,'');"
                    @keyup.native="form1.input2=(form1.input2).replace(/[^\u4e00-\u9fa5]/g,'');"></el-input>
        </el-form-item>
        <el-form-item label="原地址"  class="redItem">
          <el-input v-model="form1.input3" clearable type="text"
                    maxLength='20'
                    placeholder="请输入地址,不超过20个字，例:'王家村'"></el-input>
        </el-form-item >
        <el-form-item label="丈量时间"  class="redItem">
          <el-date-picker type="date" placeholder="选择日期" v-model="form1.input4" style="width: 100%;"></el-date-picker>
        </el-form-item>
        <el-form-item label="总金额">
          {{sumall+'元'}}
        </el-form-item >
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="4"><div>
        <el-card class="box-card">
          <el-row type="flex"><span>房屋</span></el-row>
          <el-row>
            <el-form :model="form2" label-position="right" label-width="40px" >
              <el-form-item label="间数" >
                <el-col :span="20">
                  <el-input v-model="form2.input1" clearable type="text"
                            placeholder="单位:间"
                            @blur="form2.input1=(form2.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form2.input1=(form2.input1).replace(/[^\d]/g,'');"  ></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="面积" >
                <el-col :span="20">
                  <el-input v-model="form2.input2" clearable type="text"
                            placeholder="单位:平方米"
                            @blur="form2.input2=(form2.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form2.input2=(form2.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="等级" >
                <el-col :span="20">
                  <el-input v-model="form2.input3" clearable type="text"
                            placeholder="单位:级"
                            @blur="form2.input3=(form2.input3).replace(/[^\d]/g,'');"
                            @keyup.native="form2.input3=(form2.input3).replace(/[^\d]/g,'');" ></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form2.input4" clearable type="text"
                            placeholder="单位:元"
                            @blur="form2.input4=(form2.input4).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form2.input4=(form2.input4).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum1+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>水井</span></el-row>
          <el-row>
            <el-form :model="form3" label-position="right" label-width="40px" >
              <el-form-item label="眼数" >
                <el-col :span="20">
                  <el-input v-model="form3.input1" clearable type="text"
                            placeholder="单位:眼"
                            @blur="form3.input1=(form3.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form3.input1=(form3.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form3.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form3.input2=(form3.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form3.input2=(form3.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum2+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>电话迁移费</span></el-row>
          <el-row>
            <el-form :model="form4" label-position="right" label-width="40px" >
              <el-form-item label="盘数" >
                <el-col :span="20">
                  <el-input v-model="form4.input1" clearable type="text"
                            placeholder="单位:盘"
                            @blur="form4.input1=(form4.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form4.input1=(form4.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form4.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form4.input2=(form4.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form4.input2=(form4.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum3+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
      </div></el-col>
      <el-col :span="4"><div >
        <el-card class="box-card">
          <el-row type="flex"><span>小房</span></el-row>
          <el-row>
            <el-form :model="form5" label-position="right" label-width="40px" >
              <el-form-item label="间数" >
                <el-col :span="20">
                  <el-input v-model="form5.input1" clearable type="text"
                            placeholder="单位:间"
                            @blur="form5.input1=(form5.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form5.input1=(form5.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="面积" >
                <el-col :span="20">
                  <el-input v-model="form5.input2" clearable type="text"
                            placeholder="单位:平方米"
                            @blur="form5.input2=(form5.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form5.input2=(form5.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="等级" >
                <el-col :span="20">
                  <el-input v-model="form5.input3" clearable type="text"
                            placeholder="单位:级"
                            @blur="form5.input3=(form5.input3).replace(/[^\d]/g,'');"
                            @keyup.native="form5.input3=(form5.input3).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form5.input4" clearable type="text"
                            placeholder="单位:元"
                            @blur="form5.input4=(form5.input4).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form5.input4=(form5.input4).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum4+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>沼气池</span></el-row>
          <el-row>
            <el-form :model="form6" label-position="right" label-width="40px" >
              <el-form-item label="眼数" >
                <el-col :span="20">
                  <el-input v-model="form6.input1" clearable type="text"
                            placeholder="单位:眼"
                            @blur="form6.input1=(form6.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form6.input1=(form6.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form6.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form6.input2=(form6.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form6.input2=(form6.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum5+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>围墙</span></el-row>
          <el-row>
            <el-form :model="form7" label-position="right" label-width="40px" >
              <el-form-item label="面积" >
                <el-col :span="20">
                  <el-input v-model="form7.input1" clearable type="text"  ></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form7.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form7.input2=(form7.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form7.input2=(form7.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="12">
                  {{sum6+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
      </div></el-col>
      <el-col :span="4"><div >
        <el-card class="box-card">
          <el-row type="flex"><span>猪圈</span></el-row>
          <el-row>
            <el-form :model="form8" label-position="right" label-width="40px" >
              <el-form-item label="个数" >
                <el-col :span="20">
                  <el-input v-model="form8.input1" clearable type="text"
                            placeholder="单位:个"
                            @blur="form8.input1=(form8.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form8.input1=(form8.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form8.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form8.input2=(form8.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form8.input2=(form8.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum7+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>厕所</span></el-row>
          <el-row>
            <el-form :model="form9" label-position="right" label-width="40px" >
              <el-form-item label="个数" >
                <el-col :span="20">
                  <el-input v-model="form9.input1" clearable type="text"
                            placeholder="单位:个"
                            @blur="form9.input1=(form9.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form9.input1=(form9.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form9.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form9.input2=(form9.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form9.input2=(form9.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum8+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>水泥地</span></el-row>
          <el-row>
            <el-form :model="form10" label-position="right" label-width="40px" >
              <el-form-item label="面积" >
                <el-col :span="20">
                  <el-input v-model="form10.input1" clearable type="text"
                            placeholder="单位:平方米"
                            @blur="form10.input1=(form10.input1).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form10.input1=(form10.input1).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form10.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form10.input2=(form10.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form10.input2=(form10.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum9+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>地窖</span></el-row>
          <el-row>
            <el-form :model="form7" label-position="right" label-width="60px" >
              <el-form-item label="立方米" >
                <el-col :span="20">
                  <el-input v-model="form11.input1" clearable type="text"
                            placeholder="单位:立方米"
                            @blur="form11.input1=(form11.input1).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form11.input1=(form11.input1).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form11.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form11.input2=(form11.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form11.input2=(form11.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum10+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
      </div></el-col>
      <el-col :span="4"><div >
        <el-card class="box-card">
          <el-row type="flex"><span>畜禽舍棚</span></el-row>
          <el-row>
            <el-form :model="form12" label-position="right" label-width="40px" >
              <el-form-item label="面积" >
                <el-col :span="20">
                  <el-input v-model="form12.input1" clearable type="text"
                            placeholder="单位:平方米"
                            @blur="form12.input1=(form12.input1).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form12.input1=(form12.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form12.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form12.input2=(form12.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form12.input2=(form12.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum11+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>自来水</span></el-row>
          <el-row>
            <el-form :model="form13" label-position="right" label-width="40px" >
              <el-form-item label="眼数" >
                <el-col :span="20">
                  <el-input v-model="form13.input1" clearable type="text"
                            placeholder="单位:眼"
                            @blur="form13.input1=(form13.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form13.input1=(form13.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form13.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form13.input2=(form13.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form13.input2=(form13.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum12+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>有线电视迁移</span></el-row>
          <el-row>
            <el-form :model="form14" label-position="right" label-width="40px" >
              <el-form-item label="户数" >
                <el-col :span="20">
                  <el-input v-model="form14.input1" clearable type="text"
                            placeholder="单位:户"
                            @blur="form14.input1=(form14.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form14.input1=(form14.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form14.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form14.input2=(form14.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form14.input2=(form14.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum13+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
        <el-card class="box-card">
          <el-row type="flex"><span>门楼</span></el-row>
          <el-row>
            <el-form :model="form7" label-position="right" label-width="40px" >
              <el-form-item label="个数" >
                <el-col :span="20">
                  <el-input v-model="form15.input1" clearable type="text"
                            placeholder="单位:个"
                            @blur="form15.input1=(form15.input1).replace(/[^\d]/g,'');"
                            @keyup.native="form15.input1=(form15.input1).replace(/[^\d]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="单价" >
                <el-col :span="20">
                  <el-input v-model="form15.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form15.input2=(form15.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form15.input2=(form15.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-col >
              </el-form-item>
              <el-form-item label="金额" >
                <el-col :span="20">
                  {{sum14+'元'}}
                </el-col >
              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
      </div></el-col>
      <el-col :span="8"><div >
        <el-row>
          <el-col :span="12"><div >
            <el-card class="box-card">
              <el-row type="flex"><span>树1-7年</span></el-row>
              <el-row>
                <el-form :model="form16" label-position="right" label-width="40px" >
                  <el-form-item label="个数" >
                    <el-col :span="20">
                      <el-input v-model="form16.input1" clearable type="text"
                                placeholder="单位:个"
                                @blur="form16.input1=(form16.input1).replace(/[^\d]/g,'');"
                                @keyup.native="form16.input1=(form16.input1).replace(/[^\d]/g,'');"></el-input>
                    </el-col >
                  </el-form-item>
                  <el-form-item label="单价" >
                    <el-col :span="20">
                      <el-input v-model="form16.input2" clearable type="text"
                                placeholder="单位:元"
                                @blur="form16.input2=(form16.input2).replace(/[^0-9\.]/g,'');"
                                @keyup.native="form16.input2=(form16.input2).replace(/[^0-9\.]/g,'');"></el-input>
                    </el-col >
                  </el-form-item>
                  <el-form-item label="金额" >
                    <el-col :span="20">
                      {{sum15+'元'}}
                    </el-col >
                  </el-form-item>
                </el-form>
              </el-row>
            </el-card>
            <el-card class="box-card">
              <el-row type="flex"><span>果树1-8年</span></el-row>
              <el-row>
                <el-form :model="form7" label-position="right" label-width="40px" >
                  <el-form-item label="个数" >
                    <el-col :span="20">
                      <el-input v-model="form17.input1" clearable type="text"
                                placeholder="单位:个"
                                @blur="form17.input1=(form17.input1).replace(/[^\d]/g,'');"
                                @keyup.native="form17.input1=(form17.input1).replace(/[^\d]/g,'');"></el-input>
                    </el-col >
                  </el-form-item>
                  <el-form-item label="单价" >
                    <el-col :span="20">
                      <el-input v-model="form17.input2" clearable type="text"
                                placeholder="单位:元"
                                @blur="form17.input2=(form17.input2).replace(/[^0-9\.]/g,'');"
                                @keyup.native="form17.input2=(form17.input2).replace(/[^0-9\.]/g,'');"></el-input>
                    </el-col >
                  </el-form-item>
                  <el-form-item label="金额" >
                    <el-col :span="20">
                      {{sum16+'元'}}
                    </el-col >
                  </el-form-item>
                </el-form>
              </el-row>
            </el-card>
          </div></el-col>
          <el-col :span="12"><div >
            <el-card class="box-card">
              <el-row type="flex"><span>果树（特殊）</span></el-row>
              <el-row>
                <el-form :model="form18" label-position="right" label-width="40px" >
                  <el-form-item label="个数">
                    <el-col :span="20">
                      <el-input v-model="form18.input1" clearable type="text"
                                placeholder="单位:个"
                                @blur="form18.input1=(form18.input1).replace(/[^\d]/g,'');"
                                @keyup.native="form18.input1=(form18.input1).replace(/[^\d]/g,'');"></el-input>
                    </el-col >
                  </el-form-item>
                  <el-form-item label="单价">
                    <el-col :span="20">
                      <el-input v-model="form18.input2" clearable type="text"
                                placeholder="单位:元"
                                @blur="form18.input2=(form18.input2).replace(/[^0-9\.]/g,'');"
                                @keyup.native="form18.input2=(form18.input2).replace(/[^0-9\.]/g,'');"></el-input>
                    </el-col >
                  </el-form-item>
                  <el-form-item label="金额">
                    <el-col :span="20">
                      {{sum17+'元'}}
                    </el-col >
                  </el-form-item>
                </el-form>
              </el-row>
            </el-card>
          </div></el-col>
        </el-row>
        <el-row>
          <el-card class="box-card">
            <el-row type="flex"><span>备注</span></el-row>
            <el-row>
              <el-form :model="form21" label-position="right" label-width="40px" >
                <el-form-item  >
                  <el-input type="textarea" :rows="10" placeholder="请输入内容" v-model="form21.input1"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button :disabled="right1" type="primary" icon="el-icon-circle-plus-outline" @click="subForm" round >增加</el-button>
                  <el-button :disabled="right1" type="success" icon="el-icon-edit" @click="updateForm" round >修改</el-button>
                  <el-button :disabled="right2" type="danger" icon="el-icon-delete" @click="delForm" round >删除</el-button>
                </el-form-item>
              </el-form>
            </el-row>
          </el-card>
        </el-row>
      </div></el-col>
    </el-row>
  </div>
</template>
<script>
  //# sourceMappingURL=file.js.map
  export default {
    data()
    {
      return {
        form1: {input1: '', input2: '', input3: '', input4: '', input5: 0,input6:''},
        form2: {input1: '', input2: '', input3: '', input4: '', input5: 0},
        form3: {input1: '', input2: '', input3:0},
        form4: {input1: '', input2: '', input3:0},
        form5: {input1: '', input2: '', input3: '', input4: '', input5:0},
        form6: {input1: '', input2: '', input3:0},
        form7: {input1: '', input2: '', input3: 0},
        form8: {input1: '', input2: '', input3:0},
        form9: {input1: '', input2: '', input3: ''},
        form10: {input1: '', input2: '', input3: ''},
        form11: {input1: '', input2: '', input3: ''},
        form12: {input1: '', input2: '', input3: ''},
        form13: {input1: '', input2: '', input3: ''},
        form14: {input1: '', input2: '', input3: ''},
        form15: {input1: '', input2: '', input3: ''},
        form16: {input1: '', input2: '', input3: ''},
        form17: {input1: '', input2: '', input3: ''},
        form18: {input1: '', input2: '', input3: ''},
        form21: {input1: ''},
        right0:true,right1:true,right2:true,
      }
    },
    computed:
      {
        sum1: function () {
          this.form2.input5 = this.form2.input1 * this.form2.input2 * this.form2.input3 * this.form2.input4
          return this.form2.input5;
        },
        sum2: function () {
          this.form3.input3 = this.form3.input1 * this.form3.input2
          return this.form3.input3;
        },
        sum3: function () {
          this.form4.input3 = this.form4.input1 * this.form4.input2
          return this.form4.input3;
        },
        sum4: function () {
          this.form5.input5 = this.form5.input1 * this.form5.input2 * this.form5.input3 * this.form5.input4
          return this.form5.input5;
        },
        sum5: function () {
          this.form6.input3 = this.form6.input1 * this.form6.input2
          return this.form6.input3;
        },
        sum6: function () {
          this.form7.input3 = this.form7.input1 * this.form7.input2
          return this.form7.input3;
        },
        sum7: function () {
          this.form8.input3 = this.form8.input1 * this.form8.input2
          return this.form8.input3;
        },
        sum8: function () {
          this.form9.input3 = this.form9.input1 * this.form9.input2
          return this.form9.input3;
        },
        sum9: function () {
          this.form10.input3 = this.form10.input1 * this.form10.input2
          return this.form10.input3;
        },
        sum10: function () {
          this.form11.input3 = this.form11.input1 * this.form11.input2
          return this.form11.input3;
        },
        sum11: function () {
          this.form12.input3 = this.form12.input1 * this.form12.input2
          return this.form12.input3;
        },
        sum12: function () {
          this.form13.input3 = this.form13.input1 * this.form13.input2
          return this.form13.input3;
        },
        sum13: function () {
          this.form14.input3 = this.form14.input1 * this.form14.input2
          return this.form14.input3;
        },
        sum14: function () {
          this.form15.input3 = this.form15.input1 * this.form15.input2
          return this.form15.input3;
        },
        sum15: function () {
          this.form16.input3 = this.form16.input1 * this.form16.input2
          return this.form16.input3;
        },
        sum16: function () {
          this.form17.input3 = this.form17.input1 * this.form17.input2
          return this.form17.input3;
        },
        sum17: function () {
          this.form18.input3 = this.form18.input1 * this.form18.input2
          return this.form18.input3;
        },
        sumall: function () {
          this.form1.input5 = this.form2.input5 + this.form3.input3 + this.form4.input3 + this.form5.input5 + this.form6.input3 + this.form7.input3 + this.form8.input3 + this.form9.input3 + this.form10.input3 + this.form11.input3 + this.form12.input3 + this.form13.input3 + this.form14.input3 + this.form15.input3 + this.form16.input3 + this.form17.input3 + this.form18.input3;
          return this.form1.input5;
        }
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
        if(this.form1.input6!==''&&this.form1.input1!==''&&this.form1.input2!==''&&this.form1.input3!==''&&this.form1.input4!==null){
          this.go1()
        }
        else
        {
          alert('信息输入不全。增加操作，补偿表编号.户主编号.户主姓名.住址.必须填写')
        }
      },
      updateForm() {
        if(this.form1.input6!==''&&this.form1.input1!==''){
          this.go2()
        }
        else {
          alert('信息输入不全。修改操作，编号.户主编号必须填写')
        }
      },
      delForm() {
        if(this.form1.input6!==''){
          this.open();
        }
        else {
          alert('信息输入不全。删除操作，编号必须填写')
        }
      },
      go1(){
        var _this = this
        var p={ id:this.form1.input6,
          mainid:this.form1.input1,
          name:this.form1.input2,
          address:this.form1.input3,
          measuredate:this.form1.input4,
          remark:this.form21.input1};
          p["totalmoney"]=this.form1.input5;
          p["housenum"]=this.form2.input1;
          p["housearea"]=this.form2.input2;
          p["houselv"]=this.form2.input3;
          p["houseuprice"]=this.form2.input4;
          p["houseprice"]=this.form2.input5;
          p["cellanum"]=this.form5.input1;
          p["cellaarea"]=this.form5.input2;
          p["cellalv"]=this.form5.input3;
          p["cellauprice"]=this.form5.input4;
          p["cellaprice"]=this.form5.input5;
          p["wellnum"]=this.form3.input1;
          p["welluprice"]=this.form3.input2;
          p["wellprice"]=this.form3.input3;
          p["phonenum"]=this.form4.input1;
          p["phoneuprice"]=this.form4.input2;
          p["phoneprice"]=this.form4.input3;
          p["digesternum"]=this.form6.input1;
          p["digesteruprice"]=this.form6.input2;
          p["digesterprice"]=this.form6.input3;
          p["wallnum"]=this.form7.input1;
          p["walluprice"]=this.form7.input2;
          p["wallprice"]=this.form7.input3;
          p["pigpennum"]=this.form8.input1;
          p["pigpenuprice"]=this.form8.input2;
          p["pigpenprice"]=this.form8.input3;
          p["wcnum"]=this.form9.input1;
          p["wcuprice"]=this.form9.input2;
          p["wcprice"]=this.form9.input3;
          p["concretenum"]=this.form10.input1;
          p["concreteuprice"]=this.form10.input2;
          p["concreteprice"]=this.form10.input3;
          p["cellarnum"]=this.form11.input1;
          p["cellaruprice"]=this.form11.input2;
          p["cellarprice"]=this.form11.input3;
          p["shacknum"]=this.form12.input1;
          p["shackuprice"]=this.form12.input2;
          p["shackprice"]=this.form12.input3;
          p["waternum"]=this.form13.input1;
          p["wateruprice"]=this.form13.input2;
          p["waterprice"]=this.form13.input3;
          p["tvnum"]=this.form14.input1;
          p["tvuprice"]=this.form14.input2;
          p["tvprice"]=this.form14.input3;
          p["archnum"]=this.form15.input1;
          p["archuprice"]=this.form15.input2;
          p["archprice"]=this.form15.input3;
          p["tree7num"]=this.form16.input1;
          p["tree7uprice"]=this.form16.input2;
          p["tree7price"]=this.form16.input3;
          p["tree8num"]=this.form17.input1;
          p["tree8uprice"]=this.form17.input2;
          p["tree8price"]=this.form17.input3;
          p["treespnum"]=this.form18.input1;
          p["treespuprice"]=this.form18.input2;
          p["treespprice"]=this.form18.input3;
        this.$axios
          .post('/Pdd/PopulationCul/add',p)
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
              alert('补偿表已存在，添加失败')
            }
            else if (successResponse.data.code == 402)
            {
              alert('户主信息已审核，不允许更改，添加失败')
            }
          })
          .catch(failResponse => {
          })
      },
      go2(){
        var _this = this
        _this.loading1=true
        var p={ id:this.form1.input6,
        mainid:this.form1.input1};
        if(this.form1.input3!=='')
        {
          p["address"]=this.form1.input3;
        }
        if(this.form1.input2!=='')
        {
            p["name"]=this.form1.input2;
        }
        if(this.form1.input4!==null)
        {
          p["measuredate"]=this.form1.input4;
        }
        if(this.form21.input1!=='')
        {
          p["remark"]=this.form21.input1;
        }
       if (this.form1.input5!==0)
       {
          p["totalmoney"]=this.form1.input5
       }
        if(this.form2.input1!=='')
        {
          p["housenum"]=this.form2.input1;
          p["housearea"]=this.form2.input2;
          p["houselv"]=this.form2.input3;
          p["houseuprice"]=this.form2.input4;
          p["houseprice"]=this.form2.input5;
        }
        if(this.form5.input1!=='')
        {
          p["cellanum"]=this.form5.input1;
          p["cellaarea"]=this.form5.input2;
          p["cellalv"]=this.form5.input3;
          p["cellauprice"]=this.form5.input4;
          p["cellaprice"]=this.form5.input5;
        }
        if(this.form3.input1!=='')
        {
          p["wellnum"]=this.form3.input1;
          p["welluprice"]=this.form3.input2;
          p["wellprice"]=this.form3.input3;
        }
        if(this.form4.input1!=='')
        {
          p["phonenum"]=this.form4.input1;
          p["phoneuprice"]=this.form4.input2;
          p["phoneprice"]=this.form4.input3;
        }
        if(this.form6.input1!=='')
        {
          p["digesternum"]=this.form6.input1;
          p["digesteruprice"]=this.form6.input2;
          p["digesterprice"]=this.form6.input3;
        }
        if(this.form7.input1!=='')
        {
          p["wallnum"]=this.form7.input1;
          p["walluprice"]=this.form7.input2;
          p["wallprice"]=this.form7.input3;
        }
        if(this.form8.input1!=='')
        {
          p["pigpennum"]=this.form8.input1;
          p["pigpenuprice"]=this.form8.input2;
          p["pigpenprice"]=this.form8.input3;
        }
        if(this.form9.input1!=='')
        {
          p["wcnum"]=this.form9.input1;
          p["wcuprice"]=this.form9.input2;
          p["wcprice"]=this.form9.input3;
        }
        if(this.form10.input1!=='')
        {
          p["concretenum"]=this.form10.input1;
          p["concreteuprice"]=this.form10.input2;
          p["concreteprice"]=this.form10.input3;
        }
        if(this.form11.input1!=='')
        {
          p["cellarnum"]=this.form11.input1;
          p["cellaruprice"]=this.form11.input2;
          p["cellarprice"]=this.form11.input3;
        }
        if(this.form12.input1!=='')
        {
          p["shacknum"]=this.form12.input1;
          p["shackruprice"]=this.form12.input2;
          p["shackprice"]=this.form12.input3;
        }
        if(this.form13.input1!=='')
        {
          p["waternum"]=this.form13.input1;
          p["wateruprice"]=this.form13.input2;
          p["waterprice"]=this.form13.input3;
        }
        if(this.form14.input1!=='')
        {
          p["tvnum"]=this.form14.input1;
          p["tvuprice"]=this.form14.input2;
          p["tvprice"]=this.form14.input3;
        }
        if(this.form15.input1!=='')
        {
          p["archnum"]=this.form15.input1;
          p["archuprice"]=this.form15.input2;
          p["archprice"]=this.form15.input3;
        }
        if(this.form16.input1!=='')
        {
          p["tree7num"]=this.form16.input1;
          p["tree7uprice"]=this.form16.input2;
          p["tree7price"]=this.form16.input3;
        }
        if(this.form17.input1!=='')
        {
          p["tree8num"]=this.form17.input1;
          p["tree8uprice"]=this.form17.input2;
          p["tree8price"]=this.form17.input3;
        }
        if(this.form18.input1!=='')
        {
          p["treespnum"]=this.form18.input1;
          p["treespuprice"]=this.form18.input2;
          p["treespprice"]=this.form18.input3;
        }
        this.$axios
          .post('/Pdd/PopulationCul/update',p)
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
              alert('补偿表不存在，修改失败')
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
          .post('/Pdd/PopulationCul/delete',{ id:this.form1.input6})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              alert('删除成功')
            }
            else if (successResponse.data.code == 400)
            {
              alert('补偿表不存在，删除失败')
            }
            else if (successResponse.data.code == 401)
            {
              alert('户主信息已审核，不允许更改，删除失败')
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
</style>
