package steve.spring;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author steve
 */
public class ApplicationContext {
    private Class<?> config;

    public ApplicationContext(Class<?> config) {
        this.config = config;
    }


    public Object[] getBeansName() {
        Object[] beansName = null;
        if (config.isAnnotationPresent(MyConfig.class)) {
            Method[] declaredMethods = config.getDeclaredMethods();
            beansName = Arrays.stream(declaredMethods)
                .filter(a -> a.isAnnotationPresent(MyBean.class))
                .map(a -> a.getAnnotation(MyBean.class).value())
                .toArray();
        }
        return beansName;
    }
}
