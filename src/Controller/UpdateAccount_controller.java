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
import View.Update_account;

public class UpdateAccount_controller implements ActionListener {

private Auth_service auth_service;
private JButton btnupdate;
private JTextField txt_username,txt_password;
private Authenticate auth;
int temp_id;
Update_account update;

	
	
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public UpdateAccount_controller(int temp){
		dependencyInjection();
		this.temp_id=temp;
		update=new Update_account();
		initComponents();
		loadData(temp);
		
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
		
		btnupdate=update.getBntUpdate();
       txt_username=update.getTxt_username();
		txt_password=update.getTxt_password();
		
	}
	private void initController() {
	
		btnupdate.addActionListener(this);
	}
	private void loadData(int temp_id) {
		auth=auth_service.getDatabyId(temp_id);
		txt_username.setText(auth==null? " ": auth.getUsername());
		txt_password.setText(auth==null? ""  :  auth.getPassword());
	}
	
	
	private void Update_account(int temp_id) {
	
		auth=new Authenticate();
		auth.setUsername(txt_username.getText());
		auth.setPassword(txt_password.getText());
		int status=auth_service.updateAccount(temp_id,auth);
		if(status>0) {
			JOptionPane.showMessageDialog(null, "successfully");
		     update.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "failed");
	}
	}
	private void clear() {
		txt_username.setText("");
		txt_password.setText("");
	}


	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnupdate))
			Update_account( temp_id);
		    clear();
		
		
	}

	
	
}

