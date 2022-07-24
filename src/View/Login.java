package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;


import Model.Staff;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
   
	private JPanel contentPane;
	private JPasswordField passwordfield;
	private TextPrompt placeholder;
	private TextPrompt placeholder1;
	private JTextField txt_username;
	
	private Staff staff;
	private JButton btnNewButton;
	private JButton btnlogin;
	private JLabel lblNewLabel;
	private JLabel lbl_username;
	private JLabel lbl_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 public Login() {
	        initialize();
	        
	    }

	   

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setResizable(false);
		setForeground(new Color(0, 153, 204));
		setTitle("Cargo Transportation Login\r\n");
		setBackground(new Color(0, 153, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 51, 102), 2));
		setContentPane(contentPane);
		//setUndecorated(true);
		contentPane.setVisible(true);
		contentPane.setLayout(null);

		JPanel panel_username = new JPanel();
		panel_username.setBounds(175, 147, 250, 63);
		contentPane.add(panel_username);
		panel_username.setLayout(null);

		txt_username = new JTextField();
		placeholder = new TextPrompt("Username", txt_username);
		placeholder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		placeholder.changeAlpha(0.75f);
		// placeholder.changeStyle(Font.);
		txt_username.setBackground(UIManager.getColor("Button.background"));
		txt_username.setBorder(null);
		txt_username.setToolTipText("");
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_username.setBounds(10, 10, 159, 34);
		panel_username.add(txt_username);
		txt_username.setColumns(10);

		lbl_username = new JLabel("");
		//lbl_username.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\Programs\\cargonIcon\\name (1).png"));
		lbl_username.setBounds(169, 0, 81, 64);
		panel_username.add(lbl_username);

		JPanel panel_password = new JPanel();
		panel_password.setBounds(175, 264, 250, 63);
		contentPane.add(panel_password);
		panel_password.setVisible(true);
		//panel_password.setLayout(null);

		lbl_password = new JLabel("");
		//lbl_password.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\Programs\\cargonIcon\\download.png"));
		lbl_password.setBounds(175, 0, 71, 63);
		panel_password.add(lbl_password);

		passwordfield = new JPasswordField();

		passwordfield.setBackground(UIManager.getColor("Button.background"));
		passwordfield.setBorder(null);
		placeholder1 = new TextPrompt("Password", passwordfield);
		placeholder1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		placeholder.changeAlpha(0.75f);
		// placeholder.changeStyle(Font.BOLD);
		passwordfield.setBounds(10, 10, 159, 34);
		panel_password.add(passwordfield);
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setBounds(583, 0, 20, 20);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.this.dispose();
			}
		});

		lblNewLabel_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(230, 10, 128, 127);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\Programs\\cargonIcon\\external-user-interface-kiranshastry-gradient-kiranshastry.png"));
		contentPane.add(lblNewLabel);
		
		btnlogin=new JButton("Login");
		btnlogin.setBounds(226, 362, 147, 45);
		btnlogin.setBackground(new Color(255, 255, 255));
		
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(btnlogin);
	}
	public TextPrompt getPlaceholder() {
		return placeholder;
	}
	public TextPrompt getPlaceholder_password() {
		return placeholder1;
	}
	public JTextField getTxt_username() {
		return txt_username;
	}
	public JPasswordField getPasswordfield() {
		return passwordfield;
	}
	
	public JButton getBtnlogin() {
		return btnlogin;
	}
	public JLabel getLblNewLabel_2() {
		return lblNewLabel;
	}
	public JLabel getLbl_username() {
		return lbl_username;
	}
	public JLabel getLbl_password() {
		return lbl_password;
	}
}
