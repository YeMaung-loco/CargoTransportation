package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Login_view {

	private JFrame frame;
	private JTextField txtUsername;
	private JLabel Icon_lblUsername;
	private TextPrompt placeholder;
	private TextPrompt placeholder1;
	private JLabel Icon_lblPassword;
	private JButton btnLogin;
	private JPanel panel;
	private JPasswordField passwordField;
	private JLabel Icon1JLabel;

	public Login_view() {
		System.out.println("this is logintest ");
		initialize();
		setProperties();
		addComponents();
	}

	private void initialize() {
		frame = new JFrame();
		panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		Icon_lblUsername = new JLabel();
		Icon_lblUsername.setBounds(63, 179, 160, 75);
		txtUsername = new JTextField();
	    txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtUsername.setBounds(233, 194, 217, 66);
		Icon_lblPassword = new JLabel();
		Icon_lblPassword.setBounds(63, 295, 138, 75);
		btnLogin = new JButton();
		btnLogin.setBounds(274, 423, 138, 48);
		passwordField = new JPasswordField();
		passwordField.setBounds(233, 304, 217, 66);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));

	}

	private void setProperties() {
		frame.setResizable(false);
		frame.setTitle("Cargo Transportation System");
		frame.setBounds(100, 100, 578, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);

		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		Icon_lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtUsername.setColumns(10);
		placeholder = new TextPrompt("Username", txtUsername);
		placeholder.setForeground(UIManager.getColor("Button.darkShadow"));
		placeholder.setFont(new Font("Tahoma", Font.BOLD, 18));
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.BOLD);
		placeholder1 = new TextPrompt("Password", passwordField);
		placeholder1.setForeground(UIManager.getColor("Button.darkShadow"));
		placeholder1.setFont(new Font("Tahoma", Font.BOLD, 17));

		Icon_lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnLogin.setText("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));

	}

	private void addComponents() {
		frame.getContentPane().add(panel);
		panel.add(btnLogin);
		panel.add(Icon_lblPassword);
		panel.add(Icon_lblUsername);
		panel.add(txtUsername);
		panel.add(passwordField);
		
		Icon1JLabel = new JLabel("");
		Icon1JLabel.setBounds(163, 43, 287, 126);
		panel.add(Icon1JLabel);
	}

	public JLabel getIconUsername() {
		return Icon_lblUsername;
	}

	public JLabel getIconPassword() {
		return Icon_lblPassword;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JLabel getIcon1JLabel() {
		return Icon1JLabel;
	}
}
//tested 
