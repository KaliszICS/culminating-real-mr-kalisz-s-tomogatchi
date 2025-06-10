/**
 * Javadocs...
 * @author Jathav Puvirajan
 */
import java.util.Random;
import java.util.Scanner;
public class MissingComponents extends Tasks{
    private Scanner input;
    private String[] parts;
    private String[] problems;
    private int energy;
    public MissingComponents(Scanner input){
        this.parts = new String[]{"Graphics Card", "CPU", "RAM", "Power Supply", "Coolant", "Keyboard", "Mouse"};
        this.problems = new String[]{
            "No display output.",
            "System won't boot.",
            "No memory available.",
            "No power to system.",
            "Overheating risk.",
            "Can't type.",
            "Can't control cursor."
        };
        this.input = input;
        this.energyCost = 5;
    }
    public int getLength(){
        return this.parts.length;
    }
    public void doMissingComponents(MrKalisz kalisz){
        energy = kalisz.getEnergy();
        Random rand = new Random();
        int length = getLength();
        DelayText.print("We have 3 non-functioning computers. Let's try and fix them!", 2000);
        DelayText.print("Heres a list of parts we can fix:", 500);
        for(String part : parts){
            DelayText.print(part, 500);
        }
        for(int i = 0; i < 3; i++){
            int brokenPartIndex = rand.nextInt(length);
            DelayText.print("Broken Computer " + Integer.toString(i+1) + ":", 2000);
            DelayText.print("Problem: "+ this.problems[brokenPartIndex], 2000);
            DelayText.print("Which part should we replace?", 2000);
            boolean fixed = false;
            while(!fixed){
                boolean valid = false;
                String userInput = input.nextLine();
                for(int j = 0; (j < length && !valid); j++){
                    String item = parts[j];
                    if(item.equalsIgnoreCase(userInput)){
                        valid = true;
                        if(j == brokenPartIndex){
                            DelayText.print("You fixed the computer!",1000);
                            fixed = true;
                            break;
                        }else{
                            energyChange(kalisz);
                            System.out.print("That part is not broken!");
                            if(energy <= 0){
                                return;
                            }
                            DelayText.print("Current energy is " + energy + ". Try another part: ",1000);
                            break;
                        }
                    }
                }
                if(!valid){ 
                    DelayText.print("Thats not a valid part. Please input a valid part",1000);
                }

            }
        }
        DelayText.print("You fixed all the computers! Task complete.", 2000);
    }
    @Override
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy()-energyCost);
        energy = kalisz.getEnergy();
    }
}