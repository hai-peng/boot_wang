package com.hp.boot.pojo;

public class DeptInfo {
    private  Integer deptid ;
    private  String username ;
    private  String passwords ;
    private String deptname ;
    private  String  note ;

    public DeptInfo(Integer deptid, String username, String passwords, String deptname, String note) {
        this.deptid = deptid;
        this.username = username;
        this.passwords = passwords;
        this.deptname = deptname;
        this.note = note;
    }

    public DeptInfo() {
        super();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "DeptInfo{" +
                "deptid=" + deptid +
                ", username='" + username + '\'' +
                ", passwords='" + passwords + '\'' +
                ", deptname='" + deptname + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
