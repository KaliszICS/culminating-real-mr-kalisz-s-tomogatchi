//Using a utility class because we want every class to be able to access delay text without having to create an instance of the class everytime
/**
 * It creates a method to use for delaying text in the terminal.
 * @author Lily You
 * @version 1.6 2025/05/05
 */
public final class DelayText {
    private DelayText(){
    }
	 //Googled how to delay text in java - Source: https://mrparkonline.gitbook.io/guide-to-high-school-computer-science/java-essentials/delayed-output-in-java 
	/**
	 * This is a method that print the text and delay it in the terminal
	 * @param text show the string that is being printed
	 * @param millis the amount of time the text is being delayed in milli second
	 */
	public static void print(String text, int millis){
		try{
			System.out.println(text);
			Thread.sleep(millis);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
    //Overloading
	/**
	 * This is a method that print the student object and delay it in terminal
	 * @param student show the St
	 * @param millis
	 */
    public static void print(Student student, int millis){
        try{
			System.out.println(student);
			Thread.sleep(millis);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
    }

	public static void print(Device device, int millis){
        try{
			System.out.println(device);
			Thread.sleep(millis);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
    }

	public static void printSameLine(String text, int millis){
		try{
			System.out.print(text);
			Thread.sleep(millis);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
