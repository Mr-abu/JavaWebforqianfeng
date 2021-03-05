package com.qf.www.cast;

import com.alibaba.fastjson.JSON;
import com.qf.www.entity.Grade;
import com.qf.www.entity.Student;

import javax.servlet.GenericServlet;
import java.util.ArrayList;

public class FastCast {
    public static void main(String[] args) {
        //JSON字符串
        String json1 = "{'id':1, 'name':'JAVAEE-1910', 'students':[{'id':101, 'name':'刘艺', 'age':16},{'id':102, 'name':'小李', 'age':22}]}";

        //JSON字符串转换成实体类对象
        Grade grade = JSON.parseObject(json1, Grade.class);
        System.out.println(grade);

        //实体类转换为JSON字符串
        ArrayList<Student> students= new ArrayList<Student>();
        students.add(new Student(1,"小胡", 22));
        students.add(new Student(2,"小邓", 21));
        students.add(new Student(3,"小立", 23));
        Grade grade1 = new Grade(2, "JavaEE-1911",students);
        String s = JSON.toJSONString(grade1);
        System.out.println(s);

        //集合转换为JSON
        ArrayList<Student> emps = new ArrayList<Student>();
        emps.add(new Student(1,"小胡", 22));
        emps.add(new Student(2,"小邓", 21));
        emps.add(new Student(3,"小立", 23));
        String s1 = JSON.toJSONString(emps);
        System.out.println(s1);
    }
}
