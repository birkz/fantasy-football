package tests;

import java.util.Arrays;
import java.util.List;

public class PlayerMock implements PlayerInterface {

	private static String name;
	private static PositionMock position;
	
	public static String getName(){
		return name;
	}
	
	@Override
	public boolean setPosition(PositionMock pos){
		
	}
	
	@Override
	public PositionMock getPosition() {
		return position;
	}
	
	@Override
	public String getPositionName() {
		return position.getNameOfPos();
	}
	
	

}
