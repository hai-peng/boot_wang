package com.hp.boot.service;

import com.hp.boot.pojo.EmpInfo;
import com.hp.boot.util.JsonData;

public interface EmpService {
    JsonData findAll(int page,int limit);

    JsonData deleteEmp(int empid);

    JsonData addEmp(EmpInfo emp);

    JsonData findOneEmp(int empid);
}
