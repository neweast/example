import java.lang.instrument.ClassDefinition; 
import java.lang.instrument.Instrumentation; 
import java.lang.instrument.UnmodifiableClassException; 

public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst) 
            throws ClassNotFoundException, UnmodifiableClassException, 
            InterruptedException, Exception { 
      
		int i = 0;
		while (i<5) {
			i++;
			System.out.println("11111");
			Thread.sleep(2000);
		}
    }
}