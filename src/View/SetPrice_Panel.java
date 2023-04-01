package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Utility.RoundedBorder;

public class SetPrice_Panel {

	private JFrame frame;
	private JTable tbldestination, tblweight;
	private JPanel destination_panel;
	private JPanel weight_panel;
	private DefaultTableModel dtm = new DefaultTableModel();
	private DefaultTableModel dtm1 = new DefaultTableModel();
	private JScrollPane scrollPane_destination, scrollPane_weight;
	// JTextField txt_startweight, txt_lastweight, txt_weightprice,
	// txt_destinationprice;
	private JTextField txt_weightprice, txt_startweight_1, txt_destinationprice, txt_destinationName;
	private JButton btn_weightpricesave, btn_destinationsave;
	JButton btn_weightUpdate, btn_destinationUpdate;
	private JLabel lbldestinationinput, lblNewLabel, lbl_priceweight, lbl_weighterate, lbl_startweight,
			lbl_destinationto, lbl_price;
	// private JComboBox<String> cbox_destination;
	private JButton btn_destinationdelete, btn_destinationedit, btn_weightdelete, btn_weightedit;

	public SetPrice_Panel(JFrame container) {
		this.frame = container;
		initialize();
		setProperties();
		addComponent();
		setTableDesign();
		setTableDesign1();

		frame.revalidate();
		frame.repaint();
	}

	private void setTableDesign() {
		dtm.addColumn("No.");
		dtm.addColumn("Destination");
		dtm.addColumn("Price");
		this.tbldestination.setModel(dtm);
	}

	private void setTableDesign1() {
		dtm1.addColumn("NO.");
		dtm1.addColumn("Weight");
		dtm1.addColumn("Price");
		this.tblweight.setModel(dtm1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame = new JFrame();
		destination_panel = new JPanel();
		weight_panel = new JPanel();
		tbldestination = new JTable();
		tblweight = new JTable();
		btn_destinationUpdate = new JButton();
		btn_destinationsave = new JButton();
		btn_destinationdelete = new JButton();
		btn_destinationedit = new JButton();

		btn_weightUpdate = new JButton();
		btn_weightpricesave = new JButton();
		btn_weightdelete = new JButton();
		btn_weightedit = new JButton();

		lbl_destinationto = new JLabel();
		lbl_price = new JLabel();
		lbl_priceweight = new JLabel();
		lbl_startweight = new JLabel();
		lbl_weighterate = new JLabel();
		lbldestinationinput = new JLabel();
		lblNewLabel = new JLabel();

		txt_destinationprice = new JTextField();
		txt_weightprice = new JTextField();
		txt_startweight_1 = new JTextField();
		txt_destinationName = new JTextField();
		/*
		 * txt_lastweight = new JTextField(); txt_weightprice = new JTextField();
		 * txt_destinationprice = new JTextField(); txt_startweight = new JTextField();
		 */
		// cbox_destination = new JComboBox();
		scrollPane_destination = new JScrollPane();
		scrollPane_weight = new JScrollPane();

	}

	private void setProperties() {
		weight_panel.setBounds(772, 0, 572, 759);
//		frame.setBounds(0, 0, 1356, 794);
//		frame.setTitle("Price_Details");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);

		destination_panel.setBackground(new Color(0, 206, 209));
		weight_panel.setBackground(new Color(255, 255, 204));
		destination_panel.setBounds(200, 0, 572, 759);

		destination_panel.setLayout(null);

		lbldestinationinput.setText("Destination Price Rate");
		lbldestinationinput.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbldestinationinput.setBounds(167, 23, 238, 37);

		lbl_destinationto.setText("Destination");
		lbl_destinationto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_destinationto.setBounds(83, 98, 133, 27);

		txt_destinationName.setBounds(276, 96, 179, 37);

		lbl_price.setText("Price");
		lbl_price.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_price.setBounds(83, 172, 56, 27);
		tbldestination.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbldestination.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		
		tblweight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblweight.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));

		txt_destinationprice.setBounds(276, 170, 179, 37);
		txt_destinationprice.setColumns(10);

		btn_destinationsave.setText("Save");
		btn_destinationsave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_destinationsave.setBounds(421, 303, 100, 40);

		btn_destinationUpdate.setText("Update");
		btn_destinationUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_destinationUpdate.setBounds(421, 303, 100, 40);
		btn_destinationUpdate.setVisible(false);

