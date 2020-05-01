package com.example.test.controller;
import com.example.test.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OtherController {
    @CrossOrigin
    @GetMapping("api/Pdd/rightinit")
   public Result RightInit()
    {
        return new Result(200);
    }
}
