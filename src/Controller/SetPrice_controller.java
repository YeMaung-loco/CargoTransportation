package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Destination;
import Model.Staff;
import Model.Weight;
import Service.DestinationPrice_service;
import Service.WeightPrice_service;
import TableModel.TableModel_Destination;
import TableModel.TableModel_Weight;
import View.Office_view;
import View.SetPrice_Panel;

public class SetPrice_controller implements MouseListener, ActionListener, ListSelectionListener {
	WeightPrice_service weight_service;
	DestinationPrice_service destination_service;

	Weight weight;
	Destination destination;
	List<Destination> destinationList;
	List<Weight> weightList;
	TableModel_Weight model_Weight;
	TableModel_Destination model_Destination;
	int temp_destination_id;
	int temp_weight_id;

	JFrame frame;
	JTable tbldestination, tblweight;
	JTextField txt_weightprice, txt_startweight_1, txt_destinationprice, txt_destinationName;
	JButton btn_destinationdelete, btn_destinationedit, btn_weightdelete, btn_weightedit, btn_weightpricesave,
			btn_destinationsave, btn_destinationUpdate, btn_weightUpdate;
	Office_view navigationPanel;
	SetPrice_Panel setPrice_Panel;

	public SetPrice_controller(JFrame container) {
		this.frame = container;
		dependencyInjection();
		initForm();
		initComponents();
		initController();

		showList();
		// loadPrice();
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
		// sorter = new TableRowSorter<TableModel_Order>(model_Order);
	}

	private void initController() {

		navigationPanel.getPanel_btnStaff().addMouseListener(this);
		navigationPanel.getPanel_btnOrder().addMouseListener(this);
		navigationPanel.getPanel_btnDelivery().addMouseListener(this);
		navigationPanel.getPanel_btnSetPrice().addMouseListener(this);

		tbldestination.addMouseListener(this);
		tbldestination.getSelectionModel().addListSelectionListener(this);
		tblweight.addMouseListener(this);
		tblweight.getSelectionModel().addListSelectionListener(this);

		btn_weightdelete.addActionListener(this);
		btn_weightedit.addActionListener(this);
		btn_weightpricesave.addActionListener(this);
		btn_weightUpdate.addActionListener(this);

		btn_destinationdelete.addActionListener(this);
		btn_destinationedit.addActionListener(this);
		btn_destinationsave.addActionListener(this);
		btn_destinationUpdate.addActionListener(this);

	}

	private void initComponents() {
		txt_startweight_1 = setPrice_Panel.getTxt_startweight();
		txt_weightprice = setPrice_Panel.getTxt_weightprice();
		txt_destinationprice = setPrice_Panel.getTxt_DestinationPrice();
		txt_destinationName = setPrice_Panel.getTxt_DestinationName();

		tbldestination = setPrice_Panel.getTblDestination();
		tblweight = setPrice_Panel.getTblWeight();

		btn_destinationsave = setPrice_Panel.getBtn_destinationsave();
		btn_destinationdelete = setPrice_Panel.getBtn_destinationdelete();
		btn_destinationedit = setPrice_Panel.getBtn_destinationedit();
		btn_destinationUpdate = setPrice_Panel.getBtnDestinationUpdate();

		btn_weightpricesave = setPrice_Panel.getBtn_weightpricesave();
		btn_weightdelete = setPrice_Panel.getBtn_weightdelete();
		btn_weightedit = setPrice_Panel.getBtn_weightedit();
		btn_weightUpdate = setPrice_Panel.getBtnWeightUpdate();

	}

	private void initForm() {
		System.out.println("SetController is here");
		navigationPanel = new Office_view(frame);
		setPrice_Panel = new SetPrice_Panel(frame);
		navigationPanel.getPanel_btnSetPrice().setBackground(new Color(218, 165, 32));

	}

	void setDestinationModel() {
		destination = new Destination();
		String destinationName = txt_destinationName.getText();
		int price = Integer.parseInt(txt_destinationprice.getText());
		destination.setDestinationName(destinationName);
		destination.setPrice(price);
		// return false;

	}

