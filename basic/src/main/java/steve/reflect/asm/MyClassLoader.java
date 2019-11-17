package steve.reflect.asm;

/**
 * @author steve
 */
public class MyClassLoader extends ClassLoader {
    public Class<?> myDefineClass(String name, byte[] data, int start, int len) {
        return this.defineClass(name, data, start, len);
    }
}
