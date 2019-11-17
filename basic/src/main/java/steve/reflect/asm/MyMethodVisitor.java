package steve.reflect.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

/**
 * @author steve
 */
public class MyMethodVisitor extends MethodVisitor {
    public MyMethodVisitor(int api, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
        methodVisitor.visitMethodInsn(
                INVOKESTATIC
                , MyInterceptor.class.getCanonicalName()
                , MyInterceptor.class.getMethods()[0].getName()
                , Type.getMethodDescriptor(MyInterceptor.class.getMethods()[0])
                , false);
    }
}
