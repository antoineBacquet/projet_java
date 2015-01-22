package test;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.TextureCreationException;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.Window;

public class ContentTest1 extends Content {

	private RectangleShape rectangle;
	
	private RenderTexture texture;
	
	private Sprite sprite;

	public ContentTest1() {
		rectangle = new RectangleShape(new Vector2f(50,50));
		rectangle.setOutlineThickness(1);
		rectangle.setOutlineColor(Color.BLACK);
		
		texture = new RenderTexture();
		try {
			texture.create(100, 100);
		} catch (TextureCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sprite = new Sprite();
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
		texture.clear();
		texture.draw(rectangle);
		texture.display();
		sprite.setTexture(texture.getTexture());
		target.draw(sprite);

	}

}