		scrollPane_destination = new JScrollPane();
		scrollPane_destination.setBounds(10, 361, 552, 388);
		scrollPane_destination.setViewportView(tbldestination);
		//scrollPane_destination.setBorder(new RoundedBorder(20));
		
		weight_panel.setLayout(null);

		lbl_weighterate.setText("Weight Price Rate");
		lbl_weighterate.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbl_weighterate.setBounds(195, 23, 184, 37);

		lbl_startweight.setText(" Weight");
		lbl_startweight.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_startweight.setBounds(101, 98, 76, 37);

		txt_startweight_1.setBounds(266, 101, 166, 37);
		txt_startweight_1.setColumns(10);

		lbl_priceweight.setText("Price");
		lbl_priceweight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_priceweight.setBounds(109, 178, 56, 31);

		txt_weightprice.setBounds(266, 178, 166, 37);
		txt_weightprice.setColumns(10);

		btn_weightpricesave.setText("Save");
		btn_weightpricesave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_weightpricesave.setBounds(409, 299, 100, 40);

		btn_weightUpdate.setText("Update");
		btn_weightUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_weightUpdate.setBounds(409, 299, 100, 40);
		btn_weightUpdate.setVisible(false);

		scrollPane_weight = new JScrollPane();
		scrollPane_weight.setBounds(10, 361, 540, 388);
		scrollPane_weight.setViewportView(tblweight);
	//	scrollPane_weight.setBorder(new RoundedBorder(20));

		lblNewLabel.setText("kg");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(447, 100, 38, 37);

		btn_destinationdelete.setText("Delete");
		btn_destinationdelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_destinationdelete.setBounds(228, 303, 100, 40);

		btn_destinationedit.setText("Clear");
		btn_destinationedit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_destinationedit.setBounds(22, 303, 100, 40);

		btn_weightdelete.setText("Delete");
		btn_weightdelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_weightdelete.setBounds(224, 299, 100, 40);

		btn_weightedit.setText("Clear");
		btn_weightedit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_weightedit.setBounds(25, 299, 100, 40);

	}

	private void addComponent() {
		destination_panel.add(lbldestinationinput);
		destination_panel.add(lbl_destinationto);
		destination_panel.add(txt_destinationName);
		destination_panel.add(lbl_price);
		destination_panel.add(txt_destinationprice);
		destination_panel.add(btn_destinationsave);
		destination_panel.add(scrollPane_destination);
		destination_panel.add(btn_destinationdelete);
		destination_panel.add(btn_destinationedit);
		destination_panel.add(btn_destinationUpdate);
		
		weight_panel.add(lbl_weighterate);
		weight_panel.add(lbl_startweight);
		weight_panel.add(txt_startweight_1);
		weight_panel.add(lbl_priceweight);
		weight_panel.add(txt_weightprice);
		weight_panel.add(btn_weightpricesave);
		weight_panel.add(scrollPane_weight);
		weight_panel.add(lblNewLabel);
		weight_panel.add(btn_weightUpdate);
		weight_panel.add(btn_weightdelete);
		weight_panel.add(btn_weightedit);
		if (frame != null) {
			frame.getContentPane().add(destination_panel);
			frame.getContentPane().add(weight_panel);
		}

	}

	public JTextField getTxt_DestinationName() {
		return txt_destinationName;
	}

	public JTextField getTxt_DestinationPrice() {
		return txt_destinationprice;
	}

	public JButton getBtn_destinationsave() {
		return btn_destinationsave;
	}

	public JTextField getTxt_startweight() {
		return txt_startweight_1;
	}

	public JTextField getTxt_weightprice() {
		return txt_weightprice;
	}

	public JButton getBtn_weightpricesave() {
		return btn_weightpricesave;
	}

	public JButton getBtn_destinationedit() {
		return btn_destinationedit;
	}

	public JButton getBtn_destinationdelete() {
		return btn_destinationdelete;
	}

	public JButton getBtn_weightdelete() {
		return btn_weightdelete;
	}

	public JButton getBtn_weightedit() {
		return btn_weightedit;
	}

	public JPanel getDestination_panel() {
		return destination_panel;
	}

	public JPanel getWeight_panel() {
		return weight_panel;
	}

	public JTable getTblDestination() {
		return tbldestination;
	}

	public JTable getTblWeight() {
		return tblweight;
	}
	
	public JButton getBtnDestinationUpdate() {
		return btn_destinationUpdate;
	}
	
	public JButton getBtnWeightUpdate() {
		return btn_weightUpdate;
	}
}