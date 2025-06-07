import java.io.*;
import java.util.*;
public class Main {
	int numOfWins;
	public static void main(String args[]) {
		MrKalisz kalisz = new MrKalisz();
		boolean gameStart = false;
		boolean inClassroom = false;
		boolean inTechCom = false;
		Scanner in = new Scanner(System.in);
		//image of Mr.Kalisz
		DelayText.print("Welcome to Mr.Kalisz Simulator", 2000);
		System.out.print("Type start to begin the game: ");
		String startAns = in.nextLine();
		if(startAns.equalsIgnoreCase("start")){
			gameStart = true;
		}
		//image of car driving

		//Game only starts if the player types start and initates it
		while(gameStart){
			//image of classroom
			DelayText.print("First on your schedule, go to your classroom!", 2000);
			inClassroom = true;
			//Only runs if Mr.Kalisz is in the classroom
			while(inClassroom){
				Classroom classroomTasks = new Classroom(in);
				DelayText.print("Here's the list of tasks to do in your classroom, you get to choose two: \n1. Do attendance - Energy Cost: 10 \n2. Answer Questions - Energy Cost: 5 \n3. Mark Tests - Energy Cost: 15 \n--------------------------------------------", 5000); // say each energycost beside i t
				for(int i = 0; i < 2; i++){
					if(i == 0){
						System.out.print("What's the first task you want to do? Enter the number: ");
					}
					else{
						System.out.print("What's the second task you want to do? Enter the number: ");
					}
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
						break;
					   }
					}
					if(kalisz.getEnergy() <= 0){
						DelayText.print("Energy is 0, you have lost the game!", 2000);
						inClassroom = false;
						gameStart = false;
						break;
					}
					else{
						DelayText.print("Current Energy: " + kalisz.getEnergy(), 2000);
					}
				}
				DelayText.print("After a full day in class, it's time to head to Tech Committee!", 2000);
				inTechCom = true;
				inClassroom = false;
			}

			while(inTechCom){
				TechCom techcom = new TechCom(in);
				DelayText.print("\nHere's the list of tasks to do in Tech Committee, you get choose two: \n1. Device Checking - Energy Cost: 15 \n2. Projector Checking - Energy Cost: 10 \n3. Missing Components - Energy Cost: 5 \n--------------------------------------------", 5000);
				for(int i = 0; i < 2; i++){
					if(i == 0){
						System.out.print("What's the first task you want to do? Enter the number: ");
					}
					else{
						System.out.print("What's the second task you want to do? Enter the number: ");
					}
					int taskNum = in.nextInt();
					in.nextLine(); //consume new line
					if(taskNum == 1){
						techcom.deviceCheckTask(kalisz);
					}
					else if(taskNum == 2){ //insert projector checking

					}
					else if(taskNum == 3){ //insert missing component

					}
					else{
						if(kalisz.getEnergy() <= 0){
							DelayText.print("Energy is 0, you have lost the game!", 2000);
							inTechCom = false;
							gameStart = false;
							break;
						}
						else{
							DelayText.print("No task selected. Tech Committee exited", 2000);
							break;
						}
					}
				}
				DelayText.print("Finally, the best part of the day, to go home!", 2000);
				DelayText.print("Current Energy: " + kalisz.getEnergy(), 2000);
				inTechCom = false; //exits the inTechCom loop
			}
			System.out.print("Type 'stop' to end the game: ");
			String endAns = in.nextLine();
			if(endAns.equalsIgnoreCase("stop")){
				gameStart = false;
			}
			else{
				DelayText.print("Game is continuing...", 2000);
				DelayText.print("Another day, another day at school", 2000);
				//image of the car on the road
			}
			

	}

	public static int getWins(){
		//create a fileWriter
		FileReader inputStream = null;
		int num = 0;
		try {
			inputStream = new FileReader("winsFile.txt");
			int c;
			String numStr = "";
			while((c = inputStream.read()) != -1){
				numStr = numStr + (char)c;
				num = Integer.parseInt(numStr);
			}
		} catch (IOException e){
			System.out.println(e);
		} finally {
			if (inputStream != null) { //close the file, if its open
				inputStream.close();
			}
		}
		return num;
	}
}

