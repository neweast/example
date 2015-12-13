package com.test.asm;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yuanquan.ld on 2015/12/13.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("com.test.asm.User");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new AddFieldVisitor(cw);
        cr.accept(cv, ClassReader.SKIP_DEBUG);
        byte[] codeBytes = cw.toByteArray();
        File file = new File(Test.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "User.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(codeBytes);
        fos.flush();
        fos.close();
    }
}
