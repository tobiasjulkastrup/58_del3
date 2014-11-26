package board;

public class LaborCamp extends Ownable  {
	
	private int price;
	
	public LaborCamp(String name, int price) {
		
		super(name, price);
		
		this.price = price;

	}

	private int baseRent;

	@Override
	public int getRent() {
		// TODO Auto-generated method stub
		return 0;
	}

}
