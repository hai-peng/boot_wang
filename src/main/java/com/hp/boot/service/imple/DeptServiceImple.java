package com.hp.boot.service.imple;

import com.hp.boot.mapper.DeptMapper;
import com.hp.boot.pojo.DeptInfo;
import com.hp.boot.service.DeptService;
import com.hp.boot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImple implements DeptService{
     @Autowired
    DeptMapper deptMapper;

    @Override
    public JsonData findAllDept() {
        List<DeptInfo> allDept = deptMapper.findAllDept();
        return JsonData.buildSuccess(allDept);
    }

    @Override
    public JsonData delDept(int deptid) {
       int i= deptMapper.delDept(deptid);
        return JsonData.buildSuccess("删除成功");
    }
}
