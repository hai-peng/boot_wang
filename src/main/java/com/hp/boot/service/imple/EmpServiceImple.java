package com.hp.boot.service.imple;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.boot.mapper.EmpMapper;
import com.hp.boot.pojo.EmpInfo;
import com.hp.boot.service.EmpService;
import com.hp.boot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empService")
public class EmpServiceImple implements EmpService{
    @Autowired
    EmpMapper empMapper;
    @Override
    public JsonData findAll(int page,int limit) {
         //开启分页
        PageHelper.startPage(page,limit);

        List<EmpInfo> all = empMapper.findAll();
        PageInfo<EmpInfo> pageInfo = new PageInfo<>(all);
        return JsonData.buildSuccess(pageInfo);
    }

    @Override
    public JsonData deleteEmp(int empid) {
        int result=empMapper.deleteEmp(empid);
        if(result>0){
          return   JsonData.buildSuccess("删除成功");
        }
        return   JsonData.buildError("删除失败");


    }

    @Override
    public JsonData addEmp(EmpInfo emp) {
        int result=0;

        if(emp.getEmpid()==null){
            result= empMapper.addEmp(emp);
        }else {
            result= empMapper.editEmp(emp);
        }
        if(result>0){
            JsonData.buildSuccess("编辑成功");
        }
        return JsonData.buildError("编辑失败");
    }

    @Override
    public JsonData findOneEmp(int empid) {
        EmpInfo empfindOne=empMapper.findOneEmp(empid);
        return JsonData.buildSuccess(empfindOne);
    }
}
