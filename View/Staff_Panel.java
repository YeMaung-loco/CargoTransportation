package View;

import java.awt.Font;
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

import Utility.Department_enum;
import Utility.RoundedBorder;

import java.awt.BorderLayout;
import java.awt.Color;
<<<<<<< Updated upstream
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
=======
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
>>>>>>> Stashed changes

public class Staff_Panel extends JFrame {
	JFrame frame;
	JPanel panel_list, panel_inputForm;

<<<<<<< Updated upstream
	JLabel lblName, lblAddress, lblPhone, lblNrc, lblDepartment, lblInputform, lblAccountType, lblFunction;
=======
	JLabel lblName, lblAddress, lblPhone, lblNrc, lblDepartment, lblInputform,
			lblAccountType, lblFunction;
>>>>>>> Stashed changes
	JTextField txtName, txtNRC, txtPhone, txtsearch;
	JRadioButton rdbtnOffice, rdbtnDelivery;
	JCheckBox chckbxupload, chckbxManage;
	JTextArea txtareaAddress;
	JButton btnSave, btnUpdate, btnDelete, btnClear, btnMinimize, btnMaximize, btnSearch;
	JComboBox<String> comboDepartment;
	JTable tblStaff;
	JScrollPane scrollPane;
	DefaultTableModel dtm;

	ButtonGroup radioGroup;

