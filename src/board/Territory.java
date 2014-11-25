package board;

public class Territory extends Ownable {
	
	private int rent;
	

	
	public Territory(String name, int price, int rent) {
		
		super(name, price);
		this.rent = rent;
	
	
	}
	
	@Override
	public int getRent() {
		
		return rent;
	}
	
		

}

	

