package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.Player;
import iut_lens.dut_info.monopoly.game.cases.clickAction.BuildHouse;
import iut_lens.dut_info.monopoly.game.cases.clickAction.ClickAction;
import iut_lens.dut_info.monopoly.game.cases.clickAction.ClickOnProperty;
import iut_lens.dut_info.monopoly.game.cases.clickAction.DefaultClickAction;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Property extends Buyable{
	
	private Property[] otherProperty;
	
	private static final String filePath = "Projet/Cartes/Proprietes/";
	
	private int price;

	private int prixAppartement;

	private int prixHotel;
	
	private String color;
	
	private int nbHouses = 0;

	private List<Long> loyer;

	public Property(Board board, String name) {
		super(board, name);
		loadData();
	
	}
	
	@SuppressWarnings("unchecked")
	private void loadData(){
		try {
			// read the json file
			FileReader reader = new FileReader(filePath+name+".js");

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			color = (String) jsonObject.get("couleur");
			//System.out.println("Couleur : " + couleur);
			
			String nom = (String) jsonObject.get("nom");
			//System.out.println("Carte : " + nom);
			

			this.price = Util.longToInt((long) jsonObject.get("prixAchat"));


			this.loyer = ((JSONArray) jsonObject.get("loyer"));
			
			
			// get a number from the JSON object
			this.prixAppartement =  Util.longToInt((long) jsonObject.get("prixAppartement"));
			
			this.prixHotel =  Util.longToInt((long) jsonObject.get("prixHotel"));
			
			this.mortageValue =  Util.longToInt((long) jsonObject.get("hypothequeTerrain"));

			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}
	
	public int getRent(){
		return  Util.longToInt(this.loyer.get(nbHouses));
	}

	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub
		
	}

	public int getPrice() {
		return (int)this.price;
	}
	
	
	public void setOwner(Player player) {
		this.owner = player;
		this.setColor(player.getColor());
		
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public int getHousePrice(){
		return this.prixAppartement;
	}
	
	@Override
	public ClickAction onClickOn(ActionListener listener, Vector2f size,
			Vector2i windowSize, Vector2f pos, Game game) {
		if(!board.getGame().isInTurn() && owner == board.getGame().getActualPlayer())
			if(board.habAllProperty(owner, this))
				return new BuildHouse(listener, pos, windowSize, size, name, game, this);
			else
				return new ClickOnProperty(listener, pos, windowSize, size, name, game,this);
		else
			return new DefaultClickAction(listener, pos, windowSize, size, name, game);
		
	}

	public String getColor() {
		return this.color;
	}

	public int getNbHouse() {
		return nbHouses;
	}
	public void addHouse(){
		nbHouses++;
	}
	public void removeHouse(){
		nbHouses--;
	}
	

}
