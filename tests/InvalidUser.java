package tests;

public class InvalidUser extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidUser() {}
	
		public InvalidUser(String message) {
			super(message);
		}

}