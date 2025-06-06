import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class DevicesCheck extends Tasks{
    private String[] model;
    private String[] serialNumber;
    private int[] lastServicedYears;
    private Scanner input;
    public DevicesCheck(String[] model, String[] serialNumber, int[] lastServicedYears, Scanner input){
        this.model = model;
        this.serialNumber = serialNumber;
        this.lastServicedYears = lastServicedYears;
        this.energyCost = 10;
        this.input = input;
    }
    //getters

    //setters
    public void setInput(Scanner input){
        this.input = input;
    }
    public ArrayList<Device> makeDevicesToCheckList(){
        ArrayList<Device> devices = new ArrayList<>();
        int x = 0;
        while(x < 15){
            Random rand = new Random();
            int modelIndex = rand.nextInt(2);
            int serialNumberIndex = rand.nextInt(15);
            int yearIndex = rand.nextInt(12);
            Device toBeAdded = new Device(this.model[modelIndex], this.serialNumber[serialNumberIndex], this.lastServicedYears[yearIndex]);
            while(devices.contains(toBeAdded)){
                modelIndex = rand.nextInt(2);
                serialNumberIndex = rand.nextInt(15);
                yearIndex = rand.nextInt(12);
                toBeAdded = new Device(this.model[modelIndex], this.serialNumber[serialNumberIndex], this.lastServicedYears[yearIndex]);
            }
            devices.add(toBeAdded);
            x++;
        }
        return devices;
    }

    public ArrayList<Device> makeBadDevicesList(ArrayList<Device> devices){
        ArrayList<Device> badDevices = new ArrayList<>();
        for(int i = 0; i < devices.size(); i++){
            if(devices.get(i).getLastServicedYear() < 2019){
                badDevices.add(devices.get(i));
            }
        }
        return badDevices;
    }

    public void deviceChecking(ArrayList<Device> devices, MrKalisz kalisz){
        DelayText.print("It's time to check devices! Here's the devices you need to check: ", 1000);
        for(Device device : devices){
            DelayText.print(device, 1000);
        }
        DelayText.print("To check whether a device is 'bad', check if the lastServicedYear is before 2019", 1000);
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new FileWriter("DevicesOld.txt"));
            boolean notDone = true;
            while(notDone){
                System.out.print("Enter the serial numbers of the 'bad' computers to remove them, type 'done' when finished: ");
                String serialNum = input.nextLine();
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

        //print the text file out
        DelayText.print("Here's the bad computers that have been removed: ", 1000);
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
        
        //check if the arrayList still has bad computers
        boolean badComputers = false;
        for(int i = 0; i < devices.size(); i++){
            if(devices.get(i).getLastServicedYear() < 2019){
                energyChange(kalisz);
                badComputers = true;
            }
        }
        if(badComputers){
            DelayText.print("There's still bad computers left! Task done wrong. Current Energy: " + energyLeft, 1000);
        }
        else{
            DelayText.print("You finished device checking! Task done correctly! Current Energy: " + energyLeft, 1000);
        }
        
    }

    @Override
    public void energyChange(MrKalisz kalisz){
        kalisz.setEnergy(kalisz.getEnergy() - this.energyCost);
    }
}