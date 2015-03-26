package tests;

import java.util.Random;

public class PlayerMock implements PlayerInterface {

	private String name;
	private String team;
	private PositionMock position;
	private String positionName;
	private Integer price;
	
	public PlayerMock(String name, String pos){
		this.name = name;
		this.positionName = pos;
		
		Random randomno = new Random();
		Double price = randomno.nextDouble()*1000;
		this.price = price.intValue();
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public String getPositionName() {
		return this.positionName;
	}
	
	@Override
	public void setPosition(PositionMock pos) throws InvalidPosition{
		if (pos.equals("Goalkeeper") || pos.equals("Defender") || pos.equals("Midfielder") || pos.equals("Striker")){
			this.position = pos;
		} else {
			throw new InvalidPosition(pos+" is not a valid position. Only Goalkeeper, Defender, Midfielder, and Striker are valid.");
		}
	}
	
	@Override
	public PositionMock getPosition() {
		return position;
	}
	
	public String getTeam() {
		return this.team;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
}
