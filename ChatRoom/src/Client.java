import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Client extends JFrame {
	private JTextArea clienta;
	private JScrollPane clientsp;
	private JTextField clientf;
	private Container clientc;
	private JPanel clientp;
	private JButton clientb;
	String str = "";
	private Socket socket = null;
	BufferedReader br = null;
	PrintWriter pw = null;

	public Client() {
		super("客户端");
		clientc = getContentPane();
		clientp = new JPanel();
		clienta = new JTextArea();
		clienta.setEditable(false);
		clienta.setLineWrap(true);
		clientsp = new JScrollPane(clienta);
		clientsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		clientf = new JTextField();
		clientb = new JButton("发送");
		clientb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				write();

			}
		});

		clientp.setLayout(new BorderLayout());
		clientp.add(clientf, BorderLayout.CENTER);
		clientp.add(clientb, BorderLayout.EAST);
		clientc.add(clientsp, BorderLayout.CENTER);
		clientc.add(clientp, BorderLayout.SOUTH);

		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			socket = new Socket("127.0.0.1", 8888);

			pw = new PrintWriter(socket.getOutputStream(), true);

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String s = br.readLine();
				str += s;
				str += "\n";

				clienta.setText(str);
			}
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	String msg2;

	public void write() {
		if (clientf.getText() == "" || clientf.getText() == null) {
			JOptionPane.showMessageDialog(clientc, "无法发送空消息");
		}

		else {
			msg2 = clientf.getText();
			pw.println(msg2);
			clientf.setText("");
		}
	}

	public static void main(String[] args) {
		new Client();

	}
}