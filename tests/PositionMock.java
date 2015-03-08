package tests;

public class PositionMock implements PositionInterface {
	
	private String position;
	
	public PositionMock(String pos) {
		this.position = pos;
	}
	
	@Override
	public String getPosition() {
		return position;
	}

}
