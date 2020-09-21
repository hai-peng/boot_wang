package com.hp.boot.service;

import com.hp.boot.util.JsonData;

public interface DeptService {
    JsonData findAllDept();

    JsonData delDept(int deptid);

}
