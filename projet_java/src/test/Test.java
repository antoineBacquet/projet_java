package test;

import iut_lens.dut_info.monopoly.core.Window;
import iut_lens.dut_info.monopoly.core.WindowManager;

public class Test {
	
	
	
	
	public static void main(String[] args) {
		Window window = new Window(800,600,"test");
		window.setContent(new ContentTest1());
		window.create();
		WindowManager.addWindow(window);
		
		Window window2 = new Window(800,600,"test2");
		window2.setContent(new ContentTest2());
		window2.create();
		WindowManager.addWindow(window2);
		
		WindowManager.loop();
	}
	
}
