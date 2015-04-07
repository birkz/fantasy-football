package is.hi.f2a.tests;

public class InvalidPlayer extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPlayer() {}

      //Constructor that accepts a message
      public InvalidPlayer(String message)
      {
         super(message);
      }
}
