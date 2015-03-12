package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.game.cases.Case;
import iut_lens.dut_info.monopoly.game.cases.CaseDebug;
import iut_lens.dut_info.monopoly.game.cases.Property;
import iut_lens.dut_info.monopoly.vue.GameContent;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class ClassiqueBoard extends Board {

	protected final int NB_CASE = 40;

	public ClassiqueBoard(GameContent content, Game game, Vector2f size, Vector2f pos) {
		super(content, game, size, pos, TextureManager.getTexture("board"),40);
	}

	@Override
	public void createCase() {
		double caseHeight = (float) (size.y * 0.13);
		double caseWidth = (float) ((size.y - 2 * caseHeight) / 9);

		cases = new Case[NB_CASE];

		for (int i = 0; i < NB_CASE; i++) {
			super.cases[i] = new CaseDebug(this,"depart");
		}
		
		super.cases[1] = new Property(this,"rigas");

		// gestion de la taille des cases
		for (int i = 0; i < NB_CASE; i++) {
			if (i % (NB_CASE / 4) == 0)
				super.cases[i].setSize(new Vector2f((float)caseHeight, (float)caseHeight));
			else if ((i / 10 % 2) == 0)
				super.cases[i].setSize(new Vector2f((float)caseWidth, (float)caseHeight));
			else
				super.cases[i].setSize(new Vector2f((float)caseHeight, (float)caseWidth));
		}

		// case du bas droite
		double posX = size.y - caseHeight;
		double posY = size.y - caseHeight;
		cases[0].setPos(new Vector2f((float)posX, (float)posY));

		// toutes les case du bas
		for (int i = 1; i < 10; i++) {
			posX -= caseWidth;
			cases[i].setPos(new Vector2f((float)posX, (float)posY));
		}

		// case du bas gauche
		posX -= caseHeight;
		cases[10].setPos(new Vector2f((float)posX, (float)posY));

		// cases de gauche
		for (int i = 11; i < 20; i++) {
			posY -= caseWidth;
			cases[i].setPos(new Vector2f((float)posX, (float)posY));
		}

		// case du haut gauche
		posY -= caseHeight;
		cases[20].setPos(new Vector2f((float)posX, (float)posY));
		
		// cases du haut
		posX+=caseHeight;
		
		for (int i = 21; i < 30; i++) {
			cases[i].setPos(new Vector2f((float)posX, (float)posY));
			posX += caseWidth;
		}
		
		// case du haut droit
		cases[30].setPos(new Vector2f((float)posX, (float)posY));
		
		posY+=caseHeight;
		
		// cases de gauche
		for (int i = 31; i < 40; i++) {
			cases[i].setPos(new Vector2f((float)posX, (float)posY));
			posY += caseWidth;
		}

	}

	@Override
	protected void onCreate() {
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
		render.clear(Color.WHITE);
		render.draw(rect);

		render.draw(boardSprite);
		
		for(Case c:cases)
			render.draw(c);

		render.display();

		sprite.setTexture(render.getTexture());

		target.draw(sprite);

	}

}
