package iut_lens.dut_info.monopoly.core;

import java.util.LinkedList;

public class WindowManager {
	
	private static LinkedList<Window> windows = new LinkedList<Window>();
	private static LinkedList<Window> windowsToAdd = new LinkedList<Window>();
	private static LinkedList<Window> windowsToRemove = new LinkedList<Window>();
	private static boolean isOpen = true;
	
	public static void addWindow(Window window){
		windowsToAdd.add(window);
	}
	public static void removeWindow(Window window){
		windowsToRemove.add(window);
	}
	
	public static void loop(){
		
		while(isOpen){
			for(Window window:windowsToAdd){
				windows.add(window);
			}
			windowsToAdd.clear();
			
			for(Window window:windowsToRemove){
				windows.remove(window);
			}
			windowsToRemove.clear();
			
			for(Window window:windows){
				window.handleEvent();
				window.update();
				window.render();
					
			}
			
			if(windows.size() == 0)
				isOpen = false;
		}
		
	}
	
	public static void close(){
		isOpen = false;
	}

}
