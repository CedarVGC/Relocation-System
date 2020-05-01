<template>
  <div class="a1" >
    <el-card  class="box-card">
      <el-row>
        <el-form :inline="true" :model="form18" class="demo-form-inline">
          <el-form-item label="编号" class="redItem">
            <el-input v-model="form18.input1" clearable type="text"
                      placeholder="请输入正整数，例:'1'"
                      @blur="form18.input1=(form18.input1).replace(/[^\d]/g,'');"
                      @keyup.native="form18.input1=(form18.input1).replace(/[^\d]/g,'');"></el-input>
          </el-form-item>
          <el-form-item label="企业编号" class="redItem">
            <el-input v-model="form18.input2" clearable type="text"
                      placeholder="请输入正整数，例:'1'"
                      @blur="form18.input2=(form18.input2).replace(/[^\d]/g,'');"
                      @keyup.native="form18.input2=(form18.input2).replace(/[^\d]/g,'');"></el-input>
          </el-form-item>
          <el-form-item label="企业名称" class="redItem">
            <el-input v-model="form18.input3" clearable type="text"
                      maxLength='10'
                      placeholder="请输入企业名称,，例:'动迁公司'"
                      @blur="form18.input3=(form18.input3).replace(/[^\u4e00-\u9fa5]/g,'');"
                      @keyup.native="form18.input3=(form18.input3).replace(/[^\u4e00-\u9fa5]/g,'');" ></el-input>
          </el-form-item>
        </el-form>
      </el-row>
    <el-row type="flex"> <span>补偿信息</span></el-row>
    <el-row>
      <el-row>
        <el-col :span="8">
          <el-card  class="box-card">
          <el-row type="flex"> <span>办公楼</span></el-row>
          <el-row  >
          <el-form :model="form1">
            <el-row>
            <el-col :span='8'>
            <el-form-item label="总平方数">
              <el-input v-model="form1.input1" clearable type="text"
                        placeholder="单位:平方米"
                        @blur="form1.input1=(form1.input1).replace(/[^0-9\.]/g,'');"
                        @keyup.native="form1.input1=(form1.input1).replace(/[^0-9\.]/g,'');" ></el-input>
            </el-form-item >
            </el-col>
            <el-col :span='8'>
            <el-form-item label="等级">
              <el-input v-model="form1.input2" clearable type="text"
                        placeholder="单位:级"
                        @blur="form1.input2=(form1.input2).replace(/[^\d]/g,'');"
                        @keyup.native="form1.input2=(form1.input2).replace(/[^\d]/g,'');" ></el-input>
            </el-form-item>
            </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单价">
                  <el-input v-model="form1.input3" clearable type="text"
                            placeholder="单位:元"
                            @blur="form1.input3=(form1.input3).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form1.input3=(form1.input3).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="金额">
                  {{sum1+'元'}}
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
          </el-row>
        </el-card>
        </el-col>
        <el-col :span="8">
          <el-card  class="box-card">
          <el-row type="flex" > <span>小楼</span></el-row>
          <el-row >
            <el-form :model="form2">
              <el-row>
              <el-col :span='8'>
                <el-form-item label="总平方数">
                  <el-input v-model="form2.input1" clearable type="text"
                            placeholder="单位:平方米"
                            @blur="form2.input1=(form2.input1).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form2.input1=(form2.input1).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item >
              </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="单价">
                    <el-input v-model="form2.input2" clearable type="text"
                              placeholder="单位:元"
                              @blur="form2.input2=(form2.input2).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form2.input2=(form2.input2).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="金额">
                    {{sum2+'元'}}
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </el-row>
        </el-card>
        </el-col>
        <el-col :span="8">
          <el-card  class="box-card">
          <el-row type="flex"> <span>水泥地</span></el-row>
          <el-row >
            <el-form :model="form3">
              <el-row>
              <el-col :span='8'>
                <el-form-item label="总平方数">
                  <el-input v-model="form3.input1" clearable type="text"
                            placeholder="单位:平方米"
                            @blur="form3.input1=(form3.input1).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form3.input1=(form3.input1).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item >
              </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="单价">
                    <el-input v-model="form3.input2" clearable type="text"
                              placeholder="单位:元"
                              @blur="form3.input2=(form3.input2).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form3.input2=(form3.input2).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="金额">
                    {{sum3+'元'}}
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </el-row>
          </el-card>
        </el-col>
      </el-row>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-card  class="box-card">
        <el-row type="flex"> <span>厂房</span></el-row>
        <el-row>
          <el-form :model="form4">
            <el-row>
            <el-col :span='8'>
              <el-form-item label="总平方数">
                <el-input v-model="form4.input1" clearable type="text"
                          placeholder="单位:平方米"
                          @blur="form4.input1=(form4.input1).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form4.input1=(form4.input1).replace(/[^0-9\.]/g,'');" ></el-input>
              </el-form-item >
            </el-col>
            <el-col :span='8'>
              <el-form-item label="等级">
                <el-input v-model="form4.input2" clearable type="text"
                          placeholder="单位:级"
                          @blur="form4.input2=(form4.input2).replace(/[^\d]/g,'');"
                          @keyup.native="form4.input2=(form4.input2).replace(/[^\d]/g,'');"></el-input>
              </el-form-item>
            </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单价">
                  <el-input v-model="form4.input3" clearable type="text"
                            placeholder="单位:元"
                            @blur="form4.input3=(form4.input3).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form4.input3=(form4.input3).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="金额">
                  {{sum4+'元'}}
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-row>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card  class="box-card">
        <el-row type="flex" > <span>砖地</span></el-row>
        <el-row >
          <el-form :model="form5">
            <el-row>
            <el-col :span='8'>
              <el-form-item label="总平方数">
                <el-input v-model="form5.input1" clearable type="text"
                          placeholder="单位:平方米"
                          @blur="form5.input1=(form5.input1).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form5.input1=(form5.input1).replace(/[^0-9\.]/g,'');"></el-input>
              </el-form-item >
            </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单价">
                  <el-input v-model="form5.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form5.input2=(form5.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form5.input2=(form5.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="金额">
                  {{sum5+'元'}}
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-row>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card  class="box-card">
        <el-row type="flex"> <span>水泥路</span></el-row>
        <el-row >
          <el-form :model="form6">
            <el-row>
            <el-col :span='8'>
              <el-form-item label="总平方数">
                <el-input v-model="form6.input1" clearable type="text"
                          placeholder="单位:平方米"
                          @blur="form6.input1=(form6.input1).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form6.input1=(form6.input1).replace(/[^0-9\.]/g,'');"></el-input>
              </el-form-item >
            </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单价">
                  <el-input v-model="form6.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form6.input2=(form6.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form6.input2=(form6.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="金额">
                  {{sum6+'元'}}
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-row>
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-card  class="box-card">
        <el-row type="flex" > <span>围墙</span></el-row>
        <el-row >
          <el-form :model="form7">
            <el-row>
            <el-col :span='8'>
              <el-form-item label="总平方数">
                <el-input v-model="form7.input1" clearable type="text"
                          placeholder="单位:平方米"
                          @blur="form7.input1=(form7.input1).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form7.input1=(form7.input1).replace(/[^0-9\.]/g,'');"></el-input>
              </el-form-item >
            </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单价">
                  <el-input v-model="form7.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form7.input2=(form7.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form7.input2=(form7.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="金额">
                  {{sum7+'元'}}
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-row>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card  class="box-card">
        <el-row type="flex" > <span>沥青路</span></el-row>
        <el-row >
          <el-form :model="form8">
            <el-row>
            <el-col :span='8'>
              <el-form-item label="总平方数">
                <el-input v-model="form8.input1" clearable type="text"
                          placeholder="单位:平方米"
                          @blur="form8.input1=(form8.input1).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form8.input1=(form8.input1).replace(/[^0-9\.]/g,'');"></el-input>
              </el-form-item >
            </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单价">
                  <el-input v-model="form8.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form8.input2=(form8.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form8.input2=(form8.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="金额">
                  {{sum8+'元'}}
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-row>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card  class="box-card">
        <el-row type="flex"> <span>护坡墙</span></el-row>
        <el-row >
          <el-form :model="form9">
            <el-row>
            <el-col :span='8'>
              <el-form-item label="总平方数">
                <el-input v-model="form9.input1" clearable type="text"
                          placeholder="单位:平方米"
                          @blur="form9.input1=(form9.input1).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form9.input1=(form9.input1).replace(/[^0-9\.]/g,'');"></el-input>
              </el-form-item >
            </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单价">
                  <el-input v-model="form9.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form9.input2=(form9.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form9.input2=(form9.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="金额">
                  {{sum9+'元'}}
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-row>
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-card  class="box-card">
        <el-row type="flex"> <span>挡土墙</span></el-row>
        <el-row >
          <el-form :model="form10">
            <el-row>
            <el-col :span='8'>
              <el-form-item label="总平方数">
                <el-input v-model="form10.input1" clearable type="text"
                          placeholder="单位:平方米"
                          @blur="form10.input1=(form10.input1).replace(/[^0-9\.]/g,'');"
                          @keyup.native="form10.input1=(form10.input1).replace(/[^0-9\.]/g,'');"></el-input>
              </el-form-item >
            </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="单价">
                  <el-input v-model="form10.input2" clearable type="text"
                            placeholder="单位:元"
                            @blur="form10.input2=(form10.input2).replace(/[^0-9\.]/g,'');"
                            @keyup.native="form10.input2=(form10.input2).replace(/[^0-9\.]/g,'');"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="金额">
                  {{sum10+'元'}}
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-row>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card  class="box-card">
          <el-row type="flex"> <span>栅栏</span></el-row>
          <el-row >
            <el-form :model="form11">
              <el-row>
                <el-col :span='8'>
                  <el-form-item label="总个数">
                    <el-input v-model="form11.input1" clearable type="text"
                              placeholder="单位:个"
                              @blur="form11.input1=(form11.input1).replace(/[^0-9]/g,'');"
                              @keyup.native="form11.input1=(form11.input1).replace(/[^0-9]/g,'');"></el-input>
                  </el-form-item >
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="单价">
                    <el-input v-model="form11.input2" clearable type="text"
                              placeholder="单位:元"
                              @blur="form11.input2=(form11.input2).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form11.input2=(form11.input2).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="金额">
                    {{sum11+'元'}}
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </el-row>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card  class="box-card">
          <el-row type="flex"> <span>棚厦</span></el-row>
          <el-row >
            <el-form :model="form12">
              <el-row>
                <el-col :span='8'>
                  <el-form-item label="总个数">
                    <el-input v-model="form12.input1" clearable type="text"
                              placeholder="单位:个"
                              @blur="form12.input1=(form12.input1).replace(/[^0-9]/g,'');"
                              @keyup.native="form12.input1=(form12.input1).replace(/[^0-9]/g,'');"></el-input>
                  </el-form-item >
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="单价">
                    <el-input v-model="form12.input2" clearable type="text"
                              placeholder="单位:元"
                              @blur="form12.input2=(form12.input2).replace(/[^0-9\.]/g,'');"
                              @keyup.native="form12.input2=(form12.input2).replace(/[^0-9\.]/g,'');"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="金额">
                    {{sum12+'元'}}
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
      <el-row>
        <el-col :span="8">
          <el-card  class="box-card">
            <el-row type="flex"> <span>有线电视</span></el-row>
            <el-row >
              <el-form :model="form13">
                <el-row>
                  <el-col :span='8'>
                    <el-form-item label="总个数">
                      <el-input v-model="form13.input1" clearable type="text"
                                placeholder="单位:个"
                                @blur="form13.input1=(form13.input1).replace(/[^0-9]/g,'');"
                                @keyup.native="form13.input1=(form13.input1).replace(/[^0-9]/g,'');"></el-input>
                    </el-form-item >
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="单价">
                      <el-input v-model="form13.input2" clearable type="text"
                                placeholder="单位:元"
                                @blur="form13.input2=(form13.input2).replace(/[^0-9\.]/g,'');"
                                @keyup.native="form13.input2=(form13.input2).replace(/[^0-9\.]/g,'');"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="金额">
                      {{sum13+'元'}}
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form>
            </el-row>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card  class="box-card">
            <el-row type="flex"> <span>电话</span></el-row>
            <el-row >
              <el-form :model="form14">
                <el-row>
                  <el-col :span='8'>
                    <el-form-item label="总个数">
                      <el-input v-model="form14.input1" clearable type="text"
                                placeholder="单位:个"
                                @blur="form14.input1=(form14.input1).replace(/[^0-9]/g,'');"
                                @keyup.native="form14.input1=(form14.input1).replace(/[^0-9]/g,'');" ></el-input>
                    </el-form-item >
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="单价">
                      <el-input v-model="form14.input2"  clearable type="text"
                                placeholder="单位:元"
                                @blur="form14.input2=(form14.input2).replace(/[^0-9\.]/g,'');"
                                @keyup.native="form14.input2=(form14.input2).replace(/[^0-9\.]/g,'');"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="金额">
                      {{sum14+'元'}}
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form>
            </el-row>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card  class="box-card">
            <el-row type="flex"> <span>水井</span></el-row>
            <el-row >
              <el-form :model="form15">
                <el-row>
                  <el-col :span='8'>
                    <el-form-item label="总个数">
                      <el-input v-model="form15.input1" clearable type="text"
                                placeholder="单位:个"
                                @blur="form15.input1=(form15.input1).replace(/[^0-9]/g,'');"
                                @keyup.native="form15.input1=(form15.input1).replace(/[^0-9]/g,'');" ></el-input>
                    </el-form-item >
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="单价">
                      <el-input v-model="form15.input2" clearable type="text"
                                placeholder="单位:元"
                                @blur="form15.input2=(form15.input2).replace(/[^0-9\.]/g,'');"
                                @keyup.native="form15.input2=(form15.input2).replace(/[^0-9\.]/g,'');"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="金额">
                      {{sum15+'元'}}
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form>
            </el-row>
          </el-card>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-card  class="box-card">
            <el-row type="flex"> <span>院门</span></el-row>
            <el-row >
              <el-form :model="form13">
                <el-row>
                  <el-col :span='8'>
                    <el-form-item label="总个数">
                      <el-input v-model="form16.input1" clearable type="text"
                                placeholder="单位:个"
                                @blur="form16.input1=(form16.input1).replace(/[^0-9]/g,'');"
                                @keyup.native="form16.input1=(form16.input1).replace(/[^0-9]/g,'');"></el-input>
                    </el-form-item >
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="单价">
                      <el-input v-model="form16.input2" clearable type="text"
                                placeholder="单位:元"
                                @blur="form16.input2=(form16.input2).replace(/[^0-9\.]/g,'');"
                                @keyup.native="form16.input2=(form16.input2).replace(/[^0-9\.]/g,'');"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="金额">
                      {{sum16+'元'}}
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form>
            </el-row>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card  class="box-card">
            <el-row type="flex"> <span>其它</span></el-row>
            <el-row >
              <el-form :model="form17">
                  <el-col :span='8'>
                    <el-form-item >
                      <el-input v-model="form17.input1" ></el-input>
                    </el-form-item >
                  </el-col>
              </el-form>
            </el-row>
          </el-card>
        </el-col>
        <el-col :span="8">
          <el-card  class="box-card">
            <el-row type="flex"> <span>总金额</span></el-row>
            <el-row >
              <el-form :model="form17">
                  <el-col :span='8'>
                    <el-form-item >
                      {{sumall+'元'}}
                    </el-form-item >
                  </el-col>
              </el-form>
            </el-row>
          </el-card>
        </el-col>
      </el-row>
    </el-card>
    <el-row>
      <el-button :disabled="right1" type="primary" round icon="el-icon-circle-plus-outline" @click="subForm">增加</el-button>
      <el-button :disabled="right1" type="success" round icon="el-icon-edit" @click="updateForm">修改</el-button>
      <el-button :disabled="right2" type="danger" round icon="el-icon-delete" @click="delForm">删除</el-button>
    </el-row>
  </div>
