## 第一步

	javac Premain.java
	javac Test.java
	javac TestMain.java
	javac Transformer.java



## 第二步

修改Test.class 为 Test.class.2

## 第三步

修改Test.java为： return 2

	javac Test.java

## 第四步

	jar cvfm Premain.jar *.class

修改jar包里的MANIFEST.MF文件：

    Manifest-Version: 1.0 
    Premain-Class: Premain
	
## 第五步

	java -javaagent:Premain.jar TestMain