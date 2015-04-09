package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.Player;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Company extends Buyable {
	
	private static final String filePath = "Projet/Cartes/Entreprise/";
	
	
	private int price;
	
	

	private int hypothequeTerrain;

	
	public Company(Board board, String name) {
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

			
			hypothequeTerrain =  Util.longToInt((long) jsonObject.get("valeurHypotheque"));
			
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
		return  Util.longToInt(4*board.getGame().getDicesValue());
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
