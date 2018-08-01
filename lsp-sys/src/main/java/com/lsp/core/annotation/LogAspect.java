package com.lsp.core.annotation;

import com.alibaba.fastjson.JSON;
import com.lsp.entity.SysOperLog;
import com.lsp.mapper.SysOperLogMapper;
import com.lsp.utils.IpUtil;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by songbo on 2018/8/1.
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysOperLogMapper sysOperLogMapper;

    @Pointcut("@annotation(com.lsp.core.annotation.Log)")
    private void log() {

    }

    @After("log()")
    public void insertLogSuccess(JoinPoint jp) {
        addLog(jp, getDesc(jp));
    }

    private void addLog(JoinPoint jp, String text) {
        Log.LOG_TYPE type = getType(jp);
        SysOperLog log = new SysOperLog();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //一些系统监控
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ip = IpUtil.getIp(request);
            log.setOperIp(ip);
        }
        log.setOperTime(new Date());
        log.setAction(type.toString());
        log.setMethod(jp.getSignature().getName());
        log.setOperLocation(jp.getSignature().getDeclaringTypeName());
        log.setOperName(text);

        Object[] obj = jp.getArgs();
        StringBuffer buffer = new StringBuffer();
        if (obj != null) {
            for (int i = 0; i < obj.length; i++) {
                buffer.append("[参数" + (i + 1) + ":");
                Object o = obj[i];
                if(o instanceof Model){
                    continue;
                }
                String parameter=null;
                try {
                    parameter= JSON.toJSONString(o);
                }catch (Exception e){
                    continue;
                }
                buffer.append(parameter);
                buffer.append("]");
            }
        }
        log.setOperParam(buffer.toString());
        try {
//            CurrentUser currentUser = ShiroUtil.getCurrentUse();
//            log.setUserName(currentUser.getUsername());
        } catch (UnavailableSecurityManagerException e) {

        }
        sysOperLogMapper.insert(log);
    }

    /**
     * 记录异常
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "log()", throwing = "e")
    public void afterException(JoinPoint joinPoint, Exception e) {
        addLog(joinPoint, getDesc(joinPoint) + e.getMessage());
    }


    private String getDesc(JoinPoint joinPoint) {
        MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
        Method method = methodName.getMethod();
        return method.getAnnotation(Log.class).desc();
    }

    private Log.LOG_TYPE getType(JoinPoint joinPoint) {
        MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
        Method method = methodName.getMethod();
        return method.getAnnotation(Log.class).type();
    }
}
