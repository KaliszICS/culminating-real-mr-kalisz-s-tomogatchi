import java.util.Scanner;
public class Main {
	int numOfWins;
	public static void main(String args[]) {
		MrKalisz kalisz = new MrKalisz();
		boolean gameStart = false;
		boolean inClassroom = false;
		boolean inTechCom = false;
		Scanner in = new Scanner(System.in);
		DelayText.print("Welcome to Mr.Kalisz Simulator", 2000);
		System.out.print("Type start to begin the game: ");
		String startAns = in.nextLine();
		if(startAns.equalsIgnoreCase("start")){
			gameStart = true;
		}

		//Game only starts if the player wants to
		while(gameStart){
			DelayText.print("First on your schedule, go to your classroom!", 2000);
			inClassroom = true;
			//Only runs if Mr.Kalisz is in the classroom
			while(inClassroom){
				Classroom classroomTasks = new Classroom(in);
				DelayText.print("Here's the list of tasks to do in your classroom, you will choose two: \n1. Do attendance - Energy Cost: 10 \n2. Answer Questions - Energy Cost: 5 \n3. Mark Tests - Energy Cost: 20 \n--------------------------------------------", 5000); // say each energycost beside i t
				for(int i = 0; i < 2; i++){
					System.out.print("Which task do you want to do? Enter the number: ");
					int taskNum = in.nextInt();
					in.nextLine(); //consume new line
					if(taskNum == 1){
						classroomTasks.attendanceTask(kalisz);
					}
					else if(taskNum == 2){ //insert markingTest

					}
					else if(taskNum == 3){ //insert answerQuestion

					}
					else{
						DelayText.print("No task selected. Classroom exited", 2000);
						inClassroom = false; //exits the inClassroom loop
						break;
					}
				}
				System.out.print("After a full day in class, it's time to head to Tech Committee!");
				inTechCom = true;
				inClassroom = false;
			}

			while(inTechCom){

			}
			System.out.print("Type stop to end the game: ");
			String endAns = in.nextLine();
			if(endAns.equalsIgnoreCase("stop")){
				gameStart = false;
			}

		}
		
	}
}
