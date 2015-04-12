package is.hi.f2a.tests;

import java.util.Random;

public class PlayerMock implements PlayerInterface {

	private String name;
	private String team;
	private PositionMock position;
	private String positionName;
	private Double price;
	
<<<<<<< HEAD
	/*
	 * Constructor
	 */
	public PlayerMock(String name, Position pos){
		this.name = name;
<<<<<<< HEAD
<<<<<<< HEAD
		this.position = goalkeeper;
=======
	public PlayerMock(String name, String pos){
		this.name = name;
		this.positionName = pos;
>>>>>>> parent of 74cfc3e... push to pull
=======
		this.position = pos;
>>>>>>> parent of 64162c5... more changes for the integration
=======
		this.position = pos;
>>>>>>> parent of 64162c5... more changes for the integration
		
		Random randomno = new Random();
		this.price = randomno.nextDouble()*1000;
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
	
	public Double getPrice() {
		return this.price;
	}
	
}
