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
			// brug taxAmount
			player.withdraw(taxAmount);
		} else {
			int taxratetopay = player.getBalance() / 100 * 10;
			String taxRateChoiceString;
			boolean taxRateBool = false;

			// Spørg om man vil betale taxRate eller taxAmount
			taxRateChoiceString = GUI
					.getUserButtonPressed(
							"Du skal betale skat. Vil du betale en fast takst eller 10% af din pengebeholdning?",
							"Fast takst" + taxAmount, "10 % af dine penge"
									+ taxratetopay);
			// Find ud af hvilken knap der bliver trykket på, og udfør withdraw
			// efter hvad der bliver valgt.
			taxRateBool = taxRateChoiceString.equals("Fast takst" + taxAmount);

			if (taxRateBool = true) {
				player.withdraw(taxAmount);
			} else
				player.withdraw(taxratetopay);
		}

	}
}