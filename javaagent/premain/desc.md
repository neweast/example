## 第一步

	javac Premain.java
	javac Test.java

## 第二步

	jar cvfm Premain.jar MANIFEST.MF Premain.class

	修改jar包里的MANIFEST.MF文件：

    Manifest-Version: 1.0 
    Premain-Class: Premain
	
## 第三步

	java -javaagent:Premain.jar Test