</template>
<script>
  //# sourceMappingURL=file.js.map
  export default {
    data() {
      return {
        form1:{input1:'', input2:'',input3:'',input4:''},
        form2:{input1:'',input2:'',input3:''},
        form3:{input1:'',input2:'',input3:''},
        form4:{input1:'',input2:'',input3:'',input4:''},
        form5:{input1:'',input2:'',input3:''},
        form6:{input1:'',input2:'',input3:''},
        form7:{input1:'',input2:'',input3:''},
        form8:{input1:'',input2:'',input3:''},
        form9:{input1:'',input2:'',input3:''},
        form10:{input1:'',input2:'',input3:''},
        form11:{input1:'',input2:'',input3:''},
        form12:{input1:'',input2:'',input3:''},
        form13:{input1:'',input2:'',input3:''},
        form14:{input1:'',input2:'',input3:''},
        form15:{input1:'',input2:'',input3:''},
        form16:{input1:'',input2:'',input3:''},
        form17:{input1:'',input2:''},
        form18:{input1:'',input2:'',input3:''},
        right0:true,right1:true,right2:true,
      }
    },
    computed:
      {
        sum1: function () {
          this.form1.input4 = this.form1.input1 * this.form1.input2 * this.form1.input3
          return this.form1.input4;
        },
        sum2: function () {
          this.form2.input3 = this.form2.input1 * this.form2.input2
          return this.form2.input3;
        },
        sum3: function () {
          this.form3.input3 = this.form3.input1 * this.form3.input2
          return this.form3.input3;
        },
        sum4: function () {
          this.form4.input4 = this.form4.input1 * this.form4.input2 * this.form4.input3
          return this.form4.input4;
        },
        sum5: function () {
          this.form5.input3 = this.form5.input1 * this.form5.input2
          return this.form5.input3;
        },
        sum6: function () {
          this.form6.input3 = this.form6.input1 * this.form6.input2
          return this.form6.input3;
        },
        sum7: function () {
          this.form7.input3 = this.form7.input1 * this.form7.input2
          return this.form7.input3;
        },
        sum8: function () {
          this.form8.input3 = this.form8.input1 * this.form8.input2
          return this.form8.input3;
        },
        sum9: function () {
          this.form9.input3 = this.form9.input1 * this.form9.input2
          return this.form9.input3;
        },
        sum10: function () {
          this.form10.input3 = this.form10.input1 * this.form10.input2
          return this.form10.input3;
        },
        sum11: function () {
          this.form11.input3 = this.form11.input1 * this.form11.input2
          return this.form11.input3;
        },
        sum12: function () {
          this.form12.input3 = this.form12.input1 * this.form12.input2
          return this.form12.input3;
        },
        sum13: function () {
          this.form13.input3 = this.form13.input1 * this.form13.input2
          return this.form13.input3;
        },
        sum14: function () {
          this.form14.input3 = this.form14.input1 * this.form14.input2
          return this.form14.input3;
        },
        sum15: function () {
          this.form15.input3 = this.form15.input1 * this.form15.input2
          return this.form15.input3;
        },
        sum16: function () {
          this.form16.input3 = this.form16.input1 * this.form16.input2
          return this.form16.input3;
        },
        sumall: function () {
          this.form17.input2 = this.form1.input4 +this.form2.input3 + this.form3.input3 + this.form4.input4 + this.form5.input3 + this.form6.input3 + this.form7.input3 + this.form8.input3 + this.form9.input3 + this.form10.input3 + this.form11.input3 + this.form12.input3 + this.form13.input3 + this.form14.input3 + this.form15.input3 + this.form16.input3 ;
          return this.form17.input2 ;
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
        if(this.form18.input1!==''&&this.form18.input2!==''&&this.form18.input3!==''){
          this.go1()
        }
        else
        {
          alert('信息输入不全。增加操作，编号.企业编号.企业名称 必须填写')
        }
      },
      updateForm() {
        if(this.form18.input2!==''&&this.form18.input1!==''){
          this.go2()
        }
        else {
          alert('信息输入不全。修改操作，编号.企业编号必须填写')
        }
      },
      delForm() {
        if(this.form18.input1!==''){
          this.open();
        }
        else {
          alert('信息输入不全。删除操作，编号必须填写')
        }
      },
      go1(){
        var _this = this
        _this.loading1=true
        this.$axios
          .post('/Pdd/CompanyCul/add', {
        id:this.form18.input1,
        mainid:this.form18.input2,
        name :this.form18.input3,
        totalmoney:this.form17.input2,
        asphaltroadnum :this.form8.input1,
        asphaltroaduprice :this.form8.input2,
        asphaltroadprice :this.form8.input3,
        cementroadnum:this.form6.input1,
        cementroaduprice:this.form6.input2,
        cementroadprice :this.form6.input3,
        concretenum :this.form3.input1,
        concreteuprice :this.form3.input2,
        concreteprice:this.form3.input3,
        houseletnum:this.form2.input1,
        houseletuprice:this.form2.input2,
        houseletprice :this.form2.input3,
        officenum :this.form1.input1,
        officelv :this.form1.input2,
        officeuprice  :this.form1.input3,
        officeprice :this.form1.input4,
        plantnum :this.form4.input1,
        plantlv:this.form4.input2,
        plantuprice:this.form4.input3,
        plantprice :this.form4.input4,
        retainwallnum:this.form10.input1,
        retainwalluprice:this.form10.input2,
        retainwallprice:this.form10.input3,
        slopewallnum :this.form9.input1,
        slopewalluprice :this.form9.input2,
        slopewallprice :this.form9.input3,
        tilenum :this.form5.input1,
        tileuprice:this.form5.input2,
        tileprice:this.form5.input3,
       wallnum:this.form7.input1,
        walluprice:this.form7.input2,
        wallprice:this.form7.input3,
        shednum :this.form12.input1,
        sheduprice:this.form12.input2,
        shedprice :this.form12.input3,
        wellnum:this.form15.input1,
        welluprice :this.form15.input2,
        wellprice  :this.form15.input3,
        tvnum:this.form13.input1,
        tvuprice:this.form13.input2,
        tvprice:this.form13.input3,
        fencenum:this.form11.input1,
        fenceuprice :this.form11.input2,
        fenceprice :this.form11.input3,
        phonenum  :this.form14.input1,
        phoneuprice:this.form14.input2,
        phoneprice:this.form14.input3,
         doornum  :this.form16.input1,
         dooruprice  :this.form16.input2,
         doorpricre:this.form16.input3,
        remark:this.form17.input1 })
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              _this.convert1();
              alert('企业信息添加成功')
            }
            else if (successResponse.data.code == 400)
            {
              alert('企业不存在，添加失败')
            }
            else if (successResponse.data.code == 401)
            {
              alert('企业补偿表已存在，添加失败')
            }
            else if (successResponse.data.code == 402)
            {
              alert('企业已审核，添加失败')
            }
          })
          .catch(failResponse => {
          })
      },
      go2(){
        var _this = this
        _this.loading1=true
        var p= {
          id:this.form18.input1,
          mainid:this.form18.input2};
        if (this.form8.input1!=='')
        {
          p["asphaltroadnum"]=this.form8.input1;
          p["asphaltroaduprice"]=this.form8.input2;
          p["asphaltroadprice "]=this.form8.input3;
        }
        if (this.form6.input1!=='')
        {
          p["cementroadnum"]=this.form6.input1;
          p["cementroaduprice"]=this.form6.input2;
          p[" cementroadprice"]=this.form6.input3;
        }
        if(this.form3.input1!=='')
        {
          p["concretenum"]=this.form3.input1;
          p["concreteuprice"]=this.form3.input2;
          p["concreteprice"]=this.form3.input3;
        }
        if(this.form2.input1!=='')
        {
          p["houseletnum"]=this.form2.input1;
          p["houseletuprice"]=this.form2.input1;
          p["houseletprice"]=this.form2.input1;
        }
        if(this.form1.input1!=='')
        {
          p["officenum"]=this.form1.input1;
          p["officelv"]=this.form1.input2;
          p["officeuprice"]=this.form1.input3;
          p["officeprice"]=this.form1.input4;

        }
        if(this.form4.input1!=='')
        {
          p["plantnum"]=this.form4.input1;
          p["plantlv"]=this.form4.input2;
          p["plantuprice"]=this.form4.input3;
          p["plantprice"]=this.form4.input4;
        }
        if(this.form10.input1!=='')
        {
          p["retainwallnum"]=this.form10.input1;
          p["retainwalluprice"]=this.form10.input2;
          p["retainwallprice"]=this.form10.input3;
        }
        if(this.form9.input1!=='')
        {
          p["slopewallnum"]=this.form9.input1;
          p["slopewalluprice"]=this.form9.input2;
          p["slopewallprice"]=this.form9.input3;
        }
        if(this.form5.input1!=='')
        {
          p["tilenum"]=this.form5.input1;
          p["tileuprice"]=this.form5.input2;
          p["tileprice"]=this.form5.input3;
        }
        if(this.form7.input1!=='')
        {
          p["wallnum"]=this.form7.input1;
          p["walluprice"]=this.form7.input2;
          p["wallprice"]=this.form7.input3;
        }
        if(this.form12.input1!=='')
        {
          p["shednum"]=this.form12.input1;
          p["sheduprice"]=this.form12.input2;
          p["shedprice"]=this.form12.input3;
        }
        if(this.form15.input1!=='')
        {
          p["wellnum"]=this.form15.input1;
          p["welluprice"]=this.form15.input2;
          p["wellprice"]=this.form15.input3;
        }
        if(this.form16.input1!=='')
        {
          p["doornum"]=this.form16.input1;
          p["dooruprice"]=this.form16.input2;
          p["doorpricre"]=this.form16.input3;
        }
        if(this.form11.input1!=='')
        {
          p["fencenum"]=this.form11.input1;
          p["fenceuprice"]=this.form11.input2;
          p["fenceprice"]=this.form11.input3;
        }
        if(this.form14.input1!=='')
        {
          p["phonenum"]=this.form14.input1;
          p["phoneuprice"]=this.form14.input2;
          p["phoneprice"]=this.form14.input3;
        }
        if(this.form13.input1!=='')
        {
          p["tvnum"]=this.form13.input1;
          p["tvuprice"]=this.form13.input2;
          p["tvprice"]=this.form13.input3;
        }
        if(this.form18.input3!=='')
        {
          p["name"]=this.form18.input3;
        }
        if(this.form17.input1!=='')
        {
          p["remark"]=this.form17.input1;
        }
        if(this.form17.input2!==0)
        {
          p["totalmoney"]=this.form17.input2;
        }
        this.$axios
          .post('/Pdd/CompanyCul/update',p)
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              alert('企业信息添加成功')
            }
            else if (successResponse.data.code == 400)
            {
              alert('企业不存在,修改失败')
            }
            else if (successResponse.data.code == 401)
            {
              alert('企业补偿表不存在，修改失败')
            }
            else if (successResponse.data.code == 402)
            {
              alert('企业信息已审核，不允许更改，修改失败')
            }
          })
          .catch(failResponse => {
          })
      },
      go3(){
        this.$axios
          .post('/Pdd/CompanyCul/delete',{ id:this.form18.input1})
          .then(successResponse => {
            if (successResponse.data.code == 200)
            {
              alert('删除成功')
            }
            else if (successResponse.data.code == 400)
            {
              alert('企业补偿表不存在，删除失败')
            }
            else if (successResponse.data.code == 401)
            {
              alert('企业信息已审核，不允许更改，删除失败')
            }
          })
          .catch(failResponse => {
          })
      },
      open() {
        this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
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

