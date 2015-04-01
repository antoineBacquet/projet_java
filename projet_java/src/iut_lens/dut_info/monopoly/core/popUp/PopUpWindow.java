package iut_lens.dut_info.monopoly.core.popUp;

import iut_lens.dut_info.monopoly.core.Window;

public class PopUpWindow extends Window {

	private PopUpOppener popUpOppener;

	public PopUpWindow(int width, int height, String name,PopUpOppener popUpOppener) {
		super(null);
		this.popUpOppener = popUpOppener;
	}
	
	
	
	
	public void onClose(){
		super.onClose();
		popUpOppener.onPopClose(this);
	}

}
