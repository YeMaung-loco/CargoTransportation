package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Utility.RoundedBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Staff_Panel extends JFrame {
	JFrame frame;
	JPanel panel_list, panel_inputForm;

	JLabel lblName, lblUsername, lblPassword, lblStaffid, lblAddress, lblPhone, lblNrc, lblDepartment, lblInputform,
			lblAccountType, lblFunction;
	JTextField txtName, txtUserName, txtNRC, txtPhone, txtStaffid, txtPassword, txtDepartment, txtsearch;
	JRadioButton rdbtnOffice, rdbtnDelivery;
	JCheckBox chckbxupload, chckbxManage;
	JTextArea txtareaAddress;
	JButton btnSave, btnUpdate, btnDelete, btnMinimize, btnMaximize;

	JTable tblStaff;
	JScrollPane scrollPane;
	DefaultTableModel dtm;
	JButton btnClear;
	JButton btnSearch;
	ButtonGroup group;

	JFrame containerFrame;

	public Staff_Panel(JFrame frame) {
		this.containerFrame = frame;
		initcomponent();
		setProperties();
		addComponents();

		panel_inputForm.revalidate();
		panel_inputForm.repaint();

		panel_list.revalidate();
		panel_list.repaint();

	}

	public Staff_Panel() {
		initcomponent();
		setProperties();
		addComponents();

	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("NRC");
		dtm.addColumn("Phone");
		dtm.addColumn("Address");
		dtm.addColumn("Department");
		this.tblStaff.setModel(dtm);
	}

	private void initcomponent() {

		frame = new JFrame();
		panel_inputForm = new JPanel();
		lblName = new JLabel();
		lblUsername = new JLabel();
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnOffice = new JRadioButton();
		rdbtnDelivery = new JRadioButton();

		lblAccountType = new JLabel();
		lblNrc = new JLabel();
		txtNRC = new JTextField();
		txtNRC.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhone = new JLabel();
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInputform = new JLabel();
		lblPassword = new JLabel();
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStaffid = new JLabel();
		txtStaffid = new JTextField();
		txtStaffid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDepartment = new JLabel();
		txtDepartment = new JTextField();
		txtDepartment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress = new JLabel();
		txtareaAddress = new JTextArea();
		txtareaAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFunction = new JLabel();
		chckbxupload = new JCheckBox();
		chckbxManage = new JCheckBox();

		btnMaximize = new JButton();
		btnMinimize = new JButton();
		btnSave = new JButton();
		btnUpdate = new JButton();
		btnDelete = new JButton();
		btnClear = new JButton();

		panel_list = new JPanel();
		txtsearch = new JTextField();

		btnSearch = new JButton();

		dtm = new DefaultTableModel();
		tblStaff = new JTable();
		setTableDesign();
		scrollPane = new JScrollPane(tblStaff);

		group = new ButtonGroup();
	}

	private void setProperties() {
		getContentPane().setLayout(null);
		frame.setBounds(0, 0, 1300, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel_inputForm.setBackground(new Color(255, 255, 204));
		panel_inputForm.setBounds(200, 0, 1144, 370);
		panel_inputForm.setLayout(null);

		panel_list.setBounds(200, 370, 1144, 370);
		panel_list.setLayout(null);
		panel_list.setBorder(new RoundedBorder(20));

		lblName.setText("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(30, 108, 54, 32);

		txtName.setBounds(167, 112, 200, 32);
		txtName.setColumns(10);

		lblUsername.setText("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setBounds(30, 173, 97, 32);

		txtUserName.setColumns(10);
		txtUserName.setBounds(167, 177, 200, 32);

		rdbtnOffice.setText("Office");
		rdbtnOffice.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnOffice.setBounds(167, 62, 82, 40);
		rdbtnOffice.setBackground(new Color(255, 255, 204));

		rdbtnDelivery.setText("Delivery");
		rdbtnDelivery.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnDelivery.setBackground(new Color(255, 255, 204));
		rdbtnDelivery.setBounds(264, 62, 103, 40);

		lblAccountType.setText("Account Type");
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAccountType.setBounds(30, 62, 127, 40);

		lblNrc.setText("NRC");
		lblNrc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNrc.setBounds(420, 108, 40, 32);

		txtNRC.setColumns(10);
		txtNRC.setBounds(532, 112, 200, 32);

		lblPhone.setText("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhone.setBounds(801, 108, 58, 32);

		txtPhone.setColumns(10);
		txtPhone.setBounds(916, 112, 200, 32);

		lblInputform.setText("Input Form");
		lblInputform.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInputform.setBounds(32, 10, 125, 32);

		lblStaffid.setText("Staff ID");
		lblStaffid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStaffid.setBounds(420, 177, 74, 32);

		txtStaffid.setColumns(10);
		txtStaffid.setBounds(532, 177, 200, 32);

		lblPassword.setText("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(801, 177, 89, 32);

		txtPassword.setColumns(10);
		txtPassword.setBounds(916, 177, 200, 32);

		lblDepartment.setText("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDepartment.setBounds(30, 237, 112, 32);

		txtDepartment.setColumns(10);
		txtDepartment.setBounds(167, 241, 200, 32);

		lblAddress.setText("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(420, 241, 74, 32);

		txtareaAddress.setBounds(530, 241, 202, 47);

		lblFunction.setText("Function");
		lblFunction.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFunction.setBounds(420, 66, 112, 32);

		chckbxupload.setText("Upload");
		chckbxupload.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxupload.setBounds(532, 68, 82, 30);
		chckbxupload.setBackground(new Color(255, 255, 204));

		chckbxManage.setText("Manage");
		chckbxManage.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxManage.setBounds(635, 68, 97, 30);
		chckbxManage.setBackground(new Color(255, 255, 204));

		btnMaximize.setText("Maximize");
		btnMaximize.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMaximize.setBounds(987, 10, 130, 32);

		btnMinimize.setText("Minimize");
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMinimize.setBounds(987, 10, 129, 32);

		btnSave.setText("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(30, 303, 130, 32);

		btnUpdate.setText("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(238, 303, 130, 32);

		btnDelete.setText("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(420, 303, 130, 32);

		btnClear.setText("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(602, 303, 130, 32);

		btnSearch.setText("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(987, 7, 130, 33);

		txtsearch.setBounds(788, 8, 200, 32);
		txtsearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtsearch.setColumns(10);

		scrollPane.setBounds(10, 46, 1110, 310);
		tblStaff.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tblStaff);

	}

	private void addComponents() {

		panel_inputForm.add(lblAccountType);
		panel_inputForm.add(lblAddress);
		panel_inputForm.add(lblDepartment);
		panel_inputForm.add(lblFunction);
		panel_inputForm.add(lblInputform);
		panel_inputForm.add(lblName);
		panel_inputForm.add(lblNrc);
		panel_inputForm.add(lblPassword);
		panel_inputForm.add(lblPhone);
		panel_inputForm.add(lblStaffid);
		panel_inputForm.add(lblUsername);
		panel_inputForm.add(txtareaAddress);
		panel_inputForm.add(txtDepartment);
		panel_inputForm.add(txtNRC);
		panel_inputForm.add(txtName);
		panel_inputForm.add(txtPassword);
		panel_inputForm.add(txtPhone);
		panel_inputForm.add(txtStaffid);
		panel_inputForm.add(txtUserName);

		panel_inputForm.add(rdbtnDelivery);
		panel_inputForm.add(rdbtnOffice);
		group.add(rdbtnOffice);
		group.add(rdbtnDelivery);

		panel_inputForm.add(chckbxManage);
		panel_inputForm.add(chckbxupload);

		panel_inputForm.add(btnMaximize);
		panel_inputForm.add(btnMinimize);
		panel_inputForm.add(btnDelete);
		panel_inputForm.add(btnUpdate);
		panel_inputForm.add(btnSave);
		panel_inputForm.add(btnClear);

		panel_list.add(txtsearch);
		panel_list.add(btnSearch);
		panel_list.add(scrollPane);

		if (containerFrame != null) {
			containerFrame.getContentPane().add(panel_inputForm);
			containerFrame.getContentPane().add(panel_list, BorderLayout.CENTER);
		}

	}

	public JRadioButton getRdbtnOffice() {
		return rdbtnOffice;
	}

	public JRadioButton getRdbtnDelivery() {
		return rdbtnDelivery;
	}

	public JCheckBox getChckbxupload() {
		return chckbxupload;
	}

	public JCheckBox getChckbxManage() {
		return chckbxManage;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JTextField getTxtNRC() {
		return txtNRC;
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public JTextField getTxtStaffid() {
		return txtStaffid;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public JTextField getTxtDepartment() {
		return txtDepartment;
	}

	public JTextArea getTxtareaAddress() {
		return txtareaAddress;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnMinimize() {
		return btnMinimize;
	}

	public JButton getBtnMaximize() {
		return btnMaximize;
	}

	public JTextField getTxtsearch() {
		return txtsearch;
	}

	public JButton getBtnClear() {
		return btnClear;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JPanel getPanel_create() {
		return panel_inputForm;
	}

	public JPanel getPanel_list() {
		return panel_list;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
}
