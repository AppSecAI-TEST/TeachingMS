package com.soft.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>ClassName:     ExceptionUtil
 * <p>Description:   异常处理工具
 * <p>Version        V1.0
 */
public class ExceptionUtil {
    public static String printStackTraceToString(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }
}
