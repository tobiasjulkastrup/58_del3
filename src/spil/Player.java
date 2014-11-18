package spil;

public abstract class Player {
	private String name, token;
	public Player(){

	}
	public Player (String owner,String piece)
	{
		name = owner;
		token = piece;
	}

	public String getToken(){
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//-----------------------------------------------------------------
	//  Retunerer adresse objektet som en string
	//-----------------------------------------------------------------
	public String toString()
	{
		String result;
		result = name+"\t "+ token;
		return result;
	}
}