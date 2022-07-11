package View;

import java.awt.Color;

import javax.swing.JFrame;

import Utility.FrameMoveDetect;

public class Main_View {
JFrame frame;

	public Main_View() {
		frame=new JFrame();
		frame.setBounds(FrameMoveDetect.x, FrameMoveDetect.y, 1344, 800);
		frame.setTitle("Cargo transportaion Management System");
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public JFrame getFrame() {
		return frame;
	}
}
