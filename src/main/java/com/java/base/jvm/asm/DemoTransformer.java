package com.java.base.jvm.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * http://jiangbo.me/blog/2012/02/21/java-lang-instrument/
 * 使用ASM实现在所有的类定义的方法中，在方法开始出添加了一段打印该类名和方法名的字节码。在转换完成后返回新的字节码字节流
 * Created by persiacai on 2016/3/31.
 */
public class DemoTransformer implements ClassFileTransformer{
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        ClassReader cr = new ClassReader(classfileBuffer);
        ClassNode cn = new ClassNode();
//        cr.accept(cn, 0);
        for (Object obj : cn.methods) {
            MethodNode md = (MethodNode) obj;
            if ("<init>".endsWith(md.name) || "<clinit>".equals(md.name)) {
                continue;
            }
            InsnList insns = md.instructions;
            InsnList il = new InsnList();
            il.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System",
                    "out", "Ljava/io/PrintStream;"));
            il.add(new LdcInsnNode("Enter method-> " + cn.name+"."+md.name));
            il.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL,
                    "java/io/PrintStream", "println", "(Ljava/lang/String;)V"));
            insns.insert(il);
            md.maxStack += 3;
        }
        ClassWriter cw = new ClassWriter(0);
        cn.accept(cw);
        return cw.toByteArray();
    }
}
