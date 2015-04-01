package iut_lens.dut_info.monopoly.game.cases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Company extends Case {
	
	private static final String filePath = "Projet/Cartes/Entreprise/";

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
			System.out.println("Carte : " + nom);
			

			long achat = (long) jsonObject.get("prixAchat");
			System.out.println("La casse coute : " + achat);

			
			long ht =  (long) jsonObject.get("valeurHypotheque");
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
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public CaseFallOnActionPopUp onFallOn(Vector2f size, Vector2i windowSize,
			Vector2f pos, Game game) {
		// TODO Auto-generated method stub
		return null;
	}

}
