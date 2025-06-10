/**
 * This Projector class represents the projector task and extends the abstract class, Tasks. 
 * This class allows users to access how many things there are to check
 * This class contains methods to do the check projector task and changes Mr.Kalisz's energy.
 * @author Jathav Puvirajan
 * @version 1.3 2025/06/10
 */

import java.util.Scanner;
import java.util.Random;

public class Projector extends Tasks{
    private Scanner input;
    private String[] parts;
    private int energy;

    public Projector(Scanner input) {
        this.parts = new String[]{"Cable", "Power", "Lens", "Inputs", "Internet"};
        this.input = input;
        this.energyCost = 5;
    }

    public int getLength(){
        return this.parts.length;
    }
    
    public void doProjector(MrKalisz kalisz){
        energy = kalisz.getEnergy();
        Random rand = new Random();
        int length = getLength();
        int brokenPartIndex = rand.nextInt(length);
        DelayText.print("The projector is broken! Lets try and fix it.", 1000);
        DelayText.print("Heres a list of parts to check:", 500);
        for(String part : parts){
            DelayText.print(part, 500);
        }
        boolean fixed = false;
        DelayText.print("Checking a part takes 5 energy. Which part would you like to check: ", 1000);
        while(!fixed){
            boolean valid = false;
            String userInput = input.nextLine();
            for(int i = 0; (i < length && !valid); i++){
                if(parts[i].equalsIgnoreCase(userInput)){
                    valid = true;
                    if(i == brokenPartIndex){
                        DelayText.print("The projector has been fixed!",1000);
                        fixed = true;
                        break;
                    }else{
                        energyChange(kalisz);
                        System.out.print("That part is working fine! ");
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