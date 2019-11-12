package steve.function;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author steve
 */
public class FunctionTest {
    public static void main(String[] args) {
        CollectionUtil collectionUtil = new CollectionUtilImpl();
        List<Integer> list = List.of(1, 2, 3, 4);
        List<String> transform = collectionUtil.transform(list, Object::toString);
        List<Integer> transform2 = collectionUtil.transform(list, a -> a * 2);
        System.out.println(transform);
        System.out.println(transform2);
    }

    public interface CollectionUtil {
        <E, R, T1 extends Collection<E>, T2 extends Collection<R>, F extends Function<E, R>> T2 transform(T1 c, F function);
    }

    public static class CollectionUtilImpl implements FunctionTest.CollectionUtil {
        @SuppressWarnings("unchecked")
        @Override
        public <E, R, T1 extends Collection<E>, T2 extends Collection<R>, F extends Function<E, R>> T2 transform(T1 c, F function) {
            return (T2) c.stream().map(function).collect(Collectors.toList());
        }
    }
}
