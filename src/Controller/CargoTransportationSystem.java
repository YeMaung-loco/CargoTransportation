package Controller;

import Utility.FrameMoveDetect;
import View.Main_View;
import View.Office_view;

public class CargoTransportationSystem {

	public static void main(String[] args) {
		Main_View main_View=new Main_View();
		main_View.getFrame().addComponentListener(new FrameMoveDetect());
		CreateAccount_controller createAccountController=new CreateAccount_controller(main_View.getFrame());
	}

}
