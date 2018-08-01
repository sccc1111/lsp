package com.lsp.core.annotation;

import java.lang.annotation.*;

/**
 * Created by songbo on 2018/8/1.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
@Inherited
public @interface Log {
    public enum LOG_TYPE {ADD, UPDATE, DEL, SELECT, ATHOR}

    /**
     * 内容
     */
    String desc();

    /**
     * 类型 curd
     */
    LOG_TYPE type() default LOG_TYPE.ATHOR;
}
