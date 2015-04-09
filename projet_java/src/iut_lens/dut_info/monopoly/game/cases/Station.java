package iut_lens.dut_info.monopoly.game.cases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.Player;
import iut_lens.dut_info.monopoly.game.cases.action.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.cases.action.FallOnFreeProperty;
import iut_lens.dut_info.monopoly.game.cases.action.OnFallOnOwnedProperty;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Station extends Buyable{
	
	private static final String filePath = "Projet/Cartes/Gare/";
	
	private int price;

	private List<Long> loyer;

	private int hypothequeTerrain;
	
	public Station(Board board, String name) {
		super(board, name);
		loadData();
		// TODO Auto-generated constructor stub
	}
	
	
	private void loadData(){
		try {
			// read the json file
			FileReader reader = new FileReader(filePath+name+".js");

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			
			String nom = (String) jsonObject.get("nom");
			//System.out.println("Carte : " + nom);
			

			price = Util.longToInt((long) jsonObject.get("prixAchat"));
			//System.out.println("La casse coute : " + achat);


			loyer = (JSONArray) jsonObject.get("loyer");
			
			for(int i=0; i<loyer.size(); i++){
				//System.out.println("le loyer pour " + i + " gare est de : "+loyer.get(i));
			}
			
			hypothequeTerrain =  Util.longToInt((long) jsonObject.get("valeurHypotheque"));
			//System.out.println("L'hypotheque du terrain est de : " + ht);

			
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
		return  Util.longToInt(this.loyer.get(0));
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
