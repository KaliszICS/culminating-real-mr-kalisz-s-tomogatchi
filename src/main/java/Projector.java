import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Projector extends Tasks{
    private Scanner input;
    private String[] parts;
    private int energy;
    public Projector(Scanner input) {

        this.parts = new String[]{"Cable", "Power", "Lens", "Inputs", "Internet"};
        this.input = input;
        this.energyCost = 10;
    }
    public int getLength(){
        return this.parts.length;
    }
    //setters
    public void setInput(Scanner input){
        this.input = input;
    }
    public void doProjector(MrKalisz kalisz){
        energy = kalisz.getEnergy();
        Random rand = new Random();
        int length = getLength();
        int brokenPartIndex = rand.nextInt(length);
        //Graphics: just put a broken projector up?
        DelayText.print("The projector is broken! Lets try and fix it.", 1000);
        DelayText.print("Heres a list of parts to check:", 500);
        for(String part : parts){
            DelayText.print(part, 500);
        }
        boolean fixed = false;
        DelayText.print("Checking a part takes 10 energy. Which part would you like to check: ", 1000);
        while(!fixed){
            boolean valid = false;
            String userInput = input.nextLine();
            for(int i = 0; i < length; i++){
                if(parts[i].equalsIgnoreCase(userInput)){
                    valid = true;
                    if(i == brokenPartIndex){
                        //Graphics: Flash checkmark on screen?
                        DelayText.print("The projector has been fixed!",1000);
                        fixed = true;
                        break;
                    }else{
                        energyChange(kalisz);
                        DelayText.print("That part is working fine! Try another part: ",1000);
                        //Graphics: flash big X on screen?
                        if(energy <= 0){
                            return;
                        }
                        break;
                    }
                }
            }
            if(!valid){
                DelayText.print("Thats not a valid part. Please input a valid part",1000);
            }

        }
        
        
    }
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy()-energyCost);
        energy = kalisz.getEnergy();
    }
}   