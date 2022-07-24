package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class LoginForm {

	private JFrame frmUserLogin;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JLabel lblHomeScreen;
	private JLabel lblUserLogin;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmUserLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		txtUsername.setFocusable(true);

		lblUserLogin = new JLabel("");
		lblUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		//lblUserLogin.setIcon(new ImageIcon("C:\\Users\\Phyu Phyu Khin\\Documents\\BTS\\src\\images\\male-user-100.png"));
		lblUserLogin.setBounds(515, 73, 122, 115);
		frmUserLogin.getContentPane().add(lblUserLogin);

		lblHomeScreen = new JLabel("");
		lblHomeScreen.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\Programs\\cargonIcon\\home.jpg"));
		//lblHomeScreen.setIcon(new ImageIcon("resource\home.jpg"));
		lblHomeScreen.setBounds(0, 0, 800, 385);

		frmUserLogin.getContentPane().add(lblHomeScreen);
		
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserLogin = new JFrame();
		//frmUserLogin.setIconImage(Toolkit.getDefaultToolkit()
			//	.getImage("C:\\Users\\Phyu Phyu Khin\\Documents\\BTS\\src\\images\\user.png"));
		frmUserLogin.setTitle("User Login");
		frmUserLogin.setBounds(100, 100, 816, 420);
		//frmUserLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserLogin.getContentPane().setLayout(null);
		frmUserLogin.setResizable(false);
		frmUserLogin.setLocationRelativeTo(null);
		frmUserLogin.setDropTarget(null);
		//frmUserLogin.setResizable(true);

		JLabel lblTitle = new JLabel("Cargo Transportation Management System");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setBounds(102, 10, 512, 49);
		frmUserLogin.getContentPane().add(lblTitle);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setBackground(SystemColor.desktop);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsername.setBounds(477, 166, 92, 25);
		frmUserLogin.getContentPane().add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(607, 166, 185, 28);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmUserLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setBackground(SystemColor.desktop);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(477, 218, 92, 25);
		frmUserLogin.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(251, 198, -47, 28);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmUserLogin.getContentPane().add(passwordField);

		btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(0, 204, 204));
		
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogin.setBounds(614, 276, 178, 33);
		frmUserLogin.getContentPane().add(btnLogin);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(607, 220, 185, 28);
		frmUserLogin.getContentPane().add(txtPassword);

	}
	public JTextField getTxtUsername() {
		return txtUsername;
	}
	public JPasswordField getTxtPassword() {
		return txtPassword;
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public JLabel getLblHomeScreen() {
		return lblHomeScreen;
	}
	public JLabel getLblUserLogin() {
		return lblUserLogin;
	}
}
