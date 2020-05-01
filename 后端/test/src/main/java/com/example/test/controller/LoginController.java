package com.example.test.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.test.pojo.Employee;
import com.example.test.service.EmployeeService;
import com.example.test.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
@RestController
public class LoginController {
    @Autowired
    EmployeeService employeeService;
    @CrossOrigin
    @PostMapping(value = "api/Index")
    public Result login(@RequestBody JSONObject requestUser) {
        if (null==employeeService.findUser(requestUser.getString("username"),requestUser.getString("password"))) {
            System.out.println("登录失败");
            return new Result(400);
        }
        else {
            System.out.println("登录成功");
            return new Result(200);
        }
    }
    @CrossOrigin
    @PostMapping(value = "api/PwdModify")
    public Result PwdModify(@RequestBody JSONObject Param) throws Exception{
        String username = HtmlUtils.htmlEscape((String) Param.get("username"));
        String password = HtmlUtils.htmlEscape((String) Param.get("password"));
        String newpassword = HtmlUtils.htmlEscape((String) Param.get("newpassword"));
        Employee user=employeeService.findUser(username,password);
        if (null == user) {
            System.out.println("密码修改失败");
            return new Result(400);
        } else {
            user.setPassword(newpassword);
            employeeService.update(user);
            System.out.println(user.getPassword() + "密码修改成功");
            return new Result(200);
        }
    }
}
