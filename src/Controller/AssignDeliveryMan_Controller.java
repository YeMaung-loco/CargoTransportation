package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Staff;
import Service.Order_service;
import Service.Orderstaff_service;
import Service.Staff_Service;
import TableModel.TableModel_Delivery;
import View.Deliveryman_View;
import share.Temp;

public class AssignDeliveryMan_Controller implements ActionListener, ListSelectionListener, MouseListener {
	Deliveryman_View deliManView;
	JTable tblDelivery;
	JButton btn_Confirm;

	Staff_Service staff_Service;
	Orderstaff_service orderstaff_service;
	Order_service order_service;

	TableModel_Delivery model_Delivery;
	int temp_id;
	List<String> assignList = new ArrayList<>();

	public AssignDeliveryMan_Controller(List<String> assignList) {
		this.assignList = assignList;
		dependencyInjection();
		initForm();
		initComponents();
		initController();
		showList();
	}

	private void showList() {
		List<Staff> deliList = new ArrayList<Staff>();
		deliList = staff_Service.getActiveStaff(5, true);
		model_Delivery = new TableModel_Delivery(deliList);
		tblDelivery.setModel(model_Delivery);
		// sorter = new TableRowSorter<TableModel_Staff>(model_Staff);

	}

	private void initController() {
		btn_Confirm.addActionListener(this);
		tblDelivery.addMouseListener(this);
		tblDelivery.getSelectionModel().addListSelectionListener(this);
		

	}

	private void initComponents() {
		tblDelivery = deliManView.gettblDelivery();
		btn_Confirm = deliManView.getbtnconfirm();
		

	}

	private void initForm() {
		deliManView = new Deliveryman_View();

	}

	private void dependencyInjection() {
		try {
			staff_Service = new Staff_Service();
			orderstaff_service = new Orderstaff_service();
			order_service = new Order_service();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_Confirm)) {
			OrderAssign();
		}

	}

	private void OrderAssign() {
		boolean status = orderstaff_service.createOrder_staff(assignList, temp_id);
		if (status) {
			for (String order_no : assignList) {
				order_service.assignOrder(order_no, status, "Delivering");
			}

			staff_Service.assignDelivery(temp_id, false);
			Temp.setAssign(true);

			alert("Order is assigned Successfully");
			deliManView.getFrame().dispose();
			DeliveryManage_Controller.showOrderList();

		} else {

			Temp.setAssign(false);
			System.out.println("Assign failed");
		}
	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(deliManView.getFrame(), msg);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!tblDelivery.getSelectionModel().isSelectionEmpty()) {
			temp_id = model_Delivery.getStaff_Id(tblDelivery.convertRowIndexToModel(tblDelivery.getSelectedRow()));
			System.out.println("Temp_Id" + temp_id);
		} else {
			System.out.println("Empty");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
