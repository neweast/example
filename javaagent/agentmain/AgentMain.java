import java.lang.instrument.ClassDefinition; 
 import java.lang.instrument.Instrumentation; 
 import java.lang.instrument.UnmodifiableClassException; 
public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst) 
            throws ClassNotFoundException, UnmodifiableClassException, 
            InterruptedException { 
        Class[] classes = inst.getAllLoadedClasses();
        for(Class cls :classes){
            System.out.println(cls.getName());
        }
    }
}