package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.Staff_Panel;

public class CreateAccount_controller implements ActionListener, MouseListener {

	View.Office_view office_view;
	Staff_Panel cePanel;

	public CreateAccount_controller() {
		// dependencyInjection();

		initForm();
		initController();

	}

	private void initController() {
		office_view.getPanel_btnStaff().addMouseListener(this);
		office_view.getPanel_btnOrder().addMouseListener(this);
		office_view.getPanel_btnDelivery().addMouseListener(this);

		cePanel.getBtnMinimize().addActionListener(this);
		cePanel.getBtnMaximize().addActionListener(this);

	}

	private void initForm() {
		office_view = new View.Office_view();
		cePanel = new Staff_Panel(office_view.getFrame());
		cePanel.getBtnMaximize().setVisible(false);
		office_view.getPanel_btnStaff().setBackground(new Color(218, 165, 32));
	}

	private void collapseInputForm(boolean collapse) {
		if (collapse) {
			System.out.println("collapse");
			cePanel.getPanel_create().setBounds(200, 0, 1144, 50);
			cePanel.getPanel_list().setBounds(200,50,1144,690);
			cePanel.getScrollPane().setBounds(10, 46, 1110, 630);
			// panel.setBounds(180, 34, 1144, 370);
		} else {
			System.out.println("expand");
			cePanel.getPanel_create().setBounds(200, 0, 1144, 370);
			cePanel.getPanel_list().setBounds(200,370,1144,370);
			cePanel.getScrollPane().setBounds(10, 46, 1110, 310);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(office_view.getPanel_btnStaff())) {
		  if (e.getClickCount() == 2) {
			  System.out.println("Test Double Click!!");
		  }
		  else {
			System.out.println("Single Click!!");
		}
		}
		if(e.getSource().equals(office_view.getPanel_btnOrder())) {
			  if (e.getClickCount() == 2) {
				  System.out.println("Test Double Click!!");
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cePanel.getBtnMinimize())) {
			System.out.println("collapse");
			cePanel.getBtnMinimize().setVisible(false);
			cePanel.getBtnMaximize().setVisible(true);
			collapseInputForm(true);
		}

		if (e.getSource().equals(cePanel.getBtnMaximize())) {
			System.out.println("expand");
			collapseInputForm(false);
			cePanel.getBtnMinimize().setVisible(true);
			cePanel.getBtnMaximize().setVisible(false);
		}
	}

}
