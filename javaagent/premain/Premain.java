import java.lang.instrument.*;
public class Premain { 
    public static void premain(String agentArgs, Instrumentation inst) 
            throws ClassNotFoundException, UnmodifiableClassException, Exception { 
			int i = 0;
			while (i++ <= 5) {
				System.out.println("premain run");	
				Thread.sleep(2000);
			}
    } 
 }