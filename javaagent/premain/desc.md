## ��һ��

javac Premain.java
javac Test.java
javac TestMain.java
javac Transformer.java



## �ڶ���

�޸�Test.class Ϊ Test.class.2

## ������

�޸�Test.javaΪ�� return 2

javac Test.java

## ���Ĳ�

jar cvfm Premain.jar *.class

�޸�jar�����MANIFEST.MF�ļ���

    Manifest-Version: 1.0 
    Premain-Class: Premain
	
## ���岿

java -javaagent:Premain.jar TestMain