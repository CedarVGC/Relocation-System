package com.example.test.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.test.pojo.People;
import com.example.test.pojo.Peoplecompensation;
import com.example.test.pojo.Peopledetail;
import com.example.test.pojo.Peoplesettlement;
import com.example.test.result.Result;
import com.example.test.service.PeopleService;
import com.example.test.service.PeoplecompensationService;
import com.example.test.service.PeopledetailService;
import com.example.test.service.PeoplesettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class PeopleController {
    @Autowired
    PeopleService peopleService;
    @Autowired
    PeopledetailService peopledetailService;
    @Autowired
    PeoplecompensationService peoplecompensationService;
    @Autowired
    PeoplesettlementService peoplesettlementService;
    @CrossOrigin
    @GetMapping("api/Pdd/PopulationMessage/in1")
    public List<People> PopulationMessageList1() throws Exception {
        System.out.println("户主请求初始化");
        return peopleService.list();
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationMessage/add1")
    public Result PopulationMessageAdd1(@RequestBody People requestPeople) throws Exception {
        System.out.println(requestPeople);
        if (peopleService.isExist(requestPeople.getId())) {
            System.out.println("户主已存在");
            return new Result(400);
        } else {
            System.out.println("增加户主");
            peopleService.add(requestPeople);
            return new Result(200);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationMessage/update1")
    public Result PopulationMessageUpdate1(@RequestBody People requestPeople) throws Exception {
        if (peopleService.isExist(requestPeople.getId())) {
            if(!peopleService.isVerify(requestPeople.getId()))
            {
                peopleService.update(requestPeople);
                System.out.println("修改户主成功");
                return new Result(200);
            }
            else
            {
                System.out.println("已审核的户主信息不允许修改");
                return new Result(401);
            }

        }
        else {
            System.out.println("户主不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationMessage/delete1")
    public Result PopulationMessageDelete1(@RequestBody JSONObject Param) throws Exception {
        int id = Integer.parseInt(Param.get("id").toString());
        if (peopleService.isExist(id)) {
            if(!peopleService.isVerify(id))
            {
                peopleService.delete(id);
                System.out.println("删除户主成功");
                return new Result(200);
            }
            else
            {
                System.out.println("已审核的户主信息不允许删除");
                return new Result(401);
            }

        } else {
            System.out.println("户主不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @GetMapping("api/Pdd/PopulationMessage/in2")
    public List<Peopledetail> PopulationMessageList2() throws Exception {
        System.out.println("明细户主请求初始化");
        return peopledetailService.list();
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationMessage/add2")
    public Result PopulationMessageAdd2(@RequestBody Peopledetail requestPeopledetail) throws Exception {
        System.out.println(requestPeopledetail);
        if(peopleService.isExist(requestPeopledetail.getMainid()))
        {
            if (peopledetailService.isExist(requestPeopledetail.getId())) {
                System.out.println("明细户主已存在");
                return new Result(400);
            }
            else {

                    System.out.println("增加明细户主");
                    peopledetailService.add(requestPeopledetail);
                    return new Result(200);
            }
        }
       else
        {
            System.out.println("户主不存在");
            return new Result(401);
        }
    }

    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationMessage/update2")
    public Result PopulationMessageUpdate2(@RequestBody Peopledetail requestPeopledetail) throws Exception {
        System.out.println(requestPeopledetail);
        if (peopledetailService.isExist(requestPeopledetail.getId())) {
            if(requestPeopledetail.getMainid()==0||peopleService.isExist(requestPeopledetail.getMainid()))
            {
                if(!peopledetailService.isVerify(requestPeopledetail.getId()))
                {
                    peopledetailService.update(requestPeopledetail);
                    System.out.println("修改明细户主成功");
                    return new Result(200);
                }
                else
                {
                    System.out.println("已审核的明细户主信息不允许修改");
                    return new Result(401);
                }
            }
            else
            {
                System.out.println("户主不存在");
                return new Result(402);
            }
        }
        else {
            System.out.println("明细户主不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationMessage/delete2")
    public Result PopulationMessageDelete2(@RequestBody JSONObject Param) throws Exception {
        int id = Integer.parseInt(Param.get("id").toString());
        if (peopledetailService.isExist(id))
        {
            if(!peopledetailService.isVerify(id))
            {
                peopledetailService.delete(id);
                System.out.println("删除明细户主成功");
                return new Result(200);
            }
            else
            {
                System.out.println("已审核的明细户主信息不允许修改");
                return new Result(401);
            }

        }
        else {
            System.out.println("明细户主不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationCul/add")
    public Result PopulationCulAdd(@RequestBody Peoplecompensation requestPeoplecompensation) throws Exception {
        System.out.println(requestPeoplecompensation);
        if (peopleService.isExist(requestPeoplecompensation.getMainid())){
            if(!peopleService.isVerify(requestPeoplecompensation.getMainid()))
            {
                if(!peoplecompensationService.isExist(requestPeoplecompensation.getId()))
                {
                    peoplecompensationService.add(requestPeoplecompensation);
                    return new Result(200);
                }
                else
                {
                    System.out.println("补偿表已存在，添加失败");
                    return new Result(401);
                }
            }
            else
            {
                System.out.println("户主已审核，添加失败");
                return new Result(402);
            }
        }
        else {
            System.out.println("户主不存在，添加失败");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationCul/update")
    public Result PopulationCulUpdate(@RequestBody Peoplecompensation requestPeoplecompensation) throws Exception {
        System.out.println(requestPeoplecompensation);
        if (peopleService.isExist(requestPeoplecompensation.getMainid())){
            if(!peopleService.isVerify(requestPeoplecompensation.getMainid()))
            {
                if(peoplecompensationService.isExist(requestPeoplecompensation.getId()))
                {
                    peoplecompensationService.update(requestPeoplecompensation);
                    return new Result(200);
                }
                else
                {
                    System.out.println("补偿表不存在，修改失败");
                    return new Result(401);
                }
            }
           else {
                System.out.println("户主信息已审核，不允许更改，修改失败");
                return new Result(402);
            }

        }
        else {
            System.out.println("户主不存在,修改失败");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationCul/delete")
    public Result PopulationCulDelete(@RequestBody JSONObject Param) throws Exception {
        System.out.println(Param);
        int id = Integer.parseInt(Param.get("id").toString());
        if (peoplecompensationService.isExist(id)) {
            if(!peopleService.isVerify(peoplecompensationService.findMainIdById(id)))
            {
                peoplecompensationService.delete(id);
                System.out.println("删除补偿成功");
                return new Result(200);
            }
            else
                {
                System.out.println("户主信息已审核，不允许更改，删除失败");
                return new Result(401);
                }
            }
        else
        {
            System.out.println("补偿表不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationSettlement/add")
    public Result PopulationSettlementAdd(@RequestBody Peoplesettlement requestPeoplesettlement) throws Exception {
        System.out.println(requestPeoplesettlement);
        if (peopleService.isExist(requestPeoplesettlement.getMainid())){
            if(!peopleService.isVerify(requestPeoplesettlement.getMainid()))
            {
                if(!peoplesettlementService.isExist(requestPeoplesettlement.getId()))
                {
                    peoplesettlementService.add(requestPeoplesettlement);
                    return new Result(200);
                }
                else
                {
                    System.out.println("结算表已存在，添加失败");
                    return new Result(401);
                }
            }
            else
            {
                System.out.println("户主信息已审核，不允许更改，添加失败");
                return new Result(402);
            }

        }
        else {
            System.out.println("户主不存在，添加失败");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationSettlement/update")
    public Result PopulationSettlementUpdate(@RequestBody Peoplesettlement requestPeoplesettlement) throws Exception {
        System.out.println(requestPeoplesettlement);
        if (peopleService.isExist(requestPeoplesettlement.getMainid())){
            if(!peopleService.isVerify(requestPeoplesettlement.getMainid()))
            {
                if(peoplesettlementService.isExist(requestPeoplesettlement.getId()))
                {
                    peoplesettlementService.update(requestPeoplesettlement);
                    return new Result(200);
                }
                else
                {
                    System.out.println("结算表不存在，修改失败");
                    return new Result(401);
                }
            }
            else {
                System.out.println("户主信息已审核，不允许更改，修改失败");
                return new Result(402);
            }

        }
        else {
            System.out.println("户主不存在,修改失败");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationSettlement/delete")
    public Result PopulationSettlementDelete(@RequestBody JSONObject Param) throws Exception {
        int id = Integer.parseInt(Param.get("id").toString());
        if (peoplesettlementService.isExist(id)) {
            if(!peopleService.isVerify(peoplesettlementService.findMainIdById(id))) {
                peoplesettlementService.delete(id);
                System.out.println("结算表删除成功");
                return new Result(200);
            }
            else {
                System.out.println("户主信息已审核，不允许删除");
                return new Result(401);
            }

        }
        else {
            System.out.println("结算表不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @GetMapping("/api/Pdd/PopulationCheck/in1")
    public List<People> PopulationCheckIn1() throws Exception {
        System.out.println("审核初始化");
        return peopleService.list();
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationCheck/update1")
    public Result PopulationCheckUpdate1(@RequestBody JSONObject parm) throws Exception {
        System.out.println(parm);
        for(String str:parm.keySet()){
            int id = parm.getJSONObject(str).getIntValue("id");
            int v=Integer.parseInt(parm.getJSONObject(str).getString("choose"));
            peopleService.updateVerify(id,v);
        }
        return new Result(200);
    }
    @CrossOrigin
    @GetMapping("/api/Pdd/PopulationCheck/in2")
    public List<Peopledetail> PopulationCheckIn2() throws Exception {
        System.out.println("明细户主审核初始化");
        return peopledetailService.list();
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/PopulationCheck/update2")
    public Result PopulationCheckUpdate2(@RequestBody JSONObject parm) throws Exception {
        for(String str:parm.keySet()){
            int vv=Integer.parseInt(parm.getJSONObject(str).getString("choose"));
            int id = parm.getJSONObject(str).getIntValue("id");
            peopledetailService.updateVerify(id ,vv);
        }
        return new Result(200);
    }
    @CrossOrigin
    @PostMapping("api/Pdd/PopulationQuery/in1")
    public List<People> PopulationQueryList1(@RequestBody People Param) throws Exception {
        return peopleService.PeopleQuery(Param);
    }
    @CrossOrigin
    @PostMapping("api/Pdd/PopulationQuery/in2")
    public List<Peopledetail> PopulationQueryList2(@RequestBody Peopledetail  Param) throws Exception {
        return peopledetailService.PeopledetailQuery(Param);
    }
    @CrossOrigin
    @PostMapping("api/Pdd/PopulationQuery/in3")
    public List<Peoplecompensation> PopulationQueryList3(@RequestBody Peoplecompensation Param) throws Exception {
        return peoplecompensationService.PeoplecompensationQuery(Param);
    }
    @CrossOrigin
    @PostMapping("api/Pdd/PopulationQuery/in4")
    public List<Peoplesettlement> PopulationQueryList4(@RequestBody Peoplesettlement Param) throws Exception {
        return peoplesettlementService.PeoplesettlementQuery(Param);
    }
}
