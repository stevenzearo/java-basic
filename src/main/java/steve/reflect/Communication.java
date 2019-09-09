package steve.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author steve
 */

@Target(ElementType.METHOD) //注解使用的地方（方法）
@Retention(RetentionPolicy.RUNTIME)
public @interface Communication {
    String value() default "communicate";
}
