import java.io.IOException;
import java.util.Scanner;
public class Main {
	int numOfWins;
	public static void main(String args[]) throws IOException{
		int numOfWins = FileIO.getWins();
		boolean gameStart = true;
		boolean playAgain = false;
		Scanner in = new Scanner(System.in);
		while(gameStart){
			//Taking into account a new instance so the energy refreshes
			MrKalisz kalisz = new MrKalisz();
			boolean inClassroom = false;
			boolean inTechCom = false;
			//Only say these prompts if it's the first time the player is playing
			if(!playAgain){
				DelayText.print("Welcome to Mr.Kalisz Simulator!", 2000);
				if(numOfWins == 1){
					DelayText.print("You have " + numOfWins + " win!", 2000); //shouldnt this be said either way though... jathav fix
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
			inClassroom = true;

			//Only runs if Mr.Kalisz is in the classroom
			while(inClassroom){
				Classroom classroomTasks = new Classroom(in);
				//Says all the tasks that he can do in the classroom
				DelayText.print("Here's the list of tasks to do in your classroom, you get to choose two: \n1. Do attendance - Energy Cost: 10 \n2. Mark Tests - Energy Cost: 5 \n3. Answer Questions - Energy Cost: 5 \n--------------------------------------------", 1000); // say each energycost beside i t
				DelayText.print("Note: The energy cost represents each time you do something incorrectly IN the task", 3000);
				//Makes sure the player can only play two tasks in one run
				for(int i = 0; i < 2; i++){
					//Asks the user to input which task based on the number they are ordered in
					if(i == 0){
						System.out.print("What's the first task you want to do? Enter the number: ");
					}
					else{
						System.out.print("What's the second task you want to do? Enter the number: ");
					}
					//check if it is actually an integer
					if(in.hasNextInt()){
						int taskNum = in.nextInt();
						in.nextLine();
						//Runs the specified task
						if(taskNum == 1){
							classroomTasks.attendanceTask(kalisz);
						}
						else if(taskNum == 2){ 
							classroomTasks.markTestTask(kalisz);
						}
						else if(taskNum == 3){ 
							classroomTasks.answerQuestionTask(kalisz);
						}
						//If none, continues to the next loop
						else{
							DelayText.print("No task selected.", 2000);
							continue;
						}
					}else{
						DelayText.print("No task selected.", 2000);
						continue;
					}
					//Checks if the energy is 0, you have lost the game
					if(kalisz.getEnergy() <= 0){
						DelayText.print("\nEnergy is 0, you have lost the game!", 2000);
						inClassroom = false;
						break;
					}
					//Displays current energy otherwise
					else{
						DelayText.print("Current Energy: " + kalisz.getEnergy(), 2000);
					}
				}
				//Exits classroom
				inClassroom = false;
			}

			//Checks if the player is still alive, say the prompts below
			if(kalisz.getEnergy() > 0){
				System.out.println("Classroom exited.");
				DelayText.print("\nAfter a full day in class, it's time to head to Tech Committee!", 2000);
				inTechCom = true;
			}

			//Only runs if Mr.Kalisz is in Tech Committee
			while(inTechCom){
				TechCom techcom = new TechCom(in);
				DelayText.print("Here's the list of tasks to do in Tech Committee, you get to choose two: \n1. Device Checking - Energy Cost: 15 \n2. Projector Checking - Energy Cost: 5 \n3. Missing Components - Energy Cost: 5 \n--------------------------------------------", 1000);
				DelayText.print("Note: The energy cost represents each time you do something incorrectly IN the task", 3000);
				//Makes sure the player can only play two tasks in one run
				for(int i = 0; i < 2; i++){
					if(i == 0){
						System.out.print("What's the first task you want to do? Enter the number: ");
					}
					else{
						System.out.print("What's the second task you want to do? Enter the number: ");
					}
					//check if it is actually an integer
					if(in.hasNextInt()){
						int taskNum = in.nextInt();
						in.nextLine();
						if(taskNum == 1){
							techcom.deviceCheckTask(kalisz);
						}
						else if(taskNum == 2){
							techcom.projectorCheckTask(kalisz);
						}
						else if(taskNum == 3){ 
							techcom.missingComponentTask(kalisz);
						}
						else{
							DelayText.print("No task selected.", 2000);
							continue;
						}
					}else{
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
				//Exits the inTechCom loop
				inTechCom = false; 
			}

			//Checks if player is still alive
			if(kalisz.getEnergy() > 0){
				System.out.println("Tech Committee Exited.");
				DelayText.print("\nFinally, the best part of the day, to go home!", 2000);
				DelayText.print("You ended the day with " + kalisz.getEnergy() + " energy!", 2000);
				FileIO.setWins(numOfWins + 1);
				numOfWins += 1;
				DelayText.print("You now have " + numOfWins + " wins!", 2000);
			}

			//Replay game prompts
			System.out.print("Type 'stop' to end the game or 'again' to play again: ");
			String endAns = in.nextLine();
			//Continues the game if the user wants to play again
			if(endAns.equalsIgnoreCase("again")){
				DelayText.print("Game is continuing...", 2000);
				DelayText.print("Another day, another day at school...", 2000);
				gameStart = true;
				playAgain = true;
			}
			else{
				//If they input stop or anything that isn't again, the game will just exit
				gameStart = false; 
			}
		}
	}
}

