package com.dk.bookmark.common.aspect;

import com.dk.bookmark.common.annotation.Log;
import com.dk.bookmark.common.utils.HttpContextUtils;
import com.dk.bookmark.common.utils.JsonUtils;
import com.dk.bookmark.common.domain.LogDO;
import com.dk.bookmark.common.utils.IpUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author : dukang
 * @date: 2018/7/11 17:57
 * @description:
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.dk.bookmark.common.annotation.Log)")
    public void logPointCut() {
        //切面入口
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        saveLog(point, time);
        return result;
    }
    void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LogDO sysLog = new LogDO();
        Log syslog = method.getAnnotation(Log.class);
        if (syslog != null) {
            //注解上的描述
            sysLog.setOperation(syslog.value());
        }
        //请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        //请求的参数
        Object[] args = point.getArgs();
        String params = JsonUtils.beanToJson(args[0]).substring(0, 4999);
        sysLog.setParams(params);
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        sysLog.setIp(IpUtils.getIPAddress(request));
        //用户名
        //未定义用户类-待定
        sysLog.setTime((int) time);
        //系统当前时间
        Date date = new Date();
        sysLog.setGmtCreate(date);
    }
}
