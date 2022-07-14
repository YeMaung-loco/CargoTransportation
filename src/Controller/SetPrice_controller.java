package Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

import Model.Destination;
import Model.Order;
import Model.Weight;
import Service.DestinationPrice_service;
import Service.WeightPrice_service;
import TableModel.TableModel_Destination;
import TableModel.TableModel_Order;
import TableModel.TableModel_Weight;
import View.Office_view;
import View.SetPrice_Panel;

public class SetPrice_controller implements MouseListener {
	WeightPrice_service weight_service;
	DestinationPrice_service destination_service;

	Weight weight;
	Destination destination;
	List<Destination> destinationList;
	List<Weight> weightList;
	TableModel_Weight model_Weight;
	TableModel_Destination model_Destination;

	JFrame frame;
	JTable tbldestination, tblweight;
	private JComboBox<String> cbox_destination;
	JTextField txt_weightprice, txt_startweight_1, txt_destinationprice;
	JButton btn_destinationdelete, btn_destinationedit, btn_weightdelete, btn_weightedit, btn_weightpricesave,
			btn_destinationsave;
	Office_view navigationPanel;
	SetPrice_Panel setPrice_Panel;

	public SetPrice_controller(JFrame container) {
		this.frame = container;
		dependencyInjection();
		initForm();
		initComponents();
		initController();

		showList();
		
		loadPrice();
	}

	private void showList() {
		List<Weight> weightList = new ArrayList<Weight>();
		List<Destination> destinationList = new ArrayList<>();

		weightList = weight_service.getAllweightPrice();
		model_Weight = new TableModel_Weight(weightList);

		destinationList = destination_service.getAlldestinationPrice();
		model_Destination = new TableModel_Destination(destinationList);

		tbldestination.setModel(model_Destination);
		tblweight.setModel(model_Weight);
		//sorter = new TableRowSorter<TableModel_Order>(model_Order);
	}

	private void loadPrice() {
		destinationList = destination_service.getAlldestinationPrice();
		weightList = weight_service.getAllweightPrice();

		cbox_destination.addItem("- Select -");
		for (Destination destination : destinationList) {
			cbox_destination.addItem(destination.getDestinationName());
		}

	}

	private void initController() {

		txt_weightprice = setPrice_Panel.getTxt_weightprice();
		txt_destinationprice = setPrice_Panel.getTxt_DestinationPrice();

		cbox_destination = setPrice_Panel.getCbox_destination();
		
		tbldestination=setPrice_Panel.getTblDestination();
		tblweight=setPrice_Panel.getTblWeight();

		btn_destinationsave = setPrice_Panel.getBtn_destinationsave();
		btn_weightpricesave = setPrice_Panel.getBtn_weightpricesave();
		btn_destinationdelete = setPrice_Panel.getBtn_destinationdelete();
		btn_destinationedit = setPrice_Panel.getBtn_destinationedit();
		btn_weightdelete = setPrice_Panel.getBtn_weightdelete();
		btn_weightedit = setPrice_Panel.getBtn_weightedit();

	}

	void setModel() {
		weight = new Weight();
		destination = new Destination();

		int destinationPrice = Integer.parseInt(txt_destinationprice.getText());
		int weightPrice = Integer.parseInt(txt_weightprice.getText());

		destination.setId(cbox_destination.getSelectedIndex());
		destination.setDestinationName(cbox_destination.getSelectedItem().toString());
		destination.setPrice(destinationPrice);

		weight.setWeightprice(weightPrice);

	}

	private void initComponents() {
		navigationPanel.getPanel_btnStaff().addMouseListener(this);
		navigationPanel.getPanel_btnOrder().addMouseListener(this);
		navigationPanel.getPanel_btnDelivery().addMouseListener(this);
		navigationPanel.getPanel_btnSetPrice().addMouseListener(this);

	}

	private void initForm() {
		System.out.println("SetController is here");
		navigationPanel = new Office_view(frame);
		setPrice_Panel = new SetPrice_Panel(frame);
		navigationPanel.getPanel_btnSetPrice().setBackground(new Color(218, 165, 32));

	}

	private void dependencyInjection() {
		try {
			destination_service = new DestinationPrice_service();
			weight_service = new WeightPrice_service();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(navigationPanel.getPanel_btnOrder())) {
			frame.remove(setPrice_Panel.getDestination_panel());
			frame.remove(setPrice_Panel.getWeight_panel());
			frame.remove(navigationPanel.getPanel_navigation());
			OrderManage_controller orderManage_controller = new OrderManage_controller(frame);
		}

		if (e.getSource().equals(navigationPanel.getPanel_btnStaff())) {
			System.out.println("order manage btnstaff");

			frame.remove(setPrice_Panel.getDestination_panel());
			frame.remove(setPrice_Panel.getWeight_panel());
			frame.remove(navigationPanel.getPanel_navigation());
			CreateAccount_controller account_controller = new CreateAccount_controller(frame);
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
