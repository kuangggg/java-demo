import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class MyAgent {

    public static void premain(String args, Instrumentation inst) {
        System.out.println("pre agent args " + args);

        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                System.out.println("class name " + className);

                if(!className.equals("AgentTest")) {
                    return null;
                }

                ClassPool cp = ClassPool.getDefault();

                try {
                    CtClass cc = cp.get("AgentTest");

                    CtMethod cm = cc.getDeclaredMethod("testMethod");

                    try {

                        cm.insertBefore("System.out.println(\"javassist before insert code\");");

                    } catch (CannotCompileException e) {
                        e.printStackTrace();
                    }

                    try {
                        return cc.toBytecode();

                    } catch (IOException | CannotCompileException e) {
                        e.printStackTrace();
                    }
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }, true);
    }

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println("agent main");
    }


}
