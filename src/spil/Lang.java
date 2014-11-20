package spil;

import java.util.Locale;
import java.util.ResourceBundle;

public class Lang {
	
	public static ResourceBundle messages;
	
	public void setLang(){
		Locale currentLocale = new Locale("da", "DK");
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	}
	

}
