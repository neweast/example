package com.test.asm;


import org.objectweb.asm.*;

/**
 * Created by yuanquan.ld on 2015/12/13.
 */
public class AddFieldVisitor extends ClassVisitor{
    private boolean isInterface = false;

    public AddFieldVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
        isInterface = (access & Opcodes.ACC_INTERFACE) != 0;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return super.visitMethod(access, name, desc, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        if (!isInterface) {
            FieldVisitor fv = cv.visitField(Opcodes.ACC_PRIVATE, "id", "J", null, 0);
            if (null != fv) {
                fv.visitEnd();
            }

            MethodVisitor mv = cv.visitMethod(Opcodes.ACC_PUBLIC, "getId", "()J", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitFieldInsn(Opcodes.GETFIELD, "com/test/asm/Test", "id", "J");
            mv.visitInsn(Opcodes.LRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();

            MethodVisitor mv2 = cv.visitMethod(Opcodes.ACC_PUBLIC, "setId", "(J)V", null, null);
            mv2.visitCode();
            mv2.visitVarInsn(Opcodes.ALOAD, 0);
            mv2.visitVarInsn(Opcodes.LLOAD, 1);
            mv2.visitFieldInsn(Opcodes.PUTFIELD, "com/test/asm/Test", "id", "J");
            mv2.visitInsn(Opcodes.RETURN);
            mv2.visitMaxs(1, 2);
            mv2.visitEnd();
        }
        cv.visitEnd();
    }
}
