package test;


import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Button;

public class ContentTest1 extends Content {

	
	private Button buttonTest;

	public ContentTest1() {
		super();
		
		buttonTest = new Button(this,new Vector2f(200,50),new Vector2f(50,50),"test");
		addElement(buttonTest);
	}
	@Override
	public void handleEvent(Event evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Time tau) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(RenderTarget target) {

	}
	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == buttonTest){
			System.out.println("bouttonTest presser");
		}
		
	}
	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		
	}

}
