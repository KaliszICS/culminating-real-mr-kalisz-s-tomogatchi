import java.util.ArrayList;

public class MrKalisz{
    protected ArrayList<Room> school; // i don't think this is needed
    protected int energy;
    private String firstName;
    private String lastName;

    public MrKalisz(){
        this.school = new ArrayList<>();
        this.energy = 100;
k        this.firstName = "James";
        this.lastName = "Kalisz";
    }

    //getters
    public int getEnergy(){
        return this.energy;
    }

    @Override
    public String toString(){
        return "Mr." + this.lastName;
    }
}