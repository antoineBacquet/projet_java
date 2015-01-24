package iut_lens.dut_info.monopoly.vue;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Selector;

public class OptionContent extends Content{

	
	private Selector resSelector;
	
	String[] res = {"test","test1","test2"};
	public OptionContent() {
		super();
		
		resSelector = new Selector(this,res,new Vector2f(200,50),new Vector2f(0,0),0);
		super.addElement(resSelector);
		
	}
	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		
	}

}
