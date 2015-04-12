package is.hi.f2a.tests;

public class InvalidPosition extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPosition() {}

      //Constructor that accepts a message
      public InvalidPosition(String message)
      {
         super(message);
      }
}
