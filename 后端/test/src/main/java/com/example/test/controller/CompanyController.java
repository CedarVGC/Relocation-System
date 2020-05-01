package com.example.test.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.test.pojo.*;
import com.example.test.result.Result;
import com.example.test.service.CompanyService;
import com.example.test.service.CompanycompensationService;
import com.example.test.service.CompanysettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanycompensationService companycompensationService;
    @Autowired
    CompanysettlementService companysettlementService;
    @CrossOrigin
    @GetMapping("api/Pdd/CompanyMessage/in1")
    public List<Company> CompanyMessageList() throws Exception {
        System.out.println("企业请求初始化");
        return companyService.list();
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/CompanyMessage/add1")
    public Result CompanyMessageAdd(@RequestBody Company requestCompany) throws Exception {
        System.out.println(requestCompany);
        if(companyService.isExist(requestCompany.getId()))
        {
            System.out.println("企业已存在");
            return new Result(400);
        }
        else
        {
            System.out.println("增加企业");
           companyService.add(requestCompany);
            return new Result(200);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/CompanyMessage/update1")
    public Result CompanyMessageUpdate(@RequestBody  Company requestCompany) throws Exception {
        if(companyService.isExist(requestCompany.getId()))
        {
            if (!companyService.isVerify(requestCompany.getId()))
            {
                companyService.update(requestCompany);
                System.out.println("修改企业成功");
                return new Result(200);
            }
           else
            {
                System.out.println("已审核的企业信息不允许修改");
                return new Result(401);
            }
        }
        else
        {
            System.out.println("企业不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/CompanyMessage/delete1")
    public Result CompanyMessageDelete(@RequestBody JSONObject Param) throws Exception {
        int id=Integer.parseInt(Param.get("id").toString());
        if(companyService.isExist(id))
        {
            if(!companyService.isVerify(id))
            {
                companyService.delete(id);
                System.out.println("删除企业成功");
                return new Result(200);
            }
            else
            {
                System.out.println("已审核的企业信息不允许删除");
                return new Result(401);
            }

        }
        else
        {
            System.out.println("企业不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/CompanyCul/add")
    public Result CompanyCulAdd(@RequestBody Companycompensation requestCompanycompensation) throws Exception {
        System.out.println(requestCompanycompensation);
        if (companyService.isExist(requestCompanycompensation.getMainid())){
            if(!companyService.isVerify(requestCompanycompensation.getMainid())) {
                if(!companycompensationService.isExist(requestCompanycompensation.getId())) {
                    companycompensationService.add(requestCompanycompensation);
                    return new Result(200);
                }
                else {
                    System.out.println("企业补偿表已存在，添加失败");
                    return new Result(401);
                }
            }
            else {
                System.out.println("企业已审核，添加失败");
                return new Result(402);
            }
        }
        else {
            System.out.println("企业不存在，添加失败");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/CompanyCul/update")
    public Result CompanyCulUpdate(@RequestBody Companycompensation requestCompanycompensation) throws Exception {
        if (companyService.isExist(requestCompanycompensation.getMainid())){
            if(!companyService.isVerify(requestCompanycompensation.getMainid()))
            {
                if(companycompensationService.isExist(requestCompanycompensation.getId()))
                {
                    companycompensationService.update(requestCompanycompensation);
                    return new Result(200);
                }
                else
                {
                    System.out.println("企业补偿表不存在，修改失败");
                    return new Result(401);
                }
            }
            else {
                System.out.println("企业信息已审核，不允许更改，修改失败");
                return new Result(402);
            }

        }
        else {
            System.out.println("户主不存在,修改失败");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/CompanyCul/delete")
    public Result CompanyCulDelete(@RequestBody JSONObject Param) throws Exception {
        int id = Integer.parseInt(Param.get("id").toString());
        if (companycompensationService.isExist(id)) {
            if(!companyService.isVerify(companycompensationService.findMainIdById(id)))
            {
                companycompensationService.delete(id);
                System.out.println("删除补偿成功");
                return new Result(200);
            }
            else
            {
                System.out.println("企业信息已审核，不允许更改，删除失败");
                return new Result(401);
            }
        }
        else
        {
            System.out.println("企业补偿表不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/CompanySettlement/add")
    public Result CompanySettlementAdd(@RequestBody Companysettlement requestCompanysettlement) throws Exception {
        System.out.println(requestCompanysettlement);
        if (companyService.isExist(requestCompanysettlement.getMainid())){
            if(!companyService.isVerify(requestCompanysettlement.getMainid())) {
                if(companysettlementService.isExist(requestCompanysettlement.getId())) {
                    companysettlementService.add(requestCompanysettlement);
                    return new Result(200);
                }
                else {
                    System.out.println("企业结算表已存在，添加失败 ");
                    return new Result(401);
                }
            }
            else {
                System.out.println("企业信息已审核，不允许更改，添加失败");
                return new Result(402);
            }
        }
        else {
            System.out.println("企业不存在，添加失败");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/CompanySettlement/update")
    public Result CompanySettlementUpdate(@RequestBody Companysettlement requestCompanysettlement) throws Exception {
        System.out.println(requestCompanysettlement);
        if (companyService.isExist(requestCompanysettlement.getMainid())){
            if(!companyService.isVerify(requestCompanysettlement.getMainid()))
            {
                if(companysettlementService.isExist(requestCompanysettlement.getId()))
                {
                    companysettlementService.update(requestCompanysettlement);
                    return new Result(200);
                }
                else
                {
                    System.out.println("企业结算表不存在，修改失败");
                    return new Result(401);
                }
            }
            else {
                System.out.println("企业信息已审核，不允许更改，修改失败");
                return new Result(402);
            }

        }
        else {
            System.out.println("企业不存在,修改失败");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/CompanySettlement/delete")
    public Result CompanySettlementDelete(@RequestBody JSONObject Param) throws Exception {
        int id = Integer.parseInt(Param.get("id").toString());
        if (companysettlementService.isExist(id))
        {
            if(!companyService.isVerify(companysettlementService.findMainIdById(id)))
            {
                companysettlementService.delete(id);
                return new Result(200);
            }
            else
            {
                return new Result(401);
            }

        }
        else {
            System.out.println("企业结算表不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @GetMapping("/api/Pdd/ComCheck/in1")
    public List<Company> PopulationCheckIn1() throws Exception {
        System.out.println("企业审核初始化");
        return companyService.list();
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/ComCheck/update1")
    public Result CompanyCheckUpdate1(@RequestBody JSONObject parm)throws Exception
    {
        System.out.println(parm);
        for(String str:parm.keySet()){
            int v=Integer.parseInt( parm.getJSONObject(str).getString("choose"));
            int id = parm.getJSONObject(str).getIntValue("id");
            companyService.updateVerify(id,v);
        }
        return new Result(200);
    }
    @CrossOrigin
    @PostMapping("api/Pdd/CompanyQuery/in1")
    public List<Company> CompanyQueryList1(@RequestBody Company parm) throws Exception {
        return companyService.CompanyQuery(parm);
    }
    @CrossOrigin
    @PostMapping("api/Pdd/CompanyQuery/in2")
    public List<Companycompensation> CompanyQueryList2(@RequestBody Companycompensation parm) throws Exception {
        return companycompensationService.CompanycompensationQuery(parm);
    }
    @PostMapping("api/Pdd/CompanyQuery/in3")
    public List<Companysettlement> CompanyQueryList3(@RequestBody Companysettlement parm) throws Exception {
        return companysettlementService.CompanysettlementQuery(parm);
    }
}
