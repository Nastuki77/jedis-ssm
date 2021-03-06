package org.jedis.web.annocation;

import java.lang.annotation.*;

/**
 * Created by Nastuki on 2016/10/12.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Module {
    String value();

    String name();
}
