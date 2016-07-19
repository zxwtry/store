//运行java -Xmx512M -Xms512M -XX:+UseSerialGC -Xloggc:gc.log -XX:+PrintGCDetails -Xmn1m -XX:PretenureSizeThreshold=50 -XX:MaxTenuringThreshold=1 J016_stopTheWorld
import java.util.HashMap;
public class J016_stopTheWorld {
	public static void main(String[] args) {
		PrintThread pt = new PrintThread();
		MyThread mt = new MyThread();
		pt.start();
		mt.start();
	}
	static class MyThread extends Thread {
		HashMap<Long, byte[]> map = new HashMap<Long, byte[]>();
		@Override
		public void run() {
			try {
				while (true) {
					if ((map.size() >>> 11) >= 450) {
						System.out.println("======Prepare For Clean====== : "+map.size());
						map.clear();
					}
					for (int i = 0; i < 1024; i ++) {
						map.put(System.nanoTime(), new byte[512]);
					}
					Thread.sleep(1);
				}
			} catch (Exception e) {
			
			}
		}
		
	}
	static class PrintThread extends Thread {
		public static final long startTime = System.currentTimeMillis();
		@Override
		public void run() {
			try {
				while(true) {
					long t = System.currentTimeMillis() - startTime;
					System.out.println("time: "+t);
					Thread.sleep(100);
				}
			} catch (Exception e) {
				
			}
		}
	}
}
