package com.soft.model;

import lombok.Data;

import java.util.List;

/**
 * Created by admin on 2017/8/1.
 */
@Data
public class StudentModel {

    private Integer stuId;  // id
    private String name;    //姓名
    private String phone;   //电话
    private String qq;      //QQ
    private String email;   //邮箱
    private Integer column; //座位：列
    private Integer row;    //座位：行
    private Integer classId;//所属班级

}
