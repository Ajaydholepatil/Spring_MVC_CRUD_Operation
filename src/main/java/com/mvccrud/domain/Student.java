/**
 * Created By Krishna Shinde
 * Date : 13-05-2023
 * Time : 21:55
 * Project: SpringMvcCRUDOperatn
 **/

package com.mvccrud.domain;

public class Student {
    private int rno;
    private String name;
    private String qualification;
    private int percentage;

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Student(int rno, String name, String qualification, int percentage) {
        this.rno = rno;
        this.name = name;
        this.qualification = qualification;
        this.percentage = percentage;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "rno=" + rno +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}


