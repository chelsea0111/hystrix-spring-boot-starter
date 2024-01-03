package com.xxy.middleware.hystrix.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoHystrix {
    /**
     * 失败返回结果
     *
     * @return
     */
    String returnJson() default "";

    /**
     * 超时熔断时间
     *
     * @return
     */
    int timeoutValue() default 0;
}
