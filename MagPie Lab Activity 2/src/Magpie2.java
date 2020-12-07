/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
	String response = "";
		if (statement.trim().equals("")) {
			response = "Please say something.";
		}else if (statement.indexOf("no") >= 0){
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("dog") >= 0
				|| statement.indexOf("cat") >= 0
				|| statement.indexOf("parrot") >= 0
				|| statement.indexOf("fish") >= 0)
		{
			response = "Tell me more about your pets.";
		}
		else if (statement.indexOf("David") >= 0
				|| statement.indexOf("Domingo") >= 0
				|| statement.indexOf("Mr. David") >= 0
				|| statement.indexOf("Domingo David") >= 0)
		{
			response = "Dang. Your teacher must be the best, and so are you.";
		}
		else if (statement.indexOf("Minecraft") >= 0
				|| statement.indexOf("osu!") >= 0
				|| statement.indexOf("Valorant") >= 0
				|| statement.indexOf("Roblox") >= 0)
		{
			response = "Dang. You must be a master gamer.";
		}
		else if (statement.indexOf("Math") >= 0
				|| statement.indexOf("Spanish") >= 0
				|| statement.indexOf("English") >= 0
				|| statement.indexOf("CS") >= 0)
		{
			response = "Darn. What other classes are you taking?";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}
}
