package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.CurrentUserHolder;
import Model.Staff;
import Service.Auth_service;
import Service.Staff_Service;
import Utility.FrameMoveDetect;
import View.Login_view;
import View.Main_View;

public class Login_controller implements ActionListener {

	Auth_service authservice;
	Staff_Service staffservice;
	JButton btnlogin;
	JTextField txtc_username, txt_password;
	Login_view vlogin;
	String currentRole;

	public Login_controller() {

		dependencyInjection();
		vlogin = new Login_view();
		initComponent();
		initController();

	}

	public void dependencyInjection() {
		try {
			this.authservice = new Auth_service();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aaaaaaa");
		// vlogin = new Login_view();
	}

	public void initComponent() {
		txtc_username = vlogin.getTxtUsername();
		txt_password = vlogin.getPasswordField();
		btnlogin = vlogin.getBtnLogin();
	}

	private void initController() {

		btnlogin.addActionListener(this);
	}

	private void login() {

		String username = txtc_username.getText();
		String password = txt_password.getText();
		if (!username.isBlank() && !password.isBlank()) {
			Staff staff = authservice.login(username, password);
			if (staff != null) {

				JOptionPane.showMessageDialog(null, "Successfully Login");
				CurrentUserHolder.setLoggedInUser(staff);
				currentRole = CurrentUserHolder.getCurrentUser().getRole().getRole_name();
				System.out.println("currentholder is " + CurrentUserHolder.getCurrentUser().getRole().getRole_name());

				if (CurrentUserHolder.getCurrentUser() != null && currentRole.equals("Admin")) {
					vlogin.getFrame().dispose();
					Main_View main_View = new Main_View();
					main_View.getFrame().addComponentListener(new FrameMoveDetect());
					CreateAccount_controller createAccountController = new CreateAccount_controller(
							main_View.getFrame());

				}

				if (currentRole.equals("Office Staff")) {
					System.out.println("Go to Office View");
					vlogin.getFrame().dispose();
					Main_View main_View = new Main_View();
					OrderManage_controller nextController = new OrderManage_controller(main_View.getFrame());
					// CargoTransportationSystem cargo = new CargoTransportationSystem();
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
