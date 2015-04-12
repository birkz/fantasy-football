package is.hi.f2a.tests;

/**
 *  This is a interface for a class that group F1a will create.
 */

public interface PlayerInterface {
	public enum Position {
        GOALKEEPER,
        DEFENDER,
        MIDFIELDER,
        FORWARD
    }
	public String getName();
	public void setPosition(PositionMock pos) throws InvalidPosition;
	public PositionMock getPosition();
	public String getPositionName();
	public Double getPrice();
}
