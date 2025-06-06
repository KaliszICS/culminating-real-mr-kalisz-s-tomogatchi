public class Device {
    private String model;
    private String serialNumber;
    private int lastServicedYear;

    public Device(String model, String serialNumber, int lastServicedYear){
        this.model = model;
        this.serialNumber = serialNumber;
        this.lastServicedYear = lastServicedYear;
    }

    //getters
    public String getModel(){
        return this.model;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }

    public int getLastServicedYear(){
        return this.lastServicedYear;
    }

    @Override
    public String toString(){
        return "Model: " + this.model + " SN: " + this.serialNumber + " Last Serviced Year: " + this.lastServicedYear;
    }

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
