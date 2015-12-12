import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class Test {
    public static void main(String[] args) throws AttachNotSupportedException,
            IOException, AgentLoadException, AgentInitializationException {
		String agentJar = Test.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "Test.jar";
		agentJar = agentJar.substring(1,agentJar.length());
        VirtualMachine vm = VirtualMachine.attach(args[0]);
        vm.loadAgent(agentJar);
		vm.detach();
    }
}