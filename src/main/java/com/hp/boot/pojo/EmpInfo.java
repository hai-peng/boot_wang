package com.hp.boot.pojo;

public class EmpInfo {
    private Integer  empid ;
    private String empname ;
    private String sex ;
    private String age  ;
    private String phone;
    private DeptInfo dept;

    public EmpInfo(Integer empid, String empname, String sex, String age, String phone, DeptInfo dept) {
        this.empid = empid;
        this.empname = empname;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.dept = dept;
    }

    public EmpInfo() {
        super();
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DeptInfo getDept() {
        return dept;
    }

    public void setDept(DeptInfo dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "EmpInfo{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", dept=" + dept +
                '}';
    }
}
