package com.xxy.middleware.hystrix.valve;

import com.xxy.middleware.hystrix.annotation.DoHystrix;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

public interface IValveService {
    Object access(ProceedingJoinPoint pjp, Method method, DoHystrix doHystrix, Object[] args) throws Throwable;
}
