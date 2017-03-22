package 实战JAVA虚拟机;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class Page042_ASM_Load_Class {
    public static void main(String[] args) {
        UnloadClass unloadClass = new UnloadClass();
        try {
            unloadClass.runDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main ended!");
    }
    static class UnloadClass implements Opcodes {
        @SuppressWarnings("deprecation")
        public void runDemo() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            cw.visit(V1_8, ACC_PUBLIC, "Example", null, "java/lang/Object", null);
            MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mw.visitVarInsn(ALOAD, 0);
            mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
            mw.visitInsn(RETURN);
            mw.visitMaxs(0, 0);
            mw.visitEnd();
            mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;])V", null, null);
            mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mw.visitLdcInsn("Hello world");
            mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
            mw.visitInsn(RETURN);
            mw.visitMaxs(0, 0);
            mw.visitEnd();
            byte[] code = cw.toByteArray();     
            for (int i = 0; i < 10; i ++) {
                UnloadClass loader = new UnloadClass();
                Method m = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
                m.setAccessible(true);
                m.invoke(loader, "Example", code, 0, code.length);
                m.setAccessible(false);
                System.gc();
            }
        }
    }
    static class Example {
        
    }
}
