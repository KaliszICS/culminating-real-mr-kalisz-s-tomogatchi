/**
 * This MrKalisz class allows users to access and modify the energy of Mr.Kalisz.
 * This class contains a method that returns the name in an appropriate format.
 * 
 * @author Lily You
 * @version 1.4
 */

public class MrKalisz{
    protected int energy;
    private String firstName;
    private String lastName;

    /**
     * Constructs a new MrKalisz object and initalizies energy as 100, the first name as James and last name as Kalisz
     */
    public MrKalisz(){
        this.energy = 100;
        this.firstName = "James";
        this.lastName = "Kalisz";
    }

    /**
     * Returns Mr. Kalisz's energy
     * @return Mr. Kalisz's energy as an integer
     */
    public int getEnergy(){
        return this.energy;
    }

    /**
     * Sets Mr. Kalisz's energy
     * @param energyCost the energy cost while doing a task
     */
    public void setEnergy(int energyCost){
        this.energy = energyCost;
    }

    /**
     * Returns the name in an appropriate format
     * @return name of James Kalisz as a String in the format of "Mr. Kalisz"
     */
    @Override
    public String toString(){
        return "Mr." + this.lastName;
    }
}