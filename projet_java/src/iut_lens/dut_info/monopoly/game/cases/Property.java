package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.Player;

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

public class Property extends Case implements ActionListener{
	
	private Player owner = null;
	
	private Property[] otherProperty;
	
	private static final String filePath = "Projet/Cartes/Proprietes/";
	
	private int price;

	private int prixAppartement;

	private int prixHotel;
	
	private int nbHouses = 0;

	private List<Long> loyer;

	private int hypothequeTerrain;

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

			String couleur = (String) jsonObject.get("couleur");
			//System.out.println("Couleur : " + couleur);
			
			String nom = (String) jsonObject.get("nom");
			//System.out.println("Carte : " + nom);
			

			this.price = Util.longToInt((long) jsonObject.get("prixAchat"));


			this.loyer = ((JSONArray) jsonObject.get("loyer"));
			
			
			// get a number from the JSON object
			this.prixAppartement =  Util.longToInt((long) jsonObject.get("prixAppartement"));
			
			this.prixHotel =  Util.longToInt((long) jsonObject.get("prixHotel"));
			
			this.hypothequeTerrain =  Util.longToInt((long) jsonObject.get("hypothequeTerrain"));

			
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
	
	

	@Override
	public CaseFallOnActionPopUp onFallOn(Vector2f size, Vector2i windowSize, Vector2f pos, Game game) {
		if(owner == null)return new FallOnFreeProperty(game.getListener(), pos, windowSize, size, this, game);
		
		return new OnFallOnOwnedProperty(game.getListener(), pos, windowSize, size, this, game);
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

	//TODO changer la couleur de la case et tout et tout
	public void setOwner(Player player) {
		this.owner = player;
		this.setColor(player.getColor());
		
	}
	
	public Player getOwner(){
		return owner;
	}

}
