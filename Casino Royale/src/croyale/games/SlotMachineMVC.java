package croyale.games;

import javax.swing.JPanel;

public class SlotMachineMVC {

	public SlotMachineMVC(JPanel mainFrame){
		SlotMachineModel model = new SlotMachineModel();
		SlotMachineView view = new SlotMachineView(mainFrame);
		SlotMachineController controller = new SlotMachineController(model,view);
	}
	
}
