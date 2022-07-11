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

public class login {

	private JFrame frame;
	private JTextField txtUsername;
	private JLabel lblUsername;
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
					login window = new login();
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
	public login() {
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
		txtUsername = new JTextField();
		lblPassword = new JLabel();
		btnLogin = new JButton();
		lblcargo = new JLabel();
		passwordField = new JPasswordField();

	}

	private void setProperties() {
		frame.setTitle("Cargo Transportation System");
		frame.setBounds(100, 100, 559, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblUsername.setText("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setBounds(59, 115, 122, 35);
		panel.add(lblUsername);

		txtUsername.setBounds(249, 120, 165, 30);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		lblPassword.setText("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(59, 184, 122, 35);
		passwordField.setBounds(249, 184, 165, 30);

		btnLogin.setText("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(311, 244, 101, 35);

		lblcargo.setText("Cargo Transportation System");
		lblcargo.setForeground(Color.BLUE);
		lblcargo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblcargo.setBounds(59, 27, 353, 35);

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
