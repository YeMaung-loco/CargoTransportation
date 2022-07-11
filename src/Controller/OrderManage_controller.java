package Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

import View.Office_view;
import View.Order_Panel;

public class OrderManage_controller implements MouseListener {
	Office_view office_view;
	JFrame containerFrame;
	Order_Panel order_Panel;
	JTable tblorder;
	 JTextField txtc_name, txtc_phone, txtc_address, txt_weight;

	public OrderManage_controller(JFrame frame) {
		containerFrame = frame;
		dependencyInjection();
		initForm();
		initComponents();
		initController();
	}

	public void dependencyInjection() {

	}

	public void initForm() {
		System.out.println("Order_Controller initform");
		office_view = new Office_view(containerFrame);
		order_Panel = new Order_Panel(containerFrame);
		
		office_view.getPanel_btnOrder().setBackground(new Color(218, 165, 32));

	}

	public void initComponents() {
		txtc_name=order_Panel.getTxtc_name();
		txtc_phone=order_Panel.getTxtc_phone();
		txtc_address=order_Panel.getTxtc_address();
		txt_weight=order_Panel.getTxt_weight();
		
		tblorder=order_Panel.getTable();

	}

	public void initController() {

		office_view.getPanel_btnStaff().addMouseListener(this);
		office_view.getPanel_btnOrder().addMouseListener(this);
		office_view.getPanel_btnDelivery().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(office_view.getPanel_btnStaff())) {
			System.out.println("order manage btnstaff");

			containerFrame.remove(order_Panel.getPanel_customer());
			containerFrame.remove(order_Panel.getPanel_order());
			containerFrame.remove(order_Panel.getPanel_orderList());
			containerFrame.remove(office_view.getPanel_navigation());
			CreateAccount_controller account_controller = new CreateAccount_controller(containerFrame);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
