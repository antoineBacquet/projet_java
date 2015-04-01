package iut_lens.dut_info.monopoly.core;

import iut_lens.dut_info.monopoly.vue.Menu;

import org.jsfml.system.Vector2i;

public class Main {
	
	public static void main(String[] args) {
		Window w = new Window(new WindowOption(new Vector2i(1280,720),"test"));
		w.create();
		w.setContent(new Menu(w.getWindowOption(),w));
		
		w.loop();
	}

}
