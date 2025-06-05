import java.util.Scanner;
public class Main {
	int numOfWins;
	public static void main(String args[]) {
		DelayText.print("Welcome to Mr.Kalisz Simulator", 2000);
		DelayText.print("First on your schedule, go to your classroom!", 2000);
		DelayText.print("Here's the list of tasks to do in your classroom: \nDo attendance - Energy Cost: 10 \nAnswer Questions - Energy Cost: 5 \nMark Tests - Energy Cost: 20 \n--------------------------------------------", 5000); // say each energycost beside i t
		MrKalisz kalisz = new MrKalisz();
		Scanner in = new Scanner(System.in);
		Classroom classroom = new Classroom(in);
		classroom.doAttendance(kalisz);
	}
}
