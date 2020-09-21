package com.hp.boot.controller;

import com.hp.boot.pojo.EmpInfo;
import com.hp.boot.service.EmpService;
import com.hp.boot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpService empService;
    @RequestMapping("/findAll")
    public JsonData findAll(int page,int limit){
        JsonData jsonData = empService.findAll(page,limit);
        System.out.println(jsonData);
        return jsonData;
    }
    @RequestMapping("/deleteEmp")
    public JsonData deleteEmp(int empid){
        JsonData jsonData = empService.deleteEmp(empid);

        return jsonData;
    }
    @RequestMapping("/addEmp")
    public JsonData deleteEmp(EmpInfo emp){
        JsonData jsonData = empService.addEmp(emp);

        return jsonData;
    }
    @RequestMapping("/findOneEmp")
    public JsonData findOneEmp(int empid){
        JsonData jsonData = empService.findOneEmp(empid);

        return jsonData;
    }
}
