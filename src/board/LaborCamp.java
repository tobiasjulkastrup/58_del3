package board;

public class LaborCamp extends Ownable  {
	
	private String name = null;
	private int price;
	
	public LaborCamp(String name, int price) {
		super(name);
		
		this.name = name;
		this.price = price; 

		
	}

	private int baseRent;

	@Override
	public int getRent() {
		// TODO Auto-generated method stub
		return 0;
	}

}
