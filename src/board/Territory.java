package board;

public class Territory extends Ownable {
	
	private String name = null;
	private int price;
	private int rent;
	

	
	public Territory(String name, int price, int rent) {
		super(name);

	this.name = name;
	this.price = price; 
	this.rent = rent;
	
	
	}
	
	@Override
	public int getRent() {
		
		return rent;
	}
	
		

}

	

