package com.example.test.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.test.pojo.Departmentpurview;
import com.example.test.pojo.Employee;
import com.example.test.pojo.Employeepurview;
import com.example.test.result.Result;
import com.example.test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AllpurviewService allpurviewService;
    @Autowired
    EmployeepurviewService employeepurviewService;
    @Autowired
    DepartmentpurviewService departmentpurviewService;
    @CrossOrigin
    @GetMapping("api/Pdd/in")
    public List<Employee> list() throws Exception {
        System.out.println("用户请求初始化");
        return employeeService.list();
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/add")
    public Result add(@RequestBody Employee requestEmployee) throws Exception {
        System.out.println(requestEmployee);
        if(employeeService.isExist(requestEmployee.getNumber()))
        {
            System.out.println("用户编号已存在");
            return new Result(400);
        }
        else
        {
            if(null==employeeService.findByUsername(requestEmployee.getUsername()))
            {
                System.out.println("增加用户");
                employeeService.add(requestEmployee);
                return new Result(200);
            }
            else
            {
                System.out.println("用户名已存在");
                return new Result(401);
            }

        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/update")
    public Result update(@RequestBody Employee requestEmployee) throws Exception {
        System.out.println(requestEmployee);
        if(employeeService.isExist(requestEmployee.getNumber()))
        {
            employeeService.update(requestEmployee);
            System.out.println("修改用户成功");
            return new Result(200);
        }
        else
        {
            System.out.println("用户不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/delete")
    public Result delete(@RequestBody JSONObject Param) throws Exception {
        int number=Integer.parseInt(Param.get("number").toString());
        if(employeeService.isExist(number))
        {
            employeeService.delete(number);
            System.out.println("删除用户成功");
            return new Result(200);
        }
        else
        {
            System.out.println("用户不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @GetMapping("/api/Pdd/RightsMangement/in")
    public List<JSONObject> RightsMangement()throws Exception
    {
        List<JSONObject> res=new ArrayList<JSONObject>() ;
        List<Employee> employeelist=employeeService.list();
        for (Employee e:employeelist)
        {
            JSONObject j=new JSONObject();
            j.put("id",e.getNumber());
            j.put("name",e.getUsername());
            j.put("dep",e.getDepnumber());
            for (int i=0;i<allpurviewService.AllSize();i++)
            {
                Employeepurview temp=employeepurviewService.FindByNumberAndEpid(e.getNumber(),i+1);
                if(temp!=null)
                {
                    j.put("right"+i,"✔");
                }
                else
                {
                    j.put("right"+i," ");
                }
            }
            res.add(j);
        }
        System.out.println(res);
        return res;
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/RightsMangement/update")
    public Result RightsMangementUpdate(@RequestBody JSONObject parm)
    {
        if(employeeService.isExist(parm.getIntValue("id")))
        {
            for (int i=0;i<allpurviewService.AllSize();i++)
            {
                Departmentpurview departmentpurview=departmentpurviewService.FindByNumberAndDpid(employeeService.getDepNumberByNumber(parm.getIntValue("id")),i+1);
                if(parm.containsKey("right"+i)&&departmentpurview==null)
                {
                    System.out.println("该用户所属部门权限不够");
                    return new Result(401);
                }
            }
            for (int i=0;i<allpurviewService.AllSize();i++)
            {
                Employeepurview employeepurview=employeepurviewService.FindByNumberAndEpid(parm.getIntValue("id"),i+1);
                if(parm.containsKey("right"+i)&&employeepurview!=null)
                {
                   System.out.println("重复");
                }
                else if(parm.containsKey("right"+i)&&employeepurview==null)
                {
                        Employeepurview temp=new Employeepurview();
                        temp.setNumber(parm.getIntValue("id"));
                        temp.setEpid(i+1);
                        employeepurviewService.Update(temp);
                        System.out.println("分配权限");
                }
                else if(!parm.containsKey("right"+i)&&employeepurview!=null)
                {
                        employeepurviewService.deleteByNumberAndEpid(parm.getIntValue("id"), i + 1);
                        System.out.println("删除权限");
                }
                else
                {
                    System.out.println("无事发生");
                }
            }
            return new Result(200);
        }
        System.out.println(parm);
        return new Result(400);
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/Index/in")
    public JSONObject IndexInit(@RequestBody JSONObject parm) throws Exception {
        JSONObject j=new JSONObject();
        String username=parm.getString("username");
        System.out.println(parm);
        List<Employeepurview> e=employeepurviewService.FindByNumberList(employeeService.findByUsername(username).getNumber());
        for (Employeepurview temp:e) {
                switch (temp.getEpid()) {
                    case 1:
                        j.put("right0",1);
                        break;
                    case 2:
                        j.put("right1",1);
                        break;
                    case 3:
                        j.put("right2",1);
                        break;
                    case 4:
                        j.put("right3",1);
                        break;
                    case 5:
                        j.put("right4",1);
                        break;
                }
        }
        System.out.println(j);
        return j;
    }
}
