package com.example.demo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = ("com.example.demo.test"))
public class ClobalDefaultExceptionHandler {
    //同意业务异常处理
    @ExceptionHandler(BussinessException.class)
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest req,Exception e) throws  Exception {

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(req.getRequestURL().toString());
        errorInfo.setCode(ErrorInfo.ERROR);
//        System.out.println("");

        return  errorInfo;
    }

}
