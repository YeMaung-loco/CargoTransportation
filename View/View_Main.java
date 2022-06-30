package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class View_Main {
	JFrame frame;
	DefaultTableModel dtm;
	JPanel panel;
	JLabel lblNewLabel_1;
	JButton btnEmployee, btnBrand, btnCategory, btnClose, btnLogin;
	private JPanel panel_btnBrand;
	private JLabel lblNewLabel;
	private JLabel iconJLabel_1;
	private JPanel panel_btnEmployee;
	private JPanel panel_btnCategory;

	public View_Main() {
		initComponents();
		setProperties();
		addComponents();
	}

	private void initComponents() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		btnEmployee = new JButton();	
		btnEmployee.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\admin (1).png"));
		btnClose = new JButton();
		btnBrand = new JButton();
		btnBrand.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\brand (1).png"));
		btnCategory = new JButton();
		btnLogin = new JButton();
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\logout (1).png"));
		dtm = new DefaultTableModel();
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 204, 0), UIManager.getColor("Button.shadow")));
		panel.setForeground(SystemColor.menu);
	}

	private void addComponents() {
		panel.setLayout(null);
		panel.add(btnEmployee);
		panel.add(btnBrand);
		panel.add(btnCategory);
		panel.add(btnLogin);

		frame.getContentPane().add(btnClose);
		frame.getContentPane().add(panel);
		
		panel_btnEmployee = new JPanel();
		panel_btnEmployee.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_btnEmployee.setBackground(new Color(255, 215, 0));
		panel_btnEmployee.setBounds(0, 253, 177, 70);
		panel.add(panel_btnEmployee);
		panel_btnEmployee.setLayout(null);
		
				ImageIcon deli_icon=new ImageIcon("C:\\Users\\User\\Downloads\\admin (1).png");
				JLabel iconJLabel=new JLabel(deli_icon);
				iconJLabel.setVerticalAlignment(SwingConstants.TOP);
				iconJLabel.setBounds(30, 19, 32, 32);
				lblNewLabel_1 = new JLabel("Employee");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_1.setBounds(65, 15, 87, 39);
				panel_btnEmployee.add(lblNewLabel_1);
				panel_btnEmployee.add(iconJLabel);
				
				panel_btnBrand = new JPanel();
				panel_btnBrand.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_btnBrand.setBackground(new Color(255, 215, 0));
				panel_btnBrand.setLayout(null);
				panel_btnBrand.setBounds(0, 322, 177, 70);
				panel.add(panel_btnBrand);
				
				lblNewLabel = new JLabel("Brand");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel.setBounds(74, 15, 45, 39);
				panel_btnBrand.add(lblNewLabel);
				
				iconJLabel_1 = new JLabel((Icon) new ImageIcon("C:\\Users\\User\\Downloads\\brand (1).png"));
				iconJLabel_1.setVerticalAlignment(SwingConstants.TOP);
				iconJLabel_1.setBounds(32, 19, 32, 32);
				panel_btnBrand.add(iconJLabel_1);
				
				panel_btnCategory = new JPanel();
				panel_btnCategory.setLayout(null);
				panel_btnCategory.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_btnCategory.setBackground(new Color(255, 215, 0));
				panel_btnCategory.setBounds(0, 392, 177, 70);
				panel.add(panel_btnCategory);
				
				JLabel lblCategory = new JLabel("Category");
				lblCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblCategory.setBounds(74, 15, 79, 39);
				panel_btnCategory.add(lblCategory);
				
				ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\User\\Downloads\\options-lines.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
				JLabel iconJLabel_1_1 = new JLabel();
				iconJLabel_1_1.setIcon(imageIcon);
				iconJLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
				iconJLabel_1_1.setBounds(32, 19, 32, 32);
				panel_btnCategory.add(iconJLabel_1_1);
		
	//	setTableDesign();
	}

	private void setProperties() {
		frame.setTitle("Employee Management System");
		frame.setBounds(20, 10, 1270, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		//Color color = UIManager.getColor("Table.gridColor");
		//MatteBorder border = new MatteBorder(1, 1, 0, 0, color);
		// Border blackline = BorderFactory.createLineBorder(Color.black);
		panel.setBounds(6, 10, 177, 623);
		panel.setBackground(new Color(255, 255, 102));

		//Border borderTitle = BorderFactory.createTitledBorder("Brand Form");

		

		btnEmployee.setText("Employee");
		btnEmployee.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEmployee.setBounds(0, 0, 177, 70);

		btnClose.setText("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBounds(1076, 594, 170, 39);

		btnBrand.setText("Brand");
		btnBrand.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBrand.setBounds(0, 71, 177, 70);

		btnCategory.setText("Category");
		btnCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCategory.setBounds(0, 140, 177, 70);
		
		btnLogin.setText("LogOut");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(0, 553, 177, 70);

	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

	public JButton getbtnEmployee() {
		return btnEmployee;
	}

	public JButton getbtnBrand() {
		return btnBrand;
	}

	public JButton getbtnCategory() {
		return btnCategory;
	}

	public JButton getbtnClose() {
		return btnClose;
	}
	
	public JLabel getLabel() {
		return lblNewLabel_1;
	}
	public JPanel getPanel_btnEmployee() {
		return panel_btnEmployee;
	}
	public JPanel getPanel_btnBrand() {
		return panel_btnBrand;
	}
	public JPanel getPanel_btnCategory() {
		return panel_btnCategory;
	}
}
