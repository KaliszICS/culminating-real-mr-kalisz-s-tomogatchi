/**
 * This TechCom class represents the three tasks that Mr.Kalisz can do in the tech committee room.
 * The three tasks are checking devices, checking a projector and finding missing components.
 * This class provides methods to run the three tasks.
 * @author Lily You
 * @author Jathav Puvirajan
 * @version 1.4
 */

import java.util.Scanner;
import java.util.ArrayList;

public class TechCom{
    private Tasks[] tasks;

    /**
     * Constructs a new TechCom object with the variable input and initializes an array of Tasks that have new objects of DevicesCheck, Projector and MissingComponents
     * @param input a Scanner object used to receive user input
     */
    public TechCom(Scanner input){
        this.tasks = new Tasks[]{new DevicesCheck(input), new Projector(input), new MissingComponents(input)};
    }

    /**
     * Performs the device checking task using a new DevicesCheck object to generate a list of devices to be checked
     * @param kalisz the MrKalisz object whose energy will be affected by the task
     */
    public void deviceCheckTask(MrKalisz kalisz){
        DevicesCheck devicesCheck = (DevicesCheck) tasks[0];
        ArrayList<Device> devices = devicesCheck.makeDevicesToCheckList(12);
        devicesCheck.deviceChecking(devices, kalisz);
    }


    //jathav please add im too lazy
    public void projectorCheckTask(MrKalisz kalisz){
        Projector projector = (Projector) tasks[1];
        projector.doProjector(kalisz);
    }   

    public void missingComponentTask(MrKalisz kalisz){
        MissingComponents missingComponents = (MissingComponents) tasks[2];
        missingComponents.doMissingComponents(kalisz);
    }
}