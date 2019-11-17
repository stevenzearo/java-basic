package steve.reflect.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * @author steve
 */
public class MyClassVisitor extends ClassVisitor {
    public MyClassVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if ("say".equals(name))
        return new MyMethodVisitor(access, super.visitMethod(access, name, descriptor, signature, exceptions));
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }
}
