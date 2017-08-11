package com.soft.utils;


import lombok.Getter;

/**
 * <p>ClassName:     RestExceptionResultCodeEnum
 * <p>Description:   结果错误码枚举:1000以上的，1000以下的为系统错误。每种业务错误预留1000个号
 * <p>Version        V1.0
 */
public enum RestExceptionResultCodeEnum {
    /*-----------------------------系统错误码：1000以内的，1000以下的为系统错误--------------------------*/

    /*-----------------------------0为预留错误码，成功时返回错误码0--------------------------*/
    SUCCESS(0),

    /*-----------------------------未知类型错误--------------------------*/
    //未知错误
    UNKNOWN(-1),


    /*-----------------------------认证类型错误--------------------------*/
    //无效AccessToken
    ACCESS_TOKEN_INVALID(1),


    /*-----------------------------参数错误--------------------------*/
    //参数为空错误
    PARAMETERS_MISSING(100),
    //参数格式错误
    PARAMETERS_FORMAT_ERROR(101),
    //参数范围错误
    PARAMETERS_RANGE_ERROR(102),


    /*-----------------------------资源类型错误--------------------------*/
    //无效资源
    RESOURCE_INVALID(201),
    //无资源访问权限
    RESOURCE_NO_PERMISSION(202),
    //待删除的资源正在使用中
    RESOURCE_IN_USE(203),


    /*-----------------------------具体业务相关的错误：1000以上的，1000以下的为系统错误。每个业务错误预留1000个号--------------------------*/

    /*--------基础业务数据获取相关的错误1000~1999---------*/
    //产能无效、产能获取失败
    CAPABILITY_INVALID(1001);


    /*--------追溯投料相关的错误2000~2999---------*/


    /*--------追溯产出相关的错误2000~2999---------*/



    @Getter
    private Integer value;

    RestExceptionResultCodeEnum(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
