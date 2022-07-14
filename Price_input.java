package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Price_input {

	private JFrame frame;
	private JTable tbldestination, tblweight;
	private JPanel destination_panel;
	private JPanel weight_panel;
	private DefaultTableModel dtm = new DefaultTableModel();
	private DefaultTableModel dtm1 = new DefaultTableModel();
	private JScrollPane scrollPane_destination, scrollPane_weight;
	private JTextField txt_startweight, txt_lastweight, txt_weightprice, txt_price;
	private JTextField txt_weightprice_1;
	private JTextField txt_startweight_1;
	private JTextField txt_price_1;
	private JButton btn_weightpricesave, btn_destinationsave;
	private JLabel lbldestinationinput, lblNewLabel,
			lbl_priceweight, lbl_weighterate, lbl_startweight, lblNewLabel_1, lblNewLabel_2, lbl_destinationto,
			lbl_price;
	private JComboBox cbox_destination;
	private JButton btn_destinationdelete;
	private JButton btn_destinationedit;
	private JButton btn_weightdelete;
	private JButton btn_weightedit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Price_input window = new Price_input();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Price_input() {
		initialize();
		setProperties();
		addComponent();
		setTableDesign();
		setTableDesign1();
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
		frame = new JFrame();
		destination_panel = new JPanel();
		weight_panel = new JPanel();
		tbldestination = new JTable();
		tblweight = new JTable();
		btn_weightpricesave = new JButton();
		btn_destinationsave = new JButton();
		lbl_destinationto = new JLabel();
		lbl_price = new JLabel();
		lbl_priceweight = new JLabel();
		lbl_startweight = new JLabel();
		lbl_weighterate = new JLabel();
		lbldestinationinput = new JLabel();
		lblNewLabel = new JLabel();
		lblNewLabel_1 = new JLabel();
		lblNewLabel_2 = new JLabel();
		txt_lastweight = new JTextField();
		txt_weightprice = new JTextField();
		txt_price = new JTextField();
		txt_startweight = new JTextField();
		cbox_destination = new JComboBox();
		scrollPane_destination = new JScrollPane();
		scrollPane_weight = new JScrollPane();
		btn_destinationdelete = new JButton();
		btn_destinationedit = new JButton();
		btn_weightdelete = new JButton();
		btn_weightedit = new JButton();

	}

	private void setProperties() {
		weight_panel.setBounds(772, 0, 572, 759);
		frame.setBounds(0, 0, 1356, 794);
		frame.setTitle("Price_Details");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		destination_panel.setBackground(new Color(0, 206, 209));
		weight_panel.setBackground(new Color(127, 255, 212));
		destination_panel.setBounds(200, 0, 572, 759);

		destination_panel.setLayout(null);

		lbldestinationinput.setText("Destination Rate Input");
		lbldestinationinput.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbldestinationinput.setBounds(167, 23, 238, 37);

		lblNewLabel_1.setText("Source From");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(85, 96, 130, 37);

		lblNewLabel_2.setText("KyalGaung");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(275, 101, 163, 27);

		lbl_destinationto.setText("Destination to");
		lbl_destinationto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_destinationto.setBounds(82, 161, 133, 27);

		cbox_destination.setBounds(275, 159, 179, 37);

		lbl_price.setText("Price");
		lbl_price.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_price.setBounds(82, 235, 56, 27);

		txt_price_1 = new JTextField();
		txt_price_1.setBounds(275, 233, 179, 37);
		txt_price_1.setColumns(10);

		btn_destinationsave.setText("Save");
		btn_destinationsave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_destinationsave.setBounds(421, 303, 116, 48);

		scrollPane_destination = new JScrollPane();
		scrollPane_destination.setBounds(0, 361, 572, 398);
		scrollPane_destination.setViewportView(tbldestination);
		weight_panel.setLayout(null);

		lbl_weighterate.setText("Weight Price Rate");
		lbl_weighterate.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbl_weighterate.setBounds(195, 23, 184, 37);

		lbl_startweight.setText(" Weight");
		lbl_startweight.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_startweight.setBounds(101, 98, 76, 37);

		txt_startweight_1 = new JTextField();
		txt_startweight_1.setBounds(266, 101, 166, 37);
		txt_startweight_1.setColumns(10);

		lbl_priceweight.setText("Price");
		lbl_priceweight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_priceweight.setBounds(109, 178, 56, 31);

		txt_weightprice_1 = new JTextField();
		txt_weightprice_1.setBounds(266, 178, 166, 37);
		txt_weightprice_1.setColumns(10);

		btn_weightpricesave.setText("Save");
		btn_weightpricesave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_weightpricesave.setBounds(409, 299, 116, 48);

		scrollPane_weight = new JScrollPane();
		scrollPane_weight.setBounds(0, 361, 572, 398);
		scrollPane_weight.setViewportView(tblweight);

		lblNewLabel.setText("kg");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(447, 100, 38, 37);
		
		
		btn_destinationdelete.setText("Delete");
		btn_destinationdelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_destinationdelete.setBounds(228, 303, 116, 48);
		
		
		btn_destinationedit.setText("Edit");
		btn_destinationedit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_destinationedit.setBounds(22, 303, 116, 48);
		
		
		btn_weightdelete.setText("Delete");
		btn_weightdelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_weightdelete.setBounds(224, 299, 116, 48);
		
		
		btn_weightedit.setText("Edit");
		btn_weightedit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_weightedit.setBounds(25, 299, 116, 48);

	}

	private void addComponent() {
		frame.getContentPane().add(destination_panel);
		frame.getContentPane().add(weight_panel);
		destination_panel.add(lbldestinationinput);
		destination_panel.add(lblNewLabel_1);
		destination_panel.add(lblNewLabel_2);
		destination_panel.add(lbl_destinationto);
		destination_panel.add(cbox_destination);
		destination_panel.add(lbl_price);
		destination_panel.add(txt_price_1);
		destination_panel.add(btn_destinationsave);
		destination_panel.add(scrollPane_destination);
		
		
		destination_panel.add(btn_destinationdelete);
		
		
		destination_panel.add(btn_destinationedit);
		weight_panel.add(lbl_weighterate);
		weight_panel.add(lbl_startweight);
		weight_panel.add(txt_startweight_1);
		weight_panel.add(lbl_priceweight);
		weight_panel.add(txt_weightprice_1);
		weight_panel.add(btn_weightpricesave);
		weight_panel.add(scrollPane_weight);
		weight_panel.add(lblNewLabel);
		
		
		weight_panel.add(btn_weightdelete);
		
		
		weight_panel.add(btn_weightedit);

	}
	public JComboBox getCbox_destination() {
		return cbox_destination;
	}
	public JTextField getTxt_price() {
		return txt_price_1;
	}
	public JButton getBtn_destinationsave() {
		return btn_destinationsave;
	}
	public JTextField getTxt_startweight() {
		return txt_startweight_1;
	}
	
	public JTextField getTxt_weightprice() {
		return txt_weightprice_1;
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
}
