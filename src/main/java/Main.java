import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
	int numOfWins;
	private static final String winsPath = "winsFile.txt";
	public static void main(String args[]) throws IOException{
		int numOfWins = getWins();
		boolean gameStart = true;
		boolean playAgain = false;
		Scanner in = new Scanner(System.in);
		while(gameStart){
			MrKalisz kalisz = new MrKalisz(); //new instance so the energy refreshes
			boolean inClassroom = false;
			boolean inTechCom = false;
			//image of Mr.Kalisz
			if(!playAgain){
				//ASCIIArt.kaliszAvatar();
				DelayText.print("Welcome to Mr.Kalisz Simulator!", 2000);
				if(numOfWins == 1){
					DelayText.print("You have " + numOfWins + " win!", 2000);
				}else{
					DelayText.print("You have " + numOfWins + " wins!", 2000);
				}
				System.out.print("Type 'start' to begin the game: ");
				String startAns = in.nextLine();
				if(!startAns.equalsIgnoreCase("start")){
					System.out.println("Game exited.");
					gameStart = false;
					break;
				}
			}
			DelayText.print("\nFirst on your schedule, go to your classroom!", 2500);
			//image of classroom
			inClassroom = true;
			//Only runs if Mr.Kalisz is in the classroom
			while(inClassroom){
				Classroom classroomTasks = new Classroom(in);
				DelayText.print("Here's the list of tasks to do in your classroom, you get to choose two: \n1. Do attendance - Energy Cost: 10 \n2. Mark Tests - Energy Cost: 5 \n3. Answer Questions - Energy Cost: 5 \n--------------------------------------------", 1000); // say each energycost beside i t
				DelayText.print("Note: The energy cost represents each time you do something incorrectly IN the task", 3000);
				for(int i = 0; i < 2; i++){
					if(i == 0){
						System.out.print("What's the first task you want to do? Enter the number: ");
					}
					else{
						System.out.print("What's the second task you want to do? Enter the number: ");
					}
					int taskNum = in.nextInt();
					in.nextLine();
					if(taskNum == 1){
						classroomTasks.attendanceTask(kalisz);
					}
					else if(taskNum == 2){ 
						classroomTasks.markTestTask(kalisz);
					}
					else if(taskNum == 3){ 
						classroomTasks.answerQuestionTask(kalisz);
					}
					else{
						DelayText.print("No task selected.", 2000);
						continue;
					}
					if(kalisz.getEnergy() <= 0){
					DelayText.print("\nEnergy is 0, you have lost the game!", 2000);
					inClassroom = false;
					break;
					}
					else{
					DelayText.print("Current Energy: " + kalisz.getEnergy(), 2000);
					}
				}
				inClassroom = false;
			}
			if(kalisz.getEnergy() > 0){
				System.out.println("Classroom exited.");
				DelayText.print("\nAfter a full day in class, it's time to head to Tech Committee!", 2000);
				inTechCom = true;
			}
			while(inTechCom){
				TechCom techcom = new TechCom(in);
				DelayText.print("Here's the list of tasks to do in Tech Committee, you get to choose two: \n1. Device Checking - Energy Cost: 15 \n2. Projector Checking - Energy Cost: 5 \n3. Missing Components - Energy Cost: 5 \n--------------------------------------------", 1000);
				DelayText.print("Note: The energy cost represents each time you do something incorrectly IN the task", 3000);
				for(int i = 0; i < 2; i++){
					if(i == 0){
						System.out.print("What's the first task you want to do? Enter the number: ");
					}
					else{
						System.out.print("What's the second task you want to do? Enter the number: ");
					}
					int taskNum = in.nextInt();
					in.nextLine();
					if(taskNum == 1){
						techcom.deviceCheckTask(kalisz);
					}
					else if(taskNum == 2){
						techcom.projectorCheckTask(kalisz);
					}
					else if(taskNum == 3){ 

					}
					else{
						DelayText.print("No task selected.", 2000);
						continue;
					}
					if(kalisz.getEnergy() <= 0){
						DelayText.print("\nEnergy is 0, you have lost the game!", 2000);
						inTechCom = false;
						break;
					}
					else{
						DelayText.print("Current Energy: " + kalisz.getEnergy(), 2000);
					}
				}
				inTechCom = false; //exits the inTechCom loop
			}
			if(kalisz.getEnergy() > 0){
				System.out.println("Tech Committee Exited.");
				DelayText.print("\nFinally, the best part of the day, to go home!", 2000);
				DelayText.print("You ended the day with " + kalisz.getEnergy() + " energy!", 2000);
				setWins(numOfWins + 1);
				numOfWins += 1;
				DelayText.print("You now have " + numOfWins + " wins!", 2000);
			}
			System.out.print("Type 'stop' to end the game or 'again' to play again: ");
			String endAns = in.nextLine();
			if(endAns.equalsIgnoreCase("again")){
				DelayText.print("Game is continuing...", 2000);
				DelayText.print("Another day, another day at school...", 2000);
				gameStart = true;
				playAgain = true;
				//image of the car on the road
			}
			else{
				gameStart = false; //if they input stop or anything that isn't again, the game will just exit
			}
			}
		}

	public static int getWins() throws IOException {
		//create a fileWriter
		FileReader inputStream = null;
		int num = 0;
		try {
			inputStream = new FileReader(winsPath);
			int c;
			String numStr = "";
			while((c = inputStream.read()) != -1){
				numStr = numStr + (char)c;
				num = Integer.parseInt(numStr);
			}
		} catch (IOException e){
			System.out.println(e);
		} finally {
			try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing the file.");
            }
		}
		return num;
	}
	//Source: https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
	public static void setWins(int wins){
		FileWriter writer = null;
        try {
            writer = new FileWriter(winsPath, false);
            writer.write(Integer.toString(wins));
        } catch (IOException e) {
            System.out.println("Error while writing to the file.");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing the file.");
            }
        }
	}
}

