package Controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import org.apache.tools.ant.types.selectors.modifiedselector.Algorithm;

import Model.CurrentUserHolder;
import Model.Destination;
import Model.Order;
import Service.DestinationPrice_service;
import Service.Order_service;
import TableModel.TableModel_OrderAssign;
import View.Delivery_View;
import View.Office_view;

public class DeliveryManage_Controller
		implements ActionListener, MouseListener, ListSelectionListener, ItemListener, CaretListener {
	JFrame frame;
	List<Destination> destinationList;
	Delivery_View deliveryManage_panel;
	Office_view navigation_panel;
	DestinationPrice_service destination_service;
	static Order_service order_service;
	static TableModel_OrderAssign model_OrderAssign;
	static JTable tblorder;
	JPanel panel_btnAccount, panel_btnOrderInput, panel_btnSetprice, panel_btnDelivery, panel_btnApprove;
	JPanel panel_delivery;
	// JLabel deselectLable;
	JButton btnDeselect;
	JPanel panel_deselect;
	static TableRowSorter<TableModel_OrderAssign> Ordersorter;
	JTextField txt_search;
	String order_no;
	List<String> assignList = new ArrayList<>();
	List<Integer> assignModelList = new ArrayList<>();
	JComboBox<String> combodestination;

	public DeliveryManage_Controller(JFrame frame) {
		this.frame = frame;

		dependencyInjection();
		initForm();
		initComponents();
		initController();
		loadAlldata();
		loadData();
		showOrderList();
	}

	public static void showOrderList() {
		List<Order> orderList = new ArrayList<Order>();
		orderList = order_service.getOrderbyAssign(false);
		JButton btn_viewDetail = new JButton("View");
		// JCheckBox chkBox=new JCheckBox();
		model_OrderAssign = new TableModel_OrderAssign(orderList, btn_viewDetail);

		tblorder.setModel(model_OrderAssign);

		TableCellRenderer tableRenderer = tblorder.getDefaultRenderer(JButton.class);
		tblorder.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));

		Ordersorter = new TableRowSorter<TableModel_OrderAssign>(model_OrderAssign);
	}

	private void initController() {

		if (CurrentUserHolder.getCurrentUser().getRole().getRole_name().equals("Admin")) {
			// navigation_panel.getPanel_btnStaff().addMouseListener(this);
			// navigation_panel.getPanel_btnSetPrice().addMouseListener(this);
			panel_btnAccount.addMouseListener(this);
			panel_btnSetprice.addMouseListener(this);
		}

		deliveryManage_panel.getBtnSelectdelivery().addActionListener(this);

		navigation_panel.getPanel_btnLogout().addMouseListener(this);
		panel_btnOrderInput.addMouseListener(this);
		panel_btnApprove.addMouseListener(this);
		panel_deselect.addMouseListener(this);

		btnDeselect.addActionListener(this);

		tblorder.addMouseListener(this);
		tblorder.getSelectionModel().addListSelectionListener(this);
		combodestination.addItemListener(this);
		txt_search.addCaretListener(this);
	}

	private void initComponents() {
		panel_delivery = deliveryManage_panel.getPanel();

		panel_btnAccount = navigation_panel.getPanel_btnStaff();
		panel_btnOrderInput = navigation_panel.getPanel_btnOrder();
		panel_btnDelivery = navigation_panel.getPanel_btnDelivery();
		panel_btnSetprice = navigation_panel.getPanel_btnSetPrice();
		panel_btnApprove = navigation_panel.getPanel_btn_approve();

		panel_deselect = deliveryManage_panel.getPanel_Deselect();
		combodestination = deliveryManage_panel.getCombo();
		btnDeselect = deliveryManage_panel.getBtnDeselect();
		txt_search = deliveryManage_panel.getTxtOrderid();

		tblorder = deliveryManage_panel.getTblorder();

	}

	private void initForm() {
		navigation_panel = new Office_view(frame);
		deliveryManage_panel = new Delivery_View(frame);

		navigation_panel.getPanel_btnDelivery().setBackground(new Color(218, 165, 32));

		if (CurrentUserHolder.getCurrentUser().getRole().getRole_name().equals("Office Staff")) {
			// office_view.getPanel_btnSetPrice().setVisible(false);
//			ImageIcon disableIcon = new ImageIcon(
//					new ImageIcon("resource\\disable.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));

			JLabel iconManageStaff = navigation_panel.getIconManageStaff();
			JLabel iconSetPrice = navigation_panel.getIconSetPrice();

			ImageIcon disableIcon = new ImageIcon(new ImageIcon("resource\\disable.png").getImage()
					.getScaledInstance(iconManageStaff.getWidth(), iconManageStaff.getHeight(), Image.SCALE_SMOOTH));

			iconSetPrice.setIcon(disableIcon);
			iconManageStaff.setIcon(disableIcon);

		}

	}

	private void dependencyInjection() {
		try {
			order_service = new Order_service();
			destination_service = new DestinationPrice_service();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadAlldata() {
		destinationList = destination_service.getAlldestinationPrice();
	}

	private void loadData() {
		combodestination.addItem("-Select-");

		for (Destination d : destinationList) {
			combodestination.addItem(d.getDestinationName());

		}
	}

	private void collectAssign() {

		for (int i = 0; i < tblorder.getModel().getRowCount(); i++) {
			if ((Boolean) tblorder.getModel().getValueAt(i, 0)) {
				assignList.add((String) tblorder.getModel().getValueAt(i, 2));
				assignModelList.add((Integer) tblorder.getValueAt(i, 1)-1);
			}
		}
	}
	private void alert(String msg) {
		JOptionPane.showMessageDialog(navigation_panel.getFrame(), msg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(deliveryManage_panel.getBtnSelectdelivery())) {
			assignList.clear();
			collectAssign();
			if(assignList.size()>0) {
			AssignDeliveryMan_Controller assignController = new AssignDeliveryMan_Controller(assignList);

			}
			else {
				alert("Select order to assign!!");
			}
		}
		if (e.getSource().equals(btnDeselect)) {
		//	deselectOrder();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource().equals(panel_deselect)) {
		//	deselectOrder();
		}
		if (e.getSource().equals(panel_btnAccount)) {
			frame.remove(panel_delivery);
			frame.remove(navigation_panel.getPanel_navigation());

			CreateAccount_controller account_controller = new CreateAccount_controller(frame);

		}
		if (e.getSource().equals(panel_btnOrderInput)) {
			frame.remove(panel_delivery);
			frame.remove(navigation_panel.getPanel_navigation());
			OrderManage_controller order_controller = new OrderManage_controller(frame);

		}
		if (e.getSource().equals(panel_btnSetprice)) {
			frame.remove(panel_delivery);
			frame.remove(navigation_panel.getPanel_navigation());
			SetPrice_controller price_controller = new SetPrice_controller(frame);

		}
		if (e.getSource().equals(panel_btnApprove)) {
			frame.remove(panel_delivery);
			frame.remove(navigation_panel.getPanel_navigation());
			Payment_controller payment_controlle = new Payment_controller(frame);
		}

		if (e.getSource().equals(navigation_panel.getPanel_btnLogout())) {
			frame.dispose();
			Login_controller nextController = new Login_controller();
		}

		if (e.getSource().equals(tblorder)) {
			if (tblorder.getSelectedColumn() == 8) {
				frame.remove(deliveryManage_panel.getPanel());
				frame.remove(navigation_panel.getPanel_navigation());
				// OrderManage_controller orderManage_controller = null;
				Orderdetail_controller orderdetail_controller = new Orderdetail_controller(this, null, null, order_no,
						frame);

			}

			if (e.getClickCount() == 2) {
				if (tblorder.getSelectedColumn() == 0) {
					model_OrderAssign.setValueAt(tblorder.convertRowIndexToModel(tblorder.getSelectedRow()),
							tblorder.getSelectedColumn());

				}

			}
		}

	}

//	private void deselectOrder() {
//		collectAssign();
//		System.out.println("Deselect click");
//		TableModel_OrderAssign model = (TableModel_OrderAssign) tblorder.getModel();
//		model.clearChecks(assignModelList);
//
//	}

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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!tblorder.getSelectionModel().isSelectionEmpty()) {
			order_no = model_OrderAssign.getOrder_no(tblorder.convertRowIndexToModel(tblorder.getSelectedRow()));

		}

	}

	@Override
	public void caretUpdate(CaretEvent e) {
		if (e.getSource().equals(txt_search)) {
			try {
				java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
				filters.add(RowFilter.regexFilter("(?i)" + txt_search.getText(), 2));
				// System.out.println(combodestination.getSelectedItem().toString());
				RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
				Ordersorter.setRowFilter(serviceFilter);
				tblorder.setRowSorter(Ordersorter);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}

		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(combodestination)) {
			System.out.println("combodestination");
			if (0 != combodestination.getSelectedIndex())
				try {
					System.out.println("0!");
					java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
					filters.add(RowFilter.regexFilter(combodestination.getSelectedItem().toString(), 5));
					System.out.println(combodestination.getSelectedItem().toString());
					RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
					System.out.println(serviceFilter);
					Ordersorter.setRowFilter(serviceFilter);
					tblorder.setRowSorter(Ordersorter);
				} catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
			else {
				tblorder.setRowSorter(null);
			}
		}

	}

}
