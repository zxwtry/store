import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class D015_TCP_Server {
	static transient boolean isExist = false;
	static int id = 1;
	static ConcurrentHashMap<Integer, Server> map = new ConcurrentHashMap<Integer, Server>();
	public static void main(String[] args) {
		ServerSocket ss = null;
		new Thread() {
			@Override
			public void run() {
				Scanner scan = new Scanner(System.in);
				while (scan.hasNext()) {
					String line = scan.nextLine();
					if (line.equals("server close")) {
						isExist = true;
						break;
					} else if (line.equals("list id")) {
						for (int now_id : map.keySet()) {
							System.out.printf(now_id + "\t");
						}
						System.out.println();
					} else if (line.equals("show socket")) {
						for (int now_id : map.keySet()) {
							map.get(now_id).socket_show();
						}
					} else {
						String[] sp = line.split(":");
						if (sp.length != 2) {
							System.out.println("输入数据出错!");
							continue;
						}
						int now_id = Integer.parseInt(sp[0]);
						if (! map.containsKey(now_id)) {
							System.out.println(now_id + "不存在");
							continue;
						}
						Server now_server = map.get(now_id);
						now_server.send_outside(sp[1]);
					}
				}
				scan.close();
			};
		}.start();
		new Thread() {
			@Override
			public void run() {
				while (! isExist) {
					for (int now_id : map.keySet()) {
						Server now_server = map.get(now_id);
						if (now_server.isClosed_outside()) {
							map.remove(now_id);
						} else {
						}
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
		try {
			ss = new ServerSocket(9908);
			ss.setSoTimeout(1000);
			while(! isExist) {
				try {
					Socket socket = ss.accept();
					Server server = new Server(socket, id);
					map.put(id ++, server);
					server.start();
				} catch (SocketTimeoutException e2) {
				}
			}
			for (int key : map.keySet()) {
				map.get(key).close_outside();
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
		private Socket socket = null;
		private BufferedReader br = null;
		private BufferedWriter bw = null;
		private int count = 1;
		private int id = 0;
		private transient boolean isClosed = false; 
		public Server(Socket socket, int id) {
			this.socket = socket;
			this.id = id;
			init();
		}
		public boolean send_outside(String str) {
			try {
				bw.write(str + "\r\n");
				bw.flush();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		public void close_outside() {
			this.isClosed = true;
			close();
		}
		public boolean isClosed_outside() {
			if (socket.isClosed()) {
				close_outside();
				return true;
			}
			if (null == br || null == bw) {
				close_outside();
				return true;
			}
			if (isClosed) {
				close_outside();
				return true;
			}
			try {
				bw.write("\r\n");
				bw.flush();
				return false;
			} catch (IOException e) {
				close_outside();
				return true;
			}
		}
		public void socket_show() {
			try {
				System.out.println("socket.getKeepAlive() : " + socket.getKeepAlive());
				System.out.println("socket.isBound() : " + socket.isBound());
				System.out.println("socket.isClosed() : " + socket.isClosed());
				System.out.println("socket.isConnected()" + socket.isConnected());
				System.out.println("socket.isInputShutdown()" + socket.isInputShutdown());
				System.out.println("socket.isOutputShutdown()" + socket.isOutputShutdown());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		private boolean init() {
			try {
				br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		private boolean close() {
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
		private boolean receive() {
			try {
				if (! br.ready()) {
					return false;
				}
				String line = br.readLine();
				System.out.printf("从Client:%02d接收到的第%02d条数据是：%s\r\n",id , count ++, line);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
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
		}
	}
}
