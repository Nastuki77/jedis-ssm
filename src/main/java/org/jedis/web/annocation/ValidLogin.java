package org.jedis.web.annocation;

import org.jedis.web.em.ValidPropagation;

import java.lang.annotation.*;

/**
 * Created by Nastuki on 2016/10/12.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface ValidLogin {
    ValidPropagation value() default ValidPropagation.REQUIRED;
}
