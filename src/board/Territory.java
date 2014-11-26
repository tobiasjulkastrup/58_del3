package board;

public class Territory extends Ownable {

	private int price;
	private int rent;

	public Territory(String name, int price, int rent) {

		super(name, price);
		this.price = price;
		this.rent = rent;

	}

	@Override
	public int getPrice() {

		return price;

	}

	@Override
	public int getRent() {

		return rent;
	}

}
