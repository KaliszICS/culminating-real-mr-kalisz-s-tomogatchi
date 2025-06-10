/**
 * 
 * @author Yaseman Nikoo
 * @author Lily You
 * @author Yu-Yen Shen
 * @author Jathave Puvirajan
 * @version 1.4 2025/06/11
 */
/** 
 * This class is the sueprclass of all the tasks in the game and contain the method that change the energy of the player.
 */
abstract class Tasks{
    protected int energyCost;
    //abstract boolean checkAnswer();
    abstract void energyChange(MrKalisz kalisz); 
    //need to be able to access his energy level each time we change the energy so we need to pass a kalisz object/class
}