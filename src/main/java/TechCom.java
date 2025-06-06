import java.util.Scanner;
import java.util.ArrayList;

public class TechCom{
    private DevicesCheck devicesCheck;
    private Projector projector;
    private MissingComponent missingComponent;
    private Scanner input;

    String[] models = {"Dell Optiplex 780", "Dell blah I'll check"};
    //Rnadom number generator - Source used: https://www.gigacalculator.com/calculators/random-number-generator.php 
    String[] serialNumbers = {"219256", "220825", "244197", "351657", "336776", "315745", "273759", "387771", "394961", "381150",
    "283314","344298", "298536", "270344", "261207", "314196", "233263", "246448", "250904", "375387"};
    int[] years = {2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025};
    public TechCom(Scanner input){
        this.devicesCheck = new DevicesCheck(models, serialNumbers, years, input);
        this.projector = new Projector(input); //add on
        this.missingComponent = new MissingComponent();
        this.input = input;
    }

    public void deviceCheckTask(MrKalisz kalisz){
        devicesCheck.setInput(input);
        ArrayList<Device> devices = devicesCheck.makeDevicesToCheckList();
        devicesCheck.deviceChecking(devices, kalisz);
    }

    public void projectorCheckTask(){
        //projector.setInput(input);
    }   

    public void componentCheckTask(){

    }
}