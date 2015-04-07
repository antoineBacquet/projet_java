package iut_lens.dut_info.monopoly.core.popUp;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.FontManager;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Action.ActionType;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Button;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class OptionPopUpContent implements ActionListener{
	
	private Button confirme;
	private Button cancel;
	
	private RectangleShape rect;
	private Time temps;
	private Text tempsText;
	
	private Content content;
	
	public OptionPopUpContent(Content content) {
		this.content = content;
		confirme = new Button(content, new Vector2f(100,40), "Confirmer");
		confirme.setPositionRelative(content.getWindowOption().getSize(), 0.4f, 0.6f);
		confirme.setActionListener(this);
		
		cancel = new Button(content, new Vector2f(100,40), "Annuler");
		cancel.setPositionRelative(content.getWindowOption().getSize(), 0.6f, 0.6f);
		cancel.setActionListener(this);
		
		rect = new RectangleShape(new Vector2f(((float)(content.getWindow().getSize().x*0.4)),((float)(content.getWindow().getSize().y*0.4))));
		rect.setPosition(new Vector2f(((float)((content.getWindow().getSize().x/2)-content.getWindow().getSize().x*0.4/2)),
				((float)((content.getWindow().getSize().y/2)-content.getWindow().getSize().y*0.4/2))));
		rect.setFillColor(Color.BLACK);
		
		temps = Time.getSeconds(10);
		
		tempsText = new Text("10",FontManager.getFont("arial"),20);
		tempsText.setPosition(new Vector2f((float)(content.getWindow().getSize().x/2),
			(float)(content.getWindow().getSize().y/2)));
		tempsText.setColor(Color.WHITE);
	}

	
	public void handleEvent(Event evt) {
		confirme.handleEvent(evt);
		cancel.handleEvent(evt);
	}

	
	public void update(Time tau) {
		confirme.update(tau);
		cancel.update(tau);
		temps = Time.sub(temps,tau);
		tempsText.setString(""+(int)temps.asSeconds());
	}

	
	public void render(RenderTarget target) {
		target.draw(rect);
		target.draw(tempsText);
		confirme.render(target);
		cancel.render(target);
	}


	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == confirme)
			content.actionPerformed(new Action(this,ActionType.CONFIRM));
		if(action.getSource() == cancel)
			content.actionPerformed(new Action(this,ActionType.CANCEL));
	}

}