	void setWeightModel() {
		weight = new Weight();
		int price = Integer.parseInt(txt_weightprice.getText());
		int kg = Integer.parseInt(txt_startweight_1.getText());
		weight.setId(weight_service.getLastWeightId() + 1);
		weight.setWeightprice(price);
		weight.setWeight_kg(kg);
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
		if (e.getSource().equals(tblweight)) {
			if (e.getClickCount() == 2) {
				editWeight();
			}
		}

		if (e.getSource().equals(tbldestination)) {
			if (e.getClickCount() == 2) {
				editDestination();
			}
		}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_destinationsave)) {
			saveDestination();
		}
		if (e.getSource().equals(btn_destinationedit)) {
			editDestination();
		}
		if (e.getSource().equals(btn_destinationdelete)) {
			deleteDestination();
		}

		if (e.getSource().equals(btn_destinationUpdate)) {
			updateDestination();
		}

		if (e.getSource().equals(btn_weightpricesave)) {
			saveWeight();
		}
		if (e.getSource().equals(btn_weightedit)) {
			editWeight();
		}
		if (e.getSource().equals(btn_weightdelete)) {
			deleteWeight();
		}
		if (e.getSource().equals(btn_weightUpdate)) {
			updateWeight();
		}
	}

	private void updateWeight() {
		btn_weightUpdate.setVisible(false);
		btn_weightpricesave.setVisible(true);

		setWeightModel();
		int status = weight_service.updateweightPrice(temp_weight_id, weight);
		if (status > 0) {
			alert("Successfully Updated!");
			int modelRowIndex = tblweight.convertRowIndexToModel(tblweight.getSelectedRow());
			model_Weight.setValueAt(weight, modelRowIndex);
		} else {
			alert("Failed update!");
		}
		weight = null;
		weightdataToView(weight);

	}

	private void updateDestination() {
		btn_destinationUpdate.setVisible(false);
		btn_destinationsave.setVisible(true);

		setDestinationModel();
		int status = destination_service.updatedestinationPrice(temp_destination_id, destination);
		if (status > 0) {
			alert("Successfully Updated!");
			int modelRowIndex = tbldestination.convertRowIndexToModel(tbldestination.getSelectedRow());
			model_Destination.setValueAt(destination, modelRowIndex);
		} else {
			alert("Failed update!");
		}
		destination = null;
		destinationdataToView(destination);

	}

	private void deleteWeight() {
		int modelRowIndex = tblweight.convertRowIndexToModel(tblweight.getSelectedRow());
		System.out.println("delete " + modelRowIndex);
		if (modelRowIndex != -1) {
			int status = weight_service.deleteweightPrice(temp_weight_id);
			if (status > 0) {
				model_Weight.removeRow(modelRowIndex);
				alert("Successfully Deleted!");
			} else
				alert("Delete Failed!");
		} else {
			alert("Select a row to Delete!!");
		}
	}

	private void editWeight() {
		btn_weightpricesave.setVisible(false);
		btn_weightUpdate.setVisible(true);

		Weight weight = new Weight();
		weight = weight_service.getweightPriceById(temp_weight_id);
		weightdataToView(weight);
	}

	private void weightdataToView(Weight weight) {
		txt_startweight_1.setText(weight == null ? "" : String.valueOf(weight.getWeight_kg()));
		txt_weightprice.setText(weight == null ? "" : String.valueOf(weight.getWeightprice()));

	}

	private void destinationdataToView(Destination destination) {
		txt_destinationName.setText(destination == null ? "" : String.valueOf(destination.getDestinationName()));
		txt_destinationprice.setText(destination == null ? "" : String.valueOf(destination.getPrice()));

	}

	private void saveWeight() {
		setWeightModel();
		int status = weight_service.createweightPrice(weight);

		System.out.println(weight.getWeight_kg());
		if (status > 0) {
			if (model_Weight != null)
				model_Weight.insertRow(weight);

			alert("Successfully Saved!");

		} else {
			alert("Failed Save!");
		}
		weight = null;
		weightdataToView(weight);
	}

	private void deleteDestination() {

		int modelRowIndex = tbldestination.convertRowIndexToModel(tbldestination.getSelectedRow());
		System.out.println("delete " + modelRowIndex);
		if (modelRowIndex != -1) {
			int status = destination_service.deletedestinationPrice(temp_destination_id);
			if (status > 0) {
				model_Destination.removeRow(modelRowIndex);
				alert("Successfully Deleted!");
			} else
				alert("Delete Failed!");
		} else {
			alert("Select a row to Delete!!");
		}

	}

	private void editDestination() {
		btn_destinationsave.setVisible(false);
		btn_destinationUpdate.setVisible(true);

		Destination destination = new Destination();
		destination = destination_service.getDestinationById(temp_destination_id);
		destinationdataToView(destination);
	}

	private void saveDestination() {
		setDestinationModel();
		int status = destination_service.createdestinationPrice(destination);
		if (status > 0) {
			if (model_Destination != null)
				model_Destination.insertRow(destination);

			alert("Successfully Saved!");

		} else {
			alert("Failed Save!");
		}
		destination = null;
		destinationdataToView(destination);

	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(frame, msg);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (!tbldestination.getSelectionModel().isSelectionEmpty()) {
			temp_destination_id = model_Destination
					.getDestination_Id(tbldestination.convertRowIndexToModel(tbldestination.getSelectedRow()));
			// System.out.println("temp_destination_id" + temp_destination_id);
		}

		if (!tblweight.getSelectionModel().isSelectionEmpty()) {
			temp_weight_id = model_Weight.getWeight_Id(tblweight.convertRowIndexToModel(tblweight.getSelectedRow()));
			System.out.println("temp_weight_id" + temp_weight_id);
		}

	}
}