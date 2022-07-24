package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Utility.BackgroundMenubar;

public class Office_view {
	//JFrame frame;
	JFrame frame;
	DefaultTableModel dtm;
	JPanel panel_navigation;
	BackgroundMenubar menuBar;
	JMenu mnFile;
	JMenuItem menu_export, menu_import;
	JLabel lblStaff;
	JPanel panel_btnOrder;
	JLabel lblNewLabel;
	JLabel iconJLabel_1;
	JPanel panel_btnStaff;
	JPanel panel_btnDelivery;
	JPanel panel_list;
	JPanel panel_inputForm;
	// JPanel panel_Container;
	JPanel panel_btnLogout;
	JLabel lblIcon, lbl_iconLogout, lblLogout;
	private JPanel panel_btnSetPrice;
	private JPanel panel_btn_approve;
	private JLabel iconJLabel;
	private JLabel iconSetPrice;
	private JLabel iconJLabel_1_1;
	private JLabel iconSetPrice_1;

	public Office_view(JFrame cotainer) {
		this.frame=cotainer;
		initComponents();
		setProperties();
		addComponents();
	}

	private void initComponents() {
		//frame = new JFrame();

		dtm = new DefaultTableModel();
		panel_navigation = new JPanel();

		menuBar = new BackgroundMenubar();
		//menuBar.setBorderPainted(false);
		//menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mnFile = new JMenu("File Menu");
		mnFile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menu_export = new JMenuItem("How to use");
		menu_export.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//menu_import = new JMenuItem("Import Excel");
		//menu_import.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblIcon = new JLabel();
		lbl_iconLogout = new JLabel();
		lblLogout = new JLabel("Logout");

		panel_btnStaff = new JPanel();
		panel_btnOrder = new JPanel();
		panel_btnDelivery = new JPanel();
		panel_btnLogout = new JPanel();

		// panel_Container = new JPanel();
		// panel_inputForm = new JPanel();
		// panel_list = new JPanel();

	}

	private void addComponents() {
		//frame.getContentPane().add(panel_navigation);
		//frame.setJMenuBar(menuBar);
		frame.setJMenuBar(menuBar);

		menuBar.add(mnFile);
		mnFile.add(menu_export);
		//mnFile.add(menu_import);

		panel_navigation.add(lblIcon);
		panel_navigation.add(panel_btnStaff);
		panel_navigation.add(panel_btnOrder);
		panel_navigation.add(panel_btnLogout);

		panel_btnLogout.add(lblLogout);
		panel_btnLogout.add(lbl_iconLogout);
		
		frame.getContentPane().add(panel_navigation);
		
		panel_btnSetPrice = new JPanel();
		panel_btnSetPrice.setLayout(null);
		panel_btnSetPrice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_btnSetPrice.setBackground(new Color(255, 215, 0));
		panel_btnSetPrice.setBounds(0, 235, 200, 70);
		panel_navigation.add(panel_btnSetPrice);
		
		JLabel lblSet = new JLabel("Set Price");
		lblSet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSet.setBounds(62, 10, 128, 39);
		panel_btnSetPrice.add(lblSet);
		
		iconSetPrice = new JLabel();
		iconSetPrice.setVerticalAlignment(SwingConstants.TOP);
		iconSetPrice.setBounds(20, 14, 32, 32);
		panel_btnSetPrice.add(iconSetPrice);
		
		panel_btn_approve = new JPanel();
		panel_btn_approve.setLayout(null);
		panel_btn_approve.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_btn_approve.setBackground(new Color(255, 215, 0));
		panel_btn_approve.setBounds(0, 443, 200, 70);
		panel_navigation.add(panel_btn_approve);
		
		JLabel lblPaymentApprove = new JLabel("Approve");
		lblPaymentApprove.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPaymentApprove.setBounds(62, 10, 128, 39);
		panel_btn_approve.add(lblPaymentApprove);
		
		iconSetPrice_1 = new JLabel();
		iconSetPrice_1.setVerticalAlignment(SwingConstants.TOP);
		iconSetPrice_1.setBounds(20, 14, 32, 32);
		panel_btn_approve.add(iconSetPrice_1);

	}

