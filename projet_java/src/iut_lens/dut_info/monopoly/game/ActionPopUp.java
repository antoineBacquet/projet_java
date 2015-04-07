package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.FontManager;
import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.core.element.ActionListener;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public abstract class ActionPopUp implements Drawable {

	protected Sprite sprite;

	protected RectangleShape rectangle;

	protected Text text;

	private final static Color FLOU_COLOR = new Color(50, 50, 50, 50);

	private RectangleShape fuzzyRectangle;

	protected ActionListener actionListener;

	public ActionPopUp(ActionListener actionListener, Vector2f pos, Vector2i windowSize,
			Vector2f size, String texturePath, String message) {
		this.actionListener = actionListener;
		fuzzyRectangle = new RectangleShape(new Vector2f(windowSize));
		fuzzyRectangle.setPosition(0, 0);
		fuzzyRectangle.setFillColor(FLOU_COLOR);

		Texture texture = TextureManager.getTexture(texturePath);
		this.sprite = new Sprite();
		sprite.setTexture(texture);

		float scale = (float) (size.y / sprite.getTexture().getSize().y * 0.6);
		sprite.setScale(scale, scale);

		rectangle = new RectangleShape(size);
		rectangle.setPosition(windowSize.x * pos.x - size.x / 2, windowSize.y
				* pos.y - size.y / 2);
		rectangle.setFillColor(new Color(32, 32, 32));
		rectangle.setOutlineColor(Color.BLACK);
		rectangle.setOutlineThickness(5);

		sprite.setPosition(new Vector2f(rectangle.getPosition().x
				+ rectangle.getSize().x * pos.x - texture.getSize().x * scale
				/ 2, rectangle.getPosition().y + 50));

		text = new Text(message, FontManager.getFont("arial"), 30);
		text.setPosition(new Vector2f(0, rectangle.getPosition().y + 10));
		Util.centerTextRectInX(rectangle, text);

	}

	public void renderFlou(RenderTarget target, RenderStates states) {
		target.draw(fuzzyRectangle, states);
		target.draw(rectangle,states);
		target.draw(sprite,states);
		target.draw(text, states);
	}

	public abstract boolean handleEvent(Event evt);

	public abstract void update(Time tau);

}
