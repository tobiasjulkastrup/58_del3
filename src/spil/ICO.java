package spil;

import java.util.Locale;
import java.awt.Color;
import java.util.ResourceBundle;
import boundaryToMatador.GUI;

public class ICO { // Interface Controller Object

	public static ResourceBundle messages;

	public void setLang(String lang, String region) {
		Locale currentLocale = new Locale(lang, region);
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	}

	public void setGUI() {
		GUI.create(messages.getString("fieldsForGUI")); // "fieldsForGUI.txt";
		System.out.println(messages.getString("startMessageTUI")); // "GUI will start in 3.. 2.. 1.."
	}

	public void setNewPlayerGUI(String name, int balance, Color color) {
		GUI.addPlayer(name, balance, color);
	}
}
