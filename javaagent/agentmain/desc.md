## 内容
    
	让指定的目标VM，加载并运行一个javaagent
	
## 第一步

	javac AgentMain.java
	javac Test.java
	javac TargetVM.java

## 第二步

    jar cvfm Test.jar MANIFEST.MF *.class

## 第三步

启动TargetVM
	
	java TargetVM

## 第四步

查看 TargetVM 进程号 PID，然后运行

	java Test PID
