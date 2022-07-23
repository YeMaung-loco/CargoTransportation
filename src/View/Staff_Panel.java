package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Utility.RoundedBorder;

public class Staff_Panel extends JFrame {
	JFrame frame;
	JPanel panel_list, panel_inputForm;

	JLabel lblName, lblAddress, lblPhone, lblNrc, lblDepartment, lblInputform, lblAccountType, lblFunction;
	JTextField txtName, txtNRC, txtPhone, txtsearch;
	JRadioButton rdbtnOffice, rdbtnDelivery;
	JCheckBox chckbxupload, chckbxManage;
	JTextArea txtareaAddress;
	JButton btnSave, btnUpdate, btnDelete, btnMinimize, btnMaximize,btnCreate,btnEdit;

	JTable tblStaff;
	JScrollPane scrollPane;
	DefaultTableModel dtm;
	JButton btnClear;
	JButton btnSearch;
	ButtonGroup group;

	JFrame containerFrame;
	private JCheckBox chckbxActive;
	private JComboBox<String> comboDepartment;

	public Staff_Panel(JFrame frame) {
		this.containerFrame = frame;
		initcomponent();
		setProperties();
		addComponents();

		// panel_inputForm.revalidate();
		// panel_inputForm.repaint();

		// panel_list.revalidate();
		// panel_list.repaint();

		containerFrame.revalidate();
		containerFrame.repaint();

	}

	public Staff_Panel() {

	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Phone");
		dtm.addColumn("Role");
		dtm.addColumn("Department");
		dtm.addColumn("Is Active");
		this.tblStaff.setModel(dtm);
		// resizeColumnWidth(tblStaff);
	}

	/*
	 * public void resizeColumnWidth(JTable table) { final TableColumnModel
	 * columnModel = table.getColumnModel(); for (int column = 0; column <
	 * table.getColumnCount(); column++) { int width = 15; // Min width for (int row
	 * = 0; row < table.getRowCount(); row++) { TableCellRenderer renderer =
	 * table.getCellRenderer(row, column); Component comp =
	 * table.prepareRenderer(renderer, row, column); width =
	 * Math.max(comp.getPreferredSize().width +1 , width); } width = Math.max(width,
	 * table.getColumnModel().getColumn(column).getPreferredWidth()); if(width >
	 * 300) width=300; columnModel.getColumn(column).setPreferredWidth(width); } }
	 */

	private void initcomponent() {

		//frame = new JFrame();
		panel_inputForm = new JPanel();
		lblName = new JLabel();
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		lblDepartment = new JLabel();
		lblAddress = new JLabel();
		txtareaAddress = new JTextArea();
		txtareaAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		btnCreate=new JButton();
		btnUpdate=new JButton();
		btnEdit=new JButton();

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
		/*
		 * frame.getContentPane().setLayout(null); frame.setBounds(0, 0, 1300, 760);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 */

		panel_inputForm.setBackground(new Color(255, 255, 204));
		panel_inputForm.setBounds(200, 0, 1144, 310);
		panel_inputForm.setLayout(null);

		panel_list.setBounds(200, 310, 1144, 430);
		panel_list.setLayout(null);
		panel_list.setBorder(new RoundedBorder(20));

		tblStaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblStaff.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		// tblStaff.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		lblName.setText("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(30, 108, 54, 32);

		txtName.setBounds(167, 112, 200, 32);
		txtName.setColumns(10);

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

		lblPhone.setText("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhone.setBounds(801, 108, 58, 32);

		txtPhone.setColumns(10);
		txtPhone.setBounds(916, 112, 200, 32);

		lblInputform.setText("Input Form");
		lblInputform.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInputform.setBounds(32, 10, 125, 32);

		lblDepartment.setText("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDepartment.setBounds(30, 173, 112, 32);

		lblAddress.setText("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(420, 177, 74, 32);

		Border border = BorderFactory.createLineBorder(SystemColor.activeCaptionBorder);
		txtareaAddress.setBounds(530, 177, 202, 47);
		txtareaAddress
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));

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
		btnSave.setBounds(30, 259, 130, 32);

		btnUpdate.setText("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(238, 259, 130, 32);

		btnCreate.setText("Create Account");
		btnCreate.setFont(new Font("Tahoma", Font.BOLD,16));
		btnCreate.setBounds(801,259,170,32);
		
		btnEdit.setText("Update Account");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD,16));
		btnEdit.setBounds(801,259,170,32);
		btnEdit.setVisible(false);
		
		
		btnDelete.setText("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(420, 259, 130, 32);

		btnClear.setText("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(602, 259, 130, 32);

		btnSearch.setText("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(987, 7, 130, 33);

		txtsearch.setBounds(788, 8, 200, 32);
		txtsearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtsearch.setColumns(10);

		scrollPane.setBounds(10, 46, 1110, 370);
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
		group.add(rdbtnOffice);
		group.add(rdbtnDelivery);

		panel_inputForm.add(chckbxManage);
		panel_inputForm.add(chckbxupload);
		panel_inputForm.add(chckbxActive);

		panel_inputForm.add(btnMaximize);
		panel_inputForm.add(btnMinimize);
		panel_inputForm.add(btnDelete);
		panel_inputForm.add(btnUpdate);
		panel_inputForm.add(btnSave);
		panel_inputForm.add(btnClear);
		panel_inputForm.add(btnCreate);
		panel_inputForm.add(btnEdit);
		

		panel_inputForm.add(comboDepartment);

		panel_list.add(txtsearch);
		panel_list.add(btnSearch);
		panel_list.add(scrollPane);

		
		  if (containerFrame != null) {
		  containerFrame.getContentPane().add(panel_inputForm);
		  containerFrame.getContentPane().add(panel_list, BorderLayout.CENTER); }
		 
		//frame.getContentPane().add(panel_inputForm);

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
	public JButton getBtnCreate() {
		return btnCreate;
	}
	public JButton getBtnedit() {
		return btnEdit;
	}

	public JPanel getPanel_list() {
		return panel_list;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JCheckBox getChckbxActive() {
		return chckbxActive;
	}

	public JComboBox getComboDepartment() {
		return comboDepartment;
	}

	public JTable getTable() {
		return tblStaff;
	}
}
