package board;

import boundaryToMatador.GUI;
import spil.ICO;
import spil.Player;

public class Tax extends Field {
	private int taxAmount;
	private int taxRate;
	
	public Tax(String name, int taxAmount, int taxRate) {
		super(name);
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
		
	}
	
	
	
	@Override
	public void landOnField(Player player) {
		
		if (taxRate < 0) { 
			//brug taxAmount
			player.withdraw(taxAmount);
		}
		else
			//Udregn taxRate ud fra gem i int variable
			player.getBalance();
			//Spørg om man vil betale taxRate eller taxAmount
			GUI.getUserButtonPressed("taxChoice", "Tax Rate", "TaxAmount")
			//Find ud af hvilken knap der bliver trykket på, og udfør withdraw efter hvad der bliver valgt.
	}
	
}
