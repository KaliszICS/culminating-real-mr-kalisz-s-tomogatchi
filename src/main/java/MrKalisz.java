public class MrKalisz{
    protected int energy;
    private String firstName;
    private String lastName;

    public MrKalisz(){
        this.energy = 50;
        this.firstName = "James";
        this.lastName = "Kalisz";
    }

    //getters
    public int getEnergy(){
        return this.energy;
    }

    //setters
    public void setEnergy(int energyCost){
        this.energy = energyCost;
    }
    @Override
    public String toString(){
        return "Mr." + this.lastName;
    }
}