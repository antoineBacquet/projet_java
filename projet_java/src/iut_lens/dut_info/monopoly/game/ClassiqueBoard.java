package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.game.cases.Case;
import iut_lens.dut_info.monopoly.game.cases.CaseDefault;
import iut_lens.dut_info.monopoly.game.cases.Chance;
import iut_lens.dut_info.monopoly.game.cases.CommunityChest;
import iut_lens.dut_info.monopoly.game.cases.Company;
import iut_lens.dut_info.monopoly.game.cases.MustPaidCase;
import iut_lens.dut_info.monopoly.game.cases.Property;
import iut_lens.dut_info.monopoly.game.cases.Station;
import iut_lens.dut_info.monopoly.vue.GameContent;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class ClassiqueBoard extends Board {

	protected final int NB_CASE = 40;

	public ClassiqueBoard(GameContent content, Game game, Vector2f size,
			Vector2f pos) {
		super(content, game, size, pos, TextureManager.getTexture("board"), 40);
	}

	@Override
	public void createCase() {

		cases = new Case[NB_CASE];
		
		super.cases[0] = new CaseDefault(this, "depart");
		super.cases[1] = new Property(this, "quaisDeSeine");
		super.cases[2] = new CommunityChest(this,"caisseDeCommunaute"); 
		super.cases[3] = new Property(this, "montmartre");
		super.cases[4] = new MustPaidCase(this, "impots", 2_000_000);
		super.cases[5] = new Station(this, "gareDuNord");
		super.cases[6] = new Property(this, "fillesDuCalvaire");
		super.cases[7] = new Chance(this, "chance");
		super.cases[8] = new Property(this, "porteDesLilas");
		super.cases[9] = new Property(this, "notreDameDeschamps");
		
		//TODO a changer en case prison
		super.cases[10] = new CaseDefault(this, "prison");
		
		super.cases[11] = new Property(this, "pontAlexandreIII");
		super.cases[12] = new Company(this,"telecoms"); 
		super.cases[13] = new Property(this, "pontNeuf");
		super.cases[14] = new Property(this, "passerelleDesArts"); 
		super.cases[15] = new Station(this, "gareSaintLazare");
		super.cases[16] = new Property(this, "museeDorsay");
		super.cases[17] = new CommunityChest(this, "caisseDeCommunaute");
		super.cases[18] = new Property(this, "beaubourg");
		super.cases[19] = new Property(this, "citeDesSciences");

		super.cases[20] = new CaseDefault(this, "parcGratuit");
		
		super.cases[21] = new Property(this, "stadeDeFrance");
		super.cases[22] = new Chance(this,"chance"); 
		super.cases[23] = new Property(this, "olympia");
		super.cases[24] = new Property(this, "palaisOmnisportDeParisBercy"); 
		super.cases[25] = new Station(this, "gareMontparnasse");
		super.cases[26] = new Property(this, "lyceeHenriIV");
		super.cases[27] = new Property(this, "ecoleDesArtsEtMetiers");
		super.cases[28] = new Company(this, "satellite");
		super.cases[29] = new Property(this, "laSorbonne");

		super.cases[30] = new CaseDefault(this, "allerPrison"); //TODO aller en prison
		
		super.cases[31] = new Property(this, "laDefense");
		super.cases[32] = new Property(this,"laBourse"); 
		super.cases[33] = new CommunityChest(this, "caisseDeCommunaute"); 
		super.cases[34] = new Property(this, "ministereDesFinances"); 
		super.cases[35] = new Station(this, "gareDeLyon");
		super.cases[36] = new Chance(this, "chance");
		super.cases[37] = new Property(this, "notreDameDeParis");
		super.cases[38] = new MustPaidCase(this, "taxeDeLuxe",1_000_000);
		super.cases[39] = new Property(this, "tourEiffel");
		
		
		
		this.setCasesSize();
		this.setCasesPos();
		

	}

	private void setCasesSize() {
		
		
		float sizeTmp = 0;
		if(size.y>size.x)sizeTmp = size.x;
		else sizeTmp = size.y;

		double caseHeight = (float) (sizeTmp * 0.13);
		double caseWidth = (float) ((sizeTmp - 2 * caseHeight) / 9);

		// gestion de la taille des cases
		for (int i = 0; i < NB_CASE; i++) {
			if (i % (NB_CASE / 4) == 0)
				super.cases[i].setSize(new Vector2f((float) caseHeight,
						(float) caseHeight));
			else if ((i / 10 % 2) == 0)
				super.cases[i].setSize(new Vector2f((float) caseWidth,
						(float) caseHeight));
			else
				super.cases[i].setSize(new Vector2f((float) caseHeight,
						(float) caseWidth));
		}
	}

	private void setCasesPos() {
		float sizeTmp = 0;
		if(size.y>size.x)sizeTmp = size.x;
		else sizeTmp = size.y;
		

		double caseHeight = (float) (sizeTmp * 0.13);
		double caseWidth = (float) ((sizeTmp - 2 * caseHeight) / 9);
		// case du bas droite
		double posX = sizeTmp - caseHeight;
		double posY = sizeTmp - caseHeight;
		cases[0].setPos(new Vector2f((float) posX, (float) posY));

		// toutes les case du bas
		for (int i = 1; i < 10; i++) {
			posX -= caseWidth;
			cases[i].setPos(new Vector2f((float) posX, (float) posY));
		}

		// case du bas gauche
		posX -= caseHeight;
		cases[10].setPos(new Vector2f((float) posX, (float) posY));

		// cases de gauche
		for (int i = 11; i < 20; i++) {
			posY -= caseWidth;
			cases[i].setPos(new Vector2f((float) posX, (float) posY));
		}

		// case du haut gauche
		posY -= caseHeight;
		cases[20].setPos(new Vector2f((float) posX, (float) posY));

		// cases du haut
		posX += caseHeight;

		for (int i = 21; i < 30; i++) {
			cases[i].setPos(new Vector2f((float) posX, (float) posY));
			posX += caseWidth;
		}

		// case du haut droit
		cases[30].setPos(new Vector2f((float) posX, (float) posY));

		posY += caseHeight;

		// cases de gauche
		for (int i = 31; i < 40; i++) {
			cases[i].setPos(new Vector2f((float) posX, (float) posY));
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

		for (Case c : cases)
			render.draw(c);

		render.display();

		sprite.setTexture(render.getTexture());

		target.draw(sprite);

	}

}
