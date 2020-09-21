package com.hp.boot.controller;

import com.hp.boot.mapper.DeptMapper;
import com.hp.boot.service.DeptService;
import com.hp.boot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;
    @RequestMapping("/findAllDept")
    public JsonData findAllDept(){
        JsonData jsonData = deptService.findAllDept();
        System.out.println(jsonData);
        return jsonData;
    }
    @RequestMapping("/delDept")
    public JsonData delDept(int deptid){
        JsonData jsonData = deptService.delDept(deptid);

        return jsonData;
    }
}
