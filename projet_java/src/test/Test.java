package test;

import iut_lens.dut_info.monopoly.core.Window;
import iut_lens.dut_info.monopoly.core.WindowManager;

public class Test {
	
	
	
	
	public static void main(String[] args) {
		Window window = new Window(800,600,"test");
		window.create();
		WindowManager.addWindow(window);
		WindowManager.loop();
	}
	
}
