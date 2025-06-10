/**
 * This DevicesCheck class represents the device checking task and extends the abstract class, Tasks. 
 * This class contains methods that makes a list of devices to check, a list of 'bad' devices, to do the device checking task and changes Mr.Kalisz's energy.
 * @author Lily You
 * @version 1.5 2025/06/07
 */

import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class DevicesCheck extends Tasks{
    private Scanner input;
    /**
     * Constructs a new DevicesCheck object with the variable input and initializes the energy cost of the task as 10
     * @param input a Scanner object used to recieve user input
     */
    public DevicesCheck(Scanner input){
        this.energyCost = 10;
        this.input = input;
    }
    
    //Initialized String array with the two computer model names
    String[] models = {"Dell Optiplex 7020", "Dell Optiplex 780"};
    //Used random number generator for predefined serial numbers and years - Source used: https://www.gigacalculator.com/calculators/random-number-generator.php 
    String[] serialNumbers = {"219256", "220825", "244197", "351657", "336776", "315745", "273759", "387771", "394961", "381150",
    "283314","344298", "298536", "270344", "261207", "314196", "233263", "246448", "250904", "375387"};
    int[] lastServicedYears = {2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025};


    /**
     * This method makes a Device arraylist of random devices that the player will check
     * @param numOfDevices int - the number of devices to be checked
     * @return a Device arraylist that represents devices that need to be checked
     */
    public ArrayList<Device> makeDevicesToCheckList(int numOfDevices){
        ArrayList<Device> devices = new ArrayList<>();
        int x = 0;
        //Randomizes an arraylist of devices
        while(x < numOfDevices){
            Random rand = new Random();
            int modelIndex = rand.nextInt(models.length);
            int serialNumberIndex = rand.nextInt(serialNumbers.length);
            int yearIndex = rand.nextInt(lastServicedYears.length);
            Device toBeAdded = new Device(models[modelIndex], serialNumbers[serialNumberIndex], lastServicedYears[yearIndex]);
            //Checks if the device has already been added and keeps creating a new Device to be added if so, otherwise adds it.
            while(devices.contains(toBeAdded)){
                modelIndex = rand.nextInt(models.length);
                serialNumberIndex = rand.nextInt(serialNumbers.length);
                yearIndex = rand.nextInt(lastServicedYears.length);
                toBeAdded = new Device(models[modelIndex], serialNumbers[serialNumberIndex], lastServicedYears[yearIndex]);
            }
            devices.add(toBeAdded);
            x++;
        }
        return devices;
    }

    /**
     * This method creates a list of devices that are considered 'bad' by checking if the last serviced year is before 2019
     * @param devices a Device arraylist - the devices that need to be checked
     * @return
     */
    public ArrayList<Device> makeBadDevicesList(ArrayList<Device> devices){
        ArrayList<Device> badDevices = new ArrayList<>();
        for(int i = 0; i < devices.size(); i++){
            if(devices.get(i).getLastServicedYear() < 2019){
                badDevices.add(devices.get(i));
            }
        }
        return badDevices;
    }

    /**
     * This method contains the prompts for the user to play the device checking task
     * @param devices the given Device arraylist that provides the devices that need to be checked
     * @param kalisz the MrKalisz object whose energy will be affected by the task
     */
    public void deviceChecking(ArrayList<Device> devices, MrKalisz kalisz){
        DelayText.print("It's time to check devices! Here's the devices you need to check: ", 1000);
        //Prints each device out
        for(Device device : devices){
            DelayText.print(device, 1000);
        }
        DelayText.print("\nTo know whether a device is 'bad', check if the lastServicedYear is before 2019", 1000);

        /*Prompts the user to enter serial numbers of the 'bad' computers and
        writes the computer the user inputted to a file that is supposed to contain the 'bad' computers*/
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new FileWriter("DevicesOld.txt"));
            boolean notDone = true;
            while(notDone){
                System.out.print("Enter the serial numbers of the 'bad' computers to remove them, TYPE 'done' WHEN YOU THINK YOU ARE FINISHED: ");
                String serialNum = input.nextLine();
                //Stops prompting the user once they think they are done
                if(serialNum.equalsIgnoreCase("done")){
                    notDone = false;
                }
                for(int i = 0; i < devices.size(); i++){
                    Device toBeRemoved = devices.get(i);
                    if(devices.get(i).getSerialNumber().equals(serialNum)){
                        devices.remove(i);
                        pw.println(toBeRemoved);
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        finally{
            if(pw != null){
                pw.close();
            }
        }

        //Reads the file and prints all the computers that have been removed based on the user input
        DelayText.print("Here's the computers that have been removed: ", 1000);
        Scanner s = null;
        try{
            s = new Scanner(new BufferedReader(new FileReader("DevicesOld.txt")));
            while(s.hasNext()){
                System.out.println(s.nextLine() + " ");
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
        finally{
            if(s != null){
                s.close();
            }
        }
        
        //Check if the arrayList still has bad computers
        boolean badComputers = false;
        for(int i = 0; i < devices.size(); i++){
            if(devices.get(i).getLastServicedYear() < 2019){
                //If there are 'bad' computers left then subtract 10 energy from Mr.Kalisz
                energyChange(kalisz);
                badComputers = true;
            }
        }
        if(badComputers){
            DelayText.print("There's still bad computers left! Task done wrong", 1000);
        }
        else{
            DelayText.print("You finished device checking! Task done correctly!", 1000);
        }
        
    }

    /**
     * Changes and sets Mr.Kalisz's energy based on his current energy and the energy cost of the task
     * @param kalisz the MrKalisz object whose energy will be changed
     */
    @Override
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy() - this.energyCost);
    }
}