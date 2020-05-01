package com.example.test.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.test.pojo.Departmentpurview;
import com.example.test.pojo.Departments;
import com.example.test.pojo.Employee;
import com.example.test.result.Result;
import com.example.test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
public class DepartmentsController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentsService departmentsService;
    @Autowired
    AllpurviewService allpurviewService;
    @Autowired
    EmployeepurviewService employeepurviewService;
    @Autowired
    DepartmentpurviewService departmentpurviewService;
    @CrossOrigin
    @GetMapping("api/Pdd/in2")
    public List<Departments> list2() throws Exception {
        System.out.println("部门请求初始化");
        return departmentsService.list();
    }
    @CrossOrigin
    @GetMapping("api/Pdd/getdep")
    public List<JSONObject> getDepList() throws Exception {
       List<JSONObject> temp=new ArrayList<>();
       List<Departments> dep=list2();
       for(Departments d :dep) {
       JSONObject j=new JSONObject();
       j.put("value",d.getNumber());
       j.put("label",d.getName());
       temp.add(j);
       }
       System.out.println(temp);
       return temp;
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/add2")
    public Result add2(@RequestBody Departments requestDepartments) throws Exception {
        if(departmentsService.isExist(requestDepartments.getNumber()))
        {
            System.out.println("部门已存在");
            return new Result(400);
        }
        else
        {
            System.out.println("增加部门");
            departmentsService.add(requestDepartments);
            return new Result(200);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/update2")
    public Result update2(@RequestBody Departments requestDepartments) throws Exception {
        if(departmentsService.isExist(requestDepartments.getNumber()))
        {
            System.out.println(requestDepartments);
            departmentsService.update(requestDepartments);
            System.out.println("部门修改成功");
            return new Result(200);
        }
        else
        {
            System.out.println("部门不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/delete2")
    public Result delete2(@RequestBody JSONObject Param) throws Exception {
        int number=Integer.parseInt(Param.get("number").toString());
        if(departmentsService.isExist(number))
        {
            departmentsService.delete(number);
            System.out.println("删除部门成功");
            return new Result(200);
        }
        else
        {
            System.out.println("部门不存在");
            return new Result(400);
        }
    }
    @CrossOrigin
    @GetMapping("/api/Pdd/RightsMangement/in2")
    public List<JSONObject> RightsMangement2()throws Exception
    {
        List<JSONObject> res=new ArrayList<JSONObject>() ;
        List<Departments> departmentslist=departmentsService.list();
        for (Departments e:departmentslist)
        {
            JSONObject j=new JSONObject();
            j.put("id",e.getNumber());
            j.put("name",e.getName());
            for (int i=0;i<allpurviewService.AllSize();i++)
            {
               Departmentpurview temp=departmentpurviewService.FindByNumberAndDpid(e.getNumber(),i+1);
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
        return res;
    }
    @CrossOrigin
    @PostMapping("/api/Pdd/RightsMangement/update2")
    public Result RightsMangementUpdate2(@RequestBody JSONObject parm)
    {
        if(departmentsService.isExist(parm.getIntValue("id")))
        {
            for (int i=0;i<allpurviewService.AllSize();i++)
            {
                Departmentpurview departmentpurview=departmentpurviewService.FindByNumberAndDpid(parm.getIntValue("id"),i+1);
                if(parm.containsKey("right"+i)&&departmentpurview!=null)
                {
                    System.out.println("重复");
                }
                else if(parm.containsKey("right"+i)&&departmentpurview==null)
                {
                   Departmentpurview temp=new Departmentpurview();
                    temp.setNumber(parm.getIntValue("id"));
                    temp.setDpid(i+1);
                    departmentpurviewService.Update(temp);
                    System.out.println("分配权限");
                }
                else if(!parm.containsKey("right"+i)&&departmentpurview!=null)
                {
                  departmentpurviewService.deleteByNumberAndDpid(parm.getIntValue("id"),i+1);
                  for(Employee e :employeeService.findAllByDepnumber(parm.getIntValue("id")))
                  {
                      employeepurviewService.deleteByNumberAndEpid(e.getNumber(),i+1);
                  }
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
}
