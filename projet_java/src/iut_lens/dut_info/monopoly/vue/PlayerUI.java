package iut_lens.dut_info.monopoly.vue;

import iut_lens.dut_info.monopoly.core.ContentPart;
import iut_lens.dut_info.monopoly.core.FontManager;
import iut_lens.dut_info.monopoly.core.Util;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public class PlayerUI extends ContentPart {

	private RectangleShape rect;
	private Text nameText;
	private Text moneyText;

	public PlayerUI(Vector2i contentSize, Vector2f size, Vector2f pos, Color color, String name, float money) {
		super(contentSize, size, pos);
		rect = new RectangleShape();
		rect.setOutlineThickness(2);
		rect.setOutlineColor(color);
		
		nameText = new Text(name,FontManager.getFont("arial"));
		nameText.setColor(color);
		
		
		moneyText = new Text("argent:"+money,FontManager.getFont("arial"));
		moneyText.setColor(color);
		
		//System.out.println("PlayerUI :: PlayerUI :: size : " + size + " pos : " + pos);
	}


	@Override
	public void onResize() {
		
		//size et pos du rectangles
		rect.setSize(new Vector2f(size.x-6,size.y-6));
		rect.setPosition(pos);
		
		//taille de la police
		nameText.setCharacterSize((int)size.y/2-5);
		moneyText.setCharacterSize((int)size.y/2-5);
		
		nameText.setPosition(0,pos.y-5);
		Util.centerTextRectInX(rect, nameText);		

		moneyText.setPosition(0,pos.y+rect.getSize().y-rect.getSize().y*0.6f);
		Util.centerTextRectInX(rect, moneyText);
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
		target.draw(rect);
		target.draw(nameText);
		target.draw(moneyText);	

	}


	public void setDefaultFillColor() {
		rect.setFillColor(Color.WHITE);
		
	}


	public void setFillColor() {
		rect.setFillColor(new Color(100,100,100));
		
	}


	public void majMoney(float money) {
		moneyText.setString("argent:"+((int)money));
		
		
	}

}