	private void setProperties() {
		

		menuBar.setColor(Color.orange);
		menuBar.setOpaque(true);
		menuBar.setFont(new Font("Tahoma", Font.BOLD, 12));

		// panel_inputForm.setBackground(new Color(255, 255, 153));
		// panel_inputForm.setBounds(0, 0, 1144, 370);
		// panel_list.setBackground(new Color(255, 255, 204));
		// panel_list.setBounds(0, 370, 1144, 370);

		panel_navigation.setLayout(null);
		panel_navigation.setBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 204, 0), UIManager.getColor("Button.shadow")));
		panel_navigation.setForeground(SystemColor.menu);
		panel_navigation.setBounds(0, 0, 200, 741);
		panel_navigation.setBackground(new Color(255, 255, 102));

				
		lblIcon.setBounds(0, 0, 200, 162);
		ImageIcon logo = new ImageIcon(new ImageIcon("resource\\cargo.png").getImage()
				.getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(), Image.SCALE_SMOOTH));
		lblIcon.setIcon(logo);

		lbl_iconLogout.setVerticalAlignment(SwingConstants.TOP);
		lbl_iconLogout.setBounds(50, 19, 32, 32);
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogout.setBounds(92, 15, 79, 39);

		//ImageIcon iconLogout = setIconScale("C:\\Users\\User\\Downloads\\options-lines.png");
		lbl_iconLogout.setIcon(new ImageIcon("resource\\logout.png"));

		//ImageIcon account_icon = new ImageIcon("resource\\");
		iconJLabel = new JLabel();
		panel_btnStaff.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_btnStaff.setBackground(new Color(255, 215, 0));
		panel_btnStaff.setBounds(0, 165, 200, 70);
		panel_btnStaff.setLayout(null);
		iconJLabel.setVerticalAlignment(SwingConstants.TOP);
		iconJLabel.setBounds(14, 19, 32, 32);
		lblStaff = new JLabel("Manage Account");
		lblStaff.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStaff.setBounds(62, 15, 126, 39);
		panel_btnStaff.add(lblStaff);
		panel_btnStaff.add(iconJLabel);

		panel_btnOrder.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_btnOrder.setBackground(new Color(255, 215, 0));
		panel_btnOrder.setLayout(null);
		panel_btnOrder.setBounds(0, 304, 200, 70);

		lblNewLabel = new JLabel("Manage Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(62, 15, 118, 39);
		panel_btnOrder.add(lblNewLabel);

		iconJLabel_1 = new JLabel((Icon) new ImageIcon("C:\\Users\\User\\Downloads\\brand (1).png"));
		iconJLabel_1.setVerticalAlignment(SwingConstants.TOP);
		iconJLabel_1.setBounds(14, 19, 32, 32);
		panel_btnOrder.add(iconJLabel_1);

		panel_btnDelivery.setLayout(null);
		panel_btnDelivery.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_btnDelivery.setBackground(new Color(255, 215, 0));
		panel_btnDelivery.setBounds(0, 373, 200, 70);
		panel_navigation.add(panel_btnDelivery);

		JLabel lblCategory = new JLabel("Manage Delivery");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategory.setBounds(62, 10, 128, 39);
		panel_btnDelivery.add(lblCategory);

		ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\User\\Downloads\\options-lines.png").getImage()
				.getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		iconJLabel_1_1 = new JLabel();
		iconJLabel_1_1.setIcon(imageIcon);
		iconJLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		iconJLabel_1_1.setBounds(20, 14, 32, 32);
		panel_btnDelivery.add(iconJLabel_1_1);

		panel_btnLogout.setLayout(null);
		panel_btnLogout.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_btnLogout.setBackground(new Color(255, 215, 0));
		panel_btnLogout.setBounds(0, 671, 200, 70);

	}

	private ImageIcon setIconScale(String path) {
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(path).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
		return imageIcon;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public JLabel getLabel() {
		return lblStaff;
	}

	public JPanel getPanel_btnStaff() {
		return panel_btnStaff;
	}

	public JPanel getPanel_btnOrder() {
		return panel_btnOrder;
	}

	public JPanel getPanel_btnDelivery() {
		return panel_btnDelivery;
	}

	public JPanel getPanel_list() {
		return panel_list;
	}

	public JPanel getPanel_inputForm() {
		return panel_inputForm;
	}
	
	public JPanel getPanel_btnLogout() {
		return panel_btnLogout;
	}
	public JPanel getPanel_navigation() {
		return panel_navigation;
	}
	public JPanel getPanel_btnSetPrice() {
		return panel_btnSetPrice;
	}
	public JPanel getPanel_btn_approve() {
		return panel_btn_approve;
	}
	public JLabel getIconManageStaff() {
		return iconJLabel;
	}
	public JLabel getIconSetPrice() {
		return iconSetPrice;
	}
	public JLabel getIconManageOrder() {
		return iconJLabel_1;
	}
	public JLabel getIconManageDeli() {
		return iconJLabel_1_1;
	}
	public JLabel getIconApprove() {
		return iconSetPrice_1;
	}
}
