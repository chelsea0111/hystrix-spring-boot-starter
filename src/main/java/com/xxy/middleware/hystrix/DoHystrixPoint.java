package com.xxy.middleware.hystrix;

import com.xxy.middleware.hystrix.annotation.DoHystrix;
import com.xxy.middleware.hystrix.valve.impl.HystrixValveImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DoHystrixPoint {
    @Pointcut("@annotation(com.xxy.middleware.hystrix.annotation.DoHystrix)")
    public void aopPoint() {

    }

    @Around("aopPoint() && @annotation(doHystrix)")
    public Object doRouter(ProceedingJoinPoint pjp, DoHystrix doHystrix) throws Throwable {
        HystrixValveImpl valveService = new HystrixValveImpl();
        return valveService.access(pjp,getMethod(pjp),doHystrix,pjp.getArgs());
    }

    private Method getMethod(ProceedingJoinPoint pjp) throws NoSuchMethodException {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        return pjp.getClass().getMethod(methodSignature.getName(),methodSignature.getParameterTypes());
    }
}
