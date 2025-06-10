/**
 * This Device class represents a device that includes the model, serial number and last service year of the device and allows users to access them.
 * This calls contains methods that return the device in a readable format and checks if two devices are equal.
 * @author Lily You
 * @version 1.3
 */

public class Device {
    private String model;
    private String serialNumber;
    private int lastServicedYear;

    /**
     * Constructs a new Device object with the variables model, serialNumber and lastServicedYear
     * @param model String - the name of the device's model
     * @param serialNumber String - the device's serial number
     * @param lastServicedYear int - the device's last serviced year
     */
    public Device(String model, String serialNumber, int lastServicedYear){
        this.model = model;
        this.serialNumber = serialNumber;
        this.lastServicedYear = lastServicedYear;
    }

    /**
     * Returns the name of the device's model
     * @return the model of the device as a String
     */
    public String getModel(){
        return this.model;
    }

    /**
     * Returns the device's serial number
     * @return the serial number of the device as a String
     */
    public String getSerialNumber(){
        return this.serialNumber;
    }

    /**
     * Returns the device's last serviced year
     * @return the last service year of the device as an int
     */
    public int getLastServicedYear(){
        return this.lastServicedYear;
    }

    /**
     * Returns the device's name, serial number and last serviced year in a readable format
     * @return the device's name, serial number and last serviced year as a String in the format "Model: model SN: serialNumber Last Serviced Year: lastServiceYear"
     */
    @Override
    public String toString(){
        return "Model: " + this.model + " SN: " + this.serialNumber + " Last Serviced Year: " + this.lastServicedYear;
    }

    /**
     * Checks if two devices are equal by comparing their serial numbers
     * @param o the given Device object to be compared with
     * @return true if the devices have the same serial number, otherwise false
     */
    @Override
    public boolean equals(Object o){
        if(this == o){ 
            return true;
        }
        if(o == null || getClass() != o.getClass()){ 
            return false;
        }
        Device device = (Device)o;
        if(device.getSerialNumber().equals(this.serialNumber)){
            return true;
        }
        return false;
    }
}
