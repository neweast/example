## ��һ��

	javac Premain.java
	javac Test.java

## �ڶ���

	jar cvfm Premain.jar MANIFEST.MF Premain.class

	�޸�jar�����MANIFEST.MF�ļ���

    Manifest-Version: 1.0 
    Premain-Class: Premain
	
## ������

	java -javaagent:Premain.jar Test