package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class designPanel extends JFrame {
	JFrame frame;
	private JLabel lblName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblStaffid;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblNrc;
	private JLabel lblDepartment;
	private JTextField txtName;
	private JTextField txtUserName;
	private JTextField txtNRC;
	private JTextField txtPhone;
	private JTextField txtStaffid;
	private JTextField txtPassword;
	private JTextField txtDepartment;
	private JRadioButton rdbtnOffice;
	private JRadioButton rdbtnDelivery;
	private JCheckBox chckbxupload;
	private JCheckBox chckbxManage;
	private JTextArea txtareaAddress;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnMinimize;
	private JButton btnMaximize;
	private JLabel lblInputform;
	private JLabel lblAccountType;
	private JLabel lblFunction;
	private JPanel panel_create;
	private JTextField txtsearch;
	private JTable tblEmployee;
	private JScrollPane scrollPane;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JButton btnClear;
	private JButton btnSearch;
	private ButtonGroup group;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					designPanel window = new designPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public designPanel() {
		initcomponent();
		setProperties();
		addComponents();
		setTableDesign();

	}
	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("NRC");
		dtm.addColumn("Phone");
		dtm.addColumn("Address");
		dtm.addColumn("Department");
		
		this.tblEmployee.setModel(dtm);
		
		
	
		
	}

	private void initcomponent() {

		frame = new JFrame();
		panel_create = new JPanel();
		lblName = new JLabel();
		lblUsername = new JLabel();
		txtName = new JTextField();
		txtUserName = new JTextField();
		rdbtnOffice = new JRadioButton();
		rdbtnDelivery = new JRadioButton();
		lblAccountType = new JLabel();
		lblNrc = new JLabel();
		txtNRC = new JTextField();
		lblPhone = new JLabel();
		txtPhone = new JTextField();
		lblInputform = new JLabel();
		lblPassword = new JLabel();
		txtPassword = new JTextField();
		lblStaffid = new JLabel();
		txtStaffid = new JTextField();
		lblDepartment = new JLabel();
		txtDepartment = new JTextField();
		lblAddress = new JLabel();
		txtareaAddress = new JTextArea();
		lblFunction = new JLabel();
		chckbxupload = new JCheckBox();
		chckbxManage = new JCheckBox();
		btnMaximize = new JButton();
		btnMinimize = new JButton();
		btnSave = new JButton();
		btnUpdate = new JButton();
		btnDelete = new JButton();
	     group=new ButtonGroup();
	}

	private void setProperties() {
		//getContentPane().setLayout(null);
		frame.setBounds(0, 0, 1300, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel_create.setBackground(SystemColor.activeCaption);
		panel_create.setBounds(0, 0, 1144, 370);

		panel_create.setLayout(null);

		lblName.setText("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(30, 108, 54, 32);

		txtName.setBounds(167, 112, 200, 32);
		txtName.setColumns(10);

		lblUsername.setText("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setBounds(30, 179, 97, 32);

		txtUserName.setColumns(10);
		txtUserName.setBounds(167, 183, 200, 32);

		rdbtnOffice.setText("Office");
		rdbtnOffice.setFont(new Font("Tahoma", Font.BOLD, 17));
		rdbtnOffice.setBounds(167, 66, 82, 40);
	    group.add(rdbtnOffice);

		rdbtnDelivery.setText("Delivery");
		rdbtnDelivery.setFont(new Font("Tahoma", Font.BOLD, 17));
		rdbtnDelivery.setBounds(264, 66, 103, 40);
	    group.add(rdbtnDelivery);

		lblAccountType.setText("Account Type");
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAccountType.setBounds(30, 66, 127, 40);

		lblNrc.setText("NRC");
		lblNrc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNrc.setBounds(451, 112, 40, 32);

		txtNRC.setColumns(10);
		txtNRC.setBounds(532, 112, 200, 32);

		lblPhone.setText("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhone.setBounds(809, 112, 58, 32);

		txtPhone.setColumns(10);
		txtPhone.setBounds(916, 112, 200, 32);

		lblInputform.setText("Input Form");
		lblInputform.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInputform.setBounds(32, 1, 125, 32);

		lblStaffid.setText("Staff ID");
		lblStaffid.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStaffid.setBounds(417, 183, 74, 32);

		txtStaffid.setColumns(10);
		txtStaffid.setBounds(532, 183, 200, 32);

		lblPassword.setText("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(778, 183, 89, 32);

		txtPassword.setColumns(10);
		txtPassword.setBounds(916, 183, 200, 32);

		lblDepartment.setText("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDepartment.setBounds(30, 237, 112, 32);

		txtDepartment.setColumns(10);
		txtDepartment.setBounds(167, 241, 200, 32);

		lblAddress.setText("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(417, 241, 74, 32);

		txtareaAddress.setBounds(530, 241, 202, 47);

		lblFunction.setText("Function");
		lblFunction.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFunction.setBounds(420, 70, 112, 32);

		chckbxupload.setText("Upload");
		chckbxupload.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxupload.setBounds(532, 72, 82, 30);

		chckbxManage.setText("Manage");
		chckbxManage.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxManage.setBounds(635, 72, 97, 30);

		btnMaximize.setText("Maximize");
		btnMaximize.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMaximize.setBounds(987, 10, 129, 32);

		btnMinimize.setText("Minimize");
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMinimize.setBounds(987, 10, 129, 32);

		btnSave.setText("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(30, 303, 129, 32);

		btnUpdate.setText("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(238, 303, 129, 32);

		btnDelete.setText("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(418, 303, 129, 32);

	}

	private void addComponents() {
		getContentPane().add(panel_create);
		panel_create.add(chckbxManage);
		panel_create.add(chckbxupload);
		panel_create.add(lblAccountType);
		panel_create.add(lblAddress);
		panel_create.add(lblDepartment);
		panel_create.add(lblFunction);
		panel_create.add(lblInputform);
		panel_create.add(lblName);
		panel_create.add(lblNrc);
		panel_create.add(lblPassword);
		panel_create.add(lblPhone);
		panel_create.add(lblStaffid);
		panel_create.add(lblUsername);
		panel_create.add(txtareaAddress);
		panel_create.add(txtDepartment);
		panel_create.add(txtNRC);
		panel_create.add(txtName);
		panel_create.add(txtPassword);
		panel_create.add(txtPhone);
		panel_create.add(txtStaffid);
		panel_create.add(txtUserName);
		panel_create.add(rdbtnDelivery);
		panel_create.add(rdbtnOffice);
		panel_create.add(btnMaximize);
		panel_create.add(btnMinimize);
		panel_create.add(btnDelete);
		panel_create.add(btnUpdate);
		panel_create.add(btnSave);
		
		btnClear = new JButton();
		btnClear.setText("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(598, 303, 129, 32);
		panel_create.add(btnClear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 370, 1144, 370);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearch.setBounds(703, 7, 90, 26);
		panel_1.add(lblSearch);
		
		txtsearch = new JTextField();
		txtsearch.setBounds(803, 10, 161, 26);
		panel_1.add(txtsearch);
		txtsearch.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 46, 1144, 324);
		panel_1.add(scrollPane);
		
		tblEmployee = new JTable();
		tblEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tblEmployee);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(1002, 7, 132, 26);
		panel_1.add(btnSearch);
		
	
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
}
