import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class D014_TCP_Server {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9908);
			while(true) {
				Socket socket = ss.accept();
				new Server(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != ss) {
					ss.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	static class Server extends Thread {
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		int count = 1;
		transient boolean isClosed = false; 
		public Server(Socket socket) {
			this.socket = socket;
			init();
		}
		public boolean init() {
			try {
				br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		public boolean close() {
			try {
				if (null != br) {
					br.close();
				}
				if (null != bw) {
					bw.close();
				}
				if (null != socket) {
					socket.close();
				}
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		public boolean send(String str) {
			try {
				bw.write(str + "\r\n");
				bw.flush();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		public boolean receive() {
			try {
				if (! br.ready()) {
					return false;
				}
				String line = br.readLine();
				System.out.printf("从Client接收到的第%02d条数据是：%s\r\n", count ++, line);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		@Override
		public void run() {
			init();
			Scanner scan = new Scanner(System.in);
			String line = null;
			new Thread() {
				@Override
				public void run() {
					while (! isClosed) {
						try {
							receive();
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
			}.start();
			while (! (line = scan.nextLine()).equals("server close")) {
				send(line);
			}
			isClosed = true;
			scan.close();
			close();
		}
	}
}

