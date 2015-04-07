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
	public Integer getPrice();
	public Position getPosition();
}
