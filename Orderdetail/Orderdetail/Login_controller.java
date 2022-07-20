package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Staff;
import Service.Auth_service;
import Service.Staff_Service;
import View.logintest;
import utils.CurrentUserHolder;


public class Login_controller implements ActionListener{
	
	Auth_service authservice;
	Staff_Service staffservice;
	JButton btnlogin;
	JTextField txtc_username,txt_password;
	logintest vlogin;
 
	public Login_controller() throws SQLException {
		dependencyInjection();
		vlogin=new logintest();
		initComponent();
		initController();
	}
	public void dependencyInjection() throws SQLException {
		this.authservice=new Auth_service();
		System.out.println("aaaaaaa");
		vlogin=new logintest();
		}
	public void initComponent() {
		txtc_username = vlogin.getTxtUsername();
		txt_password = vlogin.getPasswordField();
		btnlogin=vlogin.getBtnLogin();
	}
	private void initController() {
		
		btnlogin.addActionListener(this);
	}
	private void login() {
		
		String username=txtc_username.getText();
		String password=txt_password.getText();
		 if (!username.isBlank() && !password.isBlank()) {
             Staff staff = authservice.login(username, password);
             if(staff!=null) {
                
                 JOptionPane.showMessageDialog(null, "Successfully Login");
                 CurrentUserHolder.setLoggedInUser(staff);
                if(CurrentUserHolder.getCurrentUser()!=null) 
                {
                	System.out.println("currenholder is "+CurrentUserHolder.getCurrentUser().getRole().getRole_name());
                 CargoTransportationSystem cargo=new CargoTransportationSystem();
                } 
                
                if(CurrentUserHolder.getCurrentUser().getRole().equals("Office")) 
                {
                	System.out.println("Go to Office View");
                 CargoTransportationSystem cargo=new CargoTransportationSystem();
                } 
                if(CurrentUserHolder.getCurrentUser().getRole().equals("Admin")) 
                {
                	System.out.println("Go to Admin View");
                 CargoTransportationSystem cargo=new CargoTransportationSystem();
                } 

         }
		 } else {
             JOptionPane.showMessageDialog(null, "Enter required Fields");
         }

 }
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource().equals((btnlogin))) {
		login();
	}
		
	}
}
