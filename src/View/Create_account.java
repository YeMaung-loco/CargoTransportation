package View;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Create_account {

	private JFrame frame;
	private JTextField txt_username;
	private JTextField txt_password;
	private JButton bntCreate,bntUpdate;


	public Create_account() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 396);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);		
		
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
		
		bntCreate = new JButton("Create");
		bntCreate.setFont(new Font("Tahoma", Font.BOLD, 17));
		bntCreate.setBounds(237, 279, 167, 36);
		bntCreate.setVisible(true);
		
//		bntUpdate=new JButton("Update");
//		bntUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
//		bntUpdate.setBounds(237, 279, 167, 36);
//		bntUpdate.setVisible(false);
		//frame.add(bntUpdate);
		frame.add(bntCreate);
		
	}
	public JTextField getTxt_username() {
		return txt_username;
	}
	public JTextField getTxt_password() {
		return txt_password;
	}
	public JButton getBntCreate() {
		return bntCreate;
	}
	public JButton getBntUpdate() {
		return bntUpdate;
	}

	public void dispose() {
		frame.dispose();
		// TODO Auto-generated method stub
		
	}
}
