package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Model.Order;
import Service.Customer_service;
import Service.DestinationPrice_service;
import Service.Order_service;
import Service.Package_service;
import Service.WeightPrice_service;
import TableModel.TableModel_Order;
import TableModel.TableModel_Staff;
import TableModel.TableModel_completeOrder;
import TableModel.TableModel_failOrder;
import TableModel.TableModel_pendingOrder;
import TableModel.TableModel_requestingOrder;
import Utility.JTableButtonRenderer;
import View.Complete_panel;
import View.Failed_panel;
import View.Pending_panel;
import View.Requesting_panel;
import View.TabbedPane_View;

public class Payment_controller
		implements MouseListener, ActionListener, CaretListener, ItemListener, ListSelectionListener {
	private DestinationPrice_service destination_service;
	private Order_service order_service;
	private WeightPrice_service weight_service;
	private Package_service package_service;
	private Customer_service customer_service;
	private TabbedPane_View tabPane;
	private Pending_panel pendingPanel;
	private Requesting_panel requestingPanel;
	private Complete_panel completePanel;
	private Failed_panel failPanel;
	private JTable tblPending,tblRequesting,tblComplete,tblFail;
	private JLabel lblPending, lblPendingsearch,lblRequesting,lblRequestingsearch,lblComplete,lblCompletesearch,lblFail,lblFailsearch;
	private JTextField txt_pendingSearch,txt_requestingSearch,txt_completeSearch,txt_failSearch;
	private TableModel_pendingOrder model_pendingOrder;
	private TableModel_requestingOrder model_requestingOrder;
	private TableModel_completeOrder model_completeOrder;
	private TableModel_failOrder model_failOrder;
	private JFrame frame;
	private TableRowSorter<TableModel_pendingOrder> sorter;
	private JButton btn_viewdetail,btn_approve;
	

	public Payment_controller() {
		// this.frame=frame;
		dependencyInjection();

		initForm();
		initComponents();
		initController();
		
		pendingShowList();
		requestingShowList();
		completeShowList();
		failShowList();
	}

	public void dependencyInjection() {
		try {
			destination_service = new DestinationPrice_service();
			order_service = new Order_service();
			weight_service = new WeightPrice_service();
			package_service = new Package_service();
			customer_service = new Customer_service();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void initForm() {
		tabPane = new TabbedPane_View();
		pendingPanel = new Pending_panel();
		requestingPanel = new Requesting_panel();
		completePanel = new Complete_panel();
		failPanel = new Failed_panel();

		tabPane.getTabbedPane().addTab("Pending Order", pendingPanel);
		tabPane.getTabbedPane().addTab("Requesting Order", requestingPanel);
		tabPane.getTabbedPane().addTab("Complete Order", completePanel);
		tabPane.getTabbedPane().addTab("Fail Order", failPanel);
		// tabPane.addTab("Pending Order",pendingPanel);

	}

	private void initComponents() {
		txt_pendingSearch = pendingPanel.getTextField();
		tblPending = pendingPanel.getTblrequest();
		lblPending = pendingPanel.getLblNewLabel();
		lblPendingsearch = pendingPanel.getLblNewLabel_1();
		
		txt_requestingSearch=requestingPanel.getTextField();
		tblRequesting=requestingPanel.getTblrequesting();
		lblRequesting=requestingPanel.getLblNewLabel();
		lblRequesting=requestingPanel.getLblNewLabel_1();
		
		txt_completeSearch = completePanel.getSearch();
		tblComplete = completePanel.getTblcomplete();
		lblComplete = completePanel.getLbl_completeOrder();
		lblCompletesearch = completePanel.getLblNewLabel_1();
		
		txt_failSearch = failPanel.getTxtSearch();
		tblFail = failPanel.getTblfail();
		lblFail = failPanel.getLblNewLabel();
		lblFailsearch = failPanel.getLblNewLabel_1();

	}

	private void initController() {
		tblPending.addMouseListener(this);
		tblPending.getSelectionModel().addListSelectionListener(this);

		txt_pendingSearch.addCaretListener(this);
	}

	private void pendingShowList() {
		List<Order> orderList = new ArrayList<Order>();
		orderList = order_service.getAllOrderlist();
		btn_viewdetail=new JButton("View");
		model_pendingOrder = new TableModel_pendingOrder(orderList,btn_viewdetail);

		tblPending.setModel(model_pendingOrder);
		
		TableCellRenderer tableRenderer = tblPending.getDefaultRenderer(JButton.class);
		tblPending.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
		
		
		

		sorter = new TableRowSorter<TableModel_pendingOrder>(model_pendingOrder);
	}
	private void requestingShowList() {
		List<Order> orderList = new ArrayList<Order>();
		orderList = order_service.getAllOrderlist();
		btn_viewdetail=new JButton("View");
		btn_approve=new JButton("Approve");
		model_requestingOrder = new TableModel_requestingOrder(orderList,btn_viewdetail,btn_approve);

		tblRequesting.setModel(model_requestingOrder);
		
		TableCellRenderer tableRenderer = tblRequesting.getDefaultRenderer(JButton.class);
		tblRequesting.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
	}
	private void completeShowList() {
		List<Order> orderList = new ArrayList<Order>();
		orderList = order_service.getAllOrderlist();
		btn_viewdetail=new JButton("View");
		model_completeOrder = new TableModel_completeOrder(orderList,btn_viewdetail);

		tblComplete.setModel(model_completeOrder);
		
		TableCellRenderer tableRenderer = tblComplete.getDefaultRenderer(JButton.class);
		tblComplete.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
	}
	private void failShowList() {
		List<Order> orderList = new ArrayList<Order>();
		orderList = order_service.getAllOrderlist();
		btn_viewdetail=new JButton("View");
		model_failOrder = new TableModel_failOrder(orderList,btn_viewdetail);

		tblFail.setModel(model_failOrder);
		
		TableCellRenderer tableRenderer = tblFail.getDefaultRenderer(JButton.class);
		tblFail.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

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

	}

}



