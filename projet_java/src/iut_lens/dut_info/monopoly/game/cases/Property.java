package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.JSONLoader;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.Player;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsfml.system.Vector2f;

public class Property extends Case implements ActionListener{
	
	private Player owner = null;
	
	private Property[] otherProperty;
	
	private CaseFallOnActionPopUp popUp = null;
	
	private PropertyData data;

	public Property(Board board, String name) {
		super(board, name);

		//data = JSONLoader.loadPropertyData(name);
		// TODO A changer
		
		final String filePath = "Projet/Proprietes/BleuFonce/notreDameDeParis.js";
		
		// final String filePath = "Projet/Proprietes/"+name;
		
		try {
			// read the json file
			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			String nom = (String) jsonObject.get("nom");
			System.out.println("Carte : " + nom);
			

			String achat = (String) jsonObject.get("prixAchat");
			System.out.println("La casse coute : " + achat);


			JSONArray loyer= (JSONArray) jsonObject.get("loyer");
			
			for(int i=0; i<loyer.size(); i++){
				System.out.println("le loyer pour " + i + " batiment est de : "+loyer.get(i));
			}
			
			
			// get a number from the JSON object
			long pa =  (long) jsonObject.get("prixAppartement");
			System.out.println("Le prix de l'appartement est de : " + pa);
			
			long ph =  (long) jsonObject.get("prixHotel");
			System.out.println("Le prix de l'hotel est de : " + ph);
			
			long ht =  (long) jsonObject.get("hypothequeTerrain");
			System.out.println("L'hypotheque du terrain est de : " + ht);

			
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
	public CaseFallOnActionPopUp onFallOn(Vector2f size, Vector2f windowSize, Vector2f pos, Game game) {
		// if(owner == null)return new FallOnFreeProperty(this,new Vector2f(0.5f,0.3f),board.getGame().getWindowSize(),new Vector2f(400,600),this);
		if(owner == null)return new FallOnFreeProperty(this, pos, windowSize, size, this, game);
		
		return null;
	}

	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub
		
	}

}
