/**
 * This Projector class represents the projector task and extends the abstract class, Tasks. 
 * This class allows users to access how many things there are to check
 * This class contains methods to do the check projector task and changes Mr.Kalisz's energy.
 * @author Jathav Puvirajan
 * @version 1.3 2025/06/10
 */

import java.util.Random;
import java.util.Scanner;

public class Projector extends Tasks{
    private Scanner input;
    private String[] parts;
    private int energy;

    /**
     * Constructs a new Projector object with the variable input and
     * initializes parts and problems with a new String array and energy cost as 5.
     * @param input a Scanner object to retrieve user input
     */
    public Projector(Scanner input) {
        this.parts = new String[]{"Cable", "Power", "Lens", "Inputs", "Internet"};
        this.input = input;
        this.energyCost = 5;
    }

    /**
     * Gets the number of parts to check
     * @return the int representing the length of parts
     */
    public int getLength(){
        return this.parts.length;
    }
    /**
     * This method contains the prompts for the user to play the projector task
     * @param kalisz the MrKalisz object whose energy will be affected by the task
     */
    public void doProjector(MrKalisz kalisz){

        energy = kalisz.getEnergy();
        Random rand = new Random();
        int length = getLength();
        //Chooses an index for the broken part randomly. This will be used to accsess the broken part from the parts array.
        int brokenPartIndex = rand.nextInt(length);
        //Shows all parts that can be fixed
        DelayText.print("The projector is broken! Lets try and fix it.", 1000);
        DelayText.print("Heres a list of parts to check:", 500);
        for(String part : parts){
            DelayText.print(part, 500);
        }
        //Repeatedly prompts them to pick a part to fix until they get it right
        boolean fixed = false;
        DelayText.print("Checking a part takes 5 energy. Which part would you like to check: ", 1000);
        while(!fixed){
            boolean valid = false;
            String userInput = input.nextLine();
            //Checks if they chose a valid part, and if that valid part is the broken one.
            for(int i = 0; (i < length && !valid); i++){
                if(parts[i].equalsIgnoreCase(userInput)){
                    valid = true;
                    if(i == brokenPartIndex){
                        //Breaks out of the loop and ends the task if they chose the right part
                        DelayText.print("The projector has been fixed!",1000);
                        fixed = true;
                        break;
                    }else{
                        //Drains energy and re prompts the user if they chose the wrong part.
                        energyChange(kalisz);
                        System.out.print("That part is working fine! ");
                        //End the task if they run out of energy.
                        if(energy <= 0){
                            return;
                        }
                        DelayText.print("Current energy is " + energy + ". Try another part: ",1000);
                        break;
                    }
                }
            }
            //If what they typed is not a valid prompt, re prompt them without draining energy.
            if(!valid){
                DelayText.print("Thats not a valid part. Please input a valid part",1000);
            }

        }
        
        
    }

    /**
     * Changes and sets Mr.Kalisz's energy based on his current energy and the energy cost of the task
     * Updates the variable energy to the most current amount of energy
     * @param kalisz the MrKalisz object whose energy will be changed
     */
    @Override
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy()-energyCost);
        energy = kalisz.getEnergy();
    }
}   