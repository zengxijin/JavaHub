package org.jackzeng.invokedynamic;


import jdk.internal.org.objectweb.asm.*;

import java.io.IOException;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author zengxj
 * @create 2017/11/6
 */
public class ASMDump implements Opcodes {

    public static void main(String[] args) throws Exception {

        byte[] codes = dump();
        Class<?> clazz = new CustomClassLoader().defineClass("org.jackzeng.invokedynamic.Test", codes);
        clazz.getMethod("hi", null).invoke(clazz.newInstance(), new Object[]{});

        //dumpToFile("Test.class",codes);
    }

    public static void dumpToFile(String fileName, byte[] bytes) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, bytes, StandardOpenOption.CREATE_NEW);
    }


    public static byte[] dump() throws Exception {
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;
        cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, "org/jackzeng/invokedynamic/Test", null, "java/lang/Object", null);

        //no args constructor
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }

        //invokedynamic content
        {
            mv = cw.visitMethod(ACC_PUBLIC, "hi", "()V", null, null);
            mv.visitCode();

//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitLdcInsn("Hi");
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//            mv.visitInsn(RETURN);
//            mv.visitMaxs(2, 1);

            MethodType mt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class);
            Handle bootstrap = new Handle(Opcodes.H_INVOKESTATIC, "org/jackzeng/invokedynamic/ServiceWithBootstrap", "bootstrap", mt.toMethodDescriptorString());
            mv.visitInvokeDynamicInsn("dynamicInvoke", "()V", bootstrap);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 1);

            mv.visitEnd();
        }
        cw.visitEnd();
        return cw.toByteArray();
    }

    private static class CustomClassLoader extends ClassLoader implements Opcodes {
        public Class<?> defineClass(String name, byte[] b) {
            return super.defineClass(name, b, 0, b.length);
        }
    }
}
