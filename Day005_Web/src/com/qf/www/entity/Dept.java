package com.qf.www.entity;

public class Dept {
    private int empno;
    private String ename;
    private String job;

    @Override
    public String toString() {
        return "Dept{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Dept() {
    }

    public Dept(int empno, String ename, String job) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
    }
}
