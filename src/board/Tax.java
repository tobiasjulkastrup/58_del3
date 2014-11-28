package board;

import spil.ICO;
import spil.Player;
import boundaryToMatador.GUI;

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

			player.withdraw(taxAmount);

		} else {
			int taxratetopay = player.getBalance() / 100 * 10;
			String taxRateChoiceString;
			boolean taxRateBool = false;

			taxRateChoiceString = GUI.getUserButtonPressed(
					ICO.messages.getString("youHaveToPayTax"),
					ICO.messages.getString("defaultRate") + taxAmount + ")",
					ICO.messages.getString("10percent") + taxratetopay + ")");

			taxRateBool = taxRateChoiceString.equals(ICO.messages
					.getString("defaultRate") + taxAmount + ")");

			if (true == taxRateBool) {
				player.withdraw(taxAmount);
				GUI.showMessage(ICO.messages.getString("yourTaxChoice")
						+ ICO.messages.getString("defaultRate") + taxAmount
						+ ")");
			} else {
				player.withdraw(taxratetopay);
				GUI.showMessage(ICO.messages.getString("yourTaxChoice")
						+ ICO.messages.getString("10percent") + taxratetopay
						+ ")");
			}
		}

	}
}