	JFrame containerFrame;
	private JCheckBox chckbxActive;
<<<<<<< Updated upstream
	private JComboBox<String> comboDepartment;
=======
>>>>>>> Stashed changes

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
		dtm.addColumn("Phone");
<<<<<<< Updated upstream
		dtm.addColumn("Role");
		dtm.addColumn("Department");
		dtm.addColumn("Is Active");
=======
		dtm.addColumn("Department");
		dtm.addColumn("Role");
		dtm.addColumn("IsActive");
>>>>>>> Stashed changes
		this.tblStaff.setModel(dtm);
	}

	private void initcomponent() {
		frame = new JFrame();
		panel_inputForm = new JPanel();

		lblName = new JLabel();
		txtName = new JTextField();
<<<<<<< Updated upstream
		txtName.setFont(new Font("Tahoma", Font.BOLD, 15));
=======

>>>>>>> Stashed changes
		rdbtnOffice = new JRadioButton();
		rdbtnDelivery = new JRadioButton();

		lblAccountType = new JLabel();
		lblNrc = new JLabel();
		txtNRC = new JTextField();

		lblPhone = new JLabel();
		txtPhone = new JTextField();

		lblInputform = new JLabel();
<<<<<<< Updated upstream
		lblDepartment = new JLabel();
=======

		lblDepartment = new JLabel();

>>>>>>> Stashed changes
		lblAddress = new JLabel();
		txtareaAddress = new JTextArea();

		lblFunction = new JLabel();
		chckbxupload = new JCheckBox();
		chckbxManage = new JCheckBox();
		chckbxActive = new JCheckBox();

		comboDepartment = new JComboBox();
		comboDepartment.setFont(new Font("Tahoma", Font.BOLD, 15));

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

		radioGroup = new ButtonGroup();
		comboDepartment = new JComboBox<>();
	}

	private void setProperties() {
		getContentPane().setLayout(null);
		frame.setBounds(0, 0, 1300, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel_inputForm.setBackground(new Color(255, 255, 204));
		panel_inputForm.setBounds(200, 0, 1144, 310);
		panel_inputForm.setLayout(null);

		panel_list.setBounds(200, 310, 1144, 430);
		panel_list.setLayout(null);
		panel_list.setBorder(new RoundedBorder(20));

		lblName.setText("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(30, 108, 54, 32);

		txtName.setBounds(167, 112, 200, 32);
		txtName.setColumns(10);
<<<<<<< Updated upstream
=======
		txtName.setFont(new Font("Tahoma", Font.BOLD, 15));
>>>>>>> Stashed changes

		rdbtnOffice.setText("Office");
		rdbtnOffice.setActionCommand("Office");
		rdbtnOffice.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnOffice.setBounds(167, 62, 82, 40);
		rdbtnOffice.setBackground(new Color(255, 255, 204));

		rdbtnDelivery.setText("Delivery");
		rdbtnDelivery.setActionCommand("Delivery");
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
		txtNRC.setFont(new Font("Tahoma", Font.BOLD, 15));

		lblPhone.setText("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhone.setBounds(801, 108, 58, 32);

		txtPhone.setColumns(10);
		txtPhone.setBounds(916, 112, 200, 32);
		txtPhone.setFont(new Font("Tahoma", Font.BOLD, 15));

		lblInputform.setText("Input Form");
		lblInputform.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInputform.setBounds(32, 10, 125, 32);

		lblDepartment.setText("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 18));
<<<<<<< Updated upstream
		lblDepartment.setBounds(30, 173, 112, 32);

		lblAddress.setText("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(420, 177, 74, 32);

		txtareaAddress.setBounds(530, 177, 202, 47);
=======
		lblDepartment.setBounds(30, 171, 112, 32);

		lblAddress.setText("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(420, 175, 74, 32);

		txtareaAddress.setBounds(530, 171, 202, 47);
		txtareaAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
>>>>>>> Stashed changes

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

		chckbxActive.setText("Active");
		chckbxActive.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxActive.setBackground(new Color(255, 255, 204));
		chckbxActive.setBounds(801, 173, 97, 30);

		comboDepartment.setBounds(167, 177, 200, 32);

		btnMaximize.setText("Maximize");
		btnMaximize.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMaximize.setBounds(987, 10, 130, 32);

		btnMinimize.setText("Minimize");
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMinimize.setBounds(987, 10, 129, 32);

		btnSave.setText("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
<<<<<<< Updated upstream
		btnSave.setBounds(30, 259, 130, 32);

		btnUpdate.setText("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(238, 259, 130, 32);

		btnDelete.setText("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(420, 259, 130, 32);

		btnClear.setText("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(602, 259, 130, 32);
=======
		btnSave.setBounds(30, 255, 130, 32);

		btnUpdate.setText("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(238, 255, 130, 32);

		btnDelete.setText("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(420, 255, 130, 32);

		btnClear.setText("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(602, 255, 130, 32);
>>>>>>> Stashed changes

		btnSearch.setText("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(987, 7, 130, 33);

		txtsearch.setBounds(788, 8, 200, 32);
		txtsearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtsearch.setColumns(10);

<<<<<<< Updated upstream
		scrollPane.setBounds(10, 46, 1110, 370);
=======
		//comboDepartment.setModel(new DefaultComboBoxModel<>(Department_enum.values()));
		comboDepartment.setBounds(167, 175, 200, 32);
		comboDepartment.setFont(new Font("Tahoma", Font.BOLD, 15));

		scrollPane.setBounds(10, 46, 1110, 310);
>>>>>>> Stashed changes
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
		panel_inputForm.add(lblPhone);
		panel_inputForm.add(txtareaAddress);
		panel_inputForm.add(txtNRC);
		panel_inputForm.add(txtName);
		panel_inputForm.add(txtPhone);

		panel_inputForm.add(rdbtnDelivery);
		panel_inputForm.add(rdbtnOffice);
		radioGroup.add(rdbtnOffice);
		radioGroup.add(rdbtnDelivery);

		panel_inputForm.add(chckbxManage);
		panel_inputForm.add(chckbxupload);
		panel_inputForm.add(chckbxActive);

		panel_inputForm.add(btnMaximize);
		panel_inputForm.add(btnMinimize);
		panel_inputForm.add(btnDelete);
		panel_inputForm.add(btnUpdate);
		panel_inputForm.add(btnSave);
		panel_inputForm.add(btnClear);

		panel_inputForm.add(comboDepartment);
<<<<<<< Updated upstream
=======
		
		chckbxActive = new JCheckBox();
		chckbxActive.setText("Active");
		chckbxActive.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxActive.setBackground(new Color(255, 255, 204));
		chckbxActive.setBounds(801, 171, 82, 30);
		panel_inputForm.add(chckbxActive);
>>>>>>> Stashed changes

		panel_list.add(txtsearch);
		panel_list.add(btnSearch);
		panel_list.add(scrollPane);

		if (containerFrame != null) {
			containerFrame.getContentPane().add(panel_inputForm);
			containerFrame.getContentPane().add(panel_list, BorderLayout.CENTER);
		}

	}

	public ButtonGroup getRadioGroup() {
		return group;
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
<<<<<<< Updated upstream

=======
	
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
	public JCheckBox getChckbxActive() {
		return chckbxActive;
=======
	public JTable getTable() {
		return tblStaff;
	}

	public ButtonGroup getRadioGroup() {
		return radioGroup;
>>>>>>> Stashed changes
	}

	public JComboBox getComboDepartment() {
		return comboDepartment;
	}
<<<<<<< Updated upstream
	
	public JTable getTable() {
		return tblStaff;
=======
	public JCheckBox getChckbxActive() {
		return chckbxActive;
>>>>>>> Stashed changes
	}
}
