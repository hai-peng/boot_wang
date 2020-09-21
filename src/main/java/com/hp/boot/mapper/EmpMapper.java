package com.hp.boot.mapper;

import com.hp.boot.pojo.EmpInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("empMapper")
public interface EmpMapper {

    List<EmpInfo>findAll();

    int deleteEmp(int empid);

    int addEmp(EmpInfo emp);

    EmpInfo findOneEmp(int empid);

    int editEmp(EmpInfo emp);
}
