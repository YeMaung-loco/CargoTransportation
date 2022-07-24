package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Update_account {

	private JFrame frame;
	private JTextField txt_username;
	private JTextField txt_password;
	private JButton bntCreate,bntUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_account window = new Update_account();
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
	public Update_account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 396);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(56, 115, 94, 31);
		frame.getContentPane().add(lblNewLabel);
		
		txt_username = new JTextField();
		txt_username.setBounds(197, 113, 207, 36);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(56, 193, 94, 31);
		frame.getContentPane().add(lblPassword);
		
		txt_password = new JTextField();
		txt_password.setColumns(10);
		txt_password.setBounds(197, 191, 207, 36);
		frame.getContentPane().add(txt_password);
		
		
		
		bntUpdate=new JButton("Update");
		bntUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		bntUpdate.setBounds(237, 279, 167, 36);
		bntUpdate.setVisible(true);
		frame.getContentPane().add(bntUpdate);
		
		
		JLabel lblNewLabel_1 = new JLabel("Update Account");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(163, 22, 167, 44);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setVisible(true);
	}
	public JTextField getTxt_username() {
		return txt_username;
	}
	public JTextField getTxt_password() {
		return txt_password;
	}
	
	public JButton getBntUpdate() {
		return bntUpdate;
	}

	public void dispose() {
		frame.dispose();
		// TODO Auto-generated method stub
		
	}
}
