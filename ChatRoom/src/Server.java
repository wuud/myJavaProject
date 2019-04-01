
import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
	int port;
	ServerSocket server;
    static int count=0;
    
	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		try {

			port = 8888;
			server = new ServerSocket(port);

			while (true) {
				Socket socket = server.accept();
				Constant.clients.add(socket);
				count++;
				Mythread mythread = new Mythread(socket);
				mythread.start();
			}

		} catch (Exception ex) {
		}
	}

	static class Mythread extends Thread {
		Socket ssocket;
		private BufferedReader br;
		private PrintWriter pw;
		public String msg;
		public static String accountname="mo";
		private int id;
		Account a;
		public Mythread(Socket s) {
			ssocket = s;
		}

		public void run() {

			try {
				accountname=Login.accountName;
				System.out.println(accountname);
				br = new BufferedReader(new InputStreamReader(ssocket.getInputStream()));
				msg = "欢迎【" +accountname + "】进入聊天室！当前聊天室有【" + count + "】人";

				sendMsg();
				while ((msg = br.readLine()) != null) {

					msg = "【" + accountname+ "】说：" + msg;
					sendMsg();

				}
			} catch (Exception ex) {

			}
		}

		public void sendMsg() {
			try {

				for (int i = Constant.clients.size() - 1; i >= 0; i--) {
					pw = new PrintWriter(Constant.clients.get(i).getOutputStream(), true);
					pw.println(msg);
					pw.flush();
				}
			} catch (Exception ex) {
			}
		}
	}
	
}
