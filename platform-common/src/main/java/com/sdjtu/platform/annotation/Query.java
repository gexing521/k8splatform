package com.sdjtu.platform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 09:46
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {

    /**
     * 基本对象的属性名
     */
    String propName() default "";

    /**
     * 查询方式
     */
    Type type() default Type.EQUAL;

    /**
     * 连接查询的属性名，如User类中的dept
     *
     * @return
     */
    String joinName() default "";

    /**
     * 默认左连接
     *
     * @return
     */
    Join join() default Join.LEFT;

    /**
     * 多字段模糊搜索，仅支持String类型字段，多个用逗号隔开, 如@Query(blurry = "email,username")
     *
     * @return
     */
    String blurry() default "";

    enum Type {
        /**
         * 相等
         */
        EQUAL
        /**  大于等于 */
        , GREATER_THAN
        /**  小于等于 */
        , LESS_THAN
        /** 中模糊查询 */
        , INNER_LIKE
        /** 左模糊查询 */
        , LEFT_LIKE
        /**  右模糊查询 */
        , RIGHT_LIKE
        /**小于 */
        , LESS_THAN_NQ
        //** jie 2019/6/4 包含 */
        , IN
    }

    /**
     * 适用于简单连接查询，复杂的请自定义该注解，或者使用sql查询
     *
     * @Author: ytuan
     * @Date: 09:48
     */
    enum Join {
        /**
         * 左连接
         */
        LEFT
        /**  右连接 */
        , RIGHT
    }
}
