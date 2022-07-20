package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class logintest {

	private JFrame frame;
	private JTextField txtUsername;
	private JLabel lblUsername;
	private TextPrompt placeholder;
	private TextPrompt placeholder1;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblcargo;
	private JPanel panel;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logintest window = new logintest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logintest() {
		System.out.println("this is logintest ");
		initialize();
		setProperties();
		addComponents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		panel = new JPanel();
		lblUsername = new JLabel();
		lblUsername.setBounds(43, 119, 160, 48);
		txtUsername = new JTextField();
		txtUsername.setBounds(233, 206, 217, 54);
		lblPassword = new JLabel();
		lblPassword.setBounds(43, 226, 138, 48);
		btnLogin = new JButton();
		btnLogin.setBounds(274, 423, 138, 48);
		lblcargo = new JLabel();
		lblcargo.setBounds(59, 27, 353, 35);
		passwordField = new JPasswordField();
		passwordField.setBounds(256, 304, 217, 54);

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
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblUsername);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		placeholder = new TextPrompt("Username", txtUsername);
		placeholder.setForeground(UIManager.getColor("Button.darkShadow"));
		placeholder.setFont(new Font("Tahoma", Font.BOLD, 18));
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.BOLD);
		placeholder1=new TextPrompt("Password",passwordField);
		placeholder1.setForeground(UIManager.getColor("Button.darkShadow"));
		placeholder1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnLogin.setText("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));

		lblcargo.setText("Cargo Transportation System");
		lblcargo.setForeground(Color.BLUE);
		lblcargo.setFont(new Font("Tahoma", Font.BOLD, 24));

	}

	private void addComponents() {
		frame.getContentPane().add(panel);
		panel.add(lblcargo);
		panel.add(btnLogin);
		panel.add(lblPassword);
		panel.add(lblUsername);
		panel.add(txtUsername);
		panel.add(passwordField);
	}

	public JLabel getLblUsername() {
		return lblUsername;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}


	public JButton getBtnLogin() {
		return btnLogin;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
//tested 
