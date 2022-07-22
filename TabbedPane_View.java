package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TabbedPane_View {

	private JFrame frame;
	private JLabel lblRequest;
	private JLabel lblNewLabel_2;
	private JTextField txtsearch;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable tblRequestorder, tblrequest;
	private JTextField textField;
	private JTabbedPane tabbedPane;
//	Failed_panel Failed_panel;
//	Complete_panel Complete_panel;
//	Pending_panel Pending_panel;
//	Requesting_panel Requesting_panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabbedPane_View window = new TabbedPane_View();
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
	public TabbedPane_View() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	    frame.setBounds(0, 0, 1356, 795);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(200, 0, 1141, 745);

		//Pending_panel = new Pending_panel();

//		Requesting_panel = new Requesting_panel();
//		Failed_panel = new Failed_panel();
//		Complete_panel= new Complete_panel();
//		tblRequestorder = new JTable();

//		tabbedPane.addTab("Pending", Pending_panel);
//		tabbedPane.setForegroundAt(0, Color.DARK_GRAY);
//
//		Pending_panel.setLayout(null);
//
//		tabbedPane.addTab("Requesting Order", Requesting_panel);
//
//		Requesting_panel.setLayout(null);
//
//		tabbedPane.addTab("Completed Order", Complete_panel);
//		tabbedPane.addTab("Failed Order", Failed_panel);

		frame.getContentPane().add(tabbedPane);

	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
}
