package com.soft.rest_response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft.utils.ExceptionUtil;
import com.soft.utils.RestException;
import com.soft.utils.RestExceptionResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>ClassName:     RestHandlerExceptionResolver
 * <p>Description:   RestAPI简化错误处理工具
 * <p>Version        V1.0
 */

@Component
@Slf4j
public class RestHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ResultResponse result = new ResultResponse();

        if (e instanceof RestException) {
            RestException re = (RestException) e;
            result.setResultCode(re.getResultCode());
            result.setResultMsg(re.getResultMsg());
            result.setData(re.getData());

            String logString = "ResultCode: " + re.getResultCode() + "," + "ResultMsg: " + re.getResultMsg();
            log.error(logString, e);
        } else {
            result.setResultCode(RestExceptionResultCodeEnum.UNKNOWN.getValue());
            result.setResultMsg(ExceptionUtil.printStackTraceToString(e));

            log.error("Exception catches:", e);
        }

        httpServletResponse.setCharacterEncoding("UTF-8");

        try {
            httpServletResponse.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();

            PrintWriter pw = httpServletResponse.getWriter();

            pw.print(mapper.writeValueAsString(new ResultResponseWapper(result)));

            pw.close();

        } catch (IOException e1) {
            log.error("Exception catches:", e1);
        }

        return new ModelAndView();
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private class ResultResponseWapper {
        ResultResponse resultResponse;
    }

    @Setter
    @Getter
    private class ResultResponse {
        private Integer resultCode;
        private String resultMsg;
        private List data = new ArrayList();
    }
}
