/*
	先javac所有的java文件
	然后运行：java -Xbootclasspath/a:/home/zxwtry/github/store/demo/201607/D011_ClassLoader/zxwtry  ForceAppLoader
*/
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.lang.reflect.Method;
public class ForceAppLoader {
	public static void main(String[] args) throws Exception{
		ClassLoader cl = FindClassOrder.class.getClassLoader();
		byte[] bHelloLoader = loadClassBytes("HelloLoader.class");
		Method md_defineClass = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
		md_defineClass.setAccessible(true);
		md_defineClass.invoke(cl, bHelloLoader, 0, bHelloLoader.length);
		md_defineClass.setAccessible(false);
		HelloLoader loader = new HelloLoader();
		System.out.println(loader.getClass().getClassLoader());
		loader.print();
	}
	private static byte[] loadClassBytes(String name) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(name);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int ch;
			while ((ch = fis.read()) != -1) {
				byte b = (byte) ch;
				buffer.write(b);
			}
			return buffer.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
