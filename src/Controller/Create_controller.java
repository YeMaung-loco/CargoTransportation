package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Service.Auth_service;
import View.Create_account;
import Model.Authenticate;

public class Create_controller implements ActionListener {

private Auth_service auth_service;
private Create_account create;
private JButton btncreate,btnupdate;
private JTextField txt_username,txt_password;
private Authenticate auth;
int temp_id;

	
	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public Create_controller(int temp){
		dependencyInjection();
		this.temp_id=temp;
		create=new Create_account();
		initComponents();
		initController();
		
	}


	private void dependencyInjection() {
		try {
			auth_service=new Auth_service();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
		private void initComponents() {
		btnupdate=create.getBntUpdate();
		btncreate=create.getBntCreate();
		txt_username=create.getTxt_username();
		txt_password=create.getTxt_password();
		
	}
	private void initController() {
		btncreate.addActionListener(this);
		btnupdate.addActionListener(this);
	}
	
	
	private void create(int temp_id) {
		
		auth=new Authenticate();
		auth.setUsername(txt_username.getText());
		auth.setPassword(txt_password.getText());
		int status=auth_service.createAccount(temp_id,auth);
		if(status>0) 
			JOptionPane.showMessageDialog(null, "successfully");
		else
			JOptionPane.showMessageDialog(null, "failed");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource().equals(btncreate))
//			create( temp_id);
//		
//	}

	
	
}
