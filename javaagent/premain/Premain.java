import java.lang.instrument.*;
public class Premain { 
    public static void premain(String agentArgs, Instrumentation inst) 
            throws ClassNotFoundException, UnmodifiableClassException { 
        inst.addTransformer(new Transformer()); 
    } 
 }