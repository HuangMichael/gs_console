package com.huangbin.gsarts.aop;


import com.huangbin.gsarts.asyn.AsyncAccessLog;
import com.huangbin.gsarts.service.systemInfo.SysParamsService;
import com.huangbin.gsarts.util.AnnotationUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 页面访问日志aop
 */
@Component
@Aspect
@Slf4j
public class AppAccessAop {
    @Autowired
    AsyncAccessLog asyncAccessLog;
    @Autowired
    AnnotationUtil annotationUtil;

    @Autowired
    SysParamsService sysParamsService;

    @After("execution(* com.huangbin.gsarts.controller.*.*Controller.index(..))")
    public void writeAccessLog(JoinPoint point) throws InterruptedException {


        log.info("end 耗时: " + (System.currentTimeMillis()));
    }
}
