package spil;

import java.util.Locale;
import java.util.ResourceBundle;
import boundaryToMatador.GUI;

public class ICO { //Interface Controller Object
	
	public static ResourceBundle messages;
	
	public void setLang(){
		Locale currentLocale = new Locale("da", "DK");
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	}
	
	public void setGUI() {
		GUI.create("fieldsForGUI.txt");
		System.out.println("GUI will start in 3.. 2.. 1..");
	}

}
