/**
 * This DelayText class is a utility class that has methods to use for delaying text in the terminal.
 * @author Lily You
 * @version 1.6 2025/05/05
 */
public final class DelayText {
	/**
	 * Private constructor to prevent object creation
	 */
    private DelayText(){

    }

	//Googled how to delay text in java - Source: https://mrparkonline.gitbook.io/guide-to-high-school-computer-science/java-essentials/delayed-output-in-java 
	/**
	 * This is a method that prints the text and delays it in the terminal
	 * @param text the string that is being printed
	 * @param millis the amount of time the text is being delayed in milliseconds
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

	/**
	 * This is a method that prints a student object and delays the next output in the terminal
	 * @param student the Student object that is being printed
	 * @param millis the amount of time the next output is being delayed in milliseconds
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

	/**
	 * This method prints a device object and delays the next output in the terminal
	 * @param device the Device object that is being printed
	 * @param millisthe the amount of time the next output is being delayed in milliseconds
	 */
	public static void print(Device device, int millis){
        try{
			System.out.println(device);
			Thread.sleep(millis);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
    }

	/**
	 * This method prints a string and delays the next output in the terminal. The next print will continue on the same line
	 * @param text The String of text that is being printed
	 * @param millis The amount of time that the next out put is being delayed in milliseconds
	 */
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
