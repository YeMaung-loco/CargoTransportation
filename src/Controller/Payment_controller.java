package Controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import Model.CurrentUserHolder;
import Model.Order;
import Service.Customer_service;
import Service.Order_service;
import Service.Orderstaff_service;
import Service.Package_service;
import TableModel.TableModel_completeOrder;
import TableModel.TableModel_failOrder;
import TableModel.TableModel_pendingOrder;
import TableModel.TableModel_requestingOrder;
import Utility.ExportDataToExcel;
import Utility.JTableButtonRenderer;
import View.Complete_panel;
import View.Failed_panel;
import View.Office_view;
import View.Pending_panel;
import View.Requesting_panel;
import View.TabbedPane_View;
import share.Temp;

public class Payment_controller
		implements ChangeListener, MouseListener, ActionListener, CaretListener, ListSelectionListener {
//	private DestinationPrice_service destination_service;
	private Order_service order_service;
//	private WeightPrice_service weight_service;
	private Package_service package_service;
	Orderstaff_service orderstaff_service;
	private Customer_service customer_service;
	private TabbedPane_View tabPane;
	private Pending_panel pendingPanel;
	private Requesting_panel requestingPanel;
	private Complete_panel completePanel;
	private Failed_panel failPanel;
	private JTable tblPending, tblRequesting, tblComplete, tblFail;
	JTabbedPane tabbedPane, temp_pane;
//	private JLabel lblPending, lblPendingsearch, lblRequesting, lblRequestingsearch, lblComplete, lblCompletesearch,
//			lblFail, lblFailsearch;
	private JTextField txt_pendingSearch, txt_requestingSearch, txt_completeSearch, txt_failSearch;
	private TableModel_pendingOrder model_pendingOrder;
	private TableModel_requestingOrder model_requestingOrder;
	private TableModel_completeOrder model_completeOrder;
	private TableModel_failOrder model_failOrder;
	private JFrame frame;
	private TableRowSorter<TableModel_pendingOrder> sorter;
	private JButton btn_viewdetail, btn_approve, btn_complete_export;

	List<Order> pendingList, requestingList, completeList, failList;
	String order_no;

	Office_view navigationPanel;

	public Payment_controller() {
		// TODO Auto-generated constructor stub
	}

	public Payment_controller(JFrame frame) {
		this.frame = frame;
		dependencyInjection();

		initForm();
		initComponents();
		initController();

		pendingShowList();
		requestingShowList();
		completeShowList();
		failShowList();

		tabbedPane.setSelectedIndex(Temp.getLastTabPane());

	}

	public void dependencyInjection() {
		try {
			order_service = new Order_service();
			package_service = new Package_service();
			orderstaff_service = new Orderstaff_service();
			customer_service = new Customer_service();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void initForm() {
		tabPane = new TabbedPane_View(frame);
		navigationPanel = new Office_view(frame);

		pendingPanel = new Pending_panel();
		requestingPanel = new Requesting_panel();
		completePanel = new Complete_panel();
		failPanel = new Failed_panel();

		tabPane.getTabbedPane().addTab("Pending Order", pendingPanel);
		tabPane.getTabbedPane().addTab("Requesting Order", requestingPanel);
		tabPane.getTabbedPane().addTab("Complete Order", completePanel);
		tabPane.getTabbedPane().addTab("Fail Order", failPanel);

		navigationPanel.getPanel_btn_approve().setBackground(new Color(218, 165, 32));

		if (CurrentUserHolder.getCurrentUser().getRole().getRole_name().equals("Office Staff")) {
			// office_view.getPanel_btnSetPrice().setVisible(false);
			ImageIcon disableIcon = new ImageIcon(
					new ImageIcon("resource\\disable.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));

			JLabel iconManageStaff = navigationPanel.getIconManageStaff();
			JLabel iconSetPrice = navigationPanel.getIconSetPrice();

			iconSetPrice.setIcon(disableIcon);
			iconManageStaff.setIcon(disableIcon);

		}

	}

	private void initComponents() {

		tabbedPane = tabPane.getTabbedPane();
		txt_pendingSearch = pendingPanel.getTextField();
		tblPending = pendingPanel.getTblrequest();

		txt_requestingSearch = requestingPanel.getTextField();
		tblRequesting = requestingPanel.getTblrequesting();

		txt_completeSearch = completePanel.getSearch();
		tblComplete = completePanel.getTblcomplete();

		txt_failSearch = failPanel.getTxtSearch();
		tblFail = failPanel.getTblfail();

		btn_complete_export = completePanel.getbtnExport();

	}

	private void initController() {
		tabbedPane.addChangeListener(this);
		btn_complete_export.addActionListener(this);

		if (CurrentUserHolder.getCurrentUser().getRole().getRole_name().equals("Admin")) {
			navigationPanel.getPanel_btnSetPrice().addMouseListener(this);
			navigationPanel.getPanel_btnStaff().addMouseListener(this);
		}

		navigationPanel.getPanel_btnDelivery().addMouseListener(this);
		navigationPanel.getPanel_btnOrder().addMouseListener(this);
		navigationPanel.getPanel_btnLogout().addMouseListener(this);

		tblPending.addMouseListener(this);
		tblPending.getSelectionModel().addListSelectionListener(this);

		tblRequesting.getSelectionModel().addListSelectionListener(this);
		tblRequesting.addMouseListener(this);

		txt_pendingSearch.addCaretListener(this);
		txt_failSearch.addCaretListener(this);
		txt_completeSearch.addCaretListener(this);
		txt_requestingSearch.addCaretListener(this);
	}

	private void pendingShowList() {
		pendingList = new ArrayList<Order>();
		pendingList = order_service.getOrderbyAssign(true);
		btn_viewdetail = new JButton("View");
		model_pendingOrder = new TableModel_pendingOrder(pendingList, btn_viewdetail);

		tblPending.setModel(model_pendingOrder);

		TableCellRenderer tableRenderer = tblPending.getDefaultRenderer(JButton.class);
		tblPending.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));

		sorter = new TableRowSorter<TableModel_pendingOrder>(model_pendingOrder);
	}

	private void requestingShowList() {
		requestingList = new ArrayList<Order>();
		requestingList = order_service.getOrderByStatus("Delivering");
		btn_viewdetail = new JButton("View");
		btn_approve = new JButton("Approve");
		model_requestingOrder = new TableModel_requestingOrder(requestingList, btn_viewdetail, btn_approve);

		tblRequesting.setModel(model_requestingOrder);

		TableCellRenderer tableRenderer = tblRequesting.getDefaultRenderer(JButton.class);
		tblRequesting.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
	}

	private void completeShowList() {
		completeList = new ArrayList<Order>();
		completeList = order_service.getOrderByStatus("Completed");
		btn_viewdetail = new JButton("View");
		model_completeOrder = new TableModel_completeOrder(completeList, btn_viewdetail);

		tblComplete.setModel(model_completeOrder);

		TableCellRenderer tableRenderer = tblComplete.getDefaultRenderer(JButton.class);
		tblComplete.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
	}

	private void failShowList() {
		failList = new ArrayList<Order>();
		failList = order_service.getAllOrderlist();
		btn_viewdetail = new JButton("View");
		model_failOrder = new TableModel_failOrder(failList, btn_viewdetail);

		tblFail.setModel(model_failOrder);

		TableCellRenderer tableRenderer = tblFail.getDefaultRenderer(JButton.class);
		tblFail.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
	}

	private void exportExcel() {
		try {
			ExportDataToExcel.writeToExcell(tblComplete, "");
			int packageDelete = 0;
			int orderStaffDelete = 0;
			int orderDelete = 0;
			int customerDelete = 0;
			for (Order completeOrder : completeList) {
				String deleteOrderNo = completeOrder.getOrder_no();
				int deleteCustomerId = completeOrder.getCustomer().getId();
				System.out.println("Delete order_no" + deleteOrderNo);
				System.out.println("Delete customer_id" + deleteCustomerId);

				packageDelete = package_service.deletePackageByOrderNo(completeOrder.getOrder_no());
				orderStaffDelete = orderstaff_service.deleteAssignByOrderNo(completeOrder.getOrder_no());
				orderDelete = order_service.deleteOrder(completeOrder.getOrder_no());
				customerDelete = customer_service.deleteCustomer(completeOrder.getCustomer().getId());

				if (packageDelete > 0)
					System.out.println("Package delete success");
				if(orderStaffDelete>0)
					System.out.println("OrderStaff delete success");
				if (orderDelete > 0)
					System.out.println("Order delete success");
				if (customerDelete > 0)
					System.out.println("customer delete success");
				
			}

			if (packageDelete > 0 && orderDelete > 0 && customerDelete > 0 && orderStaffDelete > 0)
				model_completeOrder.removeAllRow();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_complete_export)) {
			exportExcel();

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(navigationPanel.getPanel_btnStaff())) {
			frame.remove(navigationPanel.getPanel_navigation());
			frame.remove(tabbedPane);
			CreateAccount_controller nextController = new CreateAccount_controller(frame);

		}
		if (e.getSource().equals(navigationPanel.getPanel_btnDelivery())) {
			frame.remove(navigationPanel.getPanel_navigation());
			frame.remove(tabbedPane);
			DeliveryManage_Controller nextController = new DeliveryManage_Controller(frame);
		}
		if (e.getSource().equals(navigationPanel.getPanel_btnOrder())) {
			frame.remove(navigationPanel.getPanel_navigation());
			frame.remove(tabbedPane);
			OrderManage_controller nextController = new OrderManage_controller(frame);
		}
		if (e.getSource().equals(navigationPanel.getPanel_btnSetPrice())) {
			frame.remove(navigationPanel.getPanel_navigation());
			frame.remove(tabbedPane);
			SetPrice_controller nexController = new SetPrice_controller(frame);
		}

		if (e.getSource().equals(navigationPanel.getPanel_btnLogout())) {
			frame.dispose();
			Login_controller nextController = new Login_controller();
		}

		if (e.getSource().equals(tblRequesting)) {
			if (tblRequesting.getSelectedColumn() == 8) {
				frame.remove(navigationPanel.getPanel_navigation());
				frame.remove(tabbedPane);
				Orderdetail_controller orderdetail_controller = new Orderdetail_controller(null, null, this, order_no,
						frame);

			}
			if (tblRequesting.getSelectedColumn() == 7) {

				System.out.println("Approve button");
				int status = order_service.assignOrder(order_no, true, "Completed");
				if (status > 0)
					model_requestingOrder.removeRow(tblRequesting.getSelectedRow());
			}
		}

		if (e.getSource().equals(tblPending)) {
			if (tblPending.getSelectedColumn() == 7) {

				frame.remove(navigationPanel.getPanel_navigation());
				frame.remove(tabbedPane);
				Orderdetail_controller nextController = new Orderdetail_controller(null, null, this, order_no, frame);

			}
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

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (!tblRequesting.getSelectionModel().isSelectionEmpty()) {
			order_no = model_requestingOrder
					.getOrder_no(tblRequesting.convertRowIndexToModel(tblRequesting.getSelectedRow()));
			System.out.println("Request Table -" + order_no);

		}

		if (!tblPending.getSelectionModel().isSelectionEmpty()) {
			order_no = model_pendingOrder.getOrder_no(tblPending.convertRowIndexToModel(tblPending.getSelectedRow()));
			System.out.println("Request Table -" + order_no);

		}

	}

	@Override
	public void caretUpdate(CaretEvent e) {

		if (e.getSource().equals(txt_pendingSearch)) {
			try {
				java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
				filters.add(RowFilter.regexFilter("(?i)" + txt_pendingSearch.getText(), 1));
				RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
				sorter.setRowFilter(serviceFilter);
				tblPending.setRowSorter(sorter);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}

		}
		if (e.getSource().equals(txt_requestingSearch)) {
			try {
				java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
				filters.add(RowFilter.regexFilter("(?i)" + txt_requestingSearch.getText(), 1));
				RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
				sorter.setRowFilter(serviceFilter);
				tblRequesting.setRowSorter(sorter);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}

		}
		if (e.getSource().equals(txt_completeSearch)) {
			try {
				java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
				filters.add(RowFilter.regexFilter("(?i)" + txt_completeSearch.getText(), 1));
				RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
				sorter.setRowFilter(serviceFilter);
				tblComplete.setRowSorter(sorter);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}

		}
		if (e.getSource().equals(txt_failSearch)) {
			try {
				java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
				filters.add(RowFilter.regexFilter("(?i)" + txt_failSearch.getText(), 1));
				RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
				sorter.setRowFilter(serviceFilter);
				tblFail.setRowSorter(sorter);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}

		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof JTabbedPane) {

			JTabbedPane temp_pane = (JTabbedPane) e.getSource();
			Temp.setLastTabPane(temp_pane.getSelectedIndex());

			System.out.println("Selected paneNo : " + temp_pane.getSelectedIndex());
			System.out.println("Selected paneNo : " + temp_pane.getSelectedIndex());
			if (temp_pane.getSelectedIndex() == 0) {
				pendingShowList();
			}
			if (temp_pane.getSelectedIndex() == 1) {

				requestingShowList();
			}
			if (temp_pane.getSelectedIndex() == 2) {

				completeShowList();
			}
			if (temp_pane.getSelectedIndex() == 3) {
				failShowList();
			}
		}
	}
	/*
	 * @Override public void caretUpdate(CaretEvent e) { if
	 * (e.getSource().equals(txt_pendingsearch)) { try {
	 * java.util.List<RowFilter<Object, Object>> filters = new
	 * ArrayList<RowFilter<Object, Object>>(1);
	 * filters.add(RowFilter.regexFilter("(?i)" + txt_search.getText(), 1));
	 * System.out.println(searchComboDestination.getSelectedItem().toString());
	 * RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
	 * sorter.setRowFilter(serviceFilter); tblorder.setRowSorter(sorter); } catch
	 * (Exception exception) { System.out.println(exception.getMessage()); }
	 * 
	 * }
	 * 
	 * }
	 */

}
