import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class D014_TCP_Client {
	static final String ip = "127.0.0.1";
	static final int port = 9908;
	public static void main(String[] args) {
		Client client = new Client(ip, port);
		client.start();
	}
	static class Client extends Thread{
		String ip = null;
		int port = 0;
		Socket socket = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		int count = 1;
		transient boolean isClosed = false;
		public Client(String ip, int port) {
			this.ip = ip;
			this.port = port;
			init();
		}
		public boolean send(String str) {
			try {
				bw.write(str+"\r\n");
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
				if (line != null)
					System.out.printf("从Server接收的第%02d条数据：%s\r\n", count ++, line);
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
				this.socket.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		public boolean init() {
			try {
				this.socket = new Socket(ip, port);
				this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				this.bw = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
				return true;
			} catch (Exception e1) {
				e1.printStackTrace();
				return false;
			}
		}
		@Override
		public void run() {
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
			Scanner scan = new Scanner(System.in);
			String line = null;
			while (! (line = scan.nextLine()).equals("client close")) {
				send(line);
			}
			isClosed = true;
			scan.close();
			close();
		}
	}
}

