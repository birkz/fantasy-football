package is.hi.f2a.tests;

import java.util.Random;

public class PlayerMock implements PlayerInterface {

	private String name;
	private String team;
	private Integer price;
	private Position position;
	
	/*
	 * Constructor
	 */
	public PlayerMock(String name, Position pos){
		this.name = name;
		this.position = pos;
		
		Random randomno = new Random();
		Double price = randomno.nextDouble()*1000;
		this.price = price.intValue();
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getTeam() {
		return this.team;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	public Position getPosition() {
        return position;
    }
	
	public void setPosition(Position pos) {
        this.position = pos;
    }
}
