/*
	先javac所有的java文件
	一开始是正常运行java FindClassOrder
	然后是java -Xbootclasspath/a:/home/zxwtry/github/store/demo/201607/D011_ClassLoader/zxwtry FindClassOrder
*/
public class FindClassOrder {
	public static void main(String[] args) {
		HelloLoader loader = new HelloLoader();
		loader.print();
	}
}
