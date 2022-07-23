package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import services.AuthService;
import services.EmployeeService;
import share.utils.CurrentUserHolder;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginForm {

	private JFrame frmUserLogin;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPasswordField txtPassword;
	private AuthService authService;
	private EmployeeService userService;

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

		JLabel lblUserLogin = new JLabel("");
		lblUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLogin.setIcon(new ImageIcon("C:\\Users\\Phyu Phyu Khin\\Documents\\BTS\\src\\images\\male-user-100.png"));
		lblUserLogin.setBounds(515, 73, 122, 115);
		frmUserLogin.getContentPane().add(lblUserLogin);

		JLabel lblHomeScreen = new JLabel("");
		lblHomeScreen.setIcon(new ImageIcon("C:\\Users\\Phyu Phyu Khin\\Documents\\BTS\\src\\images\\homeImg.jpeg"));
		lblHomeScreen.setBounds(0, 0, 700, 447);
		frmUserLogin.getContentPane().add(lblHomeScreen);
		this.initializeDependency();
	}

	private void initializeDependency() {
		this.authService = new AuthService();
		this.userService = new EmployeeService();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserLogin = new JFrame();
		frmUserLogin.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Phyu Phyu Khin\\Documents\\BTS\\src\\images\\user.png"));
		frmUserLogin.setTitle("User Login");
		frmUserLogin.setBounds(100, 100, 716, 486);
		frmUserLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserLogin.getContentPane().setLayout(null);
		frmUserLogin.setResizable(false);
		frmUserLogin.setLocationRelativeTo(null);
		frmUserLogin.setDropTarget(null);

		JLabel lblTitle = new JLabel("Bus Ticket Selling System");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setBounds(164, 10, 346, 49);
		frmUserLogin.getContentPane().add(lblTitle);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBackground(SystemColor.desktop);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(378, 198, 92, 25);
		frmUserLogin.getContentPane().add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(471, 198, 217, 28);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmUserLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(SystemColor.desktop);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(378, 249, 92, 25);
		frmUserLogin.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(251, 198, -47, 28);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmUserLogin.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(108, 58, 131));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = String.valueOf(txtPassword.getPassword());

				if (!username.isBlank() && !password.isBlank()) {
					String loggedInUserId = authService.login(username, password);
					if (!loggedInUserId.isBlank()) {
						CurrentUserHolder.setLoggedInUser(userService.findEmployeeById(loggedInUserId));
						frmUserLogin.setVisible(false);
						HomeForm form = new HomeForm();
						form.frame.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Enter required Fields");
				}
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(471, 305, 217, 33);
		frmUserLogin.getContentPane().add(btnLogin);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(471, 249, 217, 28);
		frmUserLogin.getContentPane().add(txtPassword);

	}
}
