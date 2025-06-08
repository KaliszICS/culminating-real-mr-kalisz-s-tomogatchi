
//Using a utility class because we want every class to be able to access delay text without having to create an instance of the class everytime
public final class DelayText {
    private DelayText(){
    }
    
    //Googled how to delay text in java - Source: https://mrparkonline.gitbook.io/guide-to-high-school-computer-science/java-essentials/delayed-output-in-java 
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
