package com.soft.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * <p>ClassName:     ObjectCopyUtil
 * <p>Description:   对象拷贝工具函数
 * <p>Version        V1.0
 */

public class ObjectCopyUtil {
    public static <T> T objectCopy(Object src, Class<T> dstType) {
        T dst;
        Constructor<?>[] constructors = dstType.getConstructors();
        try {
            dst = (T) constructors[0].newInstance();
            copyProperties(src, dst);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(ExceptionUtil.printStackTraceToString(e));
        }

        return dst;
    }
}
