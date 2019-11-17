package steve.reflect.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileInputStream;

import static org.objectweb.asm.ClassReader.EXPAND_FRAMES;
import static org.objectweb.asm.ClassReader.SKIP_DEBUG;

/**
 * @author steve
 */
public class ASMDemo {
    public static void main(String[] args) throws Exception {
        String parentPath = Student.class.getResource("").getPath();
        String className = Student.class.getSimpleName();
        File classFile = new File(parentPath + "/" + className + ".class");
        FileInputStream fileInputStream = new FileInputStream(classFile);
        ClassReader classReader = new ClassReader(fileInputStream);
        ClassWriter classWriter = new ClassWriter(classReader, EXPAND_FRAMES);
        classReader.accept(new MyClassVisitor(Opcodes.ASM7, classWriter), SKIP_DEBUG);

    }
}
