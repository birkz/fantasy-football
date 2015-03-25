package tests;

import java.util.Arrays;
import java.util.List;

public class PositionMock implements PositionInterface {
	
	private String position;
	private List<String> valid_positions = Arrays.asList("Goalkeeper","Defender","Midfielder","Striker");
	
	public PositionMock(String pos) throws InvalidPosition {
		if (valid_positions.contains(pos)){
			this.position = pos;
		} else {
			throw new InvalidPosition(pos+" is not a valid position. Only Goalkeeper, Defender, Midfielder, and Striker are valid.");
		}
	}
	
	@Override
	public String getNameOfPos() {
		return position;
	}

}
