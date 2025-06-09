public class MrKalisz{
    protected int energy;
    private String firstName;
    private String lastName;

    /**
     * constructor
     */
    public MrKalisz(){
        this.energy = 50;
        this.firstName = "James";
        this.lastName = "Kalisz";
    }

    /**
     * get Mr. Kalisz's energy points
     * @return Mr. Kalisz's energy remaining
     */
    public int getEnergy(){
        return this.energy;
    }

    /**
     * set Mr. Kalisz's energy points
     * @param energyCost the energy cost while doing a task
     */
    public void setEnergy(int energyCost){
        this.energy = energyCost;
    }

    /**
     * @return name in the format of "Mr. Kalisz"
     */
    @Override
    public String toString(){
        return "Mr." + this.lastName;
    }
}