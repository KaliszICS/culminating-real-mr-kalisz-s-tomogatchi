/**
 * This class is the superclass of all the tasks in the game and contain the method that change the energy of the player.
 * @author Yaseman Nikoo
 * @author Lily You
 * @author Yu-Yen Shen
 * @author Jathav Puvirajan
 * @version 1.4 2025/06/11
 */

abstract class Tasks{
    protected int energyCost;
    abstract void energyChange(MrKalisz kalisz); 
}