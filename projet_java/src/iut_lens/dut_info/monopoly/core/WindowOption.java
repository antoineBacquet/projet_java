package iut_lens.dut_info.monopoly.core;

import org.jsfml.system.Vector2i;

public class WindowOption {
	
	private Vector2i size = new Vector2i(0,0);
	
	private String name = "Window";
	
	
	
	public WindowOption(Vector2i size, String name) {
		this.size = size;
		this.name = name;
	}



	public Vector2i getSize() {
		 return this.size;
	}



	public String getName() {
		return this.name;
	}



	public void setSize(Vector2i size) {
		this.size = size;
		
	}



	public Vector2i getMousePos() {
		// TODO a coder
		return new Vector2i(0,0);
	}
			
	
	
	
	
	
	
	
	

}
