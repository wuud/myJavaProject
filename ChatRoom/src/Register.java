import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Register extends JFrame {

	private JTextField user_f, pass_f;
	private JPanel p1,p2;
	private Container c;
	private JLabel user_l, pass_l;
	private JButton ok;

	public Register() {
		super("注册");

		c = getContentPane();
		p1=new JPanel();
		p2=new JPanel();
		p1.setLayout(new GridLayout(2,2));
		
		
		user_l = new JLabel("请输入用户名");
		user_f = new JTextField();
		p1.add(user_l);
		p1.add(user_f);

		pass_l = new JLabel("请输入密码");
		pass_f = new JTextField();

		p1.add(pass_l);
		p1.add(pass_f);

		ok = new JButton("确定");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creatAccount();
				JOptionPane.showMessageDialog(c, "注册成功,您的账号为" + Constant.a.getID());

			}
		});
		p2.add(ok);

		
        c.add(p1, BorderLayout.CENTER);
        c.add(p2, BorderLayout.SOUTH);
		setSize(250, 120);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}

	public void creatAccount() {

		int ID = (int) (90000 * Math.random() + 10000);
		String username = user_f.getText();
		String password = pass_f.getText();
		Constant.a.setID(ID);
		Constant.a.setPassword(password);
		Constant.a.setUsername(username);
		Constant.mapPass.put(ID, password);
		Constant.mapUser.put(ID, username);
	}

	public static void main(String[] args) {
		Register r = new Register();
	}

}
