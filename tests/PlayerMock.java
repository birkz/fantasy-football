package tests;

public class PlayerMock implements PlayerInterface {

	private String name;
	private PositionMock position;
	private String positionName;
	
	public PlayerMock(String name, String pos){
		this.name = name;
		this.positionName = pos;
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
	
}
