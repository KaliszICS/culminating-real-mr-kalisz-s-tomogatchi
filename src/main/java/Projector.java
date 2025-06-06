import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Projector extends Tasks{
    private Scanner input;
    private String[] thingsToCheck;
    private int partsNum;
    public Projector(Scanner input) {

        this.thingsToCheck = new String[]{"Cable", "Power", "Lens", "Inputs", "Internet"};
        this.input = input;
        this.energyCost = 10;
    }
    public int getLength(){
        return this.thingsToCheck.length;
    }
    //setters
    public void setInput(Scanner input){
        this.input = input;
    }
    public void doProjector(MrKalisz kalisz){
        energy = kalisz.getEnergy();
        Random rand = new Random();
        int length = getLength();
        String brokenPart = thingsToCheck[rand.nextInt(length)];
        DelayText.print("The projector is broken! Lets try and fix it.", 1000);
        DelayText.print("Heres a list of parts to check:", 500);
        for(String part : thingsToCheck){
            DelayText.pring(part, 500);
        }
        DelayText.print("Checking a part takes 10 energy. Which part would you like to check?", 1000);
        
        
        
    }
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy()-energyCost);
        energy = kalisz.getEnergy();
    }
}   