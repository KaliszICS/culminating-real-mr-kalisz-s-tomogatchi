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
	 * @param text the text that is being printed
	 * @param millis the amount of time the next output is being delayed in milli second
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
	 * This is a method that print a student object and delay the next output in the terminal
	 * @param student the student object that is being printed
	 * @param millis the amount of time the next output is being delayed in milli seconds
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
	 * This method print a device object and delay the next output in the terminal.
	 * @param device the device object that is being printed.
	 * @param millisthe the amount of time the next output is being delayed in milliseconds.
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
	 * This method print a string and delay the next output in the terminal. The next print will continue on the same line.
	 * @param text The text that is being printed.
